/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.bn.core;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author AuliaYF
 */
public class Utils {

    private static final String[] units = {"", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh",
        "sebelas", "dua belas", "tiga belas", "empat belas", "lima belas", "enam belas", "tujuh belas", "depalan belas", "sembilan belas"};
    private static final String[] tens = {"", "", "dua puluh", "tiga puluh", "empat puluh", "lima puluh", "enam puluh", "tujuh puluh", "delapan puluh", "sembilan puluh"};

    /**
     *
     * @param form
     */
    public static void center_the_form(JFrame form) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        form.setLocation(dim.width / 2 - form.getWidth() / 2, dim.height / 2 - form.getHeight() / 2);
    }

    /**
     *
     * @param n
     * @return
     */
    public static String convert(int n) {
        if (n < 20) {
            return units[n];
        }
        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }
        if (n == 100) {
            return "seratus";
        }
        return null;
    }
}
