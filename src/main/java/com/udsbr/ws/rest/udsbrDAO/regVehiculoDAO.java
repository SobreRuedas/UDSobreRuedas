/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.regVehiculoDTO;
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
public class regVehiculoDAO implements interfaces<regVehiculoDTO> {

    private static final String SQL_READONE = "SELECT * FROM udsbr.regVehiculo WHERE facebookID = ? AND codigoID = ? AND "
            + "placa = ?";
    private static final String SQL_UPDATE = "UPDATE udsbr.regVehiculo SET  marca = ?, tipoVehiculo = ?, "
            + "puestosMax = ?, descVehiculo = ?, colorVehiculo = ?, observaciones = ? "
            + "WHERE facebookID = ? AND codigoID = ? AND placa = ?";
    private static final String SQL_INSERT = "INSERT INTO udsbr.regVehiculo (facebookID, codigoID, placa, marca, "
            + "tipoVehiculo, puestosMax, descVehiculo, colorVehiculo, observaciones) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM udsbr.regVehiculo WHERE facebookID = ? AND codigoID = ? AND "
            + "placa = ?";
    private static final String SQL_READMANY = "SELECT * FROM udsbr.regVehiculo WHERE facebookID = ? AND codigoID = ?";
    private static final String SQL_READALL = "SELECT * FROM udsbr.regVehiculo";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(regVehiculoDAO.class);

    public boolean create(regVehiculoDTO dto) {
        log.info("*** Inicio regVehiculoDAO create ***");
        PreparedStatement ps;
        boolean valida = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getPlaca());
            ps.setString(4, dto.getMarca());
            ps.setInt(5, dto.getTipoVehiculo());
            ps.setInt(6, dto.getPuestosMax());
            ps.setString(7, dto.getDescVehiculo());
            ps.setString(8, dto.getColorVehiculo());
            ps.setString(9, dto.getObservaciones());
            log.debug("Script Create" + ps);
            int i = 0;
            i = ps.executeUpdate();

            if (i > 0) {
                valida = true;
            }

        } catch (SQLException ex) {
            log.error("Error create regVehiculoDAO regVehiculoDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin regVehiculoDAO create ***");
        return valida;
    }

    public boolean update(regVehiculoDTO dto) {
        log.info("*** Inicio regVehiculoDAO update ***");
        PreparedStatement ps;
        boolean valida = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getMarca());
            ps.setInt(2, dto.getTipoVehiculo());
            ps.setInt(3, dto.getPuestosMax());
            ps.setString(4, dto.getDescVehiculo());
            ps.setString(5, dto.getColorVehiculo());
            ps.setString(6, dto.getObservaciones());
            ps.setString(7, dto.getFacebookID());
            ps.setString(8, dto.getCodigoID());
            ps.setString(9, dto.getPlaca());
            log.debug("Script UPDATE" + ps);
            int i = 0;
            i = ps.executeUpdate();

            if (i > 0) {
                valida = true;
            }

        } catch (SQLException ex) {
            log.error("Error update regVehiculoDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin regVehiculoDAO update ***");
        return valida;
    }

    public boolean delete(regVehiculoDTO dto) {
        log.info("*** Inicio regVehiculoDAO delete ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getPlaca());
            log.debug("Script DELETE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error delete regVehiculoDAO regVehiculoDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin regVehiculoDAO delete ***");
        return false;
    }

    public regVehiculoDTO readOne(regVehiculoDTO dto) {
        log.info("*** Inicio regVehiculoDAO readOne ***");
        PreparedStatement ps;
        ResultSet res;
        regVehiculoDTO vehiculosUsuario = new regVehiculoDTO();

        try {

            ps = con.getCnn().prepareStatement(SQL_READONE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getPlaca());
            log.debug("Script READONE" + ps);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                vehiculosUsuario = new regVehiculoDTO(res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getInt(5), res.getInt(6), res.getString(7),
                        res.getString(8), res.getString(9));
                i++;
            }
            if (i == 0) {
                log.debug("valor de i" + i);

                vehiculosUsuario.setCodigoErrorBD(2002);
                vehiculosUsuario.setMensajeErrorBD("No Se Encontro Registro");
            }else{
               vehiculosUsuario.setCodigoErrorBD(0); 
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadOne regVehiculoDAO " + ex);
            vehiculosUsuario.setCodigoErrorBD(2012);
            vehiculosUsuario.setMensajeErrorBD("Ha Ocurrido Un Error Inesperado "+ ex.getMessage());
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin regVehiculoDAO readOne ***");
        return vehiculosUsuario;
    }

    public List<regVehiculoDTO> readMany(regVehiculoDTO dto) {
        log.info("*** Inicio regVehiculoDAO readMany ***");
        PreparedStatement ps;
        ResultSet res;
        List<regVehiculoDTO> vehiculosUsuario = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READMANY);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            res = ps.executeQuery();
            log.debug("Script READMANY" + ps);
            int i = 0;
            log.debug(res);
            while (res.next()) {
                vehiculosUsuario.add(new regVehiculoDTO(res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getInt(5), res.getInt(6), res.getString(7),
                        res.getString(8), res.getString(9)));
                i++;
            }
            if (i == 0) {
                log.debug("valor de i" + i);
                dto.setCodigoErrorBD(2003);
                vehiculosUsuario.add(dto);
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany regVehiculoDAO " + ex);
            dto.setCodigoErrorBD(2013);
            dto.setMensajeErrorBD(ex.getMessage());
            vehiculosUsuario.add(dto);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin regVehiculoDAO readAll ***");
        return vehiculosUsuario;
    }

    public List<regVehiculoDTO> readAll() {
        log.info("*** Inicio regVehiculoDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<regVehiculoDTO> vehiculosUsuario = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            log.debug("Script READALL" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                vehiculosUsuario.add(new regVehiculoDTO(res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getInt(5), res.getInt(6), res.getString(7),
                        res.getString(8), res.getString(9)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany regVehiculoDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin regVehiculoDAO readAll ***");
        return vehiculosUsuario;
    }

    public List<regVehiculoDTO> readMany(regVehiculoDTO dto, filtrosBusquedaBD filtros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
