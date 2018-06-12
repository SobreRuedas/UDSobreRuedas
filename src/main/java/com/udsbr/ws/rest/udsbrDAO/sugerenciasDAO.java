/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.sugerenciasDTO;
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
public class sugerenciasDAO implements interfaces<sugerenciasDTO> {

    private static final String SQL_READONE = "SELECT * FROM sugerencias WHERE facebookID = ? AND codigoID = ? ";
    private static final String SQL_UPDATE = "UPDATE sugerencias SET phoneID = ?, facebookGroupID = ?, nombreUser = ?, "
            + "ipUsuario = ?, uuIdPhone = ?, platformPhone = ?, versionPhone = ?, "
            + "manufacturePhone = ?, isVirtualPhone = ?, serialPhone = ?, estadoUsuario = ?";
    private static final String SQL_INSERT = "INSERT INTO sugerencias (facebookID, codigoID, titulo, mensaje, clasificacion, fecha) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM sugerencias WHERE facebookID = ? AND codigoID = ? AND fecha = ?";
    private static final String SQL_READMANY = "SELECT * FROM sugerencias WHERE fecha = ?";
    private static final String SQL_READALL = "SELECT * FROM sugerencias";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(sugerenciasDAO.class);

    public boolean create(sugerenciasDTO dto) {
        log.info("*** Inicio sugerenciasDAO create ***");
        PreparedStatement ps;
        boolean resultado = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getTitulo());
            ps.setString(4, dto.getMensaje());
            ps.setInt(5, dto.getClasificacion());
            ps.setTimestamp(6, dto.getFecha());

            log.debug("Script Create" + ps);
            int i = ps.executeUpdate();
            resultado = i != 0;
        } catch (SQLException ex) {
            log.error("Error create sugerenciasDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin sugerenciasDAO create ***");
        return resultado;
    }

    public boolean update(sugerenciasDTO dto) {
        //No se Ha creado Estructura de UPDATE
        log.info("*** Inicio sugerenciasDAO update ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getTitulo());
            ps.setString(4, dto.getMensaje());
            ps.setInt(5, dto.getClasificacion());
            ps.setTimestamp(5, dto.getFecha());
            log.debug("Script UPDATE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error update sugerenciasDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin sugerenciasDAO update ***");
        return false;
    }

    public boolean delete(sugerenciasDTO dto) {
        log.info("*** Inicio sugerenciasDAO delete ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getTitulo());
            log.debug("Script DELETE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error delete sugerenciasDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin sugerenciasDAO delete ***");
        return false;
    }

    public sugerenciasDTO readOne(sugerenciasDTO dto) {
        log.info("*** Inicio sugerenciasDAO readOne ***");
        
        return null;
    }

    public List<sugerenciasDTO> readMany(sugerenciasDTO dto) {
        log.info("*** Inicio sugerenciasDAO readMany ***");
        
        log.info("*** Fin sugerenciasDAO readAll ***");
        return null;
    }

    public List<sugerenciasDTO> readAll() {
        log.info("*** Inicio sugerenciasDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<sugerenciasDTO> sugerencias = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            log.debug("Script READALL" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                sugerencias.add(new sugerenciasDTO(res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getInt(5), res.getTimestamp(6)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany sugerenciasDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin sugerenciasDAO readAll ***");
        return sugerencias;
    }

    public List<sugerenciasDTO> readMany(sugerenciasDTO dto, filtrosBusquedaBD filtros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
