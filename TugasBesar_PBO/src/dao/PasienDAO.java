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
        String sql = "INSERT INTO pasien(id, id_penyakit, umur, nama, jenis_kelamin, alamat, no_telepon) "
                + "VALUES ('" + ps.getId()+ "', '"
                + ps.getPenyakit().getId() + "', '"
                + ps.getUmur()+ "', '" + ps.getNama()+ "', '"
                + ps.getJenis_kelamin()+ "', '" + ps.getAlamat()+ "', '" + ps.getNo_telepon()+ "')";
    
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
        
        String sql = "SELECT jp.*, p.* FROM pasien AS p JOIN jenis_penyakit AS jp ON jp.id = p.id_penyakit WHERE (id LIKE "
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
// String id, int umur, String nama, String jenis_kelamin, String alamat, String no_telepon, Jenis_Penyakit penyakit           
            if(rs != null){
                while(rs.next()){
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
                    );
                    
                    Jenis_Penyakit jp = new Jenis_Penyakit(
                        rs.getInt("j.id"), 
                        rs.getString("nama_penyakit"), 
                        rs.getString("keterangan"),
                        dp
                    );
                    
                    Pasien p = new Pasien(
                        rs.getString("id"),
                        rs.getInt("umur"),
                        rs.getString("nama"),
                        rs.getString("gender"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"),
                        jp
                    );
                    
                    list.add(p);
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
    
    public List<Pasien> showPasien(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM pasien";
        System.out.println("Mengambil data Pasien...");
        
        List<Pasien> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
                    );
                    
                    Jenis_Penyakit jp = new Jenis_Penyakit(
                        rs.getInt("j.id"), 
                        rs.getString("nama_penyakit"), 
                        rs.getString("keterangan"),
                        dp
                    );
                    
                    Pasien p = new Pasien(
                        rs.getString("id"),
                        rs.getInt("umur"),
                        rs.getString("nama"),
                        rs.getString("gender"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"),
                        jp
                    );
                    
                    list.add(p);
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
    
    public Pasien searchPasien(int id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT jp.*, p.* FROM pasien AS p JOIN jenis_penyakit AS jp ON jp.id = p.id_penyakit WHERE p.id = '" + id + "'";
        System.out.println("Searching Pasien...");
        Pasien p = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Department dp = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
                    );
                    
                    Jenis_Penyakit jp = new Jenis_Penyakit(
                        rs.getInt("j.id"), 
                        rs.getString("nama_penyakit"), 
                        rs.getString("keterangan"),
                        dp
                    );
                    
                    p = new Pasien(
                        rs.getString("id"),
                        rs.getInt("umur"),
                        rs.getString("nama"),
                        rs.getString("gender"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"),
                        jp
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
        
        return p;
    }
    
    public void updatePasien(Pasien p){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE pasien SET id_penyakit = '" + p.getPenyakit().getId() +  "', " 
                + "umur = '" + p.getNama()+ "', "
                + "nama = '" + p.getNama()+ "', "
                + "gender = '" + p.getJenis_kelamin() + "', " 
                + "alamat = '" + p.getAlamat()+ "', "
                + "no_telepon = '" + p.getNo_telepon() + "', " 
                + "WHERE id = '" + p.getId() + "'";
        
        System.out.println("Editing Pasien...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Pasien " + p.getId());
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing pasien...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deletePasien(String id){
        con = dbCon.makeConnection();
        System.out.println(id);
        
        String sql = "DELETE FROM pasien WHERE id = '" + id + "'";
        System.out.println("Deleting Pasien...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Pasien " + id);
            statement.close();
        }catch(Exception e){
            System.out.println("Error deleting Pasien...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

}
