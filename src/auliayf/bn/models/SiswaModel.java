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
public class SiswaModel {

    /**
     *
     * @param nisn
     * @param kompetensi
     * @param nama
     * @param tgl_lahir
     * @param alamat
     * @param foto_siswa
     * @return
     */
    public static int insert(String nisn, String kompetensi, String nama, String tgl_lahir, String alamat, String foto_siswa) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("INSERT INTO siswa VALUES(?, ?, ?, ?, ?, ?)");

            statement.setString(1, nisn);
            statement.setString(2, kompetensi);
            statement.setString(3, nama);
            statement.setString(4, alamat);
            statement.setString(5, tgl_lahir);
            statement.setString(6, foto_siswa);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SiswaModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    /**
     *
     * @param nisn
     * @return
     */
    public static int delete(String nisn) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("DELETE FROM siswa WHERE nisn = ?");

            statement.setString(1, nisn);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SiswaModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    /**
     *
     * @param nisn
     * @param kompetensi
     * @param nama
     * @param tgl_lahir
     * @param alamat
     * @param foto_siswa
     * @return
     */
    public static int update(String nisn, String kompetensi, String nama, String tgl_lahir, String alamat, String foto_siswa) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("UPDATE siswa SET kode_kk = ?, nama_siswa = ?, tgl_lahir = ?, alamat_siswa = ?, foto_siswa = ? WHERE nisn = ?");

            statement.setString(1, kompetensi);
            statement.setString(2, nama);
            statement.setString(3, tgl_lahir);
            statement.setString(4, alamat);
            statement.setString(5, foto_siswa);
            statement.setString(6, nisn);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SiswaModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
