/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.bn.core;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RPL-03 student
 */
public abstract class table extends AbstractTableModel {

    public List<db.Model> mModels;

    public table(List<db.Model> models) {
        this.mModels = models;
    }

    @Override
    public int getRowCount() {
        return mModels.size();
    }

    @Override
    public int getColumnCount() {
        return getCols().length;
    }

    @Override
    public String getColumnName(int index) {
        return getCols()[index];
    }

    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);

    public abstract String[] getCols();
}
