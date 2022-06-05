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

public class Pasien {
    private String id;
    private int umur;
    private String nama;
    private String jenis_kelamin;
    private String alamat;
    private String no_telepon;
<<<<<<< Updated upstream
    private String jenis_pennyakit;

    public Pasien(String id, int umur, String nama, String gender, String alamat, String no_telepon, String jenis_pennyakit) {
=======
    private String no_ruangan;
    private String jenis_penyakit;
    
    public Pasien(String id, int umur, String nama, String jenis_kelamin, String alamat, String no_telepon, String no_ruangan, String jenis_penyakit, Dokter dokter) {
>>>>>>> Stashed changes
        this.id = id;
        this.umur = umur;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
        this.no_ruangan = no_ruangan;
        this.jenis_penyakit = jenis_penyakit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
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

    
    public String getNo_ruangan(){
        return no_ruangan;
    }
    
    public void setNo_ruangan(String no_ruangan){
        this.no_ruangan = no_ruangan;
    }
    
    
    
    public String getJenis_penyakit() {
        return jenis_penyakit;
    }

    public void setJenis_pennyakit(String jenis_penyakit) {
        this.jenis_penyakit = jenis_penyakit;
    }
    
 
}
