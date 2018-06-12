/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDTO;

/**
 *
 * @author MIGUEL
 */
public class loginDTO {

    private String facebookID;
    private String codigoID;
    private String phoneID;
    private String phoneModel;
    private String facebookGroupID;
    private String nombreUser;
    private String ipUsuario;
    private String uuIdPhone;
    private String platformPhone;
    private String versionPhone;
    private String manufacturePhone;
    private int isVirtualPhone;
    private String serialPhone;
    private String estadoUsuario;
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
    

    public loginDTO(String facebookID, String codigoID) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
    }

    public loginDTO(String facebookID, String codigoID, String phoneID, String phoneModel, String facebookGroupID, 
            String nombreUser, String ipUsuario, String uuIdPhone, String platformPhone, String versionPhone, 
            String manufacturePhone, int isVirtualPhone, String serialPhone, String estadoUsuario) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.phoneID = phoneID;
        this.phoneModel = phoneModel;
        this.facebookGroupID = facebookGroupID;
        this.nombreUser = nombreUser;
        this.ipUsuario = ipUsuario;
        this.uuIdPhone = uuIdPhone;
        this.platformPhone = platformPhone;
        this.versionPhone = versionPhone;
        this.manufacturePhone = manufacturePhone;
        this.isVirtualPhone = isVirtualPhone;
        this.serialPhone = serialPhone;
        this.estadoUsuario = estadoUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public loginDTO() {
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

    public String getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(String phoneID) {
        this.phoneID = phoneID;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getFacebookGroupID() {
        return facebookGroupID;
    }

    public void setFacebookGroupID(String facebookGroupID) {
        this.facebookGroupID = facebookGroupID;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    public String getUuIdPhone() {
        return uuIdPhone;
    }

    public void setUuIdPhone(String uuIdPhone) {
        this.uuIdPhone = uuIdPhone;
    }

    public String getPlatformPhone() {
        return platformPhone;
    }

    public void setPlatformPhone(String platformPhone) {
        this.platformPhone = platformPhone;
    }

    public String getVersionPhone() {
        return versionPhone;
    }

    public void setVersionPhone(String versionPhone) {
        this.versionPhone = versionPhone;
    }

    public String getManufacturePhone() {
        return manufacturePhone;
    }

    public void setManufacturePhone(String manufacturePhone) {
        this.manufacturePhone = manufacturePhone;
    }

    public int getIsVirtualPhone() {
        return isVirtualPhone;
    }

    public void setIsVirtualPhone(int isVirtualPhone) {
        this.isVirtualPhone = isVirtualPhone;
    }

    public String getSerialPhone() {
        return serialPhone;
    }

    public void setSerialPhone(String serialPhone) {
        this.serialPhone = serialPhone;
    }

}
