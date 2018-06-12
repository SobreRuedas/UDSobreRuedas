/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.response;

import com.udsbr.ws.rest.request.confUsuarioReq;

/**
 *
 * @author MIGUEL
 */
public class confUsuarioResp {
    private int codigoError;
    private String msjError;
    private confUsuarioReq notificaciones;

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

    public confUsuarioReq getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(confUsuarioReq notificaciones) {
        this.notificaciones = notificaciones;
    }

}
