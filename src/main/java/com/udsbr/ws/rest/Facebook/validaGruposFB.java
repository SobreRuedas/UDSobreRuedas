/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.Facebook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udsbr.ws.rest.VO.membersGroupsFBVO;
import com.udsbr.ws.rest.VO.usuarioGroupFBVO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIGUEL
 */
public class validaGruposFB {

    private final String USER_AGENT = "Mozilla/5.0";
    List<usuarioGroupFBVO> respuestaArray = new ArrayList();
   

    // HTTP GET request
    public List<usuarioGroupFBVO> sendGet(String facebookUrl) {
        StringBuilder response = new StringBuilder();
        
       // String url = "https://graph.facebook.com/" + grupoID + "/members?access_token=" + accessToken + "&limit=2";
        String url = facebookUrl;
        URL obj = null;
        HttpURLConnection con;
        BufferedReader in;
        int responseCode = 0;
        try {
            obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestMethod("GET");
            // responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + con.getResponseCode());
            //System.out.println("Response Text : " + con.getInputStream());
            System.out.println("Response responseMessage : " + con.getResponseMessage());
            if (con.getResponseCode() == 200) {
                responseCode = 200;
                in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response);
                System.out.println(response.toString());
            } else {
                responseCode = 0;
                System.out.println("Error " + con.getResponseMessage());
                //System.out.println("Error "+ con.getContent().toString());
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(validaGruposFB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(validaGruposFB.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Convertir la respuesta Json de Facebook a Objeto membersGroupsFBVO
        //print result
        String json = response.toString();
        System.out.println("Obj JSON:" + json);
        //Data data = new Gson().fromJson(json, Data.class);
        ObjectMapper mapper = new ObjectMapper();
        if (responseCode == 200) {
            try {
                membersGroupsFBVO usuarios = mapper.readValue(json, membersGroupsFBVO.class);
                System.out.println("Respuesta Objeto" + usuarios.getData());
                if (usuarios.getPaging().getNext() != null){
                    for(usuarioGroupFBVO i:usuarios.getData()){
                        respuestaArray.add(i);
                    }
                    sendGet(usuarios.getPaging().getNext());
                    System.out.println(usuarios.getPaging().getNext());
                }else {
                    for(usuarioGroupFBVO i:usuarios.getData()){
                        respuestaArray.add(i);
                    }
                    System.out.println("Vacio ");
                }
                for (usuarioGroupFBVO i : respuestaArray) {
                    System.out.println("ID: " + i.getId());
                    System.out.println("name: " + i.getName());
                    System.out.println("administrador: " + i.isAdministrator());
                }
                // Show it.
                //System.out.println(data);
                //final membersGroupsFBVO usuarios = gson.fromJson(json, membersGroupsFBVO.class);
                //System.out.print(usuarios.getData());
            } catch (IOException ex) {
                Logger.getLogger(validaGruposFB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return respuestaArray;
    }
}
