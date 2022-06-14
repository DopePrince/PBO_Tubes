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

public class DepartmentDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    // Method untuk mengambil semua data Department
    public List<Department> showDepartment(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM department";
        System.out.println("1Mengambil data Department...");
        
        List<Department> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    
                    Department d = new Department(
                        rs.getInt("id"),
                        rs.getString("nama")
                    );
                    list.add(d);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("test4");
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    // Method untuk menyimpan data department
    public void insertDepartment(Department d){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO department(id, nama) "
                + "VALUES ('" + d.getId() + "', '"
                + d.getNama() + "')";
        
        System.out.println("Adding Department...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Department");
            statement.close();
        }catch(Exception e){
            System.out.println("insert");
            System.out.println("Error adding Department...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Department> showDepartment(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT dp.* FROM department as dp WHERE (dp.id LIKE "
                + "'%" + query + "%'"
                + "OR dp.nama LIKE '%" + query + "%')";
        
        
        System.out.println("4Mengambil data Department...");
        
        List<Department> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    
                    Department d = new Department(
                        rs.getInt("id"),
                        rs.getString("nama")
                    );
                    
                    list.add(d);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("test");
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    

    public void updateDepartment(Department d, int id){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE department SET nama = '" + d.getNama()+ "'"
                + "WHERE id = '" + id + "'";
        
        System.out.println("Editing Department...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Department " + id);
            statement.close();
        }catch(Exception e){
            System.out.println("1test");
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
            System.out.println("delete");
            System.out.println("Error deleting department...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}
