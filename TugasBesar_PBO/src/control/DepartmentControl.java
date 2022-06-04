/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.DepartmentDAO;
import java.util.List;
import model.Department;

/**
 * Nama  : Kenneth Vincentius Theys
 * NPM   : 200710681
 * Kelas : PBO - B
**/
public class DepartmentControl {
    private DepartmentDAO dDao = new DepartmentDAO();
    
    public void insertDataRuangan(Department d){
        dDao.insertRuangan(d);
    }
    
    public List<Department> showListDepartment(){
        List<Department> dataDepartment = dDao.showDepartment();
        
        return dataDepartment;
    }
    
    public void updateDataDepartment(Department d){
        dDao.updateDepartment(d);
    }
    
    public void deleteDataDepartment(int id){
        dDao.deleteDepartment(id);
    }
}
