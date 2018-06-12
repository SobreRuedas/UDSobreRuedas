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
public class validaInicioReq {
    private String facebookID;
    private String nameFacebook;
    private String accesToken;
    private boolean administradorFlag;
    private int metodo;

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public String getNameFacebook() {
        return nameFacebook;
    }

    public void setNameFacebook(String nameFacebook) {
        this.nameFacebook = nameFacebook;
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    public boolean isAdministradorFlag() {
        return administradorFlag;
    }

    public void setAdministradorFlag(boolean administradorFlag) {
        this.administradorFlag = administradorFlag;
    }

    public int getMetodo() {
        return metodo;
    }

    public void setMetodo(int metodo) {
        this.metodo = metodo;
    }
    
    
}
