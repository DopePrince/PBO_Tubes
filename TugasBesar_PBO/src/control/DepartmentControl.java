/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.DepartmentDAO;
import java.util.List;
import model.Department;
import table.TableDepartment;

/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/

public class DepartmentControl {
    private DepartmentDAO dDao = new DepartmentDAO();
    
    public void insertDataDepartment(Department d){
        dDao.insertDepartment(d);
    }
    
    public List<Department> showListDepartment(){
        List<Department> dataDepartment = dDao.showDepartment();
        
        return dataDepartment;
    }
    
    public TableDepartment showDataDepartment(String query){
        List<Department> dataDepartment = dDao.showDepartment(query);
        TableDepartment tableDepartment = new TableDepartment(dataDepartment);
        
        return tableDepartment;
    }
    
    public void updateDataDepartment(Department d, int id){
        dDao.updateDepartment(d, id);
    }
    
    public void deleteDataDepartment(int id){
        dDao.deleteDepartment(id);
    }
}
