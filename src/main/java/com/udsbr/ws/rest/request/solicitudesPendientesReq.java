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
public class solicitudesPendientesReq {

    private String facebookID;
    private String codigoID;
    private String solicitanteCodeID;
    private String nombreSolicitante;
    private String imgFacebookSolicitante;
    private String descRutaSolicitante;
    private int flagObsevacion;
    private String descObservacionSol;
    private Timestamp fechaPartida;
    private int metodo;

    public int getMetodo() {
        return metodo;
    }

    public void setMetodo(int metodo) {
        this.metodo = metodo;
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

    public String getSolicitanteCodeID() {
        return solicitanteCodeID;
    }

    public void setSolicitanteCodeID(String solicitanteCodeID) {
        this.solicitanteCodeID = solicitanteCodeID;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getImgFacebookSolicitante() {
        return imgFacebookSolicitante;
    }

    public void setImgFacebookSolicitante(String imgFacebookSolicitante) {
        this.imgFacebookSolicitante = imgFacebookSolicitante;
    }

    public String getDescRutaSolicitante() {
        return descRutaSolicitante;
    }

    public void setDescRutaSolicitante(String descRutaSolicitante) {
        this.descRutaSolicitante = descRutaSolicitante;
    }

    public int getFlagObsevacion() {
        return flagObsevacion;
    }

    public void setFlagObsevacion(int flagObsevacion) {
        this.flagObsevacion = flagObsevacion;
    }

    public String getDescObservacionSol() {
        return descObservacionSol;
    }

    public void setDescObservacionSol(String descObservacionSol) {
        this.descObservacionSol = descObservacionSol;
    }

    public Timestamp getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(Timestamp fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

}
