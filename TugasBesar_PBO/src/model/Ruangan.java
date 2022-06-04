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
public class Ruangan {
    private int id;
    private int id_department;
    private String tipe;
    private String fasilitas;
    private float harga;

    public Ruangan(int id, int id_department, String tipe, String fasilitas, float harga) {
        this.id = id;
        this.id_department = id_department;
        this.tipe = tipe;
        this.fasilitas = fasilitas;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }
    
    public void showRuangan(){
        System.out.println("Id");
        System.out.println("Id_department");
        System.out.println("Tipe");
        System.out.println("Fasilitas");
        System.out.println("Harga");
    }
}
