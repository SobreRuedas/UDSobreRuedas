/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.Facebook.validaGruposFB;
import com.udsbr.ws.rest.VO.usuarioGroupFBVO;
import com.udsbr.ws.rest.request.validaInicioReq;
import com.udsbr.ws.rest.response.validaInicioResp;
import com.udsbr.ws.rest.udsbrDAO.loginDAO;
import com.udsbr.ws.rest.udsbrDAO.validaInicioDAO;
import com.udsbr.ws.rest.udsbrDTO.loginDTO;
import com.udsbr.ws.rest.udsbrDTO.validaInicioDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class validaInicioController {

    static Logger log = Logger.getLogger(validaInicioController.class);
    validaInicioDAO dao = new validaInicioDAO();
    String grupoID = "1850503368314259";

    public validaInicioResp validaSesionCtrl(validaInicioReq req) {
        log.info("*** Inicio validaSesionCtrl ***");
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        Timestamp fechaSolicitud = new Timestamp(lnMilisegundos);
        validaInicioResp respuesta = new validaInicioResp();
        validaInicioDTO requestDTO = new validaInicioDTO();
        validaInicioDTO responseDTO = new validaInicioDTO();
        requestDTO.setFacebookID(req.getFacebookID());
        requestDTO.setNameFacebook(req.getNameFacebook());
        requestDTO.setAccesToken(req.getAccesToken());
        requestDTO.setAdministradorFlag(req.isAdministradorFlag());
        requestDTO.setFechaRegistro(fechaSolicitud);
        validaGruposFB fb = new validaGruposFB();
        List<usuarioGroupFBVO> usuarios = new ArrayList();
        loginDAO daoLogin = new loginDAO();
        loginDTO consultaDTO = new loginDTO();

        //requestDTO.setGrupoFB(req.isAdministradorFlag());
        switch (req.getMetodo()) {
            case 1:

                loginDTO respuestaDTO = new loginDTO();
                consultaDTO.setFacebookID(req.getFacebookID());
                consultaDTO.setCodigoErrorBD(1);
                respuestaDTO = daoLogin.readOne(consultaDTO);
                if (respuestaDTO.getCodigoErrorBD() == 0) {
                    respuesta.setAcceso(true);
                    respuesta.setCodigoError(0);
                    respuesta.setCodigoID(respuestaDTO.getCodigoID());
                    respuesta.setFacebookID(respuestaDTO.getFacebookID());
                    respuesta.setGrupoFacebookId(respuestaDTO.getFacebookGroupID());
                    respuesta.setNameFacebook(respuestaDTO.getNombreUser());
                    respuesta.setValidaCodigo(false);
                    respuesta.setMsjError("");
                } else {
                    responseDTO = consultaInicioSesion(requestDTO);
                    if (respuestaDTO.getCodigoErrorBD() == 0) {
                        respuesta.setAcceso(true);
                        respuesta.setCodigoError(0);
                        respuesta.setCodigoID("");
                        respuesta.setFacebookID(responseDTO.getFacebookID());
                        respuesta.setGrupoFacebookId(responseDTO.getGrupoFB());
                        respuesta.setNameFacebook(responseDTO.getNameFacebook());
                        respuesta.setValidaCodigo(true);
                        respuesta.setMsjError("");
                    } else {
                        responseDTO = consultaAccesToken();
                        String URL = "https://graph.facebook.com/" + grupoID + "/members?access_token=" + responseDTO.getAccesToken() + "&limit=1";
                        boolean indicador = false;
                        try {

                            usuarios = fb.sendGet(URL);
                            for (usuarioGroupFBVO arregloUsuarios : usuarios) {
                                if (arregloUsuarios.getId().equals(req.getFacebookID())) {
                                    indicador = true;
                                    break;
                                }
                            }
                        } catch (Exception ex) {
                            log.error(ex);
                            java.util.logging.Logger.getLogger(sugerenciasController.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            if (indicador) {
                                respuesta.setAcceso(true);
                                respuesta.setCodigoError(0);
                                respuesta.setCodigoID("");
                                respuesta.setFacebookID(req.getFacebookID());
                                respuesta.setGrupoFacebookId("1640356149585169");
                                respuesta.setNameFacebook("UD Sobre Ruedas");
                                respuesta.setValidaCodigo(true);
                                respuesta.setMsjError("");
                            } else {
                                respuesta.setAcceso(false);
                                respuesta.setCodigoError(10);
                                respuesta.setCodigoID("");
                                respuesta.setFacebookID(req.getFacebookID());
                                respuesta.setGrupoFacebookId("1640356149585169");
                                respuesta.setNameFacebook("UD Sobre Ruedas");
                                respuesta.setValidaCodigo(true);
                                respuesta.setMsjError("No Es Posible Validar Accesos En Estos Momentos, Ponte En Contacto Con el Administrador De La App");
                            }
                        }
                    }
                }
                break;
            case 2:
                int codigoError = 0;
                String Mensaje = "";
                validaInicioDTO local = new validaInicioDTO();
                consultaDTO.setFacebookID(req.getFacebookID());
                responseDTO = consultaInicioSesion(requestDTO);
                log.debug("Resultado responseDto: " + responseDTO.getCodigoErrorBD());
                if (responseDTO.getCodigoErrorBD() == 0) {
                    requestDTO.setInicioSecion(responseDTO.getInicioSecion() + 1);
                    local = actualizaSesionUsuario(requestDTO);

                } else {
                    requestDTO.setInicioSecion(1);
                    local = creaSesionUsuario(requestDTO);
                }
                consultaDTO.setCodigoErrorBD(1);
                respuestaDTO = daoLogin.readOne(consultaDTO);

                if (respuestaDTO.getCodigoErrorBD() == 0) {
                    if ("".equals(respuestaDTO.getEstadoUsuario()) || "0".equals(respuestaDTO.getEstadoUsuario())) {
                        respuesta.setCodigoError(0);
                        respuesta.setAcceso(true);
                        respuesta.setValidaCodigo(false);
                        respuesta.setMsjError("");
                    } else {
                        respuesta.setCodigoError(1111);
                        respuesta.setValidaCodigo(false);
                        respuesta.setMsjError("No es Posible Iniciar Sesión, Ponte En Contacto Con El Administrador De La App");
                        respuesta.setAcceso(false);
                    }
                } else {
                    respuesta.setAcceso(true);
                    respuesta.setCodigoError(11);
                    respuesta.setValidaCodigo(true);
                    respuesta.setMsjError("");
                }
                if (req.isAdministradorFlag()) {
                    responseDTO = actualizaToken(requestDTO);
                    if (responseDTO.getCodigoErrorBD() == 0) {
                        respuesta.setAcceso(true);
                        respuesta.setCodigoError(0);
                        respuesta.setValidaCodigo(true);
                        respuesta.setMsjError("");
                    } else {
                        respuesta.setAcceso(false);
                        respuesta.setCodigoError(12);
                        respuesta.setMsjError("");
                    }
                }
                respuesta.setCodigoID(respuestaDTO.getCodigoID());
                respuesta.setFacebookID(respuestaDTO.getFacebookID());
                respuesta.setGrupoFacebookId(respuestaDTO.getFacebookGroupID());
                respuesta.setNameFacebook(respuestaDTO.getNombreUser());
                break;
            case 3:
                break;
            default:
                break;
        }

        log.info("*** Fin validaSesionCtrl ***");
        return respuesta;
    }

    public validaInicioDTO consultaAccesToken() {
        log.info("*** Inicio consultaAccesToken ***");
        validaInicioDTO respuestaDTO = new validaInicioDTO();
        validaInicioDTO solicitudDTO = new validaInicioDTO();
        solicitudDTO.setCodigoErrorBD(0);
        respuestaDTO = dao.readOne(solicitudDTO);
        log.info("*** Fin consultaAccesToken ***");
        return respuestaDTO;
    }

    public validaInicioDTO consultaInicioSesion(validaInicioDTO dto) {
        log.info("*** Inicio consultaInicioSesion ***");
        validaInicioDTO respuestaDTO = new validaInicioDTO();
        dto.setCodigoErrorBD(1);
        respuestaDTO = dao.readOne(dto);
        log.info("*** Fin consultaInicioSesion ***");
        return respuestaDTO;
    }

    public validaInicioDTO actualizaToken(validaInicioDTO dto) {
        log.info("*** Inicio actualizaToken ***");
        validaInicioDTO respuestaDTO = new validaInicioDTO();
        dto.setCodigoErrorBD(0);
        int codError;
        String msjError;
        boolean estado = dao.update(dto);
        if (estado) {
            codError = 0;
            msjError = "";
        } else {
            codError = 1103;
            msjError = "Upsss!!, Ha Ocurrido Un Error Inesperado, Si el Problema Persiste Contacta Al Administrador De La APP";
        }
        respuestaDTO.setCodigoErrorBD(codError);
        respuestaDTO.setMensajeErrorBD(msjError);
        log.info("*** Fin actualizaToken ***");
        return respuestaDTO;
    }

    public validaInicioDTO actualizaSesionUsuario(validaInicioDTO dto) {
        log.info("*** Inicio actualizaSesionUsuario ***");
        validaInicioDTO respuestaDTO = new validaInicioDTO();
        dto.setCodigoErrorBD(1);
        int codError;
        String msjError;
        boolean estado = dao.update(dto);
        if (estado) {
            codError = 0;
            msjError = "";
        } else {
            codError = 1104;
            msjError = "Upsss!!, Ha Ocurrido Un Error Inesperado, Si el Problema Persiste Contacta Al Administrador De La APP";
        }
        respuestaDTO.setCodigoErrorBD(codError);
        respuestaDTO.setMensajeErrorBD(msjError);
        log.info("*** Fin actualizaSesionUsuario ***");
        return respuestaDTO;
    }

    public validaInicioDTO creaSesionUsuario(validaInicioDTO dto) {
        log.info("*** Inicio creaSesionUsuario ***");
        validaInicioDTO respuestaDTO = new validaInicioDTO();
        //dto.setCodigoErrorBD(1);
        int codError;
        String msjError;
        boolean estado = dao.create(dto);
        if (estado) {
            codError = 0;
            msjError = "";
        } else {
            codError = 1105;
            msjError = "Upsss!!, Ha Ocurrido Un Error Inesperado, Si el Problema Persiste Contacta Al Administrador De La APP";
        }
        respuestaDTO.setCodigoErrorBD(codError);
        respuestaDTO.setMensajeErrorBD(msjError);
        log.info("*** Fin creaSesionUsuario ***");
        return respuestaDTO;
    }

}
