/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.VO;

import java.util.List;

/**
 *
 * @author MIGUEL
 */
public class membersGroupsFBVO {
    private List<usuarioGroupFBVO> data;
    private indicadoresFBPaginVO paging;

    public indicadoresFBPaginVO getPaging() {
        return paging;
    }

    public void setPaging(indicadoresFBPaginVO paging) {
        this.paging = paging;
    }
   
    public List<usuarioGroupFBVO> getData() {
        return data;
    }

    public void setData(List<usuarioGroupFBVO> data) {
        this.data = data;
    }
}
