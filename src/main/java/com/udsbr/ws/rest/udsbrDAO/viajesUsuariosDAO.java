/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.viajesUsuariosDTO;
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
public class viajesUsuariosDAO implements interfaces<viajesUsuariosDTO> {

    private static final String SQL_READONE = "SELECT * FROM viajesUsuarios WHERE facebookID = ? AND codigoID = ? ";
    private static final String SQL_UPDATE = "UPDATE viajesUsuarios SET nombreUsuario = ?, grupoFacebookID = ?, "
            + "grupoFacebookDesc = ?, descripcionViaje = ?, observacionFlag = ?, observacionDesc = ?, fechaViaje = ?, "
            + "fechaActual = ?, longitudPartida = ?, latitudPartida = ?, longitudDestino = ?, latitudDestino = ?, "
            + "modoViaje = ?, placaVehiculo = ?, direccionParitda = ?, direccionDestino = ?, imgPerfilFacebook = ?, nombreRuta = ? "
            + "WHERE facebookID = ? AND codigoID = ?";
    private static final String SQL_INSERT = "INSERT INTO viajesUsuarios (facebookID, codigoID, nombreUsuario, "
            + "grupoFacebookID, grupoFacebookDesc, descripcionViaje, observacionFlag, observacionDesc, fechaViaje, "
            + "fechaActual, longitudPartida, latitudPartida, longitudDestino, latitudDestino, modoViaje, "
            + "placaVehiculo, direccionParitda, direccionDestino, imgPerfilFacebook, nombreRuta) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM viajesUsuarios WHERE facebookID = ? AND codigoID = ?";
    private static final String SQL_READMANY = "SELECT * FROM viajesUsuarios "
            + "WHERE modoViaje IN(?,?,?,?) AND fechaViaje >= ? AND codigoID != ? AND facebookID != ?";
    private static final String SQL_READMANY_DISTANCIA = "SELECT * FROM viajesUsuarios "
            + "WHERE modoViaje IN(?,?,?,?) AND fechaViaje >= ?"
            + "SELECT (acos(sin(radians(36.720139)) * sin(radians(40.425797)) + cos(radians(36.720139)) * cos(radians(40.425797)) * cos(radians(-4.419422) - radians(-3.690462))) * 6378) as distancia";
    private static final String SQL_READALL = "SELECT * FROM viajesUsuarios";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(viajesUsuariosDAO.class);

    public boolean create(viajesUsuariosDTO dto) {
        log.info("*** Inicio viajesUsuariosDAO create ***");
        PreparedStatement ps;
        boolean valida = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getNombreUsuario());
            ps.setString(4, dto.getGrupoFacebookID());
            ps.setString(5, dto.getGrupoFacebookDesc());
            ps.setString(6, dto.getDescripcionViaje());
            ps.setInt(7, dto.getObservacionFlag());
            ps.setString(8, dto.getObservacionDesc());
            ps.setTimestamp(9, dto.getFechaViaje());
            ps.setTimestamp(10, dto.getFechaActual());
            ps.setString(11, dto.getLongitudPartida());
            ps.setString(12, dto.getLatitudPartida());
            ps.setString(13, dto.getLongitudDestino());
            ps.setString(14, dto.getLatitudDestino());
            ps.setInt(15, dto.getModoViaje());
            ps.setString(16, dto.getPlacaVehiculo());
            ps.setString(17, dto.getDireccionParitda());
            ps.setString(18, dto.getDireccionDestino());
            ps.setString(19, dto.getImgPerfilFacebook());
            ps.setString(20, dto.getNombreRuta());

            log.debug("Script Create" + ps);
            int i = 0;
            i = ps.executeUpdate();

