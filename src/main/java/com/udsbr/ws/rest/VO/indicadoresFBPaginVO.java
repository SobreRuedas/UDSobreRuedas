/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.VO;

/**
 *
 * @author MIGUEL
 */
public class indicadoresFBPaginVO {
    private Object cursors;
    private String next;

    public Object getCursors() {
        return cursors;
    }

    public void setCursors(Object cursors) {
        this.cursors = cursors;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
    
}
