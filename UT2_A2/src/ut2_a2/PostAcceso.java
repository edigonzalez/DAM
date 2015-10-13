/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_a2;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Eduardo
 */
public class PostAcceso extends JDialog {
    
    JLabel mensaje;
    String gestor;
    
    public PostAcceso(String usuario, String perfil, int tipoLayout){
       this.setSize(300,150);
       this.setLocation(500,100);
       this.setTitle(usuario+"/"+perfil);
       
       Container lienzo = this.getContentPane();
       lienzo.setLayout(new FlowLayout());
       
       mensaje = new JLabel();
       
       if (tipoLayout == 0) gestor = "GRIDLAYOUT";
       else gestor = "GRIDBAGLAYOUT";
       
       mensaje.setText("<html>Ha entrado con el Usuario: " + usuario.toUpperCase()+ "<br><br>" +
               "Perfil de Acceso: " + perfil.toUpperCase() + "<br><br>" + "Tipo de layout usado: " + gestor + "</html>");
       
       lienzo.add(mensaje);   
       this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
}
