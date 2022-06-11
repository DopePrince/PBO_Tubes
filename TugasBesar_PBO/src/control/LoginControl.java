/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author henry
 */

import model.Login;

public class LoginControl {
    public List<Login> showListLogin(){
        List<Pasien> dataPasien = dDao.showPasien();
        
        return dataPasien;
    }
}
