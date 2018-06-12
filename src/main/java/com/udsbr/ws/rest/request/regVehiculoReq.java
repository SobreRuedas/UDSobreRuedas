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
public class regVehiculoReq {

    private String facebookID;
    private String codigoID;
    private String placa;
    private String marca;
    private int tipoVehiculo;
    private int puestosMax;
    private String descVehiculo;
    private String colorVehiculo;
    private String observaciones;
    private int metodoConsulta;

    public int getMetodoConsulta() {
        return metodoConsulta;
    }

    public void setMetodoConsulta(int metodoConsulta) {
        this.metodoConsulta = metodoConsulta;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(int tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getPuestosMax() {
        return puestosMax;
    }

    public void setPuestosMax(int puestosMax) {
        this.puestosMax = puestosMax;
    }

    public String getDescVehiculo() {
        return descVehiculo;
    }

    public void setDescVehiculo(String descVehiculo) {
        this.descVehiculo = descVehiculo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }

    public void setColorVehiculo(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
