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
public class confUsuarioDTO {

    private String facebookID;
    private String codigoID;
    private String rutaFavorita;
    private int modoViaje;
    private String placa;
    private int puestosDisponibles;
    private String correoContacto;
    private String telefonoContacto;
    private int filtroOrigenMts;
    private int filtroDestinoMts;
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
    

    public confUsuarioDTO() {
    }

    public confUsuarioDTO(String facebookID, String codigoID, String rutaFavorita, int modoViaje, String placa) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.rutaFavorita = rutaFavorita;
        this.modoViaje = modoViaje;
        this.placa = placa;
    }

    public confUsuarioDTO(String facebookID, String codigoID, String rutaFavorita, int modoViaje, String placa, 
            int puestosDisponibles, String correoContacto, String telefonoContacto, int filtroOrigenMts, 
            int filtroDestinoMts) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.rutaFavorita = rutaFavorita;
        this.modoViaje = modoViaje;
        this.placa = placa;
        this.puestosDisponibles = puestosDisponibles;
        this.correoContacto = correoContacto;
        this.telefonoContacto = telefonoContacto;
        this.filtroOrigenMts = filtroOrigenMts;
        this.filtroDestinoMts = filtroDestinoMts;
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

    public String getRutaFavorita() {
        return rutaFavorita;
    }

    public void setRutaFavorita(String rutaFavorita) {
        this.rutaFavorita = rutaFavorita;
    }

    public int getModoViaje() {
        return modoViaje;
    }

    public void setModoViaje(int modoViaje) {
        this.modoViaje = modoViaje;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getPuestosDisponibles() {
        return puestosDisponibles;
    }

    public void setPuestosDisponibles(int puestosDisponibles) {
        this.puestosDisponibles = puestosDisponibles;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public int getFiltroOrigenMts() {
        return filtroOrigenMts;
    }

    public void setFiltroOrigenMts(int filtroOrigenMts) {
        this.filtroOrigenMts = filtroOrigenMts;
    }

    public int getFiltroDestinoMts() {
        return filtroDestinoMts;
    }

    public void setFiltroDestinoMts(int filtroDestinoMts) {
        this.filtroDestinoMts = filtroDestinoMts;
    }

}
