/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.solicitudesPendientesDTO;
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
public class solicitudesPendientesDAO implements interfaces<solicitudesPendientesDTO> {

    private static final String SQL_READONE = "SELECT * FROM solicitudesPendientes WHERE facebookID = ? AND codigoID = ? "
            + "AND solicitanteCodeID = ?";
    private static final String SQL_UPDATE = "UPDATE solicitudesPendientes SET nombreSolicitante = ?,"
            + "imgFacebookSolicitante = ?,descRutaSolicitante = ?,flagObsevacion = ?,descObservacionSol = ?, "
            + "fechaSolicitud = ?,fechaPartida = ?,flagActivo = ?,nroSolicitudes = ? "
            + "WHERE facebookID = ? AND codigoID = ? AND solicitanteCodeID = ?";
    private static final String SQL_INSERT = "INSERT INTO solicitudesPendientes (facebookID, codigoID, "
            + "solicitanteCodeID, nombreSolicitante, imgFacebookSolicitante, descRutaSolicitante, flagObsevacion, "
            + "descObservacionSol, fechaSolicitud, fechaPartida, flagActivo, nroSolicitudes) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM solicitudesPendientes WHERE facebookID = ? AND codigoID = ? "
            + "AND solicitanteCodeID = ?";
    private static final String SQL_READMANY = "SELECT * FROM solicitudesPendientes WHERE solicitanteCodeID = ? "
            + "AND fechaPartida >= ? AND flagActivo = ?";
    private static final String SQL_READMANYSOL = "SELECT * FROM solicitudesPendientes WHERE facebookID = ? AND codigoID = ? "
            + "AND fechaPartida >= ? AND flagActivo = ?";
    private static final String SQL_READALL = "SELECT * FROM solicitudesPendientes ";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(solicitudesPendientesDAO.class);

    public boolean create(solicitudesPendientesDTO dto) {
        log.info("*** Inicio solicitudesPendientesDAO create ***");
        PreparedStatement ps;
        boolean estado = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getSolicitanteCodeID());
            ps.setString(4, dto.getNombreSolicitante());
            ps.setString(5, dto.getImgFacebookSolicitante());
            ps.setString(6, dto.getDescRutaSolicitante());
            ps.setInt(7, dto.getFlagObsevacion());
            ps.setString(8, dto.getDescObservacionSol());
            ps.setTimestamp(9, dto.getFechaSolicitud());
            ps.setTimestamp(10, dto.getFechaPartida());
            ps.setInt(11, dto.getFlagActivo());
            ps.setInt(12, dto.getNroSolicitudes());

