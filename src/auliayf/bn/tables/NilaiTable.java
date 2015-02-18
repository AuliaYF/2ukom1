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
public class NilaiTable extends table {

    private final String[] cols = {"Kode Nilai", "Siswa", "Guru", "Standar Kompetensi", "Nilai Angka", "Nilai Huruf"};

    /**
     *
     * @param models
     */
    public NilaiTable(List<db.Model> models) {
        super(models);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        db.Model model = this.mModels.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.get("kode_nilai");
            case 1:
                return model.get("nisn") + " | " + model.get("nama_siswa");
            case 2:
                return model.get("kode_guru") + " | " + model.get("nama_guru");
            case 3:
                return model.get("kode_sk") + " | " + model.get("nama_sk");
            case 4:
                return model.get("nilai_angka");
            case 5:
                return model.get("nilai_huruf");
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
