/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Dokter;
import model.Department;
import model.Jenis_Penyakit;

/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/

public class TableDokter extends AbstractTableModel{
    private List<Dokter> list;
    
    public TableDokter(List<Dokter> list){
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
                return list.get(rowIndex).getDepartment().getNama();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getAlamat();
            case 3:
                return list.get(rowIndex).getNo_telepon();
            case 4:
                return list.get(rowIndex).getGender();
            case 5:
                return list.get(rowIndex).getBiaya_dokter();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Nama Department";
            case 1:
                return "Nama Dokter";
            case 2:
                return "Alamat";
            case 3:
                return "No Telpon";
            case 4:
                return "Gender";
            case 5:
                return "Biaya Dokter";
            default:
                return null;
        }
    }  
    
}
