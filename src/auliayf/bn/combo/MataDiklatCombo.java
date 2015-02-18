/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.bn.combo;

import auliayf.bn.core.db;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author RPL-03 student
 */
public class MataDiklatCombo extends AbstractListModel implements ComboBoxModel {

    private String[] data;
    private String selected;

    public MataDiklatCombo() {
        List<db.Model> models = db.query(new db.Query("mata_diklat"));
        String combo[] = new String[models.size()];

        for (int i = 0; i <= models.size() - 1; i++) {
            combo[i] = models.get(i).get("kode_mata_diklat") + " | " + models.get(i).get("nama_mata_diklat");
        }

        this.data = combo;
    }

    @Override
    public int getSize() {
        return data.length;
    }

    @Override
    public Object getElementAt(int index) {
        return data[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

}
