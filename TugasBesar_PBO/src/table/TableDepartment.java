/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

/**
 *
 * @author henry
 */

import model.Department;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TableDepartment extends AbstractTableModel{
    private List<Department> list;
    
    public TableDepartment(List<Department> list){
        this.list = list;
    }
    
    public int getRowCount() {
        return list.size();
    }
    
    public int getColumnCount() {
        return 2;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Id Department";
            case 1:
                return "Nama Department";

            default:
                return null;
        }
    }
}
