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
import java.util.EventListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Eduardo
 */
public class RelojBean extends JLabel implements ActionListener,Serializable {

    private Calendar calendar;//CALENDAR para consultar modificar las propiedades de una fecha
    private int hora, minuto, segundo, am_pm, horaAMPM; //Variables para guardar las horas minutos y segundos. AM_PM nos guarda 0 si es AM o 1 si es PM. horaAMPM nos guarda la hora en formato de 12h.
    private Timer timer; //TIMER para lanzar una tarea cada cierto tiempo
    private ActionListener actionlistenerHora; //Listener que va a escuchar el TIMER
    private boolean formato=true; //Propiedad formato inicializada por defecto a true para que el compomente muestre por defecto el reloj en 24H.
    private String Alarma; //Propiedad donde se guardará la ALARMA.
    private String[] horaAlarma; //Array para guarda en un índice la hora y en otro los minutos
    private String AlarmHM, horaReloj; //Strings usadas para guardar la hora de alarma, sin : y la hora de reloj, sin :
    private HoraAlarmaListener receptor; //Listener para escuchar cuando la hora de la alarma SEA IGUAL a la hora del reloj
    private HoraNoAlarmaListener receptorNulo; //Listener para escuchar cuando la hora de la alarma NO SEA IGUAL a la hora del reloj

    /*** Esto lo agregó NETBEANS tras implementar las clases que heredan de EvenObject. 
     Decía de implementar todos los métodos abstractos o algo así. Lo dejo porque me funciona**/
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /** Copiado tal cual del ejercicio del Temporizador. Sólo se ha cambiado los nombre 
     Esta es la clase que hereda de EventObject que nos va a controlar el evento cuando la alarma
     SEA igual a la hora**/
    public class HoraAlarmaEvent extends java.util.EventObject{
    // constructor, se le pasa el objeto y un identificador.
        public HoraAlarmaEvent(Object source){
            super(source);
        }
    }
    
    /** Copiado tal cual del ejercicio del Temporizador. Sólo se ha cambiado los nombre 
     Esta es la clase que hereda de EventObject que nos va a controlar el evento cuando la alarma
     NO SEA igual a la hora**/
    public class HoraNoAlarmaEvent extends java.util.EventObject{
    // constructor, se le pasa el objeto y un identificador.
        public HoraNoAlarmaEvent(Object source){
            super(source);
        }
    }
    
    /** Copiado tal cual del ejercicio del Temporizador. Sólo se ha cambiado los nombre 
     Esta es el listener que va a escuchar cuando la alarma SEA igual a la hora**/
    //Define la interfaz para el nuevo tipo de evento
    public interface HoraAlarmaListener extends EventListener{
        void capturarHoraAlarma(HoraAlarmaEvent ev);
    }
    
    /** Copiado tal cual del ejercicio del Temporizador. Sólo se ha cambiado los nombre 
     Esta es el listener que va a escuchar cuando la alarma NO SEA igual a la hora**/
    //Define la interfaz para el nuevo tipo de evento
    public interface HoraNoAlarmaListener extends EventListener{
        void capturarHoraNoAlarma(HoraNoAlarmaEvent ev);
    }
   
    /** Este método nos va a controlar el los segundos del reloj e irlos incrementando, así
     *  como ir incrmentando también los minutos y las horas
     */
    private void validarHora(){
        if (segundo >= 59){
            minuto++;
            segundo = 0;
            if (minuto >= 59){
                hora++;
                minuto = 0;
                if (formato){ 
                    if (hora > 24) hora = 1;
                }else{
                    if (horaAMPM == 0) horaAMPM = 12;
                    if (horaAMPM > 12) horaAMPM = 1;
                }
            }
        }else segundo++;    
    } 
    /******* FIN METODO ****/
    
