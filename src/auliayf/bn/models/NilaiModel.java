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
public class NilaiModel {

    /**
     *
     * @param siswa
     * @param guru
     * @param sk
     * @param angka
     * @param huruf
     * @return
     */
    public static int insert(String siswa, String guru, String sk, String angka, String huruf) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("INSERT INTO nilai (nisn, kode_guru, kode_sk, nilai_angka, nilai_huruf) VALUES(?, ?, ?, ?, ?)");

            statement.setString(1, siswa);
            statement.setString(2, guru);
            statement.setString(3, sk);
            statement.setString(4, angka);
            statement.setString(5, huruf);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NilaiModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NilaiModel.class.getName()).log(Level.SEVERE, null, ex);
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
            statement = conn.prepareStatement("DELETE FROM nilai WHERE kode_nilai = ?");

            statement.setString(1, kode);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NilaiModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NilaiModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    /**
     *
     * @param kode
     * @param siswa
     * @param guru
     * @param sk
     * @param angka
     * @param huruf
     * @return
     */
    public static int update(String kode, String siswa, String guru, String sk, String angka, String huruf) {
        Connection conn = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            conn = db.getConn();
            statement = conn.prepareStatement("UPDATE nilai SET nisn = ?, kode_guru = ?, kode_sk = ?, nilai_angka = ?, nilai_huruf = ? WHERE kode_nilai = ?");

            statement.setString(1, siswa);
            statement.setString(2, guru);
            statement.setString(3, sk);
            statement.setString(4, angka);
            statement.setString(5, huruf);
            statement.setString(6, kode);

            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NilaiModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NilaiModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
