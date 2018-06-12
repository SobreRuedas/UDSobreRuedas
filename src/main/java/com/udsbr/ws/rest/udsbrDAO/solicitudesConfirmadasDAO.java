/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.solicitudesConfirmadasDTO;
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
public class solicitudesConfirmadasDAO implements interfaces<solicitudesConfirmadasDTO> {

    private static final String SQL_READONE = "SELECT * FROM solicitudesConfirmadas WHERE facebookID = ? AND codigoID = ? "
            + "AND confirmanteCodeID = ?";
    private static final String SQL_UPDATE = "UPDATE solicitudesConfirmadas SET nombreConfirmante = ?,imgFacebookConfirmante = ?,descRutaConfirmante = ?,"
            + "flagObsevacion = ?,descObservacionConfirm = ?,fechaConfirmacion = ?,fechaPartida = ?,flagActivo = ?,"
            + "nroConfirmaciones = ? "
            + "WHERE facebookID = ? AND codigoID = ? AND confirmanteCodeID = ?";
    private static final String SQL_INSERT = "INSERT INTO solicitudesConfirmadas (facebookID, codigoID, "
            + "confirmanteCodeID, nombreConfirmante, imgFacebookConfirmante, descRutaConfirmante, "
            + "flagObsevacion, descObservacionConfirm, fechaConfirmacion, fechaPartida, flagActivo, nroConfirmaciones) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM solicitudesConfirmadas WHERE facebookID = ? AND codigoID = ? "
            + "AND confirmanteCodeID = ?";
    private static final String SQL_READMANY = "SELECT * FROM solicitudesConfirmadas WHERE confirmanteCodeID = ? AND "
            + "fechaPartida >= ? AND flagActivo = ?";
    private static final String SQL_READMANYCON = "SELECT * FROM solicitudesConfirmadas WHERE facebookID = ? AND codigoID = ? "
            + "AND fechaPartida >= ? AND flagActivo = ?";
    private static final String SQL_READALL = "SELECT * FROM solicitudesConfirmadas";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(solicitudesConfirmadasDAO.class);

