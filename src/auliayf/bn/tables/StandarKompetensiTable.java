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
public class StandarKompetensiTable extends table {

    private final String[] cols = {"Kode Standar Kompetensi", "Kompetensi Keahlian", "Nama Standar Kompetensi", "Kelas Standar Kompetensi"};

    /**
     *
     * @param models
     */
    public StandarKompetensiTable(List<db.Model> models) {
        super(models);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        db.Model model = this.mModels.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.get("kode_sk");
            case 1:
                return model.get("kode_kk") + " | " + model.get("nama_kompetensi_keahlian");
            case 2:
                return model.get("nama_sk");
            case 3:
                return model.get("kelas_sk");
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
