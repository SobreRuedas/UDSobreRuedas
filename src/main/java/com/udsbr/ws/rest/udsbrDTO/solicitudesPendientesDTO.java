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
public class solicitudesPendientesDTO {

    private String facebookID;
    private String codigoID;
    private String solicitanteCodeID;
    private String nombreSolicitante;
    private String imgFacebookSolicitante;
    private String descRutaSolicitante;
    private int flagObsevacion;
    private String descObservacionSol;
    private Timestamp fechaSolicitud;
    private Timestamp fechaPartida;
    private int flagActivo;
    private int nroSolicitudes;
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
    

    public solicitudesPendientesDTO() {
    }

    public solicitudesPendientesDTO(String facebookID, String codigoID, String solicitanteCodeID) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.solicitanteCodeID = solicitanteCodeID;
    }

    public solicitudesPendientesDTO(String facebookID, String codigoID, String solicitanteCodeID, 
            String nombreSolicitante, String imgFacebookSolicitante, String descRutaSolicitante, int flagObsevacion, 
            String descObservacionSol, Timestamp fechaSolicitud, Timestamp fechaPartida, int flagActivo, int nroSolicitudes) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.solicitanteCodeID = solicitanteCodeID;
        this.nombreSolicitante = nombreSolicitante;
        this.imgFacebookSolicitante = imgFacebookSolicitante;
        this.descRutaSolicitante = descRutaSolicitante;
        this.flagObsevacion = flagObsevacion;
        this.descObservacionSol = descObservacionSol;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaPartida = fechaPartida;
        this.flagActivo = flagActivo;
        this.nroSolicitudes = nroSolicitudes;
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

    public Timestamp getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Timestamp fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
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

    public int getNroSolicitudes() {
        return nroSolicitudes;
    }

    public void setNroSolicitudes(int nroSolicitudes) {
        this.nroSolicitudes = nroSolicitudes;
    }

}
