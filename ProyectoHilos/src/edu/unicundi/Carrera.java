/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi;

/**
 *
 * @author daiyd
 */
public class Carrera {
    
    
    public Carrera() {
    
    }
    
    public void empezar() {
        ComunEquipo comun = new ComunEquipo();
        Corredor corredor1 = new Corredor("Carlos", 1, comun);
        Corredor corredor2 = new Corredor("Juan", 2, comun);
        Corredor corredor3 = new Corredor("Beto", 3, comun);
        
        corredor1.start();
        corredor2.start();
        corredor3.start();
    }
    
}
