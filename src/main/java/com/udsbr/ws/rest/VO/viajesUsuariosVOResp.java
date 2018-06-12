/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.VO;

import java.sql.Timestamp;

/**
 *
 * @author MIGUEL
 */
public class viajesUsuariosVOResp {

    private String facebookID;
    private String codigoID;
    private String nombreUsuario;
    private String descripcionViaje;
    private int observacionFlag;
    private Timestamp fechaViaje;
    private int modoViaje;
    private String imgPerfilFacebook;

    public viajesUsuariosVOResp() {
    }

    public viajesUsuariosVOResp(String facebookID, String codigoID, String nombreUsuario, String descripcionViaje, int observacionFlag, Timestamp fechaViaje, int modoViaje, String imgPerfilFacebook) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.nombreUsuario = nombreUsuario;
        this.descripcionViaje = descripcionViaje;
        this.observacionFlag = observacionFlag;
        this.fechaViaje = fechaViaje;
        this.modoViaje = modoViaje;
        this.imgPerfilFacebook = imgPerfilFacebook;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDescripcionViaje() {
        return descripcionViaje;
    }

    public void setDescripcionViaje(String descripcionViaje) {
        this.descripcionViaje = descripcionViaje;
    }

    public int getObservacionFlag() {
        return observacionFlag;
    }

    public void setObservacionFlag(int observacionFlag) {
        this.observacionFlag = observacionFlag;
    }

    public Timestamp getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Timestamp fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public int getModoViaje() {
        return modoViaje;
    }

    public void setModoViaje(int modoViaje) {
        this.modoViaje = modoViaje;
    }

    public String getImgPerfilFacebook() {
        return imgPerfilFacebook;
    }

    public void setImgPerfilFacebook(String imgPerfilFacebook) {
        this.imgPerfilFacebook = imgPerfilFacebook;
    }

}
