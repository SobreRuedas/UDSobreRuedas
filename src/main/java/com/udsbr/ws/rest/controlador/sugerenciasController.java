/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.Facebook.validaGruposFB;
import com.udsbr.ws.rest.request.sugerenciasReq;
import com.udsbr.ws.rest.response.sugerenciasResp;
import com.udsbr.ws.rest.udsbrDAO.sugerenciasDAO;
import com.udsbr.ws.rest.udsbrDTO.sugerenciasDTO;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class sugerenciasController {

    static Logger log = Logger.getLogger(sugerenciasController.class);
    sugerenciasDAO dao = new sugerenciasDAO();
    sugerenciasDTO dto = new sugerenciasDTO();

    public sugerenciasResp creaSugerencias(sugerenciasReq req) {
        log.info("*** Inicio creaSugerencias ***");
        int codError = 0;
        String msjError = "";
        sugerenciasResp response = new sugerenciasResp();
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        Timestamp fechaRegistro = new Timestamp(lnMilisegundos);
        dto.setFacebookID(req.getFacebookID());
        dto.setCodigoID(req.getCodigoID());
        dto.setTitulo(req.getTitulo());
        dto.setMensaje(req.getMensaje());
        dto.setClasificacion(req.getClasificacion());
        dto.setFecha(fechaRegistro);
        log.debug("Fecha en Timestamp : "+fechaRegistro);
        
       if (dao.create(dto)) {
           codError = 0;
           msjError = "Tu Sugerencia Ha Sido Registrada Exitosamente.";
        }else{
           codError = 3001;
           msjError = "Ha Ocurrido Un Error No Esperado, Por Favor Intenta Mas Tarde";
       }
       response.setCodigoError(codError);
       response.setMsjError(msjError);
        log.info("*** Fin creaSugerencias ***");
        return response;
    }
}
