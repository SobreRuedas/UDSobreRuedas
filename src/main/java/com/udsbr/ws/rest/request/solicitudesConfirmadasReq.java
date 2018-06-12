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
public class solicitudesConfirmadasReq {

    private String facebookID;
    private String codigoID;
    private String confirmanteCodeID;
    private String nombreConfirmante;
    private String imgFacebookConfirmante;
    private String descRutaConfirmante;
    private int flagObsevacion;
    private String descObservacionConfirm;
    private Timestamp fechaPartida;
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

    public Timestamp getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(Timestamp fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    public int getMetodo() {
        return metodo;
    }

    public void setMetodo(int metodo) {
        this.metodo = metodo;
    }
}
