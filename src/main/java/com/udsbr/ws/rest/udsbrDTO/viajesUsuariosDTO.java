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
public class viajesUsuariosDTO {

    private String facebookID;
    private String codigoID;
    private String nombreUsuario;
    private String grupoFacebookID;
    private String grupoFacebookDesc;
    private String descripcionViaje;
    private int observacionFlag;
    private String observacionDesc;
    private Timestamp fechaViaje;
    private Timestamp fechaActual;
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
    private int codigoErrorBD;
    private String mensajeErrorBD;

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
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
    

    public viajesUsuariosDTO() {
    }

    public viajesUsuariosDTO(String facebookID, String codigoID, String longitudPartida, String latitudPartida, String longitudDestino, String latitudDestino) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.longitudPartida = longitudPartida;
        this.latitudPartida = latitudPartida;
        this.longitudDestino = longitudDestino;
        this.latitudDestino = latitudDestino;
    }

    public viajesUsuariosDTO(String facebookID, String codigoID, String nombreUsuario, String grupoFacebookID, 
            String grupoFacebookDesc, String descripcionViaje, int observacionFlag, String observacionDesc, 
            Timestamp fechaViaje, Timestamp fechaActual, String longitudPartida, String latitudPartida, String longitudDestino, 
            String latitudDestino, int modoViaje, String placaVehiculo, String direccionParitda, 
            String direccionDestino, String imgPerfilFacebook, String nombreRuta) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.nombreUsuario = nombreUsuario;
        this.grupoFacebookID = grupoFacebookID;
        this.grupoFacebookDesc = grupoFacebookDesc;
        this.descripcionViaje = descripcionViaje;
        this.observacionFlag = observacionFlag;
        this.observacionDesc = observacionDesc;
        this.fechaViaje = fechaViaje;
        this.fechaActual = fechaActual;
        this.longitudPartida = longitudPartida;
        this.latitudPartida = latitudPartida;
        this.longitudDestino = longitudDestino;
        this.latitudDestino = latitudDestino;
        this.modoViaje = modoViaje;
        this.placaVehiculo = placaVehiculo;
        this.direccionParitda = direccionParitda;
        this.direccionDestino = direccionDestino;
        this.imgPerfilFacebook = imgPerfilFacebook;
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

    public Timestamp getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Timestamp fechaActual) {
        this.fechaActual = fechaActual;
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

}
