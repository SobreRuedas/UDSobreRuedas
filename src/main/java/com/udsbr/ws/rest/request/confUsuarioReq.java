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
public class confUsuarioReq {

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
    private String nombreUsuario;

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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
