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
import model.Department;
import model.Pasien;
import model.Jenis_Penyakit;


/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/

public class PasienDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertPasien(Pasien ps){
        
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO pasien(id, umur, nama, jenis_kelamin, alamat, no_telepon, jenis_penyakit) "
                + "VALUES ('" + ps.getId()+ "', '"
                + ps.getUmur()+ "', '" + ps.getNama()+ "', '"
                + ps.getJenis_kelamin()+ "', '" + ps.getAlamat()+ "', '" + ps.getNo_telepon()+ "', '"
                + ps.getJenis_penyakit()+ "' )";
    
        System.out.println("Adding Pasien...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Pasien");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Pasien...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Pasien> showPasien(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM pasien WHERE (id LIKE "
                + "'%" + query + "%'"
                + "OR umur LIKE '%" + query + "%'"
                + "OR nama LIKE '%" + query + "%'"
                + "OR gender LIKE '%" + query + "%'"
                + "OR no_telepon LIKE '%" + query + "%'"
                + "OR nama_penyakit LIKE '%" + query + "%')";
        
        
        System.out.println("Mengambil data Pasien...");
        
        List<Pasien> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Pasien p = new Pasien(
                        rs.getString("id"),
                        rs.getInt("umur"),
                        rs.getString("nama"),
                        rs.getString("gender"),
                        rs.getString("alamat"),
                        rs.getFloat("no_telepon"),
                        rs.getString("jenis_penyakit")
                    );
                    
                    list.add(dk);
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
                   
                    dk = new Dokter(
                        rs.getString("dk.id"),
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
        
        String sql = "UPDATE dokter SET id_department = '" + dk.getDepartment().getId() +  "', " 
                + "nama = '" + dk.getNama()+ "', "
                + "alamat = '" + dk. getAlamat() + "', " 
                + "no_telepon = '" + dk.getNo_telepon() + "', " 
                + "gender = '" + dk.getGender() + "'"
                + "biaya_dokter = '" + dk.getBiaya_dokter()+ "'"
                + "WHERE id = '" + dk.getId() + "'";
        
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
    
    public void deleteDokter(int id){
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
