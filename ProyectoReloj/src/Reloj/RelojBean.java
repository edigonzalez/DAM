/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Eduardo
 */
public class RelojBean extends JLabel implements Serializable {
       
    private PropertyChangeSupport propertySupport;
    private Calendar calendar;
    private int hora, minuto, segundo, am_pm, horaAMPM;
    private Timer timer;
    private ActionListener actionlistener;
    private boolean formato;
    private String Alarma;
   
    
    private void validarHora(){
        if (segundo == 59){
            minuto++;
            segundo = 0;
            if (minuto == 59){
                minuto = 0;
                hora++;
                if (formato){ 
                    if (hora > 23) {
                        hora = 0;
                    }
                }else{
                    if (hora > 11){
                        hora = 0;
                    }
                }
            }
        }else segundo++;    
    }
    

    /**
     * Get the value of Alarma
     *
     * @return the value of Alarma
     */
    public String getAlarma() {
        return Alarma;
        
    }

    /**
     * Set the value of Alarma
     *
     * @param Alarma new value of Alarma
     */
    public void setAlarma(String Alarma) {
        this.Alarma = Alarma;
    }

    /**
     * Get the value of formato
     *
     * @return the value of formato
     */
    public boolean isFormato() {
        return formato;
    }

    /**
     * Set the value of formato
     *
     * @param formato new value of formato
     */
    public void setFormato(boolean formato) {
        this.formato = formato;
    }
 
    private void mostrarDatos(){
        horaAMPM = calendar.get(Calendar.HOUR);

        if (formato){
            setText(hora+" : "+minuto+" : "+segundo);
        }else{            
            if (am_pm == 0) setText(horaAMPM+" : "+minuto+" : "+segundo+ " AM");
            if (am_pm == 1) setText(horaAMPM+" : "+minuto+" : "+segundo+ " PM");
        }        
    }
    
    private void obtenerDatos (){      
        Date fechaHoraActual = new Date();
        calendar.setTime(fechaHoraActual);
        
        hora = calendar.get(Calendar.HOUR_OF_DAY);
        minuto = calendar.get(Calendar.MINUTE);
        segundo = calendar.get(Calendar.SECOND);
        am_pm = calendar.get(Calendar.AM_PM);
        
    }
    
    public RelojBean() {
       propertySupport = new PropertyChangeSupport(this);
       calendar = Calendar.getInstance();
       actionlistener = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               validarHora();
               mostrarDatos();
           }
       };
       timer = new Timer (1000, actionlistener);
       obtenerDatos();
       mostrarDatos();
       timer.start();
    } 
}
