/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDTO;

import java.sql.Timestamp;

/**
 *
 * @author MIGUEL
 */
public class calificaViajeDTO {

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
    private int codigoErrorBD;
    private String mensajeErrorBD;

    public int getCodigoErrorBD() {
        return codigoErrorBD;
    }

    public void setCodigoErrorBD(int codigoErrorBD) {
        this.codigoErrorBD = codigoErrorBD;
    }

    public String getMensajeErrorBD() {
        return mensajeErrorBD;
    }

    public void setMensajeErrorBD(String mensajeErrorBD) {
        this.mensajeErrorBD = mensajeErrorBD;
    }
    

    public calificaViajeDTO() {
    }

    public calificaViajeDTO(String facebookID, String codigoID, String codigoIDUsuario, String facebookIDUsuario, int puntuacionViaje) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.codigoIDUsuario = codigoIDUsuario;
        this.facebookIDUsuario = facebookIDUsuario;
        this.puntuacionViaje = puntuacionViaje;
    }

    public calificaViajeDTO(String facebookID, String codigoID, String codigoIDUsuario, String facebookIDUsuario, 
            int puntuacionViaje, Timestamp fechaActualizacion, String viajeID, Timestamp fechaViaje, String observacionViaje, 
            int observacionType) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.codigoIDUsuario = codigoIDUsuario;
        this.facebookIDUsuario = facebookIDUsuario;
        this.puntuacionViaje = puntuacionViaje;
        this.fechaActualizacion = fechaActualizacion;
        this.viajeID = viajeID;
        this.fechaViaje = fechaViaje;
        this.observacionViaje = observacionViaje;
        this.observacionType = observacionType;
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
}