/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Transaksi;

/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/
public class TableTransaksi extends AbstractTableModel{
    private List<Transaksi> list;
    
    public TableTransaksi(List<Transaksi> list){
        this.list = list;
    }
    
    public int getRowCount() {
        return list.size();
    }
    
    public int getColumnCount() {
        return 7;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getTanggal_transaksi();
            case 2:
                return list.get(rowIndex).getPasien().getNama();
            case 3:
                return list.get(rowIndex).getPasien().getPenyakit();
            case 4:
                return list.get(rowIndex).getRuangan().getHarga();
            case 5:
                return list.get(rowIndex).getBiaya_diagnosis();
            case 6:
                return list.get(rowIndex).getDokter().getBiaya_dokter();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Id Transaksi";
            case 1:
                return "Tanggal Transaksi";
            case 2:
                return "Nama Pasien";
            case 3:
                return "Diagnosa";
            case 4:
                return "Harga Ruangan";
            case 5:
                return "Biaya Diagnosis";
            case 6:
                return "Biaya Dokter";
            default:
                return null;
        }
    }
}
