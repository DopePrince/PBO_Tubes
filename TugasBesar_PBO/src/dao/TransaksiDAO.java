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
    
    // Method untuk mengambil semua data Department
    public List<Transaksi> showTransaksi(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM department";
        System.out.println("Mengambil data Department...");
        
        List<Transaksi> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Jenis_Penyakit j = new Jenis_Penyakit(
                        rs.getInt("id"),
                        rs.getString("nama_penyakit"),
                        rs.getString("keterangan")
                    );
                    
                    Department dp = new Department(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        j       
                            
                    );
                    
                    Dokter dk = new Dokter(
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"),
                        rs.getString("gender"),
                        rs.getFloat("biaya_dokter"),
                        dp
                    );
                    
                    Transaksi tr = new Transaksi (
                        rs.getInt("int"),
                        rs.getString("tanggal_transaksi"),
                        
                    );
                    
                    Pasien p = new Pasien(
                        rs.getString("id"),
                        rs.getString("umur"),
                    )
    private String id;
    private String umur;
    private String nama;
    private String gender;
    private String alamat;
    private String no_telepon;
    private String jenis_pennyakit;    
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
    
    // Method untuk menyimpan data department
    public void insertDepartment(Department d){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO department(id, id_penyakit, nama) "
                + "VALUES ('" + d.getId()+ "', '" + d.getJenisPenyakit().getId() + "', '"
                + d.getNama() + "')";
        
        System.out.println("Adding Department...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Department");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Department...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Department> showDepartmentBySearch(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT dp.* FROM department as dp WHERE (dp.id LIKE "
                + "'%" + query + "%'"
                + "OR dp.nama LIKE '%" + query + "%'"
                + "OR dp.jenis_penyakit LIKE '%" + query + "%')";
        
        
        System.out.println("Mengambil data Department...");
        
        List<Department> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
          
                    Jenis_Penyakit j = new Jenis_Penyakit(
                        rs.getInt("id"),
                        rs.getString("nama_penyakit"),
                        rs.getString("keterangan")
                    );
                    
                    Department d = new Department(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        j
                    );
                    
                    list.add(d);
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
    
    
    public void updateDepartment(Department d, int id){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE department SET nama = '" + d.getNama()+ "', "
                + "id_penyakit = '" + d.getJenisPenyakit().getId() + "'"
                + "WHERE id = '" + id + "'";
        
        System.out.println("Editing Department...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Department " + id);
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing Department...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    // Method untuk menghapus data Department
    public void deleteDepartment(int id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM department WHERE id = '" + id + "'";
        System.out.println("Deleting department...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " department " + id);
            statement.close();
        }catch(Exception e){
            System.out.println("Error deleting department...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}
