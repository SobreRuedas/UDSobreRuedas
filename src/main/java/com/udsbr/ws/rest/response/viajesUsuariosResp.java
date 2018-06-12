/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.response;

import com.udsbr.ws.rest.udsbrDTO.viajesUsuariosDTO;

/**
 *
 * @author MIGUEL
 */
public class viajesUsuariosResp {

    private int codigoError;
    private String msjError;
    private viajesUsuariosDTO viajes;

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

    public viajesUsuariosDTO getViajes() {
        return viajes;
    }

    public void setViajes(viajesUsuariosDTO viajes) {
        this.viajes = viajes;
    }
}
