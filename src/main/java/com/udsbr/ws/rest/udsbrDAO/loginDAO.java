/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udsbr.ws.rest.udsbrDAO;

import com.udsbr.ws.rest.conexionUSDBR.conexionBD;
import com.udsbr.ws.rest.interfacesUDSBR.filtrosBusquedaBD;
import com.udsbr.ws.rest.interfacesUDSBR.interfaces;
import com.udsbr.ws.rest.udsbrDTO.loginDTO;
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
public class loginDAO implements interfaces<loginDTO> {

    private static final String SQL_READONE = "SELECT * FROM loginUDSBR WHERE facebookID = ? AND codigoID = ? ";
    private static final String SQL_READONEUSER = "SELECT * FROM loginUDSBR WHERE facebookID = ? ";
    private static final String SQL_UPDATE = "UPDATE loginUDSBR SET phoneID = ?, facebookGroupID = ?, nombreUser = ?, "
            + "ipUsuario = ?, uuIdPhone = ?, platformPhone = ?, versionPhone = ?, "
            + "manufacturePhone = ?, isVirtualPhone = ?, serialPhone = ?, estadoUsuario = ?";
    private static final String SQL_INSERT = "INSERT INTO loginUDSBR (facebookID, codigoID, phoneID, phoneModel,"
            + "facebookGroupID, nombreUser, ipUsuario, uuIdPhone, platformPhone, "
            + "versionPhone, manufacturePhone, isVirtualPhone, serialPhone, estadoUsuario) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM loginUDSBR WHERE facebookID = ? AND codigoID = ?";
    private static final String SQL_READMANY = "SELECT * FROM loginUDSBR WHERE ";
    private static final String SQL_READALL = "SELECT * FROM loginUDSBR";
    private final conexionBD con = conexionBD.saberEstado();
    static Logger log = Logger.getLogger(loginDAO.class);

    public boolean create(loginDTO dto) {
        log.info("*** Inicio loginDAO create ***");
        PreparedStatement ps;
        boolean estadoExecute = false;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            log.debug(ps);
            ps.setString(1, dto.getFacebookID());
            ps.setString(2, dto.getCodigoID());
            ps.setString(3, dto.getPhoneID());
            ps.setString(4, dto.getPhoneModel());
            ps.setString(5, dto.getFacebookGroupID());
            ps.setString(6, dto.getNombreUser());
            ps.setString(7, dto.getIpUsuario());
            ps.setString(8, dto.getUuIdPhone());
            ps.setString(9, dto.getPlatformPhone());
            ps.setString(10, dto.getVersionPhone());
            ps.setString(11, dto.getManufacturePhone());
            ps.setInt(12, dto.getIsVirtualPhone());
            ps.setString(13, dto.getSerialPhone());
            ps.setInt(14, 0);
            log.debug("LoginDAO Create " + ps);
            int ejecuta = ps.executeUpdate();

            log.debug(ejecuta);
            if (ejecuta > 0) {
                estadoExecute = true;
            }

        } catch (SQLException ex) {
            log.error("Error create loginDAO loginDAO " + ex);

        } finally {
            con.cerrarConexion();
        }
        log.debug("Estado de la ejecución " + estadoExecute);
        log.info("*** Fin loginDAO create ***");
        return estadoExecute;
    }

    public boolean update(loginDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(loginDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public loginDTO readOne(loginDTO dto) {
        log.info("*** Inicio loginDAO readOne ***");
        PreparedStatement ps;
        ResultSet res;
        loginDTO usuariosLogin = new loginDTO();

        try {
            if (dto.getCodigoErrorBD() == 1) {
                ps = con.getCnn().prepareStatement(SQL_READONEUSER);
                ps.setString(1, dto.getFacebookID());
                
            } else {
                ps = con.getCnn().prepareStatement(SQL_READONE);
                ps.setString(1, dto.getFacebookID());
                ps.setString(2, dto.getCodigoID());
            }
            res = ps.executeQuery();

            log.debug("Select LoginDAO " + ps);
            int i = 0;
            while (res.next()) {
                usuariosLogin = new loginDTO(res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                        res.getString(8), res.getString(9), res.getString(10), res.getString(11),
                        res.getInt(12), res.getString(13), res.getString(14));
                i++;
            }
            if (i > 0) {
                usuariosLogin.setCodigoErrorBD(0);
            } else {
                usuariosLogin.setCodigoErrorBD(1001);
            }

            log.debug("Resultado " + res);

        } catch (SQLException ex) {
            log.error("Error Sentencia ReadOne loginDAO " + ex.getMessage());
            usuariosLogin.setCodigoErrorBD(1001);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin loginDAO readOne ***");
        return usuariosLogin;
    }

    public List<loginDTO> readMany(loginDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<loginDTO> readAll() {
        log.info("*** Inicio loginDAO readAll ***");
        PreparedStatement ps;
        ResultSet res;
        ArrayList<loginDTO> usuariosLogin = new ArrayList();

        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            while (res.next()) {
                usuariosLogin.add(new loginDTO(res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                        res.getString(8), res.getString(9), res.getString(10), res.getString(11),
                        res.getInt(12), res.getString(13), res.getString(14)));

            }
        } catch (SQLException ex) {
            log.error("Error Sentencia ReadMany loginDAO " + ex);
        } finally {
            con.cerrarConexion();
        }
        log.info("*** Fin loginDAO readAll ***");
        return usuariosLogin;
    }

    public List<loginDTO> readMany(loginDTO dto, filtrosBusquedaBD filtros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
