/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.calificaViajeDTO;
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
public class calificaViajeDAO implements interfaces<calificaViajeDTO> {

    private static final String SQL_READONE = "SELECT * FROM calificaViaje WHERE facebookID = ? AND codigoID = ? AND viajeID = ?";
    private static final String SQL_UPDATE = "UPDATE calificaViaje SET codigoIDUsuario = ?, facebookIDUsuario = ?, "
            + "puntuacionViaje = ?, fechaActualizacion = ?, fechaViaje = ?, observacionViaje = ?, observacionType = ? "
            + "WHERE facebookID = ? AND codigoID = ? AND viajeID = ?";
    private static final String SQL_INSERT = "INSERT INTO calificaViaje (facebookID, codigoID, codigoIDUsuario, "
            + "facebookIDUsuario, puntuacionViaje, fechaActualizacion, viajeID, fechaViaje, observacionViaje, "
            + "observacionType) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM calificaViaje WHERE facebookID = ? AND codigoID = ? AND viajeID = ?";
    private static final String SQL_READMANY = "SELECT * FROM calificaViaje WHERE facebookID = ? AND codigoID = ?";
    private static final String SQL_READMANYUSER = "SELECT * FROM calificaViaje WHERE facebookIDUsuario = ? "
            + "AND codigoIDUsuario = ?";
    private static final String SQL_READALL = "SELECT * FROM calificaViaje";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(calificaViajeDAO.class);
    private int codError;
    private String msjError;

    public boolean create(calificaViajeDTO dto) {
        log.info("*** Inicio calificaViajeDAO create ***");
        PreparedStatement ps;
        boolean estado = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getCodigoIDUsuario());
            ps.setString(4, dto.getFacebookIDUsuario());
            ps.setInt(5, dto.getPuntuacionViaje());
            ps.setTimestamp(6, dto.getFechaActualizacion());
            ps.setString(7, dto.getViajeID());
            ps.setTimestamp(8, dto.getFechaViaje());
            ps.setString(9, dto.getObservacionViaje());
            ps.setInt(10, dto.getObservacionType());

            log.debug("Script Create" + ps);
            int i = ps.executeUpdate();
            if (i > 0) {
                estado = true;
            }

        } catch (SQLException ex) {
            log.error("Error create calificaViajeDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin calificaViajeDAO create ***");
        return estado;
    }

    public boolean update(calificaViajeDTO dto) {
        //No se Ha creado Estructura de UPDATE
        log.info("*** Inicio calificaViajeDAO update ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getCodigoIDUsuario());
            ps.setString(2, dto.getFacebookIDUsuario());
            ps.setInt(3, dto.getPuntuacionViaje());
            ps.setTimestamp(4, dto.getFechaActualizacion());
            ps.setString(5, dto.getViajeID());
            ps.setTimestamp(6, dto.getFechaViaje());
            ps.setString(7, dto.getObservacionViaje());
            ps.setInt(8, dto.getObservacionType());
            ps.setString(9, dto.getFacebookID());
            ps.setString(10, dto.getCodigoID());
            log.debug("Script UPDATE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error update calificaViajeDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin calificaViajeDAO update ***");
        return false;
    }

    public boolean delete(calificaViajeDTO dto) {
        log.info("*** Inicio calificaViajeDAO delete ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            log.debug("Script DELETE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error delete calificaViajeDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin calificaViajeDAO delete ***");
        return false;
    }

    public calificaViajeDTO readOne(calificaViajeDTO dto) {
        log.info("*** Inicio calificaViajeDAO readOne ***");
        PreparedStatement ps;
        ResultSet res;
        calificaViajeDTO calificaViaje = new calificaViajeDTO();

        try {

            ps = con.getCnn().prepareStatement(SQL_READONE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());

            log.debug("Script READONE" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                calificaViaje = new calificaViajeDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getInt(5), res.getTimestamp(6), res.getString(7),
                        res.getTimestamp(8), res.getString(9), res.getInt(10));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadOne calificaViajeDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin calificaViajeDAO readOne ***");
        return calificaViaje;
    }

    public List<calificaViajeDTO> readMany(calificaViajeDTO dto) {
        log.info("*** Inicio calificaViajeDAO readMany Solicitantes***");
        PreparedStatement ps;
        ResultSet res;
        List<calificaViajeDTO> calificaViaje = new ArrayList();
        calificaViajeDTO repuestaDTO = new calificaViajeDTO();

        try {

            ps = con.getCnn().prepareStatement(SQL_READMANY);

            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            log.debug("Script READMANY" + ps);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                calificaViaje.add(new calificaViajeDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getInt(5), res.getTimestamp(6), res.getString(7),
                        res.getTimestamp(8), res.getString(9), res.getInt(10)));
                i++;
            }
            if (i > 0) {
                codError = 0;
                msjError = "";
            } else {
                codError = 7004;
                msjError = "No Se Han Encontrado Registros Con El Criterio De Busqueda";
                repuestaDTO.setCodigoErrorBD(codError);
                repuestaDTO.setMensajeErrorBD(msjError);
                calificaViaje.add(repuestaDTO);
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany calificaViajeDAO " + ex);
            codError = 7014;
            msjError = "Uppss, Se Ha Presentado El Error: " + ex.getMessage();
            repuestaDTO.setCodigoErrorBD(codError);
            repuestaDTO.setMensajeErrorBD(msjError);
            calificaViaje.add(repuestaDTO);
        } finally {
            con.cerrarConexion();
        }

        log.info("*** Fin calificaViajeDAO readAll ***");
        return calificaViaje;
    }

    public List<calificaViajeDTO> readAll() {
        log.info("*** Inicio calificaViajeDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<calificaViajeDTO> calificaViaje = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            log.debug("Script READALL" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                calificaViaje.add(new calificaViajeDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getInt(5), res.getTimestamp(6), res.getString(7),
                        res.getTimestamp(8), res.getString(9), res.getInt(10)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany calificaViajeDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin calificaViajeDAO readAll ***");
        return calificaViaje;
    }

    public List<calificaViajeDTO> readMany(calificaViajeDTO dto, filtrosBusquedaBD filtros) {
        log.info("*** Inicio calificaViajeDAO readManySol Solicitudes***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<calificaViajeDTO> calificaViaje = new ArrayList();

        /* try {
        
        ps = con.getCnn().prepareStatement(SQL_READMANYCON);
        res = ps.executeQuery();
        ps.setString(1, dto.getFacebookID());
        ps.setString(2, dto.getCodigoID());
        ps.setTimestamp(3, dto.getFechaPartida());
        log.debug("Script READMANY" + ps);
        while (res.next()) {
        calificaViaje.add(new calificaViajeDTO(res.getString(1), res.getString(2),
        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getInt(11), res.getInt(12)));
        
        }
        } catch (SQLException ex) {
        log.error("Error Sentencia ReadMany calificaViajeDAO " + ex);
        } finally {
        con.cerrarConexion();
        }*/
        log.info("*** Fin calificaViajeDAO readManySol ***");
        return calificaViaje;

    }

}
