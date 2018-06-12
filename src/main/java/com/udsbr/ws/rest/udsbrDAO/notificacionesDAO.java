/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.notificacionesDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author MIGUEL
 */
public class notificacionesDAO implements interfaces<notificacionesDTO> {

    private static final String SQL_READONE = "SELECT * FROM notificaciones WHERE facebookID = ? AND codigoID = ?"
            + " AND fechaVista = ? AND titulo = ?";
    private static final String SQL_UPDATE = "UPDATE notificaciones SET imgVista = ?, imgFull = ?, descripcionBreve = ?, "
            + "descripcionFull = ?, link = ?, fechaVista = ? "
            + "WHERE facebookID = ? AND codigoID = ? AND titulo = ?"
            + "manufacturePhone = ?, isVirtualPhone = ?, serialPhone = ?, estadoUsuario = ?";
    private static final String SQL_INSERT = "INSERT INTO notificaciones (facebookID, codigoID, imgVista, imgFull, "
            + "descripcionBreve, descripcionFull, link, fechaVista, titulo) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM notificaciones WHERE facebookID = ? AND codigoID = ? AND titulo = ?";
    private static final String SQL_READMANY = "SELECT * FROM notificaciones WHERE CAST(fechaVista AS DATE) >= ? AND CAST(fechaVista AS DATE) <= ? ";
    private static final String SQL_READALL = "SELECT * FROM notificaciones";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(notificacionesDAO.class);
    long dia = 86400000;

    public boolean create(notificacionesDTO dto) {
        log.info("*** Inicio notificacionesDAO create ***");
        PreparedStatement ps;
        boolean resultado = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getImgVista());
            ps.setString(4, dto.getImgFull());
            ps.setString(5, dto.getDescripcionBreve());
            ps.setString(6, dto.getDescripcionFull());
            ps.setString(7, dto.getLink());
            ps.setTimestamp(8, dto.getFechaVista());
            ps.setString(9, dto.getTitulo());

            log.debug("Script Create" + ps);
            int i = ps.executeUpdate();
            resultado = i != 0;

        } catch (SQLException ex) {
            log.error("Error create notificacionesDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin notificacionesDAO create ***");
        return resultado;
    }

    public boolean update(notificacionesDTO dto) {
        //No se Ha creado Estructura de UPDATE
        log.info("*** Inicio notificacionesDAO update ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getImgVista());
            ps.setString(4, dto.getImgFull());
            ps.setString(5, dto.getDescripcionBreve());
            ps.setString(6, dto.getDescripcionFull());
            ps.setString(7, dto.getLink());
            ps.setTimestamp(8, dto.getFechaVista());
            ps.setString(9, dto.getTitulo());
            log.debug("Script UPDATE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error update notificacionesDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin notificacionesDAO update ***");
        return false;
    }

    public boolean delete(notificacionesDTO dto) {
        log.info("*** Inicio notificacionesDAO delete ***");
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getTitulo());
            log.debug("Script DELETE" + ps);
            return ps.execute();

        } catch (SQLException ex) {
            log.error("Error delete notificacionesDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin notificacionesDAO delete ***");
        return false;
    }

    public notificacionesDTO readOne(notificacionesDTO dto) {
        log.info("*** Inicio notificacionesDAO readOne ***");
        PreparedStatement ps;
        ResultSet res;
        notificacionesDTO notificaciones = new notificacionesDTO();

        try {

            ps = con.getCnn().prepareStatement(SQL_READONE);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setTimestamp(3, dto.getFechaVista());
            ps.setString(4, dto.getTitulo());
            log.debug("Script READONE" + ps);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                notificaciones = new notificacionesDTO(res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                        res.getTimestamp(8), res.getString(9));
                i++;
            }
            if (i == 0) {
                notificaciones.setCodigoErrorBD(4003);
                notificaciones.setMensajeErrorBD("No Hay Notificaciones ha Mostrar, Por favor Intente Mas Tarde");

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadOne notificacionesDAO " + ex);
            notificaciones.setCodigoErrorBD(4013);
            notificaciones.setMensajeErrorBD("Ha Ocurrido Un Error Inesperado " + ex.getMessage() + ", Por favor Intente Mas Tarde");
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin notificacionesDAO readOne ***");
        return notificaciones;
    }

    public List<notificacionesDTO> readMany(notificacionesDTO dto) {
        log.info("*** Inicio notificacionesDAO readMany ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<notificacionesDTO> notificaciones = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READMANY);

            Date fecha = new java.sql.Date(dto.getFechaVista().getTime());

            Date fechaMenor = new java.sql.Date(dto.getFechaVista().getTime() - (7 * dia));
            log.debug("Fecha Actual: " + fecha + " Fecha Menor = " + fechaMenor + "entero " + dto.getFechaVista().getTime());
            ps.setDate(1, (java.sql.Date) fechaMenor);
            ps.setDate(2, (java.sql.Date) fecha);
            log.debug("Script READMANY" + ps);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                notificaciones.add(new notificacionesDTO(res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                        res.getTimestamp(8), res.getString(9)));
                i++;
            }
            if (i == 0) {
                dto.setCodigoErrorBD(4002);
                dto.setMensajeErrorBD("No Hay Notificaciones ha Mostrar, Por favor Intente Mas Tarde");
                notificaciones.add(dto);
            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany notificacionesDAO " + ex);
            dto.setCodigoErrorBD(4012);
            dto.setMensajeErrorBD("Ha Ocurrido Un Error Inesperado " + ex.getMessage() + ", Por favor Intente Mas Tarde");
            notificaciones.add(dto);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin notificacionesDAO readAll ***");
        return notificaciones;
    }

    public List<notificacionesDTO> readAll() {
        log.info("*** Inicio notificacionesDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<notificacionesDTO> notificaciones = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            log.debug("Script READALL" + ps);
            res = ps.executeQuery();
            while (res.next()) {
                notificaciones.add(new notificacionesDTO(res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                        res.getTimestamp(8), res.getString(9)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany notificacionesDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin notificacionesDAO readAll ***");
        return notificaciones;
    }

    public List<notificacionesDTO> readMany(notificacionesDTO dto, filtrosBusquedaBD filtros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
