/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.VO.viajesUsuariosVOResp;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.request.consultaViajesReq;
import com.udsbr.ws.rest.request.viajesUsuariosReq;
import com.udsbr.ws.rest.response.consultaViajesResp;
import com.udsbr.ws.rest.response.viajesUsuariosResp;
import com.udsbr.ws.rest.udsbrDAO.viajesUsuariosDAO;
import com.udsbr.ws.rest.udsbrDTO.viajesUsuariosDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class viajesUsuariosController {

    static Logger log = Logger.getLogger(viajesUsuariosController.class);
    viajesUsuariosDAO dao = new viajesUsuariosDAO();

    public viajesUsuariosResp creaActualizaViaje(viajesUsuariosReq request) {
        log.info("*** Inicio creaActualizaViaje ***");
        int codError = 0;
        String msjError = "";
        //long dia = 86400000;
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        Timestamp fechaSolicitud = new Timestamp(lnMilisegundos);
        viajesUsuariosResp response = new viajesUsuariosResp();
        viajesUsuariosDTO dto = new viajesUsuariosDTO();
        viajesUsuariosDTO consultaDTO = new viajesUsuariosDTO();
        viajesUsuariosDTO resultadoDTO = new viajesUsuariosDTO();
        dto.setFacebookID(request.getFacebookID());
        dto.setCodigoID(request.getCodigoID());
        dto.setNombreUsuario(request.getNombreUsuario());
        dto.setGrupoFacebookID(request.getGrupoFacebookID());
        dto.setGrupoFacebookDesc(request.getGrupoFacebookDesc());
        dto.setDescripcionViaje(request.getDescripcionViaje());
        dto.setObservacionFlag(request.getObservacionFlag());
        dto.setObservacionDesc(request.getObservacionDesc());
        dto.setFechaViaje(request.getFechaViaje());
        dto.setFechaActual(fechaSolicitud);
        dto.setLongitudPartida(request.getLongitudPartida());
        dto.setLatitudPartida(request.getLatitudPartida());
        dto.setLongitudDestino(request.getLongitudDestino());
        dto.setLatitudDestino(request.getLatitudDestino());
        dto.setModoViaje(request.getModoViaje());
        dto.setPlacaVehiculo(request.getPlacaVehiculo());
        dto.setDireccionParitda(request.getDireccionParitda());
        dto.setDireccionDestino(request.getDireccionDestino());
        dto.setImgPerfilFacebook(request.getImgPerfilFacebook());
        dto.setNombreRuta(request.getNombreRuta());

        switch (request.getMetodo()) {
            case 1:
                resultadoDTO = actualizaViaje(dto);
                if (resultadoDTO.getCodigoErrorBD() == 0) {
                    codError = 0;
                    msjError = "Tu Viaje Ha Sido Compartido";
                } else {
                    resultadoDTO = creaViaje(dto);
                    if (resultadoDTO.getCodigoErrorBD() == 0) {
                        codError = 0;
                        msjError = "Tu Viaje Ha Sido Compartido";
                    } else {
                        codError = 0;
                        msjError = "Upss!! Se Ha Producido Un Error Inesperado, Si El Problema Persiste Contacta Al Administrador De La App";
                        consultaDTO = null;
                    }
                }
                break;
            case 2:
                resultadoDTO = consultaViajeUsuario(request.getFacebookID(), request.getCodigoID());
                if(resultadoDTO.getCodigoErrorBD() == 0){
                    consultaDTO = resultadoDTO;
                 }else{
                    codError = resultadoDTO.getCodigoErrorBD();
                    msjError = resultadoDTO.getMensajeErrorBD();
                    consultaDTO = null;
                }
                break;
            default:
                codError = 10000;
                msjError = "Metodo No Valido";
                consultaDTO = null;
                break;
        }

        response.setCodigoError(codError);
        response.setMsjError(msjError);
        response.setViajes(consultaDTO);
        log.info("*** Fin creaActualizaViaje ***");
        return response;
    }

    public viajesUsuariosDTO consultaViajeUsuario(String facebookID, String codigoID) {
        log.info("*** Inicio consultaViajeUsuario ***");
        viajesUsuariosDTO dto = new viajesUsuariosDTO();
        viajesUsuariosDTO respuestaDTO = new viajesUsuariosDTO();
        dto.setFacebookID(facebookID);
        dto.setCodigoID(codigoID);
        respuestaDTO = dao.readOne(dto);
        log.info("*** Fin consultaViajeUsuario ***");
        return respuestaDTO;
    }

    public viajesUsuariosDTO actualizaViaje(viajesUsuariosDTO dto) {
        log.info("*** Inicio actualizaViaje ***");
        viajesUsuariosDTO respuestaDTO = new viajesUsuariosDTO();
        int codError;
        String msjError;
        boolean estado = dao.update(dto);
        if (estado) {
            codError = 0;
            msjError = "";
        } else {
            codError = 10004;
            msjError = "Uups!!, Ha Ocurrido Un Error Inesperado, Si el Problema Persiste Contacta Al Administrador De La APP";
        }
        respuestaDTO.setCodigoErrorBD(codError);
        respuestaDTO.setMensajeErrorBD(msjError);
        log.info("*** Fin actualizaViaje ***");
        return respuestaDTO;
    }

    public viajesUsuariosDTO creaViaje(viajesUsuariosDTO dto) {
        log.info("*** Inicio creaViaje ***");
        viajesUsuariosDTO respuestaDTO = new viajesUsuariosDTO();
        int codError;
        String msjError;
        boolean estado = dao.create(dto);
        if (estado) {
            codError = 0;
            msjError = "";
        } else {
            codError = 10005;
            msjError = "Uups!!, Ha Ocurrido Un Error Inesperado, Si el Problema Persiste Contacta Al Administrador De La APP";
        }
        respuestaDTO.setCodigoErrorBD(codError);
        respuestaDTO.setMensajeErrorBD(msjError);
        log.info("*** Fin creaViaje ***");
        return respuestaDTO;
    }

    public consultaViajesResp viajesUsuarios(consultaViajesReq req) {
        log.info("*** Inicio viajesUsuarios ***");
        consultaViajesResp response = new consultaViajesResp();
        List<viajesUsuariosVOResp> viajeResp = new ArrayList();
        viajesUsuariosDTO respuestaDTO = new viajesUsuariosDTO();
        List<viajesUsuariosDTO> consultaDTO = new ArrayList();
        consultaDTO = consultaViajes(req.getFacebookID(), req.getCodigoID(), req.getFiltroOrigenKMs(), req.getFiltroDestinoKMs(), req.getModoViaje());
        for (int i = 0; i < consultaDTO.size(); i++) {
            respuestaDTO = consultaDTO.get(i);
            viajeResp.add(new viajesUsuariosVOResp(respuestaDTO.getFacebookID(), respuestaDTO.getCodigoID(),
                    respuestaDTO.getNombreUsuario(), respuestaDTO.getDescripcionViaje(), respuestaDTO.getObservacionFlag(),
                    respuestaDTO.getFechaViaje(), respuestaDTO.getModoViaje(), respuestaDTO.getImgPerfilFacebook()));
        }

        response.setCodigoError(consultaDTO.get(0).getCodigoErrorBD());
        response.setMsjError(consultaDTO.get(0).getMensajeErrorBD());
        response.setViajes(viajeResp);

        log.info("*** Fin viajesUsuarios ***");
        return response;
    }

    public List<viajesUsuariosDTO> consultaViajes(String facebookID, String codigoID, int filtroOrigen, int filtroDestino, int modoViaje) {
        log.info("*** Inicio consultaViajes ***");
        viajesUsuariosDTO dto = new viajesUsuariosDTO();
        List<viajesUsuariosDTO> consultaDTO = new ArrayList();
        filtrosBusquedaBD filtros = new filtrosBusquedaBD();
        long dia = 86400000;
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        Timestamp fechaBusqueda = new Timestamp(lnMilisegundos - dia);
        int pie = 1, cicla = 2, moto = 3, carro = 4;
        int distanciaOrigen = filtroOrigen;
        int distanciaDestino = filtroOrigen;
        switch (modoViaje) {
            case 1:
                cicla = 1;
                break;
            case 2:
                pie = 2;
                moto = 2;
                carro = 2;
                break;
            default:
                cicla = 1;
                moto = 1;
                carro = 1;
                break;
        }
        dto.setFacebookID(facebookID);
        dto.setCodigoID(codigoID);
        dto.setModoViaje(modoViaje);
        dto.setFechaViaje(fechaBusqueda);
        filtros.setModoViajePie(pie);
        filtros.setModoViajeCicla(cicla);
        filtros.setModoViajeMoto(moto);
        filtros.setModoViajeCarro(carro);
        filtros.setDistanciaOrigen(distanciaDestino);
        filtros.setDistanciaDestino(distanciaOrigen);
        consultaDTO = dao.readMany(dto, filtros);
        log.info("*** Fin consultaViajes ***");
        return consultaDTO;
    }
}
