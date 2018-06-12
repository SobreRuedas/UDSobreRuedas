/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.request.solicitudesConfirmadasReq;
import com.udsbr.ws.rest.response.solicitudesConfirmadasResp;
import com.udsbr.ws.rest.udsbrDAO.solicitudesConfirmadasDAO;
import com.udsbr.ws.rest.udsbrDTO.solicitudesConfirmadasDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class solicitudesConfirmadasController {

    static Logger log = Logger.getLogger(solicitudesConfirmadasController.class);
    solicitudesConfirmadasDAO dao = new solicitudesConfirmadasDAO();

    public solicitudesConfirmadasResp solicitudesConf(solicitudesConfirmadasReq request) {
        log.info("*** Inicio solicitudesConf ***");
        solicitudesConfirmadasResp response = new solicitudesConfirmadasResp();
        solicitudesConfirmadasDTO dto = new solicitudesConfirmadasDTO();
        solicitudesConfirmadasDTO consultaDTO = new solicitudesConfirmadasDTO();
        solicitudesConfirmadasDTO respuestaDTO = new solicitudesConfirmadasDTO();
        List<solicitudesConfirmadasDTO> consultaLista = new ArrayList();
        int codError = 0;
        String msjError = "";
        long dia = 86400000;
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        Timestamp fechaSolicitud = new Timestamp(lnMilisegundos);
        Timestamp fechaPartida = new Timestamp(lnMilisegundos - dia);
        dto.setFacebookID(request.getFacebookID());
        dto.setCodigoID(request.getCodigoID());
        dto.setConfirmanteCodeID(request.getConfirmanteCodeID());
        dto.setNombreConfirmante(request.getNombreConfirmante());
        dto.setImgFacebookConfirmante(request.getImgFacebookConfirmante());
        dto.setDescRutaConfirmante(request.getDescRutaConfirmante());
        dto.setFlagObsevacion(request.getFlagObsevacion());
        dto.setDescObservacionConfirm(request.getDescObservacionConfirm());
        dto.setFechaPartida(request.getFechaPartida());
        dto.setFechaConfirmacion(fechaSolicitud);
        //dto.setFlagActivo(request.getFlagActivo());
        //dto.setNroConfirmaciones(request.setNroConfirmaciones());
        switch (request.getMetodo()) {
            case 1:
                consultaDTO = consulta(request.getFacebookID(), request.getCodigoID(), request.getConfirmanteCodeID());
                switch (consultaDTO.getCodigoErrorBD()) {
                    case 0:
                        dto.setNroConfirmaciones(consultaDTO.getNroConfirmaciones() + 1);
                        dto.setFlagActivo(1);
                        respuestaDTO = actualiza(dto);
                        codError = respuestaDTO.getCodigoErrorBD();
                        msjError = respuestaDTO.getMensajeErrorBD();
                        break;
                    case 9001:
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
                    respuestaDTO.setMensajeErrorBD("Tu Confirmación Ha Sido Eliminada");
                }
                codError = respuestaDTO.getCodigoErrorBD();
                msjError = respuestaDTO.getMensajeErrorBD();
                break;
            case 3:
                consultaLista = consultaSolicitudes(request.getConfirmanteCodeID(), fechaPartida);
                codError = consultaLista.get(0).getCodigoErrorBD();
                msjError = consultaLista.get(0).getMensajeErrorBD();
                break;
            case 4:
                consultaLista = solicitudesConfirmadas(request.getFacebookID(), request.getCodigoID(), fechaPartida);
                codError = consultaLista.get(0).getCodigoErrorBD();
                msjError = consultaLista.get(0).getMensajeErrorBD();
                break;
            default:
                codError = 9100;
                msjError = "Opción No Valida";
                break;
        }
        response.setCodigoError(codError);
        response.setMsjError(msjError);
        response.setSolicitudes(consultaLista);
        log.info("*** Fin solicitudesConf ***");
        return response;
    }

    public solicitudesConfirmadasDTO consulta(String facebookID, String codigoID, String solicitanteID) {
        log.info("*** Inicio consulta ***");
        solicitudesConfirmadasDTO consultaDTO = new solicitudesConfirmadasDTO();
        solicitudesConfirmadasDTO dto = new solicitudesConfirmadasDTO();
        dto.setFacebookID(facebookID);
        dto.setCodigoID(codigoID);
        dto.setConfirmanteCodeID(solicitanteID);
        consultaDTO = dao.readOne(dto);
        log.info("*** Fin consulta ***");
        return consultaDTO;
    }

    public solicitudesConfirmadasDTO actualiza(solicitudesConfirmadasDTO dto) {
        log.info("*** Inicio actualiza ***");
        solicitudesConfirmadasDTO consultaDTO = new solicitudesConfirmadasDTO();
        int codError;
        String msjError;
        boolean estado = dao.update(dto);
        if (estado) {
            codError = 0;
            msjError = "Tu Confirmación Ha Sido Enviada Exitosamente";
        } else {
            codError = 9002;
            msjError = "Ha Ocurrido Un Error Inesperado, Si El Problema Persiste Contacta Al Administrador De La APP";
        }
        consultaDTO.setCodigoErrorBD(codError);
        consultaDTO.setMensajeErrorBD(msjError);
        log.info("*** Fin actualiza ***");
        return consultaDTO;
    }

    public solicitudesConfirmadasDTO creacion(solicitudesConfirmadasDTO dto) {
        log.info("*** Inicio creacion ***");
        solicitudesConfirmadasDTO consultaDTO = new solicitudesConfirmadasDTO();
        int codError;
        String msjError;
        boolean estado = dao.create(dto);
        if (estado) {
            codError = 0;
            msjError = "Tu Confirmación Ha Sido Enviada Exitosamente";
        } else {
            boolean estadoActualiza = dao.update(dto);
            if (estadoActualiza) {
                codError = 0;
                msjError = "Tu Confirmación Ha Sido Enviada Exitosamente";
            } else {
                codError = 9003;
                msjError = "Ha Ocurrido Un Error Inesperado, Si El Problema Persiste Contacta Al Administrador De La APP";
            }
        }
        consultaDTO.setCodigoErrorBD(codError);
        consultaDTO.setMensajeErrorBD(msjError);
        log.info("*** Fin creacion ***");
        return consultaDTO;
    }

    public List<solicitudesConfirmadasDTO> consultaSolicitudes(String confirmanteID, Timestamp fechaPartida) {
        log.info("*** Inicio consultaSolicitudes ***");
        List<solicitudesConfirmadasDTO> consultaLista = new ArrayList();
        solicitudesConfirmadasDTO dto = new solicitudesConfirmadasDTO();
        dto.setConfirmanteCodeID(confirmanteID);
        dto.setFechaPartida(fechaPartida);
        dto.setCodigoErrorBD(1);
        consultaLista = dao.readMany(dto);
        log.info("*** Fin consultaSolicitudes ***");
        return consultaLista;
    }

    public List<solicitudesConfirmadasDTO> solicitudesConfirmadas(String facebookID, String codigoID, Timestamp fechaPartida) {
        log.info("*** Inicio solicitudesConfirmadas ***");
        List<solicitudesConfirmadasDTO> consultaLista = new ArrayList();
        solicitudesConfirmadasDTO dto = new solicitudesConfirmadasDTO();
        dto.setFacebookID(facebookID);
        dto.setCodigoID(codigoID);
        dto.setFechaPartida(fechaPartida);
        dto.setCodigoErrorBD(2);
        consultaLista = dao.readMany(dto);
        log.info("*** Fin solicitudesConfirmadas ***");
        return consultaLista;
    }
}
