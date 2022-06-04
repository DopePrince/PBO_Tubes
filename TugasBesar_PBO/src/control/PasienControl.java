/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.PasienDAO;
import java.util.List;
import model.Pasien;
import table.TablePasien;

/**
 * Nama  : Kenneth Vincentius Theys
 * NPM   : 200710681
 * Kelas : PBO - B
**/
public class PasienControl {
        private PasienDAO dDao = new PasienDAO();
    
    public void insertDataPasien(Pasien p) {
        dDao.insertPasien(p);
    }
    
    public TablePasien showDataPasien(String query){
        
        List<Pasien> dataPasien = dDao.showPasien(query);
        TablePasien tablePasien = new TablePasien(dataPasien);
            
        return tablePasien;
    }
    
    public List<Pasien> showListPasien(){
        List<Pasien> dataPasien = dDao.showPasien();
        
        return dataPasien;
    }
        
    public void updateDataPasien(Pasien p){
        dDao.updatePasien(p);
    }
    
    public void deleteDataPasien(String id){
        dDao.deletePasien(id);
    }
    
}
