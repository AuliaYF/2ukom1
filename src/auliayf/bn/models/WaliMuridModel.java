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
public class WaliMuridModel {

    /**
     *
     * @param kode
     * @param siswa
     * @param nama_ayah
     * @param pekerjaan_ayah
     * @param nama_ibu
     * @param pekerjaan_ibu
     * @param alamat
     * @param telp
     * @return
     */
    public static int insert(String kode, String siswa, String nama_ayah, String pekerjaan_ayah, String nama_ibu, String pekerjaan_ibu, String alamat, String telp) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("INSERT INTO wali_murid VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, kode);
            statement.setString(2, siswa);
            statement.setString(3, nama_ayah);
            statement.setString(4, pekerjaan_ayah);
            statement.setString(5, nama_ibu);
            statement.setString(6, pekerjaan_ibu);
            statement.setString(7, alamat);
            statement.setString(8, telp);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WaliMuridModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(WaliMuridModel.class.getName()).log(Level.SEVERE, null, ex);
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
            statement = conn.prepareStatement("DELETE FROM wali_murid WHERE kode_wali = ?");

            statement.setString(1, kode);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WaliMuridModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(WaliMuridModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    /**
     *
     * @param kode
     * @param siswa
     * @param nama_ayah
     * @param pekerjaan_ayah
     * @param nama_ibu
     * @param pekerjaan_ibu
     * @param alamat
     * @param telp
     * @return
     */
    public static int update(String kode, String siswa, String nama_ayah, String pekerjaan_ayah, String nama_ibu, String pekerjaan_ibu, String alamat, String telp) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("UPDATE wali_murid SET nisn = ?,  nama_ayah = ?, pekerjaan_ayah = ?, nama_ibu = ?, pekerjaan_ibu = ?, alamat_wali = ?, telp_wali = ? WHERE kode_wali = ?");

            statement.setString(1, siswa);
            statement.setString(2, nama_ayah);
            statement.setString(3, pekerjaan_ayah);
            statement.setString(4, nama_ibu);
            statement.setString(5, pekerjaan_ibu);
            statement.setString(6, alamat);
            statement.setString(7, telp);
            statement.setString(8, kode);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WaliMuridModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(WaliMuridModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
