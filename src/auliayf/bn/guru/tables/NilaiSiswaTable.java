/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.bn.guru.tables;

import auliayf.bn.core.db;
import auliayf.bn.core.table;
import java.util.List;

/**
 *
 * @author RPL-03 student
 */
public class NilaiSiswaTable extends table {

    private final String[] cols = {"Kode Nilai", "Standar Kompetensi", "Nilai Angka", "Nilai Huruf"};

    public NilaiSiswaTable(List<db.Model> models) {
        super(models);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        db.Model model = this.mModels.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.get("kode_nilai");
            case 1:
                return model.get("kode_sk") + " | " + model.get("nama_sk");
            case 2:
                return model.get("nilai_angka");
            case 3:
                return model.get("nilai_huruf");
        }
        return null;
    }

    @Override
    public String[] getCols() {
        return cols;
    }

}
