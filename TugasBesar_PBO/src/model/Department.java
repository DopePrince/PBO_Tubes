/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


/**
 * Kelompok 5
**/
public class Department {
    private int id;
    private String nama;
    private String jenis_penyakit;
    
    public Department(int id, String nama, String jenis_penyakit) {
        this.id = id;
        this.nama = nama;
        this.jenis_penyakit = jenis_penyakit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_penyakit() {
        return jenis_penyakit;
    }

    public void setJenis_penyakit(String jenis_penyakit) {
        this.jenis_penyakit = jenis_penyakit;
    }
    
    public void showDepartment(){
        System.out.println("Id Department");
        System.out.println("Nama");
        System.out.println("Jenis penyakit");
    }
}
