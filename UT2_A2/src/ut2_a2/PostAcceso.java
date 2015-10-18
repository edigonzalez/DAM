/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_a2;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Eduardo
 */
public class PostAcceso extends JDialog { //El Objeto PostAcceso va a contener estos atributos
    
    JLabel mensaje; //label para mostrar un mensaje
    String gestor; //Variable para mostrar el tipo de layoiut seleccionado
    
    public PostAcceso(String usuario, String perfil, int tipoLayout){ //Constructor del Objeto Post Acceso. Se le pasa el usuario y perfil que tuvo el acceso correcto y el tipo de layout seleccionado (0=GridLayout ; 1=GridBagLayout)
       this.setSize(300,150);// tamaño de la ventana
       this.setLocation(500,100);// posicion 
       this.setTitle(usuario+"/"+perfil);//Título de la ventana. La cogemos de los parámetros pasados a esta clase
       
       Container lienzo = this.getContentPane();//Creamos el contenedor. Que va a contener el panel donde estarán nuestro botones, textfield, etc.
       lienzo.setLayout(new FlowLayout()); //esta vez no usamos un panel, si no que directamente lo ponemos sobre el contenedor
       
       mensaje = new JLabel(); //Inicializamos la etiqueta declarada para mostrar el mensaje
       
       //Si el parámetro tipolayout que se le pasa a esta clase es igual 0, entonces el gestor = GRIDLAYOOUT. Si es igual 1, el gestor = GRIDBAGLAYOUT
       if (tipoLayout == 0) gestor = "GRIDLAYOUT";
       else gestor = "GRIDBAGLAYOUT";
       
       //Establecemos el texto de la etiqueta. Se pueden usar etiquetas html para darle formato a la etiqueta <br> = salto de línea
       mensaje.setText("<html>Ha entrado con el Usuario: " + usuario.toUpperCase()+ "<br><br>" +
               "Perfil de Acceso: " + perfil.toUpperCase() + "<br><br>" + "Tipo de layout usado: " + gestor + "</html>");
       
       lienzo.add(mensaje);   //añadímos la etiqueta al contenedor
       
       this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// le decimos que al cerrar la ventana, solamente la cierre y no salga del programa
    }
}
