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
public class solicitudesConfirmadasDTO {

    private String facebookID;
    private String codigoID;
    private String confirmanteCodeID;
    private String nombreConfirmante;
    private String imgFacebookConfirmante;
    private String descRutaConfirmante;
    private int flagObsevacion;
    private String descObservacionConfirm;
    private Timestamp fechaConfirmacion;
    private Timestamp fechaPartida;
    private int flagActivo;
    private int nroConfirmaciones;
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
    
    public solicitudesConfirmadasDTO() {
    }

    public solicitudesConfirmadasDTO(String codigoID, String confirmanteCodeID, String nombreConfirmante) {
        this.codigoID = codigoID;
        this.confirmanteCodeID = confirmanteCodeID;
        this.nombreConfirmante = nombreConfirmante;
    }

    public solicitudesConfirmadasDTO(String facebookID, String codigoID, String confirmanteCodeID, 
            String nombreConfirmante, String imgFacebookConfirmante, String descRutaConfirmante, 
            int flagObsevacion, String descObservacionConfirm, Timestamp fechaConfirmacion, Timestamp fechaPartida, 
            int flagActivo, int nroConfirmaciones) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.confirmanteCodeID = confirmanteCodeID;
        this.nombreConfirmante = nombreConfirmante;
        this.imgFacebookConfirmante = imgFacebookConfirmante;
        this.descRutaConfirmante = descRutaConfirmante;
        this.flagObsevacion = flagObsevacion;
        this.descObservacionConfirm = descObservacionConfirm;
        this.fechaConfirmacion = fechaConfirmacion;
        this.fechaPartida = fechaPartida;
        this.flagActivo = flagActivo;
        this.nroConfirmaciones = nroConfirmaciones;
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

    public String getConfirmanteCodeID() {
        return confirmanteCodeID;
    }

    public void setConfirmanteCodeID(String confirmanteCodeID) {
        this.confirmanteCodeID = confirmanteCodeID;
    }

    public String getNombreConfirmante() {
        return nombreConfirmante;
    }

    public void setNombreConfirmante(String nombreConfirmante) {
        this.nombreConfirmante = nombreConfirmante;
    }

    public String getImgFacebookConfirmante() {
        return imgFacebookConfirmante;
    }

    public void setImgFacebookConfirmante(String imgFacebookConfirmante) {
        this.imgFacebookConfirmante = imgFacebookConfirmante;
    }

    public String getDescRutaConfirmante() {
        return descRutaConfirmante;
    }

    public void setDescRutaConfirmante(String descRutaConfirmante) {
        this.descRutaConfirmante = descRutaConfirmante;
    }

    public int getFlagObsevacion() {
        return flagObsevacion;
    }

    public void setFlagObsevacion(int flagObsevacion) {
        this.flagObsevacion = flagObsevacion;
    }

    public String getDescObservacionConfirm() {
        return descObservacionConfirm;
    }

    public void setDescObservacionConfirm(String descObservacionConfirm) {
        this.descObservacionConfirm = descObservacionConfirm;
    }

    public Timestamp getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(Timestamp fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public Timestamp getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(Timestamp fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    public int getFlagActivo() {
        return flagActivo;
    }

    public void setFlagActivo(int flagActivo) {
        this.flagActivo = flagActivo;
    }

    public int getNroConfirmaciones() {
        return nroConfirmaciones;
    }

    public void setNroConfirmaciones(int nroConfirmaciones) {
        this.nroConfirmaciones = nroConfirmaciones;
    }

}
