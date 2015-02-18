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
public class SiswaGuruTable extends table {

    private final String[] cols = {"NISN", "Nama Siswa", "Tanggal Lahir", "Foto Siswa"};

    public SiswaGuruTable(List<db.Model> models) {
        super(models);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        db.Model model = this.mModels.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.get("nisn");
            case 1:
                return model.get("nama_siswa");
            case 2:
                return model.get("tgl_lahir");
            case 3:
                return model.get("foto_siswa");
        }
        return null;
    }

    @Override
    public String[] getCols() {
        return cols;
    }

}
