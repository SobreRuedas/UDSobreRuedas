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
public class viajesUsuariosReq {

    private String facebookID;
    private String codigoID;
    private String nombreUsuario;
    private String grupoFacebookID;
    private String grupoFacebookDesc;
    private String descripcionViaje;
    private int observacionFlag;
    private String observacionDesc;
    private Timestamp fechaViaje;
    private String longitudPartida;
    private String latitudPartida;
    private String longitudDestino;
    private String latitudDestino;
    private int modoViaje;
    private String placaVehiculo;
    private String direccionParitda;
    private String direccionDestino;
    private String imgPerfilFacebook;
    private String nombreRuta;
    private int metodo;

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
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

    public String getGrupoFacebookID() {
        return grupoFacebookID;
    }

    public void setGrupoFacebookID(String grupoFacebookID) {
        this.grupoFacebookID = grupoFacebookID;
    }

    public String getGrupoFacebookDesc() {
        return grupoFacebookDesc;
    }

    public void setGrupoFacebookDesc(String grupoFacebookDesc) {
        this.grupoFacebookDesc = grupoFacebookDesc;
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

    public String getObservacionDesc() {
        return observacionDesc;
    }

    public void setObservacionDesc(String observacionDesc) {
        this.observacionDesc = observacionDesc;
    }

    public Timestamp getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Timestamp fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public String getLongitudPartida() {
        return longitudPartida;
    }

    public void setLongitudPartida(String longitudPartida) {
        this.longitudPartida = longitudPartida;
    }

    public String getLatitudPartida() {
        return latitudPartida;
    }

    public void setLatitudPartida(String latitudPartida) {
        this.latitudPartida = latitudPartida;
    }

    public String getLongitudDestino() {
        return longitudDestino;
    }

    public void setLongitudDestino(String longitudDestino) {
        this.longitudDestino = longitudDestino;
    }

    public String getLatitudDestino() {
        return latitudDestino;
    }

    public void setLatitudDestino(String latitudDestino) {
        this.latitudDestino = latitudDestino;
    }

    public int getModoViaje() {
        return modoViaje;
    }

    public void setModoViaje(int modoViaje) {
        this.modoViaje = modoViaje;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getDireccionParitda() {
        return direccionParitda;
    }

    public void setDireccionParitda(String direccionParitda) {
        this.direccionParitda = direccionParitda;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getImgPerfilFacebook() {
        return imgPerfilFacebook;
    }

    public void setImgPerfilFacebook(String imgPerfilFacebook) {
        this.imgPerfilFacebook = imgPerfilFacebook;
    }

    public int getMetodo() {
        return metodo;
    }

    public void setMetodo(int metodo) {
        this.metodo = metodo;
    }

}