    /*** PROPIEDAD ALARMA ***/
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
        horaAlarma = Alarma.split(":"); //guardamos en un arrya de String la hora y minutos por separado
        //Aquí lo que hacemos es que si escribimos la alarma, por ejemplo, 03:08, se van a eliminar los 0
        if (horaAlarma[0].charAt(0)=='0') horaAlarma[0]=horaAlarma[0].substring(1, horaAlarma[0].length());
        if (horaAlarma[1].charAt(0)=='0') horaAlarma[1]=horaAlarma[1].substring(1, horaAlarma[1].length());    
        AlarmHM = horaAlarma[0]+horaAlarma[1];  //Aquí guardamos la concatenación de las dos cadenas
    }
    /*** FIN DE LA PROPIEDAD ALARMA **/
    
    /*** PROPIEDAD FORMATO ***/
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
    /*** FIN DE LA PROPIEDAD FORMATO ***/
    
    /*** Este método nos va a controlar el modo de visualizar el reloj. Si en formato 12h 
     * o en formato 24H, según sea true o false la propiedad formato.
     * FORMATO = TRUE ---> 24H
     * FORMATO = FALSE ---> 12h
     */
    private void mostrarDatos(){
        horaAMPM = calendar.get(Calendar.HOUR);
        if (horaAMPM == 0) horaAMPM=12; //En formato 12h, las 12 las muestra como 0. Aquí le decímos que lo muestre como 12
        
        if (formato){ //Si formato es TRUE, mostramos hora + minuto + segundo en formato de 24H y guardamos en la variable la concatenacion de hora y minuto pasados a string
            setText(hora+" : "+minuto+" : "+segundo);
            horaReloj = String.valueOf(hora)+String.valueOf(minuto);
        }else{//Si es FALSE, y según sea la variable am_pm nos va a decir si estasmo en AM o PM. Mostramos hora + minuto + segundo en formato 12h y guardamos en la variable la concatenacion de hora y minuto pasados a string    
            if (am_pm == 0) setText(horaAMPM+" : "+minuto+" : "+segundo+ " AM");
            if (am_pm == 1) setText(horaAMPM+" : "+minuto+" : "+segundo+ " PM");
            horaReloj = String.valueOf(horaAMPM)+String.valueOf(minuto);
        }        
    }
    /*** FIN METODO ***/
    
    /*** Método a través del cual vamos a obtener los datos de la hora, minutos y segundos ***/
    private void obtenerDatos (){      
        Date fechaHoraActual = new Date();
        calendar.setTime(fechaHoraActual);
        
        hora = calendar.get(Calendar.HOUR_OF_DAY);
        minuto = calendar.get(Calendar.MINUTE);
        segundo = calendar.get(Calendar.SECOND);
        am_pm = calendar.get(Calendar.AM_PM);
        
    }
    /*** FIN METODO ***/
    
    /*** CONSTRUCTOR DE LA CLASE DEL COMPONENTE JAVA ***/
    public RelojBean() {
       calendar = Calendar.getInstance(); //instanciamos calendar que el cual nos crea un objeto de la clase conteniendo la fecha de ese momento
       actionlistenerHora = new ActionListener() { 
           @Override
           public void actionPerformed(ActionEvent e) {
               validarHora(); //Llamamos al método que nos va a controlar el paso de los segundos 
               mostrarDatos(); //Mostramos la hora
               
               /** Solamente para imprimo la salida de las dos variables para saber que hora está cogiendo **/
                    //System.out.println(horaReloj+"--->HORA RELOJ");
                    //System.out.println(AlarmHM+"--->HORA ALARMA");
               /**** SE PUEDE ELIMINAR. ES SIMPLEMENTE INFORMACION COMPLEMENTARIA****************************/
               
               if (horaReloj.equals(AlarmHM)){ //Si la hora coincide con la alarma salta el evento que programemos o no
                   receptor.capturarHoraAlarma(new HoraAlarmaEvent(this));
               }else receptorNulo.capturarHoraNoAlarma(new HoraNoAlarmaEvent(this)); //si no coincide salta el evento que programemos o no
            }
       };
       timer = new Timer (1000, actionlistenerHora); //instaciamos el TIMER diciendole que ejecute el actionlistenerHora cada segundo
       obtenerDatos(); //Obtenemos los datos de hora, minuto y segundo por primera vez
       mostrarDatos(); //Mostramos la hora obtenida por primera vez
       timer.start(); //Empieza a lanzar la tarea
    } 
    
    // Copiado tal cual del ejercicio del Temporizador. Sólo se ha cambiado los nombres. Creo que se usa para que los eventos salgan en las propiedades, no lo se... 
    
    public void addHoraAlarmaListener(HoraAlarmaListener receptor){
        this.receptor = receptor;
    }

    public void removeHoraAlarmaListener(HoraAlarmaListener receptor){
        this.receptor=null;
    }
    
    public void addHoraNoAlarmaListener(HoraNoAlarmaListener receptor){
        this.receptorNulo = receptor;
    }

    public void removeHoraNoAlarmaListener(HoraNoAlarmaListener receptor){
        this.receptorNulo=null;
    }
}
