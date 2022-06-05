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
    private String gender;
    private String alamat;
    private String no_telepon;
    private Jenis_Penyakit jenis_penyakit;
    private Transaksi transaksi;

    public Pasien(String id, int umur, String nama, String gender, String alamat, String no_telepon, Jenis_Penyakit jenis_penyakit, Transaksi transaksi) {
        this.id = id;
        this.umur = umur;
        this.nama = nama;
        this.gender = gender;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
        this.jenis_penyakit = jenis_penyakit;
        this.transaksi = transaksi;
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

    public Jenis_Penyakit getJenis_pennyakit() {
        return jenis_penyakit;
    }

    public void setJenis_penyakit(Jenis_Penyakit jenis_penyakit) {
        this.jenis_penyakit = jenis_penyakit;
    }
    
    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }
    
}
