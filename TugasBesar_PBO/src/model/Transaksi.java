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

public class Transaksi {
    private int id;
    private double biaya_diagnosis;
    private String tanggal_transaksi;
    private Pasien pasien;
    private Dokter dokter;
    private Ruangan ruangan;

    public Transaksi(int id, double biaya_diagnosis, String tanggal_transaksi, Pasien pasien, Dokter dokter, Ruangan ruangan) {
        this.id = id;
        this.biaya_diagnosis = biaya_diagnosis;
        this.tanggal_transaksi = tanggal_transaksi;
        this.pasien = pasien;
        this.dokter = dokter;
        this.ruangan = ruangan;
    }
    
    public Transaksi(double biaya_diagnosis, String tanggal_transaksi, Pasien pasien, Dokter dokter, Ruangan ruangan) {
        this.biaya_diagnosis = biaya_diagnosis;
        this.tanggal_transaksi = tanggal_transaksi;
        this.pasien = pasien;
        this.dokter = dokter;
        this.ruangan = ruangan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBiaya_diagnosis() {
        return biaya_diagnosis;
    }

    public void setBiaya_diagnosis(double biaya_diagnosis) {
        this.biaya_diagnosis = biaya_diagnosis;
    }
    
    
    
    public String getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(String tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public Ruangan getRuangan() {
        return ruangan;
    }

    public void setRuangan(Ruangan ruangan) {
        this.ruangan = ruangan;
    }
    
    
}
