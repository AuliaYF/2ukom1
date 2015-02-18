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
public class GuruTable extends table {

    private final String[] cols = {"Kode Guru", "Kompetensi Keahlian", "Nama Guru", "NIP", "Alamat Guru", "Telpon Guru"};

    /**
     *
     * @param models
     */
    public GuruTable(List<db.Model> models) {
        super(models);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        db.Model model = this.mModels.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.get("kode_guru");
            case 1:
                return model.get("kode_kk") + " | " + model.get("nama_kompetensi_keahlian");
            case 2:
                return model.get("nama_guru");
            case 3:
                return model.get("nip");
            case 4:
                return model.get("alamat_guru");
            case 5:
                return model.get("telp_guru");
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
