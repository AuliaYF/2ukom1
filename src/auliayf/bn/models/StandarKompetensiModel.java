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
public class StandarKompetensiModel {

    public static int insert(String kode, String kompetensi, String nama, String kelas) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("INSERT INTO standar_kompetensi VALUES(?, ?, ?, ?)");

            statement.setString(1, kode);
            statement.setString(2, kompetensi);
            statement.setString(3, nama);
            statement.setString(4, kelas);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StandarKompetensiModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StandarKompetensiModel.class.getName()).log(Level.SEVERE, null, ex);
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
            statement = conn.prepareStatement("DELETE FROM standar_kompetensi WHERE kode_sk = ?");

            statement.setString(1, kode);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StandarKompetensiModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StandarKompetensiModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public static int update(String kode, String kompetensi, String nama, String kelas) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("UPDATE standar_kompetensi SET kode_kk = ?, nama_sk = ?, kelas_sk = ? WHERE kode_sk = ?");

            statement.setString(1, kompetensi);
            statement.setString(2, nama);
            statement.setString(3, kelas);
            statement.setString(4, kode);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StandarKompetensiModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StandarKompetensiModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
