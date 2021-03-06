/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.bn.guru.views;

import auliayf.bn.core.Utils;
import auliayf.bn.core.db;
import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author AuliaYF
 */
public class ReportView extends JFrame {

    private final String reportName;
    private final HashMap<String, Object> param;

    /**
     *
     * @param report_name
     * @param param
     */
    public ReportView(String report_name, HashMap<String, Object> param) {
        this.reportName = report_name;
        this.param = param;
        
        init();
    }

    private void init() {
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Nilai Siswa");
        Utils.center_the_form(ReportView.this);
    }

    /**
     *
     */
    public void callReport() {
        JasperPrint jp = generateReport();
        JRViewer viewer = new JRViewer(jp);
        this.getContentPane().add(viewer);
        this.setVisible(true);
    }

    private JasperPrint generateReport() {
        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport("report" + File.separator + this.reportName + ".jasper", param, db.getConn());
        } catch (JRException ex) {
            Logger.getLogger(ReportView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jp;
    }
}
