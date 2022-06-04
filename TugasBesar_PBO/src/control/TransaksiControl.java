/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.TransaksiDAO;
import java.util.List;
import model.Transaksi;
import table.TableTransaksi;

/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/

public class TransaksiControl {
    private TransaksiDAO dDao = new TransaksiDAO();
    
    public void insertDataTransaksi(Transaksi tr) {
        dDao.insertTransaksi(tr);
    }
    
    public TableTransaksi showDataTransaksi(String query){
        
        List<Transaksi> dataTransaksi = dDao.showTransaksi(query);
        TableTransaksi tableTransaksi = new TableTransaksi(dataTransaksi);
            
        return tableTransaksi;
    }
    
    public List<Transaksi> showListTransaksi(){
        List<Transaksi> dataTransaksi = dDao.showTransaksi();
        
        return dataTransaksi;
    }
        
    public void updateDataTransaksi(Transaksi tr){
        dDao.updateTransaksi(tr);
    }
    
    public void deleteDataTransaksi(int id){
        dDao.deleteTransaksi(id);
    }
    
}
