/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


/**
 * Kelompok 5 :
 * 200710534 - Nicholas Suharto
 * 200710587 - Aldyo Putra
 * 200710607 - Henry
 * 200710653 - Tia Vianka Yustin
 * 200710681 - Kenneth Vincentius Theys
**/

public class Department {
    private int id;
    private String nama;
    private Jenis_Penyakit jenisPenyakit;

    public Department(int id, String nama, Jenis_Penyakit jenisPenyakit) {
        this.id = id;
        this.nama = nama;
        this.jenisPenyakit = jenisPenyakit;
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

    public Jenis_Penyakit getJenisPenyakit() {
        return jenisPenyakit;
    }

    public void setJenisPenyakit(Jenis_Penyakit jenisPenyakit) {
        this.jenisPenyakit = jenisPenyakit;
    }
    
    public void showDepartment(){
        System.out.println("Id Department");
        System.out.println("Nama");
        System.out.println("Jenis penyakit");
    }
}
