/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.request.solicitudesPendientesReq;
import com.udsbr.ws.rest.response.solicitudesPendientesResp;
import com.udsbr.ws.rest.udsbrDAO.solicitudesPendientesDAO;
import com.udsbr.ws.rest.udsbrDTO.solicitudesPendientesDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class solicitudesPendientesController {

    static Logger log = Logger.getLogger(solicitudesPendientesController.class);
    solicitudesPendientesDAO dao = new solicitudesPendientesDAO();

    public solicitudesPendientesResp solicitudesPend(solicitudesPendientesReq request) {
        log.info("*** Inicio solicitudesPend ***");
        solicitudesPendientesResp response = new solicitudesPendientesResp();
        solicitudesPendientesDTO dto = new solicitudesPendientesDTO();
        solicitudesPendientesDTO consultaDTO = new solicitudesPendientesDTO();
        solicitudesPendientesDTO respuestaDTO = new solicitudesPendientesDTO();
        List<solicitudesPendientesDTO> consultaLista = new ArrayList();
        int codError = 0;
        String msjError = "";
        long dia = 86400000;
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        Timestamp fechaSolicitud = new Timestamp(lnMilisegundos);
        Timestamp fechaPartida = new Timestamp(lnMilisegundos - dia);
        dto.setFacebookID(request.getFacebookID());
        dto.setCodigoID(request.getCodigoID());
        dto.setSolicitanteCodeID(request.getSolicitanteCodeID());
        dto.setNombreSolicitante(request.getNombreSolicitante());
        dto.setImgFacebookSolicitante(request.getImgFacebookSolicitante());
        dto.setDescRutaSolicitante(request.getDescRutaSolicitante());
        dto.setFlagObsevacion(request.getFlagObsevacion());
        dto.setDescObservacionSol(request.getDescObservacionSol());
        dto.setFechaSolicitud(fechaSolicitud);
        dto.setFechaPartida(request.getFechaPartida());

        //dto.setFlagActivo(request.getFlagActivo());
        //dto.setNroSolicitudes(request.getNroSolicitudes());
        switch (request.getMetodo()) {
            case 1:
                consultaDTO = consulta(request.getFacebookID(), request.getCodigoID(), request.getSolicitanteCodeID());
                switch (consultaDTO.getCodigoErrorBD()) {
                    case 0:
                        dto.setNroSolicitudes(consultaDTO.getNroSolicitudes() + 1);
                        dto.setFlagActivo(1);
                        respuestaDTO = actualiza(dto);
                        codError = respuestaDTO.getCodigoErrorBD();
                        msjError = respuestaDTO.getMensajeErrorBD();
                        break;
                    case 8001:
                        dto.setFlagActivo(1);
                        respuestaDTO = creacion(dto);
                        codError = respuestaDTO.getCodigoErrorBD();
                        msjError = respuestaDTO.getMensajeErrorBD();
                        break;
                    default:
                        respuestaDTO = consultaDTO;
                        codError = respuestaDTO.getCodigoErrorBD();
                        msjError = respuestaDTO.getMensajeErrorBD();
                        break;
                }
                break;
            case 2:
                dto.setFlagActivo(0);
                respuestaDTO = actualiza(dto);
                if (respuestaDTO.getCodigoErrorBD() == 0) {
                    respuestaDTO.setMensajeErrorBD("Tu Solicitud Ha Sido Eliminada");
                }
                codError = respuestaDTO.getCodigoErrorBD();
                msjError = respuestaDTO.getMensajeErrorBD();
                break;
            case 3:
                consultaLista = consultaSolicitudes(request.getSolicitanteCodeID(), fechaPartida);
                codError = consultaLista.get(0).getCodigoErrorBD();
                msjError = consultaLista.get(0).getMensajeErrorBD();
                break;
            case 4:
                consultaLista = solicitudesRealizadas(request.getFacebookID(), request.getCodigoID(), fechaPartida);
                codError = consultaLista.get(0).getCodigoErrorBD();
                msjError = consultaLista.get(0).getMensajeErrorBD();
                break;
            default:
                codError = 8100;
                msjError = "Opción No Valida";
                break;
        }
        response.setCodigoError(codError);
        response.setMsjError(msjError);
        response.setSolicitudes(consultaLista);
        log.info("*** Fin solicitudesPend ***");
        return response;
    }

    public solicitudesPendientesDTO consulta(String facebookID, String codigoID, String solicitanteID) {
        log.info("*** Inicio consulta ***");
        solicitudesPendientesDTO consultaDTO = new solicitudesPendientesDTO();
        solicitudesPendientesDTO dto = new solicitudesPendientesDTO();
        dto.setFacebookID(facebookID);
        dto.setCodigoID(codigoID);
        dto.setSolicitanteCodeID(solicitanteID);
        consultaDTO = dao.readOne(dto);
        log.info("*** Fin consulta ***");
        return consultaDTO;
    }

    public solicitudesPendientesDTO actualiza(solicitudesPendientesDTO dto) {
        log.info("*** Inicio actualiza ***");
        solicitudesPendientesDTO consultaDTO = new solicitudesPendientesDTO();
        int codError;
        String msjError;
        boolean estado = dao.update(dto);
        if (estado) {
            codError = 0;
            msjError = "Tu Solicitud Ha Sido Enviada Exitosamente";
        } else {
            codError = 8002;
            msjError = "Ha Ocurrido Un Error Inesperado, Si El Problema Persiste Contacta Al Administrador De La APP";
        }
        consultaDTO.setCodigoErrorBD(codError);
        consultaDTO.setMensajeErrorBD(msjError);
        log.info("*** Fin actualiza ***");
        return consultaDTO;
    }

    public solicitudesPendientesDTO creacion(solicitudesPendientesDTO dto) {
        log.info("*** Inicio creacion ***");
        solicitudesPendientesDTO consultaDTO = new solicitudesPendientesDTO();
        int codError;
        String msjError;
        boolean estado = dao.create(dto);
        if (estado) {
            codError = 0;
            msjError = "Tu Solicitud Ha Sido Enviada Exitosamente";
        } else {
            boolean estadoActualizar = dao.update(dto);
            if (estadoActualizar) {
                codError = 0;
                msjError = "Tu Solicitud Ha Sido Enviada Exitosamente";
            } else {
                codError = 8003;
                msjError = "Ha Ocurrido Un Error Inesperado, Si El Problema Persiste Contacta Al Administrador De La APP";
            }
        }
        consultaDTO.setCodigoErrorBD(codError);
        consultaDTO.setMensajeErrorBD(msjError);
        log.info("*** Fin creacion ***");
        return consultaDTO;
    }

    public List<solicitudesPendientesDTO> consultaSolicitudes(String solictudID, Timestamp fechaPartida) {
        log.info("*** Inicio consultaSolicitudes ***");
        List<solicitudesPendientesDTO> consultaLista = new ArrayList();
        solicitudesPendientesDTO dto = new solicitudesPendientesDTO();
        dto.setSolicitanteCodeID(solictudID);
        dto.setFechaPartida(fechaPartida);
        dto.setCodigoErrorBD(1);
        consultaLista = dao.readMany(dto);
        log.info("*** Fin consultaSolicitudes ***");
        return consultaLista;
    }

    public List<solicitudesPendientesDTO> solicitudesRealizadas(String facebookID, String codigoID, Timestamp fechaPartida) {
        log.info("*** Inicio solicitudesRealizadas ***");
        List<solicitudesPendientesDTO> consultaLista = new ArrayList();
        solicitudesPendientesDTO dto = new solicitudesPendientesDTO();
        dto.setFacebookID(facebookID);
        dto.setCodigoID(codigoID);
        dto.setFechaPartida(fechaPartida);
        dto.setCodigoErrorBD(2);
        consultaLista = dao.readMany(dto);
        log.info("*** Fin solicitudesRealizadas ***");
        return consultaLista;
    }
}