            if (i > 0) {
                valida = true;
            }

        } catch (SQLException ex) {
            log.error("Error create viajesUsuariosDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin viajesUsuariosDAO create ***");
        return valida;
    }

    public boolean update(viajesUsuariosDTO dto) {
        //No se Ha creado Estructura de UPDATE
        log.info("*** Inicio viajesUsuariosDAO update ***");
        PreparedStatement ps;
        boolean valida = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombreUsuario());
            ps.setString(2, dto.getGrupoFacebookID());
            ps.setString(3, dto.getGrupoFacebookDesc());
            ps.setString(4, dto.getDescripcionViaje());
            ps.setInt(5, dto.getObservacionFlag());
            ps.setString(6, dto.getObservacionDesc());
            ps.setTimestamp(7, dto.getFechaViaje());
            ps.setTimestamp(8, dto.getFechaActual());
            ps.setString(9, dto.getLongitudPartida());
            ps.setString(10, dto.getLatitudPartida());
            ps.setString(11, dto.getLongitudDestino());
            ps.setString(12, dto.getLatitudDestino());
            ps.setInt(13, dto.getModoViaje());
            ps.setString(14, dto.getPlacaVehiculo());
            ps.setString(15, dto.getDireccionParitda());
            ps.setString(16, dto.getDireccionDestino());
            ps.setString(17, dto.getImgPerfilFacebook());
            ps.setString(18, dto.getNombreRuta());
            ps.setString(19, dto.getFacebookID());
            ps.setString(20, dto.getCodigoID());
            log.debug("Script UPDATE" + ps);
            int i = 0;
            i = ps.executeUpdate();

            if (i > 0) {
                valida = true;
            }
        } catch (SQLException ex) {
            log.error("Error update viajesUsuariosDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin viajesUsuariosDAO update ***");
        return valida;
    }

    public boolean delete(viajesUsuariosDTO dto) {
        log.info("*** Inicio viajesUsuariosDAO delete ***");
        PreparedStatement ps;
        boolean valida = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            log.debug("Script DELETE" + ps);
            int i = 0;
            i = ps.executeUpdate();

            if (i > 0) {
                valida = true;
            }

        } catch (SQLException ex) {
            log.error("Error delete viajesUsuariosDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin viajesUsuariosDAO delete ***");
        return valida;
    }

    public viajesUsuariosDTO readOne(viajesUsuariosDTO dto) {
        log.info("*** Inicio viajesUsuariosDAO readOne ***");
        PreparedStatement ps;
        ResultSet res;
        viajesUsuariosDTO viajesUsuarios = new viajesUsuariosDTO();
        int codError = 0;
        String msjError = "";

        try {

            ps = con.getCnn().prepareStatement(SQL_READONE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());

            log.debug("Script READONE" + ps);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                viajesUsuarios = new viajesUsuariosDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getString(11), res.getString(12),
                        res.getString(13), res.getString(14), res.getInt(15), res.getString(16), res.getString(17),
                        res.getString(18), res.getString(19), res.getString(20));
                i++;
            }
            if (i == 0) {
                codError = 10002;
                msjError = "No Hay Coincidencias Con Los Criterios De Busqueda, Si El Problema Persiste Contacta Al Administrador De La App";
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadOne viajesUsuariosDAO " + ex);
            codError = 10012;
            msjError =  "Uupss!!! Se Ha presentado El Error: "+ ex.getMessage()+", Si el Problema Persiste Contacta Al Administrador De La App";
        } finally {
            con.cerrarConexion();
        }
        viajesUsuarios.setCodigoErrorBD(codError);
        viajesUsuarios.setMensajeErrorBD(msjError);
        log.info("*** Fin viajesUsuariosDAO readOne ***");
        return viajesUsuarios;
    }

    /**
     * Metodo que se encarga de realizar la consulta filtrada hacia la Base de
     * datos de acuerdo a condiciones que se establecen en el Objeto
     * filtrosBusquedaBD.
     *
     * @param dto
     * @param filtros
     * @return
     */
    public List<viajesUsuariosDTO> readMany(viajesUsuariosDTO dto, filtrosBusquedaBD filtros) {
        log.info("*** Inicio viajesUsuariosDAO readMany Solicitantes***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<viajesUsuariosDTO> viajesUsuarios = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READMANY);
            
            ps.setInt(1, filtros.getModoViajePie());
            ps.setInt(2, filtros.getModoViajeCicla());
            ps.setInt(3, filtros.getModoViajeMoto());
            ps.setInt(4, filtros.getModoViajeCarro());
            ps.setTimestamp(5, dto.getFechaViaje());
            ps.setString(6, dto.getCodigoID());
            ps.setString(7, dto.getFacebookID());
            res = ps.executeQuery();
            log.debug("Script READMANY" + ps);
            int i = 0;
            while (res.next()) {
                viajesUsuarios.add(new viajesUsuariosDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getString(11), res.getString(12),
                        res.getString(13), res.getString(14), res.getInt(15), res.getString(16), res.getString(17),
                        res.getString(18), res.getString(19), res.getString(20)));
                i++;
            }
            if (i == 0) {
                dto.setCodigoErrorBD(10001);
                dto.setMensajeErrorBD("No Se Han Encontrado Coincidencias Con Los Criterios De Busqueda");
                viajesUsuarios.add(dto);
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany viajesUsuariosDAO " + ex);
            dto.setCodigoErrorBD(10011);
            dto.setMensajeErrorBD("Uupps!!! Se Ha Producido El Error: " + ex.getMessage() + ", Si El Problema Persiste COntacta Al Administrador De La App");
            viajesUsuarios.add(dto);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin viajesUsuariosDAO readAll ***");
        return viajesUsuarios;
    }

    public List<viajesUsuariosDTO> readAll() {
        log.info("*** Inicio viajesUsuariosDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<viajesUsuariosDTO> viajesUsuarios = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            log.debug("Script READALL" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                viajesUsuarios.add(new viajesUsuariosDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getString(11), res.getString(12),
                        res.getString(13), res.getString(14), res.getInt(15), res.getString(16), res.getString(17),
                        res.getString(18), res.getString(19), res.getString(20)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany viajesUsuariosDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin viajesUsuariosDAO readAll ***");
        return viajesUsuarios;
    }

}
