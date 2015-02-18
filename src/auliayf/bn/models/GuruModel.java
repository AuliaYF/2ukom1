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
 * @author AuliaYF
 */
public class GuruModel {

    /**
     *
     * @param kode
     * @param kompetensi
     * @param nama
     * @param nip
     * @param alamat
     * @param telp
     * @return
     */
    public static int insert(String kode, String kompetensi, String nama, String nip, String alamat, String telp) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("INSERT INTO guru VALUES(?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, kode);
            statement.setString(2, kompetensi);
            statement.setString(3, nama);
            statement.setString(4, nip);
            statement.setString(5, "smkn1=oke");
            statement.setString(6, alamat);
            statement.setString(7, telp);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GuruModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuruModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    /**
     *
     * @param kode
     * @return
     */
    public static int delete(String kode) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("DELETE FROM guru WHERE kode_guru = ?");

            statement.setString(1, kode);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GuruModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuruModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    /**
     *
     * @param kode
     * @param kompetensi
     * @param nama
     * @param nip
     * @param alamat
     * @param telp
     * @return
     */
    public static int update(String kode, String kompetensi, String nama, String nip, String alamat, String telp) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("UPDATE guru SET kode_kk = ?, nama_guru = ?, nip = ?, alamat_guru = ?, telp_guru = ? WHERE kode_guru = ?");

            statement.setString(1, kompetensi);
            statement.setString(2, nama);
            statement.setString(3, nip);
            statement.setString(4, alamat);
            statement.setString(5, telp);
            statement.setString(6, kode);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GuruModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuruModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
