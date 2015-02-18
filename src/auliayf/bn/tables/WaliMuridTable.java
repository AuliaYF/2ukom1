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
public class WaliMuridTable extends table {

    private final String[] cols = {"Kode Wali", "Siswa", "Nama Ayah", "Pekerjaan Ayah", "Nama Ibu", "Pekerjaan Ibu", "Alamat Wali", "Telpon Wali"};

    /**
     *
     * @param models
     */
    public WaliMuridTable(List<db.Model> models) {
        super(models);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        db.Model model = this.mModels.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.get("kode_wali");
            case 1:
                return model.get("nisn") + " | " + model.get("nama_siswa");
            case 2:
                return model.get("nama_ayah");
            case 3:
                return model.get("pekerjaan_ayah");
            case 4:
                return model.get("nama_ibu");
            case 5:
                return model.get("pekerjaan_ibu");
            case 6:
                return model.get("alamat_wali");
            case 7:
                return model.get("telp_wali");
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
