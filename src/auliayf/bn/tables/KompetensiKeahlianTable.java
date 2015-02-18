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
 * @author RPL-03 student
 */
public class KompetensiKeahlianTable extends table {

    private final String[] cols = {"Kode Kompetensi Keahlian", "Mata Diklat", "Nama Kompetensi Keahlian"};

    public KompetensiKeahlianTable(List<db.Model> models) {
        super(models);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        db.Model model = this.mModels.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.get("kode_kk");
            case 1:
                return model.get("kode_mata_diklat") + " | " + model.get("nama_mata_diklat");
            case 2:
                return model.get("nama_kompetensi_keahlian");
        }
        return null;
    }

    @Override
    public String[] getCols() {
        return cols;
    }

}