    public boolean create(solicitudesConfirmadasDTO dto) {
        log.info("*** Inicio solicitudesConfirmadasDAO create ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getConfirmanteCodeID());
            ps.setString(4, dto.getNombreConfirmante());
            ps.setString(5, dto.getImgFacebookConfirmante());
            ps.setString(6, dto.getDescRutaConfirmante());
            ps.setInt(7, dto.getFlagObsevacion());
            ps.setString(8, dto.getDescObservacionConfirm());
            ps.setTimestamp(9, dto.getFechaConfirmacion());
            ps.setTimestamp(10, dto.getFechaPartida());
            ps.setInt(11, dto.getFlagActivo());
            ps.setInt(12, dto.getNroConfirmaciones());

            log.debug("Script Create" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error create solicitudesConfirmadasDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesConfirmadasDAO create ***");
        return false;
    }

    public boolean update(solicitudesConfirmadasDTO dto) {
        //No se Ha creado Estructura de UPDATE
        log.info("*** Inicio solicitudesConfirmadasDAO update ***");
        PreparedStatement ps;
        boolean estado = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombreConfirmante());
            ps.setString(2, dto.getImgFacebookConfirmante());
            ps.setString(3, dto.getDescRutaConfirmante());
            ps.setInt(4, dto.getFlagObsevacion());
            ps.setString(5, dto.getDescObservacionConfirm());
            ps.setTimestamp(6, dto.getFechaConfirmacion());
            ps.setTimestamp(7, dto.getFechaPartida());
            ps.setInt(8, dto.getFlagActivo());
            ps.setInt(9, dto.getNroConfirmaciones());
            ps.setString(10, dto.getFacebookID());
            ps.setString(11, dto.getCodigoID());
            ps.setString(12, dto.getConfirmanteCodeID());
            log.debug("Script UPDATE" + ps);
            int i = ps.executeUpdate();
            if (i > 0) {
                estado = true;
            }

        } catch (SQLException ex) {
            log.error("Error update solicitudesConfirmadasDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesConfirmadasDAO update ***");
        return estado;
    }

    public boolean delete(solicitudesConfirmadasDTO dto) {
        log.info("*** Inicio solicitudesConfirmadasDAO delete ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getConfirmanteCodeID());
            log.debug("Script DELETE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error delete solicitudesConfirmadasDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesConfirmadasDAO delete ***");
        return false;
    }

    public solicitudesConfirmadasDTO readOne(solicitudesConfirmadasDTO dto) {
        log.info("*** Inicio solicitudesConfirmadasDAO readOne ***");
        PreparedStatement ps;
        ResultSet res;
        solicitudesConfirmadasDTO solicitudesConfirmadas = new solicitudesConfirmadasDTO();
        int codError = 0;
        String msjError = "";
        try {

            ps = con.getCnn().prepareStatement(SQL_READONE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getConfirmanteCodeID());

            log.debug("Script READONE" + ps);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                solicitudesConfirmadas = new solicitudesConfirmadasDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getInt(11), res.getInt(12));
                i++;
            }
            if (i == 0) {
                codError = 9001;
                msjError = "No Existe Registro Con Los Parametros De Busqueda; Si El Problema Persiste Consulte Administrador De La APP";
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadOne solicitudesConfirmadasDAO " + ex);
            codError = 9011;
            msjError = "Ha Ocurrido Un Error :" + ex.getMessage() + "; Si El Problema Persiste Consulte Administrador De La APP";
        } finally {
            con.cerrarConexion();
        }
        solicitudesConfirmadas.setCodigoErrorBD(codError);
        solicitudesConfirmadas.setMensajeErrorBD(msjError);
        log.info("*** Fin solicitudesConfirmadasDAO readOne ***");
        return solicitudesConfirmadas;
    }

    public List<solicitudesConfirmadasDTO> readMany(solicitudesConfirmadasDTO dto) {
        log.info("*** Inicio solicitudesConfirmadasDAO readMany Solicitantes ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<solicitudesConfirmadasDTO> solicitudesConfirmadas = new ArrayList();
        solicitudesConfirmadasDTO consultaDTO = new solicitudesConfirmadasDTO();
        try {
if (dto.getCodigoErrorBD() == 1) {
                ps = con.getCnn().prepareStatement(SQL_READMANY);
                ps.setString(1, dto.getConfirmanteCodeID());
                ps.setTimestamp(2, dto.getFechaPartida());
                ps.setInt(3, 1);
                
            }else{
                ps = con.getCnn().prepareStatement(SQL_READMANYCON);
                ps.setString(1, dto.getFacebookID());
                ps.setString(2, dto.getCodigoID());
                ps.setTimestamp(3, dto.getFechaPartida());
                ps.setInt(4, 1);
            }
            
            res = ps.executeQuery();
            log.debug("Script READMANY" + ps);
            int i =0;
            while (res.next()) {
                solicitudesConfirmadas.add(new solicitudesConfirmadasDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getInt(11), res.getInt(12)));
                i++;
            }
            if (i == 0) {
                consultaDTO.setCodigoErrorBD(9004);
                if (dto.getCodigoErrorBD() == 1){
                consultaDTO.setMensajeErrorBD("No Tienes Confirmaciones Pendientes");
                }else{
                  consultaDTO.setMensajeErrorBD("No Has Realizado Confirmaciones");  
                }
                solicitudesConfirmadas.add(consultaDTO);
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany solicitudesConfirmadasDAO " + ex);
            consultaDTO.setCodigoErrorBD(9014);
            consultaDTO.setMensajeErrorBD("Uuupss!! Se Ha Presentado Un Error: " + ex.getMessage() + ", Si El Problema Continua Contacta Al Administrador De La APP");
            solicitudesConfirmadas.add(consultaDTO);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesConfirmadasDAO readAll ***");
        return solicitudesConfirmadas;
    }

    public List<solicitudesConfirmadasDTO> readAll() {
        log.info("*** Inicio solicitudesConfirmadasDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<solicitudesConfirmadasDTO> solicitudesConfirmadas = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            log.debug("Script READALL" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                solicitudesConfirmadas.add(new solicitudesConfirmadasDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getInt(11), res.getInt(12)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany solicitudesConfirmadasDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesConfirmadasDAO readAll ***");
        return solicitudesConfirmadas;
    }

    public List<solicitudesConfirmadasDTO> readMany(solicitudesConfirmadasDTO dto, filtrosBusquedaBD filtros) {
        log.info("*** Inicio solicitudesConfirmadasDAO readManySol Solicitudes***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<solicitudesConfirmadasDTO> solicitudesConfirmadas = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READMANYCON);
            res = ps.executeQuery();
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setTimestamp(3, dto.getFechaPartida());
            log.debug("Script READMANY" + ps);
            while (res.next()) {
                solicitudesConfirmadas.add(new solicitudesConfirmadasDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7),
                        res.getString(8), res.getTimestamp(9), res.getTimestamp(10), res.getInt(11), res.getInt(12)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany solicitudesConfirmadasDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin solicitudesConfirmadasDAO readManySol ***");
        return solicitudesConfirmadas;

    }

}
