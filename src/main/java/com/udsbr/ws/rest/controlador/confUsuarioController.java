/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.request.confUsuarioReq;
import com.udsbr.ws.rest.response.confUsuarioResp;
import com.udsbr.ws.rest.udsbrDAO.confUsuarioDAO;
import com.udsbr.ws.rest.udsbrDTO.confUsuarioDTO;
import com.udsbr.ws.rest.udsbrDTO.loginDTO;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class confUsuarioController {

    static Logger log = Logger.getLogger(confUsuarioController.class);
    confUsuarioResp response = new confUsuarioResp();
    confUsuarioDAO dao = new confUsuarioDAO();
    confUsuarioDTO dto = new confUsuarioDTO();
    int codError = 0;
    String msjError = "";
    confUsuarioReq datosRespuesta = new confUsuarioReq();;

    public confUsuarioResp creaConfiguracion(confUsuarioReq request) {
        log.info("*** Inicio creaConfiguracion ***");
        boolean validaRespUpdateDao;
        boolean validaRespCreateDao;
        dto.setFacebookID(request.getFacebookID());
        dto.setCodigoID(request.getCodigoID());
        dto.setRutaFavorita(request.getRutaFavorita());
        dto.setModoViaje(request.getModoViaje());
        dto.setPlaca(request.getPlaca());
        dto.setPuestosDisponibles(request.getPuestosDisponibles());
        dto.setCorreoContacto(request.getCorreoContacto());
        dto.setTelefonoContacto(request.getTelefonoContacto());
        dto.setFiltroOrigenMts(request.getFiltroOrigenMts());
        dto.setFiltroDestinoMts(request.getFiltroDestinoMts());

        validaRespUpdateDao = dao.update(dto);
        if (validaRespUpdateDao) {
            codError = 0;
            msjError = "Se Ha Actualizado Tu Configuración De Viaje";
        } else {
            validaRespCreateDao = dao.create(dto);
            if (validaRespCreateDao) {
                codError = 0;
                msjError = "Se Ha Creado Tu Configuración De Viaje";
            } else {
                codError = 5001;
                msjError = "Ha Ocurrido Un Error No Esperado, Si El Problema Persiste Contacte El Administrador de La Aplicación";
            }
        }
        response.setCodigoError(codError);
        response.setMsjError(msjError);
        response.setNotificaciones(datosRespuesta);
        log.info("*** Fin creaConfiguracion ***");
        return response;
    }

    public confUsuarioResp consultaConfiguracion(confUsuarioReq request) {
        log.info("*** Inicio consultaConfiguracion ***");
        confUsuarioDTO dtoRespuesta = new confUsuarioDTO();
        loginController login = new loginController();
        loginDTO DTOLogin = new loginDTO();
        
        dto.setFacebookID(request.getFacebookID());
        dto.setCodigoID(request.getCodigoID());
        dto.setRutaFavorita(request.getRutaFavorita());
        dto.setModoViaje(request.getModoViaje());
        dto.setPlaca(request.getPlaca());
        dto.setPuestosDisponibles(request.getPuestosDisponibles());
        dto.setCorreoContacto(request.getCorreoContacto());
        dto.setTelefonoContacto(request.getTelefonoContacto());
        dto.setFiltroOrigenMts(request.getFiltroOrigenMts());
        dto.setFiltroDestinoMts(request.getFiltroDestinoMts());

        dtoRespuesta = dao.readOne(dto);

        if (dtoRespuesta.getCodigoErrorBD() == 0) {
            datosRespuesta.setFacebookID(dtoRespuesta.getFacebookID());
            datosRespuesta.setCodigoID(dtoRespuesta.getCodigoID());
            datosRespuesta.setRutaFavorita(dtoRespuesta.getRutaFavorita());
            datosRespuesta.setModoViaje(dtoRespuesta.getModoViaje());
            datosRespuesta.setPlaca(dtoRespuesta.getPlaca());
            datosRespuesta.setPuestosDisponibles(dtoRespuesta.getPuestosDisponibles());
            datosRespuesta.setCorreoContacto(dtoRespuesta.getCorreoContacto());
            datosRespuesta.setTelefonoContacto(dtoRespuesta.getTelefonoContacto());
            datosRespuesta.setFiltroOrigenMts(dtoRespuesta.getFiltroOrigenMts());
            datosRespuesta.setFiltroDestinoMts(dtoRespuesta.getFiltroDestinoMts());
            DTOLogin = login.consultaUsuario(request.getFacebookID(), request.getCodigoID());
            if (DTOLogin.getCodigoErrorBD() == 0) {
                datosRespuesta.setNombreUsuario(DTOLogin.getNombreUser());
                codError = 0;
                msjError = "";
            }else{
                datosRespuesta.setNombreUsuario("");
                codError = 5201;
                msjError = "Uuupss... No Ha Sido Posible Recuperar La Totalidad De La Información, Por fvor Intenta Mas Tarde";
            }

        }
        
        response.setCodigoError(codError);
        response.setMsjError(msjError);
        response.setNotificaciones(datosRespuesta);
        log.info("*** Fin consultaConfiguracion ***");
        return response;
    }

}
