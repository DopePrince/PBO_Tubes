/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.RuanganDAO;
import java.util.List;
import model.Ruangan;

/**
 * Nama  : Kenneth Vincentius Theys
 * NPM   : 200710681
 * Kelas : PBO - B
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
