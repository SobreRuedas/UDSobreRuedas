/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.rutasFavoritasDTO;
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
public class rutasFavoritasDAO implements interfaces<rutasFavoritasDTO> {

    private static final String SQL_READONE = "SELECT * FROM rutasFavoritas WHERE facebookID = ? AND codigoID = ? AND nombreRuta = ?";
    private static final String SQL_UPDATE = "UPDATE rutasFavoritas SET descRuta = ?, longitudOrigen = ?, latitudOrigen = ?, "
            + "longitudDestino = ?, latitudDestino = ?, flagFavorita = ?, descOrigen = ?, descDestino = ? "
            + "WHERE facebookID = ? AND codigoID = ? AND nombreRuta = ?";
    private static final String SQL_INSERT = "INSERT INTO rutasFavoritas (facebookID, codigoID, nombreRuta, descRuta, "
            + "longitudOrigen, latitudOrigen, longitudDestino, latitudDestino, flagFavorita, descOrigen, descDestino) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM rutasFavoritas WHERE facebookID = ? AND codigoID = ? AND "
            + "nombreRuta = ?";
    private static final String SQL_READMANY = "SELECT * FROM rutasFavoritas WHERE facebookID = ? AND codigoID = ?";
    private static final String SQL_READALL = "SELECT * FROM rutasFavoritas";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(rutasFavoritasDAO.class);

    public boolean create(rutasFavoritasDTO dto) {
        log.info("*** Inicio rutasFavoritasDAO create ***");
        PreparedStatement ps;
        boolean estado = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getNombreRuta());
            ps.setString(4, dto.getDescRuta());
            ps.setString(5, dto.getLongitudOrigen());
            ps.setString(6, dto.getLatitudOrigen());
            ps.setString(7, dto.getLongitudDestino());
            ps.setString(8, dto.getLatitudDestino());
            ps.setInt(9, dto.getFlagFavorita());
            ps.setString(10, dto.getDescOrigen());
            ps.setString(11, dto.getDescDestino());

            log.debug("Script Create" + ps);
            int i = ps.executeUpdate();
            if (i > 0) {
                estado = true;
            }

        } catch (SQLException ex) {
            log.error("Error create rutasFavoritasDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin rutasFavoritasDAO create ***");
        return estado;
    }

    public boolean update(rutasFavoritasDTO dto) {
        //No se Ha creado Estructura de UPDATE
        log.info("*** Inicio rutasFavoritasDAO update ***");
        PreparedStatement ps;
        boolean estado = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);

            ps.setString(1, dto.getDescRuta());
            ps.setString(2, dto.getLongitudOrigen());
            ps.setString(3, dto.getLatitudOrigen());
            ps.setString(4, dto.getLongitudDestino());
            ps.setString(5, dto.getLatitudDestino());
            ps.setInt(6, dto.getFlagFavorita());
            ps.setString(7, dto.getDescOrigen());
            ps.setString(8, dto.getDescDestino());
            ps.setString(9, dto.getFacebookID());
            ps.setString(10, dto.getCodigoID());
            ps.setString(11, dto.getNombreRuta());
            log.debug("Script UPDATE" + ps);
            int i = ps.executeUpdate();
            if (i > 0) {
                estado = true;
            }
        } catch (SQLException ex) {
            log.error("Error update rutasFavoritasDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin rutasFavoritasDAO update ***");
        return estado;
    }

    public boolean delete(rutasFavoritasDTO dto) {
        log.info("*** Inicio rutasFavoritasDAO delete ***");
        PreparedStatement ps;
        boolean estado = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getNombreRuta());
            log.debug("Script DELETE" + ps);
            int i = ps.executeUpdate();
            if (i > 0) {
                estado = true;
            }
        } catch (SQLException ex) {
            log.error("Error delete rutasFavoritasDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin rutasFavoritasDAO delete ***");
        return estado;
    }

    public rutasFavoritasDTO readOne(rutasFavoritasDTO dto) {
        log.info("*** Inicio rutasFavoritasDAO readOne ***");
        PreparedStatement ps;
        ResultSet res;
        rutasFavoritasDTO rutasFavoritas = new rutasFavoritasDTO();
        int codError;
        String msjError;

        try {

            ps = con.getCnn().prepareStatement(SQL_READONE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getNombreRuta());

            log.debug("Script READONE" + ps);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                rutasFavoritas = new rutasFavoritasDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                        res.getString(8), res.getInt(9), res.getString(10), res.getString(11));
                i++;
            }
            if (i > 0) {
                codError = 0;
                msjError = "";
            } else {
                codError = 6004;
                msjError = "No Se Han Encontrado Registros Con El Criterio De Busqueda";
            }
        } catch (SQLException ex) {
            codError = 6014;
            msjError = "Error: " + ex.getMessage();
            log.error("Error Sentencia ReadOne rutasFavoritasDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        rutasFavoritas.setCodigoErrorBD(codError);
        rutasFavoritas.setMensajeErrorBD(msjError);
        log.info("*** Fin rutasFavoritasDAO readOne ***");
        return rutasFavoritas;
    }

    public List<rutasFavoritasDTO> readMany(rutasFavoritasDTO dto) {
        log.info("*** Inicio rutasFavoritasDAO readMany Solicitantes***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<rutasFavoritasDTO> rutasFavoritas = new ArrayList();
        rutasFavoritasDTO respuesta = new rutasFavoritasDTO();
        int codError;
        String msjError;
        try {

            ps = con.getCnn().prepareStatement(SQL_READMANY);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            log.debug("Script READMANY" + ps);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                rutasFavoritas.add(new rutasFavoritasDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                        res.getString(8), res.getInt(9), res.getString(10), res.getString(11)));
                i++;
            }
            if (i > 0) {
                codError = 0;
                msjError = "";
            } else {
                codError = 6005;
                msjError = "No Se Han Encontrado Registros Con El Criterio De Busqueda";
                respuesta = new rutasFavoritasDTO();
                respuesta.setCodigoErrorBD(codError);
                respuesta.setMensajeErrorBD(msjError);
                rutasFavoritas.add(respuesta);
            }
        } catch (SQLException ex) {
            codError = 6015;
            msjError = "Error: " + ex.getMessage();
            respuesta.setCodigoErrorBD(codError);
            respuesta.setMensajeErrorBD(msjError);
            rutasFavoritas.add(respuesta);
            log.error("Error Sentencia ReadMany rutasFavoritasDAO " + ex);
        } finally {
            con.cerrarConexion();
        }

        log.info("*** Fin rutasFavoritasDAO readAll ***");

        return rutasFavoritas;
    }

    public List<rutasFavoritasDTO> readAll() {
        log.info("*** Inicio rutasFavoritasDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<rutasFavoritasDTO> rutasFavoritas = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            log.debug("Script READALL" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                rutasFavoritas.add(new rutasFavoritasDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                        res.getString(8), res.getInt(9), res.getString(10), res.getString(11)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany rutasFavoritasDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin rutasFavoritasDAO readAll ***");
        return rutasFavoritas;
    }

    public List<rutasFavoritasDTO> readMany(rutasFavoritasDTO dto, filtrosBusquedaBD filtros) {

        return null;

    }
}
