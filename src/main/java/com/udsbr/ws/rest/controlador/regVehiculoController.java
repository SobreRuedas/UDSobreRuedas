/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.controlador;

import com.udsbr.ws.rest.request.regVehiculoReq;
import com.udsbr.ws.rest.response.regVehiculoResp;
import com.udsbr.ws.rest.udsbrDAO.regVehiculoDAO;
import com.udsbr.ws.rest.udsbrDTO.regVehiculoDTO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class regVehiculoController {

    static Logger log = Logger.getLogger(regVehiculoController.class);

    public regVehiculoResp consultaActualizaCreaVehiculo(regVehiculoReq req) {
        log.info("*** Inicio consultaActualizaCreaVehiculo ***");
        regVehiculoDAO dao = new regVehiculoDAO();
        regVehiculoResp response = new regVehiculoResp();
        regVehiculoDTO dto = new regVehiculoDTO();
        regVehiculoDTO consultaDTO = new regVehiculoDTO();
        List<regVehiculoDTO> vehiculos = new ArrayList();
        int codError;
        String msjError;
        dto.setFacebookID(req.getFacebookID());
        dto.setCodigoID(req.getCodigoID());
        dto.setPlaca(req.getPlaca());
        dto.setMarca(req.getMarca());
        dto.setTipoVehiculo(req.getTipoVehiculo());
        dto.setPuestosMax(req.getPuestosMax());
        dto.setDescVehiculo(req.getDescVehiculo());
        dto.setColorVehiculo(req.getColorVehiculo());
        dto.setObservaciones(req.getObservaciones());

        switch (req.getMetodoConsulta()) {
            case 1: //Registra Nuevo Vehiculo
                boolean crea;
                crea = dao.create(dto);
                if (crea) {
                    codError = 0;
                    msjError = "Vehículo Registrado Exitosamente";
                } else {
                    boolean actualiza;
                    actualiza = dao.update(dto);
                    if (actualiza) {
                        codError = 0;
                        msjError = "Se Ha Actualizado La Informacíon Exitosamente";
                    } else {
                        codError = 2004;
                        msjError = "Ha Ocurrido Un Error Inesperado, Si El Problema Persisite Contacte El Administrador de La Aplicación";
                    }
                }
                break;
            case 2:
                vehiculos.add(dao.readOne(dto));
                if (vehiculos.get(0).getCodigoErrorBD() == 0) {
                    codError = 0;
                    msjError = "";
                } else {
                    codError = 2002;
                    msjError = "No Logro Recuperar Registro, Si El Problema Persisite Contacte El Administrador de La Aplicación";

                }
                break;
            case 3:
                vehiculos = dao.readMany(dto);
                log.debug(vehiculos);
                log.debug(" Tamanio  " + vehiculos.size() + " valor 0 " + vehiculos.get(0).getCodigoErrorBD());
                switch (vehiculos.get(vehiculos.size() - 1).getCodigoErrorBD()) {
                    case 2003:
                        codError = 2003;
                        msjError = "Aún No Has Registrado Medios De Transporte";
                        break;
                    case 2013:
                        codError = 2013;
                        msjError = "Ha Ocurrido Un Error Inesperado, Si El Problema Persisite Contacte El Administrador de La Aplicación";
                        break;
                    default:
                        codError = 0;
                        msjError = "";
                        break;
                }

                break;
            case 4:
                boolean actualiza;
                actualiza = dao.update(dto);
                if (actualiza) {
                    codError = 0;
                    msjError = "Se Ha Actualizado La Informacíon Exitosamente";
                } else {
                    codError = 2004;
                    msjError = "Ha Ocurrido Un Error Inesperado, Si El Problema Persisite Contacte El Administrador de La Aplicación";
                }
                break;
            default:
                codError = 2113;
                msjError = "Opción No valida";
                break;
        }
        response.setCodigoError(codError);
        response.setMsjError(msjError);
        response.setVehiculosReg(vehiculos);
        log.info("*** Fin consultaActualizaCreaVehiculo ***");
        return response;
    }

    public List<regVehiculoDTO> consultaVehiculosUsuario(regVehiculoDTO dto) {
        List<regVehiculoDTO> vehiculos = new ArrayList();

        return vehiculos;
    }

    public regVehiculoDTO consultaVehiculo(regVehiculoDTO dto) {
        regVehiculoDTO vehiculo = new regVehiculoDTO();

        return vehiculo;
    }

}
