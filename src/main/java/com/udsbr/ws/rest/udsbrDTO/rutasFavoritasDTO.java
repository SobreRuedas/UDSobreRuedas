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
public class rutasFavoritasDTO {

    private String facebookID;
    private String codigoID;
    private String nombreRuta;
    private String descRuta;
    private String longitudOrigen;
    private String latitudOrigen;
    private String longitudDestino;
    private String latitudDestino;
    private int flagFavorita;
    private String descOrigen;
    private String descDestino;
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
    

    public rutasFavoritasDTO() {
    }

    public rutasFavoritasDTO(String facebookID, String codigoID, String nombreRuta) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.nombreRuta = nombreRuta;
    }

    public rutasFavoritasDTO(String facebookID, String codigoID, String nombreRuta, String descRuta, 
            String longitudOrigen, String latitudOrigen, String longitudDestino, String latitudDestino, 
            int flagFavorita, String descOrigen, String descDestino) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.nombreRuta = nombreRuta;
        this.descRuta = descRuta;
        this.longitudOrigen = longitudOrigen;
        this.latitudOrigen = latitudOrigen;
        this.longitudDestino = longitudDestino;
        this.latitudDestino = latitudDestino;
        this.flagFavorita = flagFavorita;
        this.descOrigen = descOrigen;
        this.descDestino = descDestino;
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

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getDescRuta() {
        return descRuta;
    }

    public void setDescRuta(String descRuta) {
        this.descRuta = descRuta;
    }

    public String getLongitudOrigen() {
        return longitudOrigen;
    }

    public void setLongitudOrigen(String longitudOrigen) {
        this.longitudOrigen = longitudOrigen;
    }

    public String getLatitudOrigen() {
        return latitudOrigen;
    }

    public void setLatitudOrigen(String latitudOrigen) {
        this.latitudOrigen = latitudOrigen;
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

    public int getFlagFavorita() {
        return flagFavorita;
    }

    public void setFlagFavorita(int flagFavorita) {
        this.flagFavorita = flagFavorita;
    }

    public String getDescOrigen() {
        return descOrigen;
    }

    public void setDescOrigen(String descOrigen) {
        this.descOrigen = descOrigen;
    }

    public String getDescDestino() {
        return descDestino;
    }

    public void setDescDestino(String descDestino) {
        this.descDestino = descDestino;
    }

}
