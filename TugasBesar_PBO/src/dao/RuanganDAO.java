/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Ruangan;
import model.Department;
import model.Jenis_Penyakit;

/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/

public class RuanganDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertRuangan(Ruangan r){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO ruangan(no, id_department, tipe, harga, fasilitas) "
                + "VALUES ('" + r.getNo()+ "', '" + r.getDepartment().getId()+ "', '"
                + r.getTipe()+ "', '" + r.getHarga()+ "', '" + r.getFasilitas()+ "')";
        
        System.out.println("Adding Dokter...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Ruangan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Ruangan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Ruangan> showRuangan(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT r.*, dp.*, j.* FROM ruangan as r JOIN (department as dp JOIN jenis_penyakit as j ON as.id_penyakit = j.id)ON dp.id = dk.id_department WHERE (r.no LIKE "
                + "'%" + query + "%'"
                + "OR r.tipeLIKE '%" + query + "%'"
                + "OR r.harga LIKE '%" + query + "%'"
                + "OR r.fasilitas LIKE '%" + query + "%'"
                + "OR dp.nama LIKE '%" + query + "%'"
                + "OR j.nama_penyakit LIKE '%" + query + "%')";
        
        
        System.out.println("Mengambil data Ruangan...");
        
        List<Ruangan> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){   
                    Jenis_Penyakit j = new Jenis_Penyakit(
                        rs.getInt("j.id"), 
                        rs.getString("nama_penyakit"), 
                        rs.getString("keterangan") 
                    );
                    
                    
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama"),
                        j
                    );
                   
                    Ruangan r = new Ruangan(
                        rs.getInt("r.no"),
                        rs.getString("tipe"),
                        rs.getFloat("harga"),
                        rs.getString("fasilitas"),
                        dp
                    );
                    
                    list.add(r);
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
    
    public List<Ruangan> showRuangan(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM ruangan";
        System.out.println("Mengambil data Ruangan...");
        
        List<Ruangan> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Jenis_Penyakit jp = new Jenis_Penyakit(
                        rs.getInt("jp.id"), 
                        rs.getString("nama_penyakit"), 
                        rs.getString("keterangan")
                    );
                    
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama"),
                        jp
                    );
                    
                    Ruangan r = new Ruangan(
                        rs.getInt("no"),
                            rs.getString("tipe"),
                            rs.getDouble("harga"),
                            rs.getString("fasilitas"),
                            dp
                    );
                    
                    list.add(r);
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
    
    public Ruangan searchRuangan(int no){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM ruangan WHERE no = '" + no + "'";
        System.out.println("Searching Ruangan...");
        Ruangan r = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Jenis_Penyakit j = new Jenis_Penyakit(
                        rs.getInt("j.id"), 
                        rs.getString("nama_penyakit"), 
                        rs.getString("keterangan") 
                    );
                    
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama"),
                        j
                    );
                   
                    r = new Ruangan(
                        rs.getInt("r.no"),
                        rs.getString("tipe"),
                        rs.getFloat("harga"),
                        rs.getString("fasilitas"),
                        dp
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
        
        return r;
    }
    
    public void updateRuangan(Ruangan r){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE ruangan SET id_department = '" + r.getDepartment().getId() +  "', " 
                + "tipe = '" + r.getTipe()+ "', "
                + "harga = '" + r.getHarga() + "', " 
                + "fasilitas= '" + r.getFasilitas() + "', " 
                + "WHERE no = '" + r.getNo() + "'";
        
        System.out.println("Editing Ruangan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Ruangan " + r.getNo());
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing Ruangan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteRuangan(int no){
        con = dbCon.makeConnection();
        System.out.println(no);
        
        String sql = "DELETE FROM ruangan WHERE no = '" + no + "'";
        System.out.println("Deleting Ruangan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Ruangan " + no);
            statement.close();
        }catch(Exception e){
            System.out.println("Error deleting Ruangan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

}
