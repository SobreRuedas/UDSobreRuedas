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
public class notificacionesReq {

    private String facebookID;
    private String codigoID;
    private String imgVista;
    private String imgFull;
    private String descripcionBreve;
    private String descripcionFull;
    private String link;
    private String titulo;

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

    public void setDescripcionFull(String descripciónFull) {
        this.descripcionFull = descripciónFull;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
