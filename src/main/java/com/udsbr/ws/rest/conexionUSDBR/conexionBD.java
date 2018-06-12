/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.conexionUSDBR;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;




/**
 *
 * @author MIGUEL
 */
public class conexionBD {

    Properties atributosBD = new Properties();
    
    //ServletContext context = event.getServletContext();
    private final String usuario = "udsbr";
    //Contraseña si tiene, si no tiene entonces dejar en blanco
    // private final String pass = "GDXmix14318";
    private final String pass = "udsbr#01";
    //Servidor (localhost si lo tenemos local) o puede ser un servidor remoto, vinajo
    // private final String host = "mysql23332-env-1119869.j.facilcloud.com";
    private final String host = "localHost";
    //Nombre de la base de datos a la cual queremos conectarnos
    private final String nombre_BD = "udsbr";
    URL fileLocation = getClass().getClassLoader().getResource("configBD.properties");
    
    public static conexionBD instance;
    private Connection cnn;
    static Logger log = Logger.getLogger(conexionBD.class);
    private conexionBD() {
        
        //PropertyConfigurator.configure("log4j.properties");
        log.info("*** Inicio conexionBD ***");
        String servidor, usuarioBD, contrasenaBD;
        try {
            //log.debug("localización URL configDB "+fileLocation.getPath());
            atributosBD.load(new FileReader("/home/gidenutas/UdSobreRuedas/config/configBD.properties"));
            //servidor = "jdbc:mysql://" + atributosBD.getProperty("host") + "/" + atributosBD.getProperty("nombreBD") ;
            servidor = atributosBD.getProperty("UrlBD");
            usuarioBD = atributosBD.getProperty("usuarioBD");
            contrasenaBD = atributosBD.getProperty("contrasena");
            log.debug("Datos de Conexión: Servidor = "+servidor + "Usuario: " + usuarioBD + "contrasena = "+ contrasenaBD);
            //String servidor = "jdbc:mysql://" + host + "/" + nombre_BD;
            try {
                Class.forName("com.mysql.jdbc.Driver");//driver de conexion de la base de datos
                cnn = DriverManager.getConnection(servidor, usuarioBD, contrasenaBD);
            } catch (ClassNotFoundException ex) {
                log.error("Erro Driver de Conexion BD" + ex);
                //Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                log.error("Erro al Conexion BD " + ex);
                //Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            log.error("Error Lectura de Properties BD "+ex);
            //Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            log.error("Error al Cargar Properties BD "+ex);
            //Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.info("*** Fin conexionBD ***");
    }

    public Connection getCnn() {
        //log.info("*** Inicio getCnn ***");
        return cnn;
        
    }

    public synchronized static conexionBD saberEstado() {
        log.info("*** Inicio saberEstado ***");
        if (instance == null) {
            instance = new conexionBD();
        }
        log.info("*** Fin saberEstado ***");
        return instance;
        
    }

    public void cerrarConexion() {
        log.info("*** Inicio cerrarConexion ***");
         instance = null;
        /* try {
        cnn.close();
        } catch (SQLException ex) {
        log.error("Error al Cerrar la conexion a BD "+ex);
        //Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        instance = null;
        }*/
        log.info("*** Fin cerrarConexion ***");
    }
}
