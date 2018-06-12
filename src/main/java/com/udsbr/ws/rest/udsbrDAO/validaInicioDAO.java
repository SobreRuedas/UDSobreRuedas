/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.validaInicioDTO;
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
public class validaInicioDAO implements interfaces<validaInicioDTO> {

    private static final String SQL_READONE = "select * from UDSBR.validaInicio where administradorFlag = true and fechainicio"
            + " = (select max(fechainicio) from UDSBR.validaInicio where administradorFlag = true)";
    private static final String SQL_READONEUSER = "select * from UDSBR.validaInicio where facebookID = ?";
    private static final String SQL_UPDATE = "UPDATE validaInicio SET accestoken = ?";
    private static final String SQL_INSERT = "INSERT INTO validaInicio (facebookID, nombreFB, accesToken, administradorFlag, "
            + "grupoFB, inicioSesion, fechaInicio) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM UDSBR.validaInicio WHERE facebookID = ? AND codigoID = ? AND viajeID = ?";
    private static final String SQL_READMANY = "SELECT * FROM UDSBR.validaInicio WHERE facebookID = ?";
    private static final String SQL_UPDATEUSER = "UPDATE UDSBR.validaInicio SET fechainicio = ?, inicioSesion = ? where facebookID = ?";
    private static final String SQL_READALL = "SELECT * FROM UDSBR.validaInicio";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(validaInicioDAO.class);
    private int codError = 0;
    private String msjError = "";

    public boolean create(validaInicioDTO dto) {
        log.info("*** Inicio validaInicioDAO create ***");
        PreparedStatement ps;
        boolean estado = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getNameFacebook());
            ps.setString(3, dto.getAccesToken());
            ps.setBoolean(4, dto.isAdministradorFlag());
            ps.setString(5, dto.getGrupoFB());
            ps.setInt(6, dto.getInicioSecion());
            ps.setTimestamp(7, dto.getFechaRegistro());

            log.debug("Script Create" + ps);
            int i = ps.executeUpdate();
            if (i > 0) {
                estado = true;
            }

        } catch (SQLException ex) {
            log.error("Error create validaInicioDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin validaInicioDAO create ***");
        return estado;
    }

    public boolean update(validaInicioDTO dto) {
        //No se Ha creado Estructura de UPDATE
        log.info("*** Inicio validaInicioDAO update ***");
        PreparedStatement ps;
        try {
            if (dto.getCodigoErrorBD() == 0) {
                ps = con.getCnn().prepareStatement(SQL_UPDATE);
                ps.setString(1, dto.getAccesToken());
                log.debug("Script UPDATE " + ps);
            } else {
                ps = con.getCnn().prepareStatement(SQL_UPDATEUSER);
                ps.setString(3, dto.getFacebookID());
                ps.setInt(2, dto.getInicioSecion());
                ps.setTimestamp(1, dto.getFechaRegistro());
                log.debug("Script UPDATE USER" + ps);
            }

            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error update validaInicioDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin validaInicioDAO update ***");
        return false;
    }

    public boolean delete(validaInicioDTO dto) {
        log.info("*** Inicio validaInicioDAO delete ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getFacebookID());
            log.debug("Script DELETE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error delete validaInicioDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin validaInicioDAO delete ***");
        return false;
    }

    public validaInicioDTO readOne(validaInicioDTO dto) {
        log.info("*** Inicio validaInicioDAO readOne ***");
        PreparedStatement ps;
        ResultSet res;
        validaInicioDTO validaInicio = new validaInicioDTO();

        try {
            if (dto.getCodigoErrorBD() == 0) {
                ps = con.getCnn().prepareStatement(SQL_READONE);
                log.debug("Script READONE" + ps);
            } else {
                ps = con.getCnn().prepareStatement(SQL_READONEUSER);
                ps.setString(1, dto.getFacebookID());
                log.debug("Script READONEUSER" + ps);
            }
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                //log.debug("Ingresa al Res: "+res);
                validaInicio = new validaInicioDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getBoolean(4), res.getString(5), res.getInt(6), res.getTimestamp(7));
                i++;
            }
            //log.debug("valor de i: "+i);
            if (i == 0) {
                codError = 1100;
                msjError = "No Hay Coincidencias Con Los Criterios De Busqueda, Si El Problema Persiste Contacta Al Administrador De La App";
            }
            
            
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadOne validaInicioDAO " + ex);
            codError = 1101;
            msjError = "Upsss... Ha Ocurrido Un Error Inesperado, Si El Problema Persiste Contacta Al Administrador De La App";
            
        } finally {
            validaInicio.setCodigoErrorBD(codError);
            validaInicio.setMensajeErrorBD(msjError);
            con.cerrarConexion();
        }
        log.info("*** Fin validaInicioDAO readOne ***");
        return validaInicio;
    }

    public List<validaInicioDTO> readMany(validaInicioDTO dto) {
        log.info("*** Inicio validaInicioDAO readMany Solicitantes***");
        PreparedStatement ps;
        ResultSet res;
        List<validaInicioDTO> validaInicio = new ArrayList();
        validaInicioDTO repuestaDTO = new validaInicioDTO();

        try {

            ps = con.getCnn().prepareStatement(SQL_READMANY);

            ps.setString(1, dto.getFacebookID());
            // ps.setString(2, dto.getCodigoID());
            log.debug("Script READMANY" + ps);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                validaInicio.add(new validaInicioDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getBoolean(4), res.getString(5), res.getInt(6), res.getTimestamp(7)));
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
                validaInicio.add(repuestaDTO);
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany validaInicioDAO " + ex);
            codError = 7014;
            msjError = "Uppss, Se Ha Presentado El Error: " + ex.getMessage();
            repuestaDTO.setCodigoErrorBD(codError);
            repuestaDTO.setMensajeErrorBD(msjError);
            validaInicio.add(repuestaDTO);
        } finally {
            con.cerrarConexion();
        }

        log.info("*** Fin validaInicioDAO readAll ***");
        return validaInicio;
    }

    public List<validaInicioDTO> readAll() {
        log.info("*** Inicio validaInicioDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<validaInicioDTO> validaInicio = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            log.debug("Script READALL" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                validaInicio.add(new validaInicioDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getBoolean(4), res.getString(5), res.getInt(6), res.getTimestamp(7)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany validaInicioDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin validaInicioDAO readAll ***");
        return validaInicio;
    }

    public List<validaInicioDTO> readMany(validaInicioDTO dto, filtrosBusquedaBD filtros) {
        log.info("*** Inicio validaInicioDAO readManySol Solicitudes***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<validaInicioDTO> validaInicio = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATEUSER);
            res = ps.executeQuery();
            ps.setTimestamp(1, dto.getFechaRegistro());
            ps.setInt(2, dto.getInicioSecion());
            ps.setString(3, dto.getFacebookID());

            log.debug("Script READMANY" + ps);
            while (res.next()) {
                validaInicio.add(new validaInicioDTO(res.getString(1), res.getString(2),
                        res.getString(3), res.getBoolean(4), res.getString(5), res.getInt(6), res.getTimestamp(7)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany validaInicioDAO " + ex);
        }
        log.info("*** Fin validaInicioDAO readManySol ***");
        return validaInicio;

    }

}
