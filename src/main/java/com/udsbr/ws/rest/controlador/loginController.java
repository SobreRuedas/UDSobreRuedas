/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.request.validaUsuarioReq;
import com.udsbr.ws.rest.response.validaUsuarioResp;
import com.udsbr.ws.rest.udsbrDAO.loginDAO;
import com.udsbr.ws.rest.udsbrDTO.loginDTO;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class loginController {

    loginDAO ctrlDAO = new loginDAO();
    validaUsuarioResp resp = new validaUsuarioResp();
    static Logger log = Logger.getLogger(loginController.class);

    public validaUsuarioResp validaUser(validaUsuarioReq req) {
        log.info("*** Inicio validaUser ***");
        loginDTO dto = new loginDTO();
        loginDTO consultaDTO = new loginDTO();
        boolean creaUsuario, actualizaUsuario;
        int codigoError = 1111;
        int codigoEvento = 1111;
        String msjError = "";
        String msjEvento = "";
        dto.setFacebookID(req.getIdFacebook());
        dto.setCodigoID(req.getIdCodigo());
        dto.setPhoneID(req.getIdPhone());
        dto.setPhoneModel(req.getModelPhone());
        dto.setFacebookGroupID(req.getIdGrupo());
        dto.setNombreUser(req.getNombreUsuario());
        dto.setIpUsuario(req.getIpUsuario());
        dto.setUuIdPhone(req.getUuidPhone());
        dto.setPlatformPhone(req.getPlatformPhone());
        dto.setVersionPhone(req.getVersionPhone());
        dto.setManufacturePhone(req.getManufacturePhone());
        dto.setSerialPhone(req.getSerialPhone());
        dto.setIsVirtualPhone(req.getIsVirtualPhone());
        //dto.setEstadoUsuario("");
        consultaDTO = ctrlDAO.readOne(dto);
        log.debug("Estructura DTO " + dto.getCodigoErrorBD());
        switch (consultaDTO.getCodigoErrorBD()) {
            case 0:
                codigoError = 0;
                codigoEvento = 1;
                msjError = "Usuario ya registrado";
                msjEvento = "Ingreso Ok";
                break;
            case 1001:
                log.debug("Estrucutura Codigo"+req.getIdCodigo());
                boolean validaCodigo = !(req.getIdCodigo()== null || "".equals(req.getIdCodigo()));;
                if (validaCodigo) {
                    creaUsuario = ctrlDAO.create(dto);
                    if (creaUsuario) {
                        codigoError = 0;
                        codigoEvento = 1;
                        msjError = "Usuario Creado Exitosamente";
                        msjEvento = "Ingreso Ok";
                    } else {
                        codigoError = 1001;
                        codigoEvento = 3;
                        msjError = "No Es Posible Completar el Registro: ";
                        msjEvento = "Ponte En Contacto Con El Administrador De La Aplicación";
                    }
                } else {
                    codigoError = -1;
                    codigoEvento = 0;
                    msjError = "Digite Código U. Distrital";
                    msjEvento = "" + dto.getFacebookGroupID();
                }

                break;
            case 1002:
                if (dto.getCodigoID() != null || !"".equals(dto.getCodigoID())) {
                    actualizaUsuario = ctrlDAO.update(dto);
                    if (actualizaUsuario) {
                        codigoError = 0;
                        codigoEvento = 2;
                        msjError = "usuario Actualizado Exitosamente, Vuelve A Solicitar Credenciales Del Grupo";
                        msjEvento = "" + dto.getFacebookGroupID();
                    } else {
                        codigoError = 1002;
                        codigoEvento = 3;
                        msjError = "No Es Posible Validar Registro";
                        msjEvento = "Ponte En Contacto Con El Administrador De La Aplicación";
                    }
                } else {
                    codigoError = -1;
                    codigoEvento = 0;
                    msjError = "Digite Código U. Distrital";
                    msjEvento = "" + dto.getFacebookGroupID();
                }
                break;
            default:
                codigoEvento = 3;
                msjError = "No Es Posible Validar Registro";
                msjEvento = "Ponte En Contacto Con El Administrador De La Aplicación";
                break;
        }
        resp.setCodError(codigoError);
        resp.setCodEvento(codigoEvento);
        resp.setMsjError(msjError);
        resp.setEstadoUsuario(dto.getEstadoUsuario());
        resp.setMsjEvento(msjEvento);
        resp.setIdUsuario(dto.getPhoneID());

        log.info("*** Fin validaUser ***");
        return resp;
    }
    
    public loginDTO consultaUsuario (String facebookID, String codigoID){
        log.info("*** Inicio consultaUsuario ***");
        loginDTO consultaDTO = new loginDTO();
        loginDTO respuestaDTO = new loginDTO();
        loginDAO dao = new loginDAO();
        consultaDTO.setFacebookID(facebookID);
        consultaDTO.setCodigoID(codigoID);
        respuestaDTO = dao.readOne(consultaDTO);
        log.info("*** Fin consultaUsuario ***");
        return respuestaDTO;
    }
}
