/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daiyd
 */
public class Corredor extends Thread{
    private String nombre;
    private int posicion;
    private ComunEquipo comun;

    public Corredor(String nombre, int posicion, ComunEquipo comun) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.comun = comun;
    }

    @Override
    public void run() {

        if (posicion == 1) {
            System.out.println("Arranco a correr " + nombre);
            for (int i = 0; i < 33; i++) {
         
                try {
                    Thread.sleep(100);
                    System.out.println(nombre + " Voy en el paso: " + i);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
            
            synchronized(comun){
                comun.notifyAll();
            }
            
            System.out.println("Corredor " + nombre + " Acabo");
        } else {
            synchronized(comun) {
                System.out.println("Corredor " + nombre + " en espera");
                try {
                    comun.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
            System.out.println("Corredor " + nombre + " empiezo a correr");
        }

    }

}
