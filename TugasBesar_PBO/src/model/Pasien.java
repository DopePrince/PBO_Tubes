/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 * Nama  : Kenneth Vincentius Theys
 * NPM   : 200710681
 * Kelas : PBO - B
**/
public class Pasien {
    private String id;
    private String umur;
    private String nama;
    private String gender;
    private String alamat;
    private String no_telepon;
    private String jenis_pennyakit;

    public Pasien(String id, String umur, String nama, String gender, String alamat, String no_telepon, String jenis_pennyakit) {
        this.id = id;
        this.umur = umur;
        this.nama = nama;
        this.gender = gender;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
        this.jenis_pennyakit = jenis_pennyakit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getJenis_pennyakit() {
        return jenis_pennyakit;
    }

    public void setJenis_pennyakit(String jenis_pennyakit) {
        this.jenis_pennyakit = jenis_pennyakit;
    }
    
    
}
