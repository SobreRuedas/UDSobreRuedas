/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDTO;

import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author MIGUEL
 */
public class sugerenciasDTO {

    private String facebookID;
    private String codigoID;
    private String titulo;
    private String mensaje;
    private int clasificacion;
    private Timestamp fecha;
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
    

    public sugerenciasDTO() {
    }

    public sugerenciasDTO(String facebookID, String codigoID) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
    }

    public sugerenciasDTO(String facebookID, String codigoID, String titulo, String mensaje, int clasificacion, Timestamp fecha) {
        this.facebookID = facebookID;
        this.codigoID = codigoID;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.clasificacion = clasificacion;
        this.fecha = fecha;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

}
