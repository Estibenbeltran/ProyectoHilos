/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 *
 * @author daiyd
 */
public class Corredor extends Thread {
    Panel objPanelGlobal;
    int salida;
    Ventana ventana;
    static boolean ganador = false;
    static boolean llegada1 = false, llegada2 = false,llegada3 = false;

    Corredor(Panel objPanel, int posicion, Ventana v){
        objPanelGlobal = objPanel;
        salida = posicion;
        ventana = v;
    }
    @Override
    public void run(){
        ganador = false;
        int ale1, ale2, ale3;
        boolean jugar = false;
        ale1 = (int)(Math.random()*140)+81;
        ale2 = (int)(Math.random()*140)+81;
        ale3 = (int)(Math.random()*140)+81;
        super.run(); 
        if(salida>=1 && salida<=3){
            jugar = true;
        }
        if(jugar){
            for(int i=0; i<368; i++){
                if(salida == 1){
                    if(objPanelGlobal.x1<368){
                        objPanelGlobal.x1+=2;
                    }else{
                        llegada1 = true;
                        Ventana v = new Ventana();
                        i=369;
                        if(ganador==false){
                        JOptionPane.showMessageDialog(v, "GANA LA EL CORREDOR 1", "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        ganador=true;
                        }
                    }

                    try {
                        Thread.sleep(ale1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    objPanelGlobal.repaint();
                    objPanelGlobal.removeAll();
                }

                if(salida == 2){
                    if(objPanelGlobal.x2<368){
                        objPanelGlobal.x2+=2;
                    }else{
                        llegada2 = true;
                        Ventana v = new Ventana();
                        i = 369;
                        if(ganador==false){
                        JOptionPane.showMessageDialog(v, "GANA EL CORREDOR 2", "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        ganador=true;
                        }
                    }

                    try {
                        Thread.sleep(ale2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    objPanelGlobal.repaint();
                    objPanelGlobal.removeAll();
                }
                

                if(salida == 3){
                    if(objPanelGlobal.x3<368){
                        objPanelGlobal.x3+=2;
                    }else{
                        llegada3 = true;
                        
                        Ventana v = new Ventana();
                        i = 369;
                        if(ganador==false){
                        JOptionPane.showMessageDialog(v, "GANA EL CORREDOR 3", "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        ganador=true;
                        }
                    }

                    try {
                        Thread.sleep(ale3);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    objPanelGlobal.repaint();
                    objPanelGlobal.removeAll();
                }
            }
        }else{
            objPanelGlobal.x1=0;
            objPanelGlobal.x2=0;
            objPanelGlobal.x3=0;
            
            objPanelGlobal.repaint();
            objPanelGlobal.removeAll();
        }
    }
}
