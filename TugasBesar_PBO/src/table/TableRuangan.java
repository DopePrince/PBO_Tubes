/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Ruangan;

/**
 *
 * @author ASUS
 */
public class TableRuangan extends AbstractTableModel{
    private List<Ruangan> list;

    public TableRuangan(List<Ruangan> list) {
        this.list = list;
    }
    
    @Override
     public int getRowCount() {
        return list.size();
    }
     
     @Override
     public int getColumnCount (){
         return 5;
    }
     
    @Override
    public Object getValueAt (int rowIndex, int columnIndex){
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getNo();
            case 1:
                return list.get(rowIndex).getTipe();
            case 2:
                return list.get(rowIndex).getHarga();
            case 3:
                return list.get(rowIndex).getFasilitas();
            case 4:
                return list.get(rowIndex).getDepartment().getNama();
            default:
                return null;
            }
      }    
    @Override
    public String getColumnName (int column){
        switch (column){
            case 0:
                return "No";
            case 1:
                return "Tipe Ruangan";
            case 2:
                return "Harga Ruangan";
             case 3:
                return "Fasilitas Ruangan";
            case 4:
                return "Nama Department";
            default:
                return null;
          }
       }  
    
}

