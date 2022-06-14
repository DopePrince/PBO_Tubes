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
import model.Jenis_Penyakit;

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
        
        String sql = "SELECT dk.*, dp.*, j.* FROM dokter as dk JOIN (department as dp JOIN jenis_penyakit as j ON dp.id = j.id_department) ON dk.id_department = dp.id WHERE (dk.nama LIKE "
                + "'%" + query + "%'"
                + "OR dk.alamat LIKE '%" + query + "%'"
                + "OR dk.no_telepon LIKE '%" + query + "%'"
                + "OR dk.gender LIKE '%" + query + "%'"
                + "OR dk.biaya_dokter LIKE '%" + query + "%'"
                + "OR dp.nama LIKE '%" + query + "%'"
                + "OR j.nama_penyakit LIKE '%" + query + "%')";
        
        System.out.println("Mengambil data Dokter...");
        
        List<Dokter> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
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
                    
                    list.add(dk);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("23Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    public List<Dokter> showDokter(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT dk.*, dp.* FROM dokter as dk JOIN department as dp ON dk.id_department = dp.id";
        System.out.println("Mengambil data Dokter...");
        
        List<Dokter> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()) {
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
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
                    list.add(dk);
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
    
    public Dokter searchDokter(int id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM dokter WHERE id = '" + id + "'";
        System.out.println("Searching Dokter...");
        Dokter dk = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
                    );
                   
                    dk = new Dokter(
                        rs.getInt("dk.id"),
                        rs.getString("dk.nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"),
                        rs.getString("gender"),
                        rs.getFloat("biaya_dokter"),
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
        
        return dk;
    }
    
    public void updateDokter(Dokter dk){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE dokter SET id_department = '" + dk.getDepartment().getId() 
                + "', nama = '" + dk.getNama()
                + "', alamat = '" + dk. getAlamat() 
                + "', no_telepon = '" + dk.getNo_telepon() 
                + "', gender = '" + dk.getGender()
                + "', biaya_dokter = '" + dk.getBiaya_dokter()
                + "' WHERE id = '" + dk.getId() + "'";
        System.out.println("Editing Dokter...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Dokter " + dk.getId());
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing Dokter...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteDokter(String id){
        con = dbCon.makeConnection();
        System.out.println(id);
        
        String sql = "DELETE FROM dokter WHERE id = '" + id + "'";
        System.out.println("Deleting Dokter...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Dokter " + id);
            statement.close();
        }catch(Exception e){
            System.out.println("Error deleting Dokter...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}
