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
                + "VALUES('" + r.getNo()+ "', '" + r.getDepartment().getId()
                + "', '" + r.getTipe()+ "', '" + r.getHarga()
                + "', '" + r.getFasilitas()+ "')";
        
        System.out.println("Adding Ruangan...");
        
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
        
        String sql = "SELECT dp.*, r.* FROM department as dp JOIN ruangan as r ON dp.id = r.id_department WHERE (r.no LIKE "
                + "'%" + query + "%'"
                + "OR r.tipe LIKE '%" + query + "%'"
                + "OR r.harga LIKE '%" + query + "%'"
                + "OR r.fasilitas LIKE '%" + query + "%'"
                + "OR dp.nama LIKE '%" + query + "%')";
        
        System.out.println("Mengambil data Ruangan...");
        
        List<Ruangan> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){   
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
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
        
        String sql = "SELECT dp.*, r.* FROM ruangan AS r JOIN department AS dp WHERE r.id_department = dp.id";
        System.out.println("Mengambil data Ruangan...");
        
        List<Ruangan> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
                    );
                    
                    Ruangan r = new Ruangan(
                        Integer.parseInt(rs.getString("no")),
                        rs.getString("r.tipe"),
                        rs.getDouble("r.harga"),
                        rs.getString("r.fasilitas"),
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
        
        String sql = "UPDATE ruangan SET no = '" + r.getNo() +  "', " 
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
        
        String sql = "DELETE FROM ruangan WHERE no = " + no + "";
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
