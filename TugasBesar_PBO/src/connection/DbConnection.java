/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Nama  : Kenneth Vincentius Theys
 * NPM   : 200710681
 * Kelas : PBO - B
**/
public class DbConnection {
    public static Connection CON;
    public static final String URL = "jdbc:mysql://";
    public static final String PATH = "109.106.254.101:3306/u764338354_tubesK5?useSSL=false";
    public static final String USER = "u764338354_tubesK5";
    public static final String PASS = "u764338354_tubesKelompok5";
    
    public Connection makeConnection(){
        System.out.println("Opening database...");
        try{
            CON = DriverManager.getConnection(URL + PATH, USER, PASS);
            System.out.println("Success!");
        } catch(Exception e){
            System.out.println("Error opening database...");
            System.out.println(e);
        }
        
        return CON;
    }
    
    public void closeConnection(){
        System.out.println("Closing database...");
        try{
            CON.close();
            System.out.println("Success!");
        }catch(Exception e){
            System.out.println("Error closing database...");
            System.out.println(e);
        }
    }
}