            log.debug("Script Create" + ps);
            int i = ps.executeUpdate();
            if (i > 0) {
                estado = true;
            }

        } catch (SQLException ex) {
            log.error("Error create solicitudesPendientesDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesPendientesDAO create ***");
        return estado;
    }

    public boolean update(solicitudesPendientesDTO dto) {
        //No se Ha creado Estructura de UPDATE
        log.info("*** Inicio solicitudesPendientesDAO update ***");
        PreparedStatement ps;
        boolean estado = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);

            ps.setString(1, dto.getNombreSolicitante());
            ps.setString(2, dto.getImgFacebookSolicitante());
            ps.setString(3, dto.getDescRutaSolicitante());
            ps.setInt(4, dto.getFlagObsevacion());
            ps.setString(5, dto.getDescObservacionSol());
            ps.setTimestamp(6, dto.getFechaSolicitud());
            ps.setTimestamp(7, dto.getFechaPartida());
            ps.setInt(8, dto.getFlagActivo());
            ps.setInt(9, dto.getNroSolicitudes());
            ps.setString(10, dto.getFacebookID());
            ps.setString(11, dto.getCodigoID());
            ps.setString(12, dto.getSolicitanteCodeID());
            log.debug("Script UPDATE" + ps);
            int i = ps.executeUpdate();
            if (i > 0) {
                estado = true;
            }

        } catch (SQLException ex) {
            log.error("Error update solicitudesPendientesDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesPendientesDAO update ***");
        return estado;
    }

    public boolean delete(solicitudesPendientesDTO dto) {
        log.info("*** Inicio solicitudesPendientesDAO delete ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getSolicitanteCodeID());
            log.debug("Script DELETE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error delete solicitudesPendientesDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesPendientesDAO delete ***");
        return false;
    }

    public solicitudesPendientesDTO readOne(solicitudesPendientesDTO dto) {
        log.info("*** Inicio solicitudesPendientesDAO readOne ***");
        PreparedStatement ps;
        ResultSet res;
        solicitudesPendientesDTO solicitudesPendientes = new solicitudesPendientesDTO();
        int codError = 0;
        String msjError = "";
        try {

            ps = con.getCnn().prepareStatement(SQL_READONE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getSolicitanteCodeID());

            log.debug("Script READONE" + ps);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                solicitudesPendientes = new solicitudesPendientesDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getInt(11), res.getInt(12));
                i++;
            }
            if (i == 0) {
                codError = 8001;
                msjError = "No Existe Registro Con Los Parametros De Busqueda; Si El Problema Persiste Consulte Administrador De La APP";
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadOne solicitudesPendientesDAO " + ex);
            codError = 8011;
            msjError = "Ha Ocurrido Un Error :" + ex.getMessage() + "; Si El Problema Persiste Consulte Administrador De La APP";
        } finally {
            con.cerrarConexion();
        }
        solicitudesPendientes.setCodigoErrorBD(codError);
        solicitudesPendientes.setMensajeErrorBD(msjError);
        log.info("*** Fin solicitudesPendientesDAO readOne ***");
        return solicitudesPendientes;
    }

    public List<solicitudesPendientesDTO> readMany(solicitudesPendientesDTO dto) {
        log.info("*** Inicio solicitudesPendientesDAO readMany Solicitantes***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<solicitudesPendientesDTO> solicitudesPendientes = new ArrayList();
        solicitudesPendientesDTO consultaDTO = new solicitudesPendientesDTO();
        try {
            if (dto.getCodigoErrorBD() == 1) {
                ps = con.getCnn().prepareStatement(SQL_READMANY);
                ps.setString(1, dto.getSolicitanteCodeID());
                ps.setTimestamp(2, dto.getFechaPartida());
                ps.setInt(3, 1);
                
            }else{
                ps = con.getCnn().prepareStatement(SQL_READMANYSOL);
                ps.setString(1, dto.getFacebookID());
                ps.setString(2, dto.getCodigoID());
                ps.setTimestamp(3, dto.getFechaPartida());
                ps.setInt(4, 1);
            }
            res = ps.executeQuery();
            log.debug("Script READMANY" + ps);
            int i = 0;
            while (res.next()) {
                solicitudesPendientes.add(new solicitudesPendientesDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getInt(11), res.getInt(12)));
                i++;
            }
            if (i == 0) {
                consultaDTO.setCodigoErrorBD(8004);
                if (dto.getCodigoErrorBD() == 1){
                consultaDTO.setMensajeErrorBD("No Tienes Solicitudes Pendientes");
                }else{
                  consultaDTO.setMensajeErrorBD("No Has Realizado Solicitudes");  
                }
                solicitudesPendientes.add(consultaDTO);
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany solicitudesPendientesDAO " + ex);
            consultaDTO.setCodigoErrorBD(8014);
            consultaDTO.setMensajeErrorBD("Uuupss!! Se Ha Presentado Un Error: " + ex.getMessage() + ", Si El Problema Continua Contacta Al Administrador De La APP");
            solicitudesPendientes.add(consultaDTO);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesPendientesDAO readAll ***");
        return solicitudesPendientes;
    }

    public List<solicitudesPendientesDTO> readAll() {
        log.info("*** Inicio solicitudesPendientesDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<solicitudesPendientesDTO> solicitudesPendientes = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            log.debug("Script READALL" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                solicitudesPendientes.add(new solicitudesPendientesDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getInt(11), res.getInt(12)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany solicitudesPendientesDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesPendientesDAO readAll ***");
        return solicitudesPendientes;
    }

    public List<solicitudesPendientesDTO> readMany(solicitudesPendientesDTO dto, filtrosBusquedaBD filtros) {
        log.info("*** Inicio solicitudesPendientesDAO readManySol Solicitudes***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<solicitudesPendientesDTO> solicitudesPendientes = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READMANYSOL);
            res = ps.executeQuery();
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setTimestamp(3, dto.getFechaPartida());
            log.debug("Script READMANY" + ps);
            while (res.next()) {
                solicitudesPendientes.add(new solicitudesPendientesDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getInt(11), res.getInt(12)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany solicitudesPendientesDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesPendientesDAO readManySol ***");
        return solicitudesPendientes;

    }

}
