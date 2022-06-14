/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.Jenis_PenyakitDAO;
import java.util.List;
import model.Jenis_Penyakit;
import table.TableJenis_Penyakit;
/**
 *
 * @author ASUS
 */
public class Jenis_PenyakitControl {
    private Jenis_PenyakitDAO jpDao = new Jenis_PenyakitDAO();
    
    public List<Jenis_Penyakit> showJenis_Penyakit(){
        List<Jenis_Penyakit> list = jpDao.showJenis_Penyakit();
        return list;
    }
    
    public TableJenis_Penyakit showDataPenyakit(String query){
        List<Jenis_Penyakit> dataPenyakit = jpDao.showListJenis_Penyakit(query);
        TableJenis_Penyakit tablePenyakit = new TableJenis_Penyakit(dataPenyakit);
        
        return tablePenyakit;
    }
    
    public void insertJenis_Penyakit(Jenis_Penyakit jp){
        jpDao.insertJenis_Penyakit(jp);
    }
    
    public void updateJenis_Penyakit(Jenis_Penyakit jp){
        jpDao.updateJenis_Penyakit(jp);
    }
    
    public void deleteJenis_Penyakit(int id){
        jpDao.deleteJenis_Penyakit(id);
    }
    
}
