/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pasien;
import model.Transaksi;

/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/

public class TablePasien extends AbstractTableModel{
    private List<Pasien> list;
    
    public TablePasien(List<Pasien> list){
        this.list = list;
    }
    
    public int getRowCount() {
        return list.size();
    }
    
    public int getColumnCount() {
        return 6;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return list.get(rowIndex).getNama();
            case 1:
                return list.get(rowIndex).getUmur();
            case 2:
                return list.get(rowIndex).getGender();
            case 3:
                return list.get(rowIndex).getAlamat();
            case 4:
                return list.get(rowIndex).getNo_telepon();
            case 5:
                return list.get(rowIndex).getJenis_pennyakit().getNama_penyakit();
//            case 6:
//                return list.get(rowIndex).getTransaksi();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Nama";
            case 1:
                return "Umur";
            case 2:
                return "Gender";
            case 3:
                return "Alamat";
            case 4:
                return "No Telpon";
            case 5:
                return "Diagnosa";
//            case 6:
//                return "Total Biaya";
            default:
                return null;
        }
    }
}
