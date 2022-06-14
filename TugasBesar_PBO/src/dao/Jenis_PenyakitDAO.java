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
import model.Jenis_Penyakit;
import model.Department;
/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/
public class Jenis_PenyakitDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public List<Jenis_Penyakit> showJenis_Penyakit (){
        con=dbCon.makeConnection ();
        
        String sql = "SELECT dp.*, p.* FROM jenis_penyakit AS p JOIN department AS d WHERE p.id_penyakit = dp.id";
        System.out.println ("Mengambil data jenis penyakit...");
        
        List<Jenis_Penyakit> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null){
                while (rs.next()){
                    Department d = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
                    );
                    
                    Jenis_Penyakit jp = new Jenis_Penyakit (                   
                        Integer.parseInt(rs.getString("p.id")),
                        rs.getString ("p.nama_penyakit"),
                        rs.getString("p.keterangan"),
                        d
                    );
                list.add(jp);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading2 database...");
            e.printStackTrace();
        }
        dbCon.closeConnection();
        return list;
    }
    
    public void insertJenis_Penyakit(Jenis_Penyakit jp){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO jenis_penyakit(id,nama_penyakit,keterangan)"
                + "VALUES('"+ jp.getId()+ "','" + jp.getNama_penyakit()
                + "','" + jp.getKeterangan()+ "')";
        
        System.out.println("Adding Jenis_Penyakit");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added "+ result + "Jenis_Penyakit");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Jenis_Penyakit");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    public void updateJenis_Penyakit(Jenis_Penyakit jp) {
        con = dbCon.makeConnection();
        
        String sql = "UPDATE jenis_penyakit SET id = '" + jp.getId()+ "',nama_penyakit = '" + jp.getNama_penyakit()+ "',keterangan= '" + jp.getKeterangan()+ "' "
                + "WHERE id = '" + jp.getId() + "'"; 
        System.out.println("Editing Jenis_Penyakit...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Jenis_Penyakit " + jp.getId());
            statement.close(); 
        } catch (Exception e) {
             System.out.println("Error editing Jenis_Penyakit...");
             System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteJenis_Penyakit(int id) {
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM jenis_penyakit WHERE id = " + id + "";
        System.out.println("Deleting Jenis_Penyakit..");
        
        try {
            Statement statement = con.createStatement ();
            int result=statement.executeUpdate (sql);
            System.out.println ("Delete" + result +" Jenis_penyakit " + id);
            statement.close ();
        } catch (Exception e) {
            System.out.println("Error deleting Jenis_Penyakit");
            System.out.println(e);
        }
    }
    
    public List<Jenis_Penyakit> showJenis_Penyakit(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT dp.*, p.* FROM department as dp JOIN jenis_penyakit as p WHERE (p.id LIKE "
                + "'%" + query + "%'"
                + "OR p.nama_penyakit LIKE '%" + query + "%'"
                + "OR dp.nama LIKE '%" + query + "%')";
        
        
        System.out.println("Mengambil data Jenis Penyakit...");
        
        List<Jenis_Penyakit> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Department d = new Department(
                        rs.getInt("dp.id"),
                        rs.getString("dp.nama")
                    );

                    Jenis_Penyakit j = new Jenis_Penyakit(
                        rs.getInt("p.id"), 
                        rs.getString("p.nama_penyakit"),
                        rs.getString("p.keterangan"),
                        d
                    );
                    
                    list.add(j);
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
}
