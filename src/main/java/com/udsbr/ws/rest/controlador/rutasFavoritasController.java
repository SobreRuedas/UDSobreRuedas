/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.request.rutasFavoritasReq;
import com.udsbr.ws.rest.response.rutasFavoritasResp;
import com.udsbr.ws.rest.udsbrDAO.rutasFavoritasDAO;
import com.udsbr.ws.rest.udsbrDTO.rutasFavoritasDTO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class rutasFavoritasController {

    static Logger log = Logger.getLogger(rutasFavoritasController.class);

    rutasFavoritasDAO dao = new rutasFavoritasDAO();
    int codError;
    String msjError;

    public rutasFavoritasResp crudRutasFavoritas(rutasFavoritasReq request) {
        log.info("*** Inicio crudRutasFavoritas ***");
        rutasFavoritasDTO respuestaDTO = new rutasFavoritasDTO();
        rutasFavoritasResp response = new rutasFavoritasResp();
        rutasFavoritasDTO dto = new rutasFavoritasDTO();
        List<rutasFavoritasDTO> respuestaDTOList = new ArrayList();
        dto.setFacebookID(request.getFacebookID());
        dto.setCodigoID(request.getCodigoID());
        dto.setNombreRuta(request.getNombreRuta());
        dto.setDescRuta(request.getDescRuta());
        dto.setLongitudOrigen(request.getLongitudOrigen());
        dto.setLatitudOrigen(request.getLatitudOrigen());
        dto.setLongitudDestino(request.getLongitudDestino());
        dto.setLatitudDestino(request.getLatitudDestino());
        dto.setFlagFavorita(request.getFlagFavorita());
        dto.setDescOrigen(request.getDescOrigen());
        dto.setDescDestino(request.getDescDestino());
        switch (request.getMetodoConsulta()) {
            case 1:
                respuestaDTO = creaRuta(dto);
                codError = respuestaDTO.getCodigoErrorBD();
                msjError = respuestaDTO.getMensajeErrorBD();
                break;
            case 2:
                respuestaDTO = actualizaRuta(dto);
                codError = respuestaDTO.getCodigoErrorBD();
                msjError = respuestaDTO.getMensajeErrorBD();
                break;
            case 3:
                respuestaDTO = eliminaRuta(dto.getFacebookID(), dto.getCodigoID(), dto.getNombreRuta());
                codError = respuestaDTO.getCodigoErrorBD();
                msjError = respuestaDTO.getMensajeErrorBD();
                break;
            case 4:
                respuestaDTO = consultaRuta(dto.getFacebookID(), dto.getCodigoID(), dto.getNombreRuta());
                codError = respuestaDTO.getCodigoErrorBD();
                msjError = respuestaDTO.getMensajeErrorBD();
                break;
            case 5:
                respuestaDTOList = consultaListaRutas(dto.getFacebookID(), dto.getCodigoID());
                codError = respuestaDTOList.get(0).getCodigoErrorBD();
                msjError = respuestaDTOList.get(0).getMensajeErrorBD();
                break;
            default:
                codError = 6000;
                msjError = "Opcion No Permitida...";
                break;
        }

        response.setCodigoError(codError);
        response.setMsjError(msjError);
        if (request.getMetodoConsulta() == 5) {
            response.setRutas(respuestaDTOList);
        } else {
            //respuestaDTOList = new ArrayList();
            respuestaDTOList.add(respuestaDTO);
            response.setRutas(respuestaDTOList);
        }

        log.info("*** Fin crudRutasFavoritas ***");
        return response;
    }

    public rutasFavoritasDTO creaRuta(rutasFavoritasDTO dto) {
        log.info("*** Inicio creaRuta ***");
        rutasFavoritasDTO respuesta = new rutasFavoritasDTO();
        boolean estado = dao.create(dto);
        if (estado) {
            codError = 0;
            msjError = "Tu Ruta Ha Sido Creada Exitosamente";
        } else {
            boolean estadoActualiza = dao.update(dto);
            if (estadoActualiza) {
                codError = 0;
                msjError = "Tu Ruta Ha Sido Actualizada Exitosamente";
            } else {
                codError = 6003;
                msjError = "Uuupss..., Se Ha Producido Un Error Inesperado, Si El Problema Continua Contacta Al Administrador De La APP";
            }
            /*codError = 6001;
            msjError = "Uuupss..., Se Ha Producido Un Error Inesperado, Si El Problema Continua Contacta Al Administrador De La APP";
             */
        }
        respuesta.setCodigoErrorBD(codError);
        respuesta.setMensajeErrorBD(msjError);
        log.info("*** Fin creaRuta ***");
        return respuesta;
    }

    public rutasFavoritasDTO actualizaRuta(rutasFavoritasDTO dto) {
        log.info("*** Inicio eliminaRuta ***");
        rutasFavoritasDTO respuesta = new rutasFavoritasDTO();
        boolean estado = dao.update(dto);
        if (estado) {
            codError = 0;
            msjError = "Tu Ruta Ha Sido Actualizada Exitosamente";
        } else {
            codError = 6003;
            msjError = "Uuupss..., Se Ha Producido Un Error Inesperado, Si El Problema Continua Contacta Al Administrador De La APP";
        }
        respuesta.setCodigoErrorBD(codError);
        respuesta.setMensajeErrorBD(msjError);
        log.info("*** Fin eliminaRuta ***");
        return respuesta;
    }

    public rutasFavoritasDTO eliminaRuta(String facebookID, String codigoID, String ruta) {
        log.info("*** Inicio eliminaRuta ***");
        rutasFavoritasDTO respuesta = new rutasFavoritasDTO();
        rutasFavoritasDTO dto = new rutasFavoritasDTO();
        dto.setFacebookID(facebookID);
        dto.setCodigoID(codigoID);
        dto.setNombreRuta(ruta);
        boolean estado = dao.delete(dto);
        if (estado) {
            codError = 0;
            msjError = "Tu Ruta Ha Sido Eliminada Exitosamente";
        } else {
            codError = 6002;
            msjError = "Uuupss..., Se Ha Producido Un Error Inesperado, Si El Problema Continua Contacta Al Administrador De La APP";
        }
        respuesta.setCodigoErrorBD(codError);
        respuesta.setMensajeErrorBD(msjError);
        log.info("*** Fin eliminaRuta ***");
        return respuesta;
    }

    public rutasFavoritasDTO consultaRuta(String facebookID, String codigoID, String ruta) {
        log.info("*** Inicio consultaRuta ***");
        rutasFavoritasDTO respuesta = new rutasFavoritasDTO();
        rutasFavoritasDTO dto = new rutasFavoritasDTO();
        dto.setFacebookID(facebookID);
        dto.setCodigoID(codigoID);
        dto.setNombreRuta(ruta);
        respuesta = dao.readOne(dto);
        log.info("*** Fin consultaRuta ***");
        return respuesta;
    }

    public List<rutasFavoritasDTO> consultaListaRutas(String facebookID, String codigoID) {
        log.info("*** Inicio consultaListaRutas ***");
        List<rutasFavoritasDTO> respuesta = new ArrayList();
        rutasFavoritasDTO dto = new rutasFavoritasDTO();
        dto.setFacebookID(facebookID);
        dto.setCodigoID(codigoID);
        respuesta = dao.readMany(dto);
        log.info("*** Fin consultaListaRutas ***");
        return respuesta;
    }

}
