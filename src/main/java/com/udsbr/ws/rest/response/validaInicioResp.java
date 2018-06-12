/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.response;

/**
 *
 * @author MIGUEL
 */
public class validaInicioResp {
    private String facebookID;
    private String codigoID;
    private String nameFacebook;
    private String grupoFacebookId;
    private String grupoFacebookName;
    private boolean acceso;
    private boolean validaCodigo;
    private int codigoError;
    private String msjError;

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

    public String getNameFacebook() {
        return nameFacebook;
    }

    public void setNameFacebook(String nameFacebook) {
        this.nameFacebook = nameFacebook;
    }

    public String getGrupoFacebookId() {
        return grupoFacebookId;
    }

    public void setGrupoFacebookId(String grupoFacebookId) {
        this.grupoFacebookId = grupoFacebookId;
    }

    public String getGrupoFacebookName() {
        return grupoFacebookName;
    }

    public void setGrupoFacebookName(String grupoFacebookName) {
        this.grupoFacebookName = grupoFacebookName;
    }

    public boolean isAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    public boolean isValidaCodigo() {
        return validaCodigo;
    }

    public void setValidaCodigo(boolean validaCodigo) {
        this.validaCodigo = validaCodigo;
    }
    
    
}
