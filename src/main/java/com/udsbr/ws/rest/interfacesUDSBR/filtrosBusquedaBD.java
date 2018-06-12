/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.interfacesUDSBR;

/**
 *
 * @author MIGUEL
 */
public class filtrosBusquedaBD {
    private int modoViajePie;
    private int modoViajeCicla;
    private int modoViajeMoto;
    private int modoViajeCarro;
    private int distanciaOrigen;
    private int distanciaDestino;

    public int getModoViajePie() {
        return modoViajePie;
    }

    public void setModoViajePie(int modoViajePie) {
        this.modoViajePie = modoViajePie;
    }

    public int getModoViajeCicla() {
        return modoViajeCicla;
    }

    public void setModoViajeCicla(int modoViajeCicla) {
        this.modoViajeCicla = modoViajeCicla;
    }

    public int getModoViajeMoto() {
        return modoViajeMoto;
    }

    public void setModoViajeMoto(int modoViajeMoto) {
        this.modoViajeMoto = modoViajeMoto;
    }

    public int getModoViajeCarro() {
        return modoViajeCarro;
    }

    public void setModoViajeCarro(int modoViajeCarro) {
        this.modoViajeCarro = modoViajeCarro;
    }

    public int getDistanciaOrigen() {
        return distanciaOrigen;
    }

    public void setDistanciaOrigen(int distanciaOrigen) {
        this.distanciaOrigen = distanciaOrigen;
    }

    public int getDistanciaDestino() {
        return distanciaDestino;
    }

    public void setDistanciaDestino(int distanciaDestino) {
        this.distanciaDestino = distanciaDestino;
    }

  
    
}
