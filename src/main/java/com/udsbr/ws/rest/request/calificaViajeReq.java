/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.request;

import java.sql.Timestamp;

/**
 *
 * @author MIGUEL
 */
public class calificaViajeReq {

    private String facebookID;
    private String codigoID;
    private String codigoIDUsuario;
    private String facebookIDUsuario;
    private int puntuacionViaje;
    private Timestamp fechaActualizacion;
    private String viajeID;
    private Timestamp fechaViaje;
    private String observacionViaje;
    private int observacionType;
    private int metodo;

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

    public String getCodigoIDUsuario() {
        return codigoIDUsuario;
    }

    public void setCodigoIDUsuario(String codigoIDUsuario) {
        this.codigoIDUsuario = codigoIDUsuario;
    }

    public String getFacebookIDUsuario() {
        return facebookIDUsuario;
    }

    public void setFacebookIDUsuario(String facebookIDUsuario) {
        this.facebookIDUsuario = facebookIDUsuario;
    }

    public int getPuntuacionViaje() {
        return puntuacionViaje;
    }

    public void setPuntuacionViaje(int puntuacionViaje) {
        this.puntuacionViaje = puntuacionViaje;
    }

    public Timestamp getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Timestamp fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getViajeID() {
        return viajeID;
    }

    public void setViajeID(String viajeID) {
        this.viajeID = viajeID;
    }

    public Timestamp getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Timestamp fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public String getObservacionViaje() {
        return observacionViaje;
    }

    public void setObservacionViaje(String observacionViaje) {
        this.observacionViaje = observacionViaje;
    }

    public int getObservacionType() {
        return observacionType;
    }

    public void setObservacionType(int observacionType) {
        this.observacionType = observacionType;
    }

    public int getMetodo() {
        return metodo;
    }

    public void setMetodo(int metodo) {
        this.metodo = metodo;
    }
    
    
}
