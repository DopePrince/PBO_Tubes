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

public class Dokter {
    private String id;
    private String nama;
    private String alamat;
    private String no_telepon;
    private String gender;
    private float biaya_dokter;
    private Department department;

    public Dokter(String id, String nama, String alamat, String no_telepon, String gender, float biaya_dokter, Department department) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
        this.gender = gender;
        this.biaya_dokter = biaya_dokter;
        this.department = department;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getBiaya_dokter() {
        return biaya_dokter;
    }

    public void setBiaya_dokter(float biaya_dokter) {
        this.biaya_dokter = biaya_dokter;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    
    
    public void showDokter(){
        System.out.println("Id Dokter");
        System.out.println("FK Id Department");
        System.out.println("Nama");
        System.out.println("Alamat");
        System.out.println("No. telepon");
        System.out.println("Gender");
        System.out.println("Biaya Dokter");
    }
}
