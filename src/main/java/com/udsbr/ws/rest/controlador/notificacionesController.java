/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.request.notificacionesReq;
import com.udsbr.ws.rest.response.notificacionesResp;
import com.udsbr.ws.rest.udsbrDAO.notificacionesDAO;
import com.udsbr.ws.rest.udsbrDTO.notificacionesDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class notificacionesController {

    static Logger log = Logger.getLogger(regVehiculoController.class);
    notificacionesDTO dto = new notificacionesDTO();
    notificacionesDAO dao = new notificacionesDAO();

    public notificacionesResp creaNotificaciones(notificacionesReq req) {
        log.info("*** Inicio notificaciones ***");
        int codError = 0;
        String msjError = "";
        notificacionesResp response = new notificacionesResp();
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        Timestamp fechaRegistro = new Timestamp(lnMilisegundos);
        dto.setFacebookID(req.getFacebookID());
        dto.setCodigoID(req.getCodigoID());
        dto.setImgVista(req.getImgVista());
        dto.setImgFull(req.getImgFull());
        dto.setDescripcionBreve(req.getDescripcionBreve());
        dto.setDescripcionFull(req.getDescripcionFull());
        dto.setLink(req.getLink());
        dto.setFechaVista(fechaRegistro);
        dto.setTitulo(req.getTitulo());

        if (dao.create(dto)) {
            codError = 0;
            msjError = "Notificacion Creada Exitosamente";
        } else {
            codError = 4001;
            msjError = "Se Ha presentado Un Error Al Crear La Notificacion, Si El Problema Persiste Contacta Al Administrador De La Aplicacion";
        }
        response.setCodigoError(codError);
        response.setMsjError(msjError);
        log.info("*** Fin notificaciones ***");
        return response;
    }

    public notificacionesResp ConsultaNotificacionesAll(notificacionesReq req) {
        log.info("*** Inicio ConsultaNotificacionesAll ***");
        int codError = 0;
        String msjError = "";
        notificacionesResp response = new notificacionesResp();
        List<notificacionesDTO> listaNotificaciones = new ArrayList();
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        Timestamp fechaRegistro = new Timestamp(lnMilisegundos);
        dto.setFacebookID(req.getFacebookID());
        dto.setCodigoID(req.getCodigoID());
        dto.setImgVista(req.getImgVista());
        dto.setImgFull(req.getImgFull());
        dto.setDescripcionBreve(req.getDescripcionBreve());
        dto.setDescripcionFull(req.getDescripcionFull());
        dto.setLink(req.getLink());
        dto.setFechaVista(fechaRegistro);
        dto.setTitulo(req.getTitulo());
        listaNotificaciones = dao.readMany(dto);
        
        
        if (listaNotificaciones.get(0).getCodigoErrorBD() == 0) {
            codError = 0;
            msjError = "";
            
        } else {
            codError = listaNotificaciones.get(0).getCodigoErrorBD();
            msjError = "Se Ha Presentado El Error: " +listaNotificaciones.get(0).getMensajeErrorBD()+ ", Si El Problema Persiste Contacta Al Administrador De La Aplicacion";
        }
        response.setCodigoError(codError);
        response.setMsjError(msjError);
        response.setNotificaciones(listaNotificaciones);
        log.info("*** Fin ConsultaNotificacionesAll ***");
        return response;
    }
    
    public notificacionesResp ConsultaNotificacion(notificacionesReq req) {
        log.info("*** Inicio ConsultaNotificacion ***");
        int codError = 0;
        String msjError = "";
        notificacionesResp response = new notificacionesResp();
        List<notificacionesDTO> listaNotificaciones = new ArrayList();
        notificacionesDTO consNotificacion = new notificacionesDTO();
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        
        long resta = lnMilisegundos - 3;
        log.debug("Operación = "+resta+"\n lnMilisegundos"+ lnMilisegundos);
        Timestamp fechaRegistro = new Timestamp(lnMilisegundos);
        dto.setFacebookID(req.getFacebookID());
        dto.setCodigoID(req.getCodigoID());
        dto.setImgVista(req.getImgVista());
        dto.setImgFull(req.getImgFull());
        dto.setDescripcionBreve(req.getDescripcionBreve());
        dto.setDescripcionFull(req.getDescripcionFull());
        dto.setLink(req.getLink());
        dto.setFechaVista(fechaRegistro);
        dto.setTitulo(req.getTitulo());
        consNotificacion = dao.readOne(dto);
        
        
        if (consNotificacion.getCodigoErrorBD() == 0) {
            codError = 0;
            msjError = "";
            listaNotificaciones.add(consNotificacion);
            
        } else {
            codError = consNotificacion.getCodigoErrorBD();
            msjError = "Se Ha Presentado El Error: " +consNotificacion.getMensajeErrorBD()+ ", Si El Problema Persiste Contacta Al Administrador De La Aplicacion";
        }
        response.setCodigoError(codError);
        response.setMsjError(msjError);
        response.setNotificaciones(listaNotificaciones);
        log.info("*** Fin ConsultaNotificacion ***");
        return response;
    }

}
