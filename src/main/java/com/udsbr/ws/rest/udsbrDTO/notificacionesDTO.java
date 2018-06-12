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
public class notificacionesDTO {

    private String facebookID;
    private String codigoID;
    private String imgVista;
    private String imgFull;
    private String descripcionBreve;
    private String descripcionFull;
    private String link;
    private Timestamp fechaVista;
    private String titulo;
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
    

    public notificacionesDTO() {
    }

  
    public notificacionesDTO(String facebookID, String codigoID, String titulo) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.titulo = titulo;
    }
    

    public notificacionesDTO(String facebookID, String codigoID, String imgVista, String imgFull, String descripcionBreve, String descripcionFull, String link, Timestamp fechaVista, String titulo) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.imgVista = imgVista;
        this.imgFull = imgFull;
        this.descripcionBreve = descripcionBreve;
        this.descripcionFull = descripcionFull;
        this.link = link;
        this.fechaVista = fechaVista;
        this.titulo = titulo;
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

    public String getImgVista() {
        return imgVista;
    }

    public void setImgVista(String imgVista) {
        this.imgVista = imgVista;
    }

    public String getImgFull() {
        return imgFull;
    }

    public void setImgFull(String imgFull) {
        this.imgFull = imgFull;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public String getDescripcionFull() {
        return descripcionFull;
    }

    public void setDescripcionFull(String descripcionFull) {
        this.descripcionFull = descripcionFull;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Timestamp getFechaVista() {
        return fechaVista;
    }

    public void setFechaVista(Timestamp fechaVista) {
        this.fechaVista = fechaVista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
