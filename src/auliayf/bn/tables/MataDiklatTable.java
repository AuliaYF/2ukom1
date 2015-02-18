/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.bn.tables;

import auliayf.bn.core.db;
import auliayf.bn.core.table;
import java.util.List;

/**
 *
 * @author AuliaYF
 */
public class MataDiklatTable extends table {

    private final String[] cols = {"Kode Mata Diklat", "Nama Mata Diklat"};

    /**
     *
     * @param models
     */
    public MataDiklatTable(List<db.Model> models) {
        super(models);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        db.Model model = this.mModels.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.get("kode_mata_diklat");
            case 1:
                return model.get("nama_mata_diklat");
        }
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public String[] getCols() {
        return cols;
    }

}
