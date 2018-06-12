/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.response;

import com.udsbr.ws.rest.udsbrDTO.solicitudesPendientesDTO;
import java.util.List;

/**
 *
 * @author MIGUEL
 */
public class solicitudesPendientesResp {

    private int codigoError;
    private String msjError;
    private List<solicitudesPendientesDTO> solicitudes;

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    public String getMsjError() {
        return msjError;
    }

    public void setMsjError(String msjError) {
        this.msjError = msjError;
    }

    public List<solicitudesPendientesDTO> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<solicitudesPendientesDTO> solicitudes) {
        this.solicitudes = solicitudes;
    }

}
