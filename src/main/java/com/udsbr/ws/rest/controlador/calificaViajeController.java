/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.request.calificaViajeReq;
import com.udsbr.ws.rest.response.calificaViajeResp;
import com.udsbr.ws.rest.udsbrDAO.calificaViajeDAO;
import com.udsbr.ws.rest.udsbrDTO.calificaViajeDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class calificaViajeController {

    static Logger log = Logger.getLogger(calificaViajeController.class);
    calificaViajeDAO dao = new calificaViajeDAO();

    public calificaViajeResp creaConsulta(calificaViajeReq request) {
        log.info("*** Inicio creaConsulta ***");
        calificaViajeResp response = new calificaViajeResp();
        calificaViajeDTO dto = new calificaViajeDTO();
        calificaViajeDTO consultaDto = new calificaViajeDTO();
        List<calificaViajeDTO> listaCalificacion = new ArrayList();
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        Timestamp fechaRegistro = new Timestamp(lnMilisegundos);
        int codError;
        String msjError;
        
        dto.setFacebookID(request.getFacebookID());
        dto.setCodigoID(request.getCodigoID());
        dto.setCodigoIDUsuario(request.getCodigoIDUsuario());
        dto.setFacebookIDUsuario(request.getFacebookIDUsuario());
        dto.setPuntuacionViaje(request.getPuntuacionViaje());
        dto.setFechaActualizacion(fechaRegistro);
        dto.setViajeID(request.getViajeID());
        dto.setFechaViaje(request.getFechaViaje());
        dto.setObservacionViaje(request.getObservacionViaje());
        dto.setObservacionType(request.getObservacionType());
        
        switch (request.getMetodo()){
            case 1:
                consultaDto = creaCalificacion(dto);
                codError = consultaDto.getCodigoErrorBD();
                msjError = consultaDto.getMensajeErrorBD();
                break;
            case 2:
                listaCalificacion = consultaCalificacion(dto.getFacebookID(), dto.getCodigoID());
                codError = listaCalificacion.get(0).getCodigoErrorBD();
                msjError = listaCalificacion.get(0).getMensajeErrorBD();
                break;
            default :
                codError = 7000;
                msjError = "Opción No Valida";
                break;
        }
        response.setCodigoError(codError);
        response.setMsjError(msjError);
        response.setCalificacionViajes(listaCalificacion);
        log.info("*** Fin creaConsulta ***");
        return response;
    }
    
    public calificaViajeDTO creaCalificacion (calificaViajeDTO objDto){
        log.info("*** Inicio creaCalificacion ***");
        calificaViajeDTO consultaDto = new calificaViajeDTO();
        boolean estado;
        estado = dao.create(objDto);
        if(estado){
            consultaDto.setCodigoErrorBD(0);
            consultaDto.setMensajeErrorBD("Gracias Por Tu Colaboración");
        }else{
            consultaDto.setCodigoErrorBD(7001);
            consultaDto.setMensajeErrorBD("Uuupss!!!, Se Ha Producido Un Error Inesperado, Si el Problema Continua Contacta Al Administrados De La APP");
        }
        log.info("*** Fin creaCalificacion ***");
        return  consultaDto;
    }
    
    
    public List<calificaViajeDTO> consultaCalificacion(String facebookId, String codigoId){
        log.info("*** Inicio consultaCalificacion ***");
        List<calificaViajeDTO> consultaDto =new ArrayList();
        calificaViajeDTO parametros = new calificaViajeDTO();
        parametros.setFacebookID(facebookId);
        parametros.setCodigoID(codigoId);
        consultaDto = dao.readMany(parametros);
        log.info("*** Fin consultaCalificacion ***");
        return consultaDto;
    }
    
}
