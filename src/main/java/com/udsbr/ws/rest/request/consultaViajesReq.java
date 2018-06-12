/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.request;

/**
 *
 * @author MIGUEL
 */
public class consultaViajesReq {

    private String facebookID;
    private String codigoID;
    private int filtroDestinoKMs;
    private int filtroOrigenKMs;
    private int modoViaje;

    public int getFiltroDestinoKMs() {
        return filtroDestinoKMs;
    }

    public void setFiltroDestinoKMs(int filtroDestinoKMs) {
        this.filtroDestinoKMs = filtroDestinoKMs;
    }

    public int getFiltroOrigenKMs() {
        return filtroOrigenKMs;
    }

    public void setFiltroOrigenKMs(int filtroOrigenKMs) {
        this.filtroOrigenKMs = filtroOrigenKMs;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public String getCodigoID() {
        return codigoID;
    }

    public void setCodigoID(String codigoID) {
        this.codigoID = codigoID;
    }

    public int getModoViaje() {
        return modoViaje;
    }

    public void setModoViaje(int modoViaje) {
        this.modoViaje = modoViaje;
    }

}
