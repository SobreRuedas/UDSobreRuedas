/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.response;

import com.udsbr.ws.rest.VO.viajesUsuariosVOResp;
import java.util.List;

/**
 *
 * @author MIGUEL
 */
public class consultaViajesResp {
    private int codigoError;
    private String msjError;
    private List<viajesUsuariosVOResp> viajes;

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

    public List<viajesUsuariosVOResp> getViajes() {
        return viajes;
    }

    public void setViajes(List<viajesUsuariosVOResp> viajes) {
        this.viajes = viajes;
    }
    
    
    
}
