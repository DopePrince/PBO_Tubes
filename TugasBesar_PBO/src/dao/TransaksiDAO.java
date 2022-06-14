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
import model.Pasien;
import model.Ruangan;
import model.Dokter;
import model.Transaksi;
import model.Jenis_Penyakit;
import model.Department;

public class TransaksiDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertTransaksi(Transaksi t){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO transaksi(id, id_pasien, id_dokter, no_ruangan, biaya_diagnosis, tanggal_transaksi) "
                + "VALUES ('" + t.getId()+ "', '" + t.getPasien().getId()+ "', '"
                + t.getDokter().getId()+ "', '" + t.getBiaya_diagnosis()+ "', '"
                + t.getTanggal_transaksi()+ "')";
        
        System.out.println("Adding Transaksi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Transaksi");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Transaksi> showTransaksi(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT j.*, p.*, t.* FROM jenis_penyakit as j JOIN (pasien p JOIN transaksi as t ON p.id = t.id_pasien) ON j.id = p.id_pasien WHERE (p.umur LIKE "
                + "'%" + query + "%'"
                + "OR p.nama LIKE '%" + query + "%'"
                + "OR p.gender LIKE '%" + query + "%'"
                + "OR p.alamat`r LIKE '%" + query + "%'"
                + "OR p.no_telepon LIKE '%" + query + "%'"
                + "OR j.id LIKE '%" + query + "%'"
                + "OR j.nama_penyakit LIKE '%" + query + "%')"
                + "OR j.keterangan LIKE '%" + query + "%')";
        
        
        System.out.println("Mengambil data Transaksi...");
        
        List<Transaksi> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
                    );
                    
                    Jenis_Penyakit j = new Jenis_Penyakit(
                        rs.getInt("j.id"), 
                        rs.getString("nama_penyakit"), 
                        rs.getString("keterangan"),
                        dp
                    );
                   
                    Dokter dk = new Dokter(
                        rs.getInt("dk.id"),
                        rs.getString("dk.nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"),
                        rs.getString("gender"),
                        rs.getFloat("biaya_dokter"),
                        dp
                            
                    
                    );
                    
                    Pasien p = new Pasien(
                        rs.getInt("p.id"),
                        rs.getInt("umur"),
                        rs.getString("nama"),
                        rs.getString("gender"),
                        rs.getString("p.alamat"),
                        rs.getString("no_telepon"),
                        j
                    ); 
                    
                        
                    Ruangan r = new Ruangan(
                        rs.getInt("r.no"),
                        rs.getString("tipe"),
                        rs.getFloat("harga"),
                        rs.getString("fasilitas"),
                        dp
                    );
                    
                    Transaksi tr = new Transaksi(
                        rs.getInt("r.id"),
                        rs.getDouble("biaya_diagnosis"),
                        rs.getString("tanggal_transaksi"),
                        p,
                        dk,
                        r
                    );
                            

                    list.add(tr);
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
    
    public List<Transaksi> showTransaksi(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM transaksi";
        System.out.println("Mengambil data Transaksi...");
        
        List<Transaksi> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()) {
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
                    );
                    
                    Jenis_Penyakit j = new Jenis_Penyakit(
                        rs.getInt("j.id"), 
                        rs.getString("nama_penyakit"), 
                        rs.getString("keterangan"),
                        dp
                    );
                   
                    Dokter dk = new Dokter(
                        rs.getInt("dk.id"),
                        rs.getString("dk.nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"),
                        rs.getString("gender"),
                        rs.getFloat("biaya_dokter"),
                        dp
                    );
                    
                    Pasien p = new Pasien(
                        rs.getInt("p.id"),
                        rs.getInt("umur"),
                        rs.getString("nama"),
                        rs.getString("gender"),
                        rs.getString("p.alamat"),
                        rs.getString("no_telepon"),
                        j
                    ); 
                    
                        
                    Ruangan r = new Ruangan(
                        rs.getInt("r.no"),
                        rs.getString("tipe"),
                        rs.getFloat("harga"),
                        rs.getString("fasilitas"),
                        dp
                    );
                    
                    Transaksi tr = new Transaksi(
                        rs.getInt("r.id"),
                        rs.getDouble("biaya_diagnosis"),
                        rs.getString("tanggal_transaksi"),
                        p,
                        dk,
                        r
                    );
                    
                    list.add(tr);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    public Transaksi searchTransaksi(int id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM transaksi WHERE id = '" + id + "'";
        System.out.println("Searching Transaksi...");
        Transaksi tr = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
                    );
                    
                    Jenis_Penyakit j = new Jenis_Penyakit(
                        rs.getInt("j.id"), 
                        rs.getString("nama_penyakit"), 
                        rs.getString("keterangan"),
                        dp
                    );
                   
                    Dokter dk = new Dokter(
                        rs.getInt("dk.id"),
                        rs.getString("dk.nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"),
                        rs.getString("gender"),
                        rs.getFloat("biaya_dokter"),
                        dp
                            
                    
                    );
                    
                    Pasien p = new Pasien(
                        rs.getInt("p.id"),
                        rs.getInt("umur"),
                        rs.getString("nama"),
                        rs.getString("gender"),
                        rs.getString("p.alamat"),
                        rs.getString("no_telepon"),
                        j
                    ); 
                    
                        
                    Ruangan r = new Ruangan(
                        rs.getInt("r.no"),
                        rs.getString("tipe"),
                        rs.getFloat("harga"),
                        rs.getString("fasilitas"),
                        dp
                    );
                    
                    tr = new Transaksi(
                        rs.getInt("r.id"),
                        rs.getDouble("biaya_diagnosis"),
                        rs.getString("tanggal_transaksi"),
                        p,
                        dk,
                        r
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
        
        return tr;
    }
    
    public void updateTransaksi(Transaksi tr){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE transaksi SET id_dokter = '" + tr.getDokter().getId() +  "', " 
                + "id_pasien = '" + tr.getPasien().getId()+ "', "
                + "id_ruangan = '" + tr.getRuangan() + "', " 
                + "tanggal_transaksi = '" + tr.getTanggal_transaksi()+ "'"
                + "WHERE id = '" + tr.getId() + "'";
        
        System.out.println("Editing Transaksi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Transaksi " + tr.getId());
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteTransaksi(String id){
        con = dbCon.makeConnection();
        System.out.println(id);
        
        String sql = "DELETE FROM transaki WHERE id = '" + id + "'";
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
