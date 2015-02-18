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
public class SiswaTable extends table {

    private final String[] cols = {"NISN", "Kompetensi Keahlian", "Nama Siswa", "Tanggal Lahir", "Alamat Siswa", "Foto Siswa"};

    /**
     *
     * @param models
     */
    public SiswaTable(List<db.Model> models) {
        super(models);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        db.Model model = this.mModels.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.get("nisn");
            case 1:
                return model.get("kode_kk") + " | " + model.get("nama_kompetensi_keahlian");
            case 2:
                return model.get("nama_siswa");
            case 3:
                return model.get("tgl_lahir");
            case 4:
                return model.get("alamat_siswa");
            case 5:
                return model.get("foto_siswa");
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
