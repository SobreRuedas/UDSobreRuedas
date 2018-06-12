/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.response;

/**
 *
 * @author MIGUEL
 */
public class validaUsuarioResp {

    private int codError;
    private String msjError;
    private int codEvento; //se establece la operacion que el frontEnd debe seguir 1=ok, 2= volver a consultar Grupo, 3 = no permitir Ingreso a la app se debera mostrar mensaje de contactar a administrador
    private String msjEvento; // solo aplica si el codEvento = 3
    private String idUsuario; // pendiente con el objetivo de identificar al usuario en un chat o comunicacón interna
    private String estadoUsuario; //Objetivo es validar si se permite o no el ingreso

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    public int getCodError() {
        return codError;
    }

    public void setCodError(int codError) {
        this.codError = codError;
    }

    public String getMsjError() {
        return msjError;
    }

    public void setMsjError(String msjError) {
        this.msjError = msjError;
    }

    public int getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(int codEvento) {
        this.codEvento = codEvento;
    }

    public String getMsjEvento() {
        return msjEvento;
    }

    public void setMsjEvento(String msjEvento) {
        this.msjEvento = msjEvento;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
