/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.DokterDAO;
import java.util.List;
import model.Dokter;
import table.TableDokter;

/**
 * Nama  : Kenneth Vincentius Theys
 * NPM   : 200710681
 * Kelas : PBO - B
**/
public class DokterControl {
    private DokterDAO dDao = new DokterDAO();
    
    public void insertDataDokter(Dokter dr) {
        dDao.insertDokter(dr);
    }
    
    public TableDokter showDataDokter(String query){
        
        List<Dokter> dataDokter = dDao.showDokter(query);
        TableDokter tableDokter = new TableDokter(dataDokter);
            
        return tableDokter;
    }
    
    public List<Dokter> showListDokter(){
        List<Dokter> dataDokter = dDao.showDokter();
        
        return dataDokter;
    }
        
    public void updateDataDokter(Dokter dr){
        dDao.updateDokter(dr);
    }
    
    public void deleteDataDokter(String id){
        dDao.deleteDokter(id);
    }
    
}
