/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.RuanganDAO;
import java.util.List;
import model.Ruangan;

/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/

public class RuanganControl {
    private RuanganDAO dDao = new RuanganDAO();
    
    public void insertDataRuangan(Ruangan r){
        dDao.insertRuangan(r);
    }
    
    public List<Ruangan> showListRuangan(){
        List<Ruangan> dataRuangan = dDao.showRuangan();
        
        return dataRuangan;
    }
    
    public void updateDataRuangan(Ruangan r){
        dDao.updateRuangan(r);
    }
    
    public void deleteDataRuangan(int no){
        dDao.deleteRuangan(no);
    }
}
