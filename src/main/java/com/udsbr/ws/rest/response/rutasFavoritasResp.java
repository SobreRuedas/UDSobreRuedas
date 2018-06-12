/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.response;

import com.udsbr.ws.rest.udsbrDTO.rutasFavoritasDTO;
import java.util.List;

/**
 *
 * @author MIGUEL
 */
public class rutasFavoritasResp {
    private int codigoError;
    private String msjError;
    private List<rutasFavoritasDTO> rutas;

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

    public List<rutasFavoritasDTO> getRutas() {
        return rutas;
    }

    public void setRutas(List<rutasFavoritasDTO> rutas) {
        this.rutas = rutas;
    }
    
    
}
