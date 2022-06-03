/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import model.Dokter;

public class DokterDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertDokter(Dokter d){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO dokter(id, id_department, nama, alamat, no_telepon, gender, biaya_dokter) "
                + "VALUES ('" + d.getId()+ "', '" + d.getDepartment().getId()+ "', '"
                + d.getNama() + "', '" + d.getAlamat()+ "', '"
                + d.getNo_telepon() + "', '" + d.getGender() + "', '" + d.getBiaya_dokter() + "')";
        
        System.out.println("Adding Dokter...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Dokter");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Dokter...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Dokter> showDokter(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT dk.*, dp.* FROM dokter as dk JOIN department as dp ON dp.id = dk.id_department WHERE (dk.nama LIKE "
                + "'%" + query + "%'"
                + "OR dk.alamat LIKE '%" + query + "%'"
                + "OR dk.no_telepon LIKE '%" + query + "%'"
                + "OR dk.gender LIKE '%" + query + "%'"
                + "OR dk.biaya_dokter LIKE '%" + query + "%'"
                + "OR dp.nama LIKE '%" + query + "%'"
                + "OR dp.nama LIKE '%" + query + "%')";
        
        
        System.out.println("Mengambil data Transaksi...");
        
        List<Transaksi> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                System.out.println("test");
                while(rs.next()){
                    System.out.println("test");
                    Computer c = new Computer(
                        rs.getString("c.id"),
                        rs.getString("c.nama"),
                        rs.getString("processor"),
                        rs.getInt("kapasitasRAM"),
                        rs.getString("jenis"),
                        rs.getInt("dayaListrik"),
                        rs.getInt("kapasitasBaterai")
                    );
                    
                    Pembeli p = new Pembeli(
                        rs.getInt("cp.id"),
                        rs.getString("cp.nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon")
                    );
                    
                    Transaksi t = new Transaksi(
                        rs.getInt("ct.id"),
                        rs.getString("tanggal_transaksi"),
                        rs.getString("total_harga"),
                        rs.getString("bonus"),
                        c,
                        p
                    );
                    list.add(t);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    public Transaksi searchTransaksi(int id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM computer_transaksi WHERE id = '" + id + "'";
        System.out.println("Searching Transaksi...");
        Transaksi t = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Computer c = new Computer(
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("processor"),
                        rs.getInt("kapasitasRAM"),
                        rs.getString("jenis"),
                        rs.getInt("dayaListrik"),
                        rs.getInt("kapasitasBaterai")
                    );
                    
                    Pembeli p = new Pembeli(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon")
                    );
                    
                    t = new Transaksi(
                        rs.getInt("id"),
                        rs.getString("tanggal_transaksi"),
                        rs.getString("total_harga"),
                        rs.getString("bonus"),
                        c,
                        p
                    );
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return t;
    }
    
    public void updateTransaksi(Transaksi t){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE computer_transaksi SET id_computer = '" + t.getComputer().getId()+ "', " 
                + "id_pembeli = '" + t.getPembeli().getId()+ "', "
                + "tanggal_transaksi = '" + t.getTanggal_transaksi() + "', " 
                + "total_harga = '" + t.getTotal_harga() + "', " 
                + "bonus = '" + t.getBonus() + "'"
                + "WHERE id = '" + t.getId() + "'";
        
        System.out.println("Editing Transaksi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Transaksi " + t.getId());
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteTransaksi(int id){
        con = dbCon.makeConnection();
        System.out.println(id);
        
        String sql = "DELETE FROM computer_transaksi WHERE id = '" + id + "'";
        System.out.println("Deleting Transaksi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Transaksi " + id);
            statement.close();
        }catch(Exception e){
            System.out.println("Error deleting Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}
