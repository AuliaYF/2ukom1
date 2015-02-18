/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.bn.models;

import auliayf.bn.core.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RPL-03 student
 */
public class MataDiklatModel {

    public static int insert(String kode, String nama) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("INSERT INTO mata_diklat VALUES(?, ?)");

            statement.setString(1, kode);
            statement.setString(2, nama);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MataDiklatModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MataDiklatModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public static int delete(String kode) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("DELETE FROM mata_diklat WHERE kode_mata_diklat = ?");

            statement.setString(1, kode);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MataDiklatModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MataDiklatModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public static int update(String kode, String nama) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("UPDATE mata_diklat SET nama_mata_diklat = ? WHERE kode_mata_diklat = ?");

            statement.setString(1, nama);
            statement.setString(2, kode);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MataDiklatModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MataDiklatModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
