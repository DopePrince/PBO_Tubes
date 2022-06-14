/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Jenis_Penyakit;

/**
 *
 * @author ASUS
 */
public class TableJenis_Penyakit extends AbstractTableModel{
    private List<Jenis_Penyakit> list;

    public TableJenis_Penyakit(List<Jenis_Penyakit> list) {
        this.list = list;
    }
    
    @Override
     public int getRowCount() {
        return list.size();
    }
     
     @Override
     public int getColumnCount (){
         return 4;
    }
     
    @Override
    public Object getValueAt (int rowIndex, int columnIndex){
        
            switch (columnIndex){
        case 0:
            return list.get(rowIndex).getId();
        case 1:
            return list.get(rowIndex).getDepartment().getNama();
        case 2:
            return list.get(rowIndex).getNama_penyakit();
        case 3:
            return list.get(rowIndex).getKeterangan();
         default:
            return null;
        }
      }    
    @Override
    public String getColumnName (int column){
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Nama Department";
            case 2:
                return "Nama Penyakit";
            case 3:
                return "Keterangan";
            
            default:
                return null;
          }
       }  
    
}
