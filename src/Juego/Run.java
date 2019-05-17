/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Interfaz.Inicio;
import Interfaz.Juego;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

/**
 *
 * @author Aspire
 */
public class Run {
    
    public static void main(String[] args){
    
   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
            
                    // Se obtiene un Clip de sonido
                    Clip sonido = AudioSystem.getClip();
            
                    // Se carga con un fichero wav
                    sonido.open(AudioSystem.getAudioInputStream(new File(
                    "C:\\Users\\Aspire\\Documents\\NetBeansProjects\\Poker\\src\\Audios\\LoveIsBlue.wav")));
            
                    // Comienza la reproducción
                    sonido.start();
                    
                    sonido.loop(Clip.LOOP_CONTINUOUSLY);
                    
                } catch (Exception e) {
                    System.out.println("" + e); 
                }
                
                
                try{ 
                    Thread.sleep(1000); 
                } 
                catch(InterruptedException e ){ 
                    System.out.println("" + e);
                }
                              
                Inicio inicio = new Inicio(); 
                
                inicio.setVisible(true);    
                
                
                try{ 
                    Thread.sleep(7000); 
                } 
                catch(InterruptedException e ){ 
                    System.out.println("" + e);
                }      
                
                inicio.jTextFieldTexas.setText("Hola");
                
                try{ 
                    Thread.sleep(7000); 
                } 
                catch(InterruptedException e ){ 
                    System.out.println("" + e);
                }      
                
                javax.swing.JPanel pane = new JPanel();
                
                pane.updateUI();
                
                inicio.jTextFieldPoker.setText("HolaUwU");
                
                                
            }
        });
    }
   
    
    
    
    
}
