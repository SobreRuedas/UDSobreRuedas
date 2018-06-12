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
public class validaInicioDTO {
    private String facebookID;
    private String nameFacebook;
    private String accesToken;
    private boolean administradorFlag;
    private String grupoFB;
    private int inicioSecion;
    private Timestamp fechaRegistro;
    private int codigoErrorBD;
    private String mensajeErrorBD;

    public validaInicioDTO() {
    }

    public validaInicioDTO(String facebookID, String nameFacebook, String accesToken, boolean administradorFlag, String grupoFB, int inicioSecion, Timestamp fechaRegistro) {
        this.facebookID = facebookID;
        this.nameFacebook = nameFacebook;
        this.accesToken = accesToken;
        this.administradorFlag = administradorFlag;
        this.grupoFB = grupoFB;
        this.inicioSecion = inicioSecion;
        this.fechaRegistro = fechaRegistro;
    }

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

    public String getGrupoFB() {
        return grupoFB;
    }

    public void setGrupoFB(String grupoFB) {
        this.grupoFB = grupoFB;
    }

    public int getInicioSecion() {
        return inicioSecion;
    }

    public void setInicioSecion(int inicioSecion) {
        this.inicioSecion = inicioSecion;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
