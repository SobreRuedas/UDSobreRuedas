/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.confUsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class confUsuarioDAO implements interfaces<confUsuarioDTO> {

    private static final String SQL_READONE = "SELECT * FROM confUsuario WHERE facebookID = ? AND codigoID = ? ";
    private static final String SQL_UPDATE = "UPDATE confUsuario SET rutaFavorita = ?, "
            + "modoViaje = ?, placa = ?, puestosDisponibles = ?, correoContacto = ?, telefonoContacto = ?, "
            + "filtroOrigenMts = ?, filtroDestinoMts = ? "
            + "WHERE facebookID = ? AND codigoID = ?";
    private static final String SQL_INSERT = "INSERT INTO confUsuario (facebookID, codigoID, rutaFavorita, modoViaje, "
            + "placa, puestosDisponibles, correoContacto, telefonoContacto, filtroOrigenMts, filtroDestinoMts) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM confUsuario WHERE facebookID = ? AND codigoID = ?";
    //private static final String SQL_READMANY = "SELECT * FROM confUsuario WHERE ";
    private static final String SQL_READALL = "SELECT * FROM confUsuario";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(confUsuarioDAO.class);

    public boolean create(confUsuarioDTO dto) {
        log.info("*** Inicio confUsuarioDAO create ***");
        boolean estadoExecute = false;
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getRutaFavorita());
            ps.setInt(4, dto.getModoViaje());
            ps.setString(5, dto.getPlaca());
            ps.setInt(6, dto.getPuestosDisponibles());
            ps.setString(7, dto.getCorreoContacto());
            ps.setString(8, dto.getTelefonoContacto());
            ps.setInt(9, dto.getFiltroOrigenMts());
            ps.setInt(10, dto.getFiltroDestinoMts());

            log.debug("Script Create" + ps);
            int ejecuta = ps.executeUpdate();
            //return ps.execute();
            //log.debug(""+ejecuta);
            if (ejecuta > 0) {
                estadoExecute = true;
            }

        } catch (SQLException ex) {
            log.error("Error create confUsuarioDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin confUsuarioDAO create ***");
        return estadoExecute;
    }

    public boolean update(confUsuarioDTO dto) {
        //No se Ha creado Estructura de UPDATE
        log.info("*** Inicio confUsuarioDAO update ***");
        PreparedStatement ps;
        boolean validaInsert = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getRutaFavorita());
            ps.setInt(2, dto.getModoViaje());
            ps.setString(3, dto.getPlaca());
            ps.setInt(4, dto.getPuestosDisponibles());
            ps.setString(5, dto.getCorreoContacto());
            ps.setString(6, dto.getTelefonoContacto());
            ps.setInt(7, dto.getFiltroOrigenMts());
            ps.setInt(8, dto.getFiltroDestinoMts());
            ps.setString(9, dto.getFacebookID());
            ps.setString(10, dto.getCodigoID());
            log.debug("Script UPDATE" + ps);
            int ejecuta = ps.executeUpdate();
            
            log.debug(ejecuta);
            if (ejecuta>0){
                validaInsert = true;
            }
        } catch (SQLException ex) {
            log.error("Error update confUsuarioDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin confUsuarioDAO update ***");
        return validaInsert;
    }

    public boolean delete(confUsuarioDTO dto) {
        log.info("*** Inicio confUsuarioDAO delete ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            log.debug("Script DELETE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error delete confUsuarioDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin confUsuarioDAO delete ***");
        return false;
    }

    public confUsuarioDTO readOne(confUsuarioDTO dto) {
        log.info("*** Inicio confUsuarioDAO readOne ***");
        PreparedStatement ps;
        ResultSet res;
        confUsuarioDTO confUsuario = new confUsuarioDTO();

        try {

            ps = con.getCnn().prepareStatement(SQL_READONE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            log.debug("Script READONE" + ps);
            res = ps.executeQuery();
            int i =0;
            while (res.next()) {
                confUsuario = new confUsuarioDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getInt(4), res.getString(5), res.getInt(6), res.getString(7),
                        res.getString(8), res.getInt(9), res.getInt(10));
                i++;
            }
            if(i >0){
                confUsuario.setCodigoErrorBD(0);
            }else{
                confUsuario.setCodigoErrorBD(1001);
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadOne confUsuarioDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin confUsuarioDAO readOne ***");
        return confUsuario;
    }

    public List<confUsuarioDTO> readMany(confUsuarioDTO dto) {
        log.info("*** Inicio confUsuarioDAO readMany Solicitantes***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<confUsuarioDTO> confUsuario = new ArrayList();

        /* try {
        
        ps = con.getCnn().prepareStatement(SQL_READMANY);
        res = ps.executeQuery();
        ps.setString(1, dto.getConfirmanteCodeID());
        ps.setTime(2, dto.getFechaPartida());
        log.debug("Script READMANY" + ps);
        while (res.next()) {
        confUsuario.add(new confUsuarioDTO(res.getString(1), res.getString(2),
        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
        res.getString(8), res.getTime(9), res.getTime(10), res.getInt(11), res.getInt(12)));
        
        }
        } catch (SQLException ex) {
        log.error("Error Sentencia ReadMany confUsuarioDAO " + ex);
        } finally {
        con.cerrarConexion();
        }*/
        log.info("*** Fin confUsuarioDAO readAll ***");
        return confUsuario;
    }

    public List<confUsuarioDTO> readAll() {
        log.info("*** Inicio confUsuarioDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<confUsuarioDTO> confUsuario = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            log.debug("Script READALL" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                confUsuario.add(new confUsuarioDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getInt(4), res.getString(5), res.getInt(6), res.getString(7),
                        res.getString(8), res.getInt(9), res.getInt(10)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany confUsuarioDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin confUsuarioDAO readAll ***");
        return confUsuario;
    }

    public List<confUsuarioDTO> readMany(confUsuarioDTO dto, filtrosBusquedaBD filtros) {
        log.info("*** Inicio confUsuarioDAO readManySol Solicitudes***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<confUsuarioDTO> confUsuario = new ArrayList();
       
        /*try {
        
        ps = con.getCnn().prepareStatement(SQL_READMANYCON);
        res = ps.executeQuery();
        ps.setString(1, dto.getFacebookID());
        ps.setString(2, dto.getCodigoID());
        ps.setTime(3, dto.getFechaPartida());
        log.debug("Script READMANY" + ps);
        while (res.next()) {
        confUsuario.add(new confUsuarioDTO(res.getString(1), res.getString(2),
        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
        res.getString(8), res.getTime(9), res.getTime(10), res.getInt(11), res.getInt(12)));
        
        }
        } catch (SQLException ex) {
        log.error("Error Sentencia ReadMany confUsuarioDAO " + ex);
        } finally {
        con.cerrarConexion();
        }
        log.info("*** Fin confUsuarioDAO readManySol ***");*/
        return confUsuario;

    }

}
