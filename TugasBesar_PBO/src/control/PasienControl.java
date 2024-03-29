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
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/

public class PasienControl {
        private PasienDAO dDao = new PasienDAO();
    
    public void insertDataPasien(Pasien p) {
        dDao.insertPasien(p);
    }
    
    public TablePasien showDataPasien(String query){
        
        List<Pasien> dataPasien = dDao.showListPasien(query);
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
    
    public void deleteDataPasien(int id){
        dDao.deletePasien(id);
    }
    
}
