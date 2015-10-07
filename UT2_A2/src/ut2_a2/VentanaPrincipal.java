/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_a2;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Eduardo
 */
public class VentanaPrincipal extends JFrame{
    
    private final JButton botonGridBagLayout;
    private final JButton botonGridLayout;
    private final JButton botonSalir;
    private final JLabel etiqueta;
    private final JPanel p;
    
   public VentanaPrincipal(){
       this.setSize(300,140);
       this.setLocation(500,100);
       this.setTitle("UT2_A2");
       
       Container lienzo = this.getContentPane();
       /*** CONSTRUIMOS EL PANEL ***/
       p = new JPanel();
       p.setLayout(new GridBagLayout());
       
       GridBagConstraints pFormato = new GridBagConstraints();
       pFormato.fill = GridBagConstraints.HORIZONTAL;

       int fila=0; // para ir indicando la fila donde se ponen los objetos..
     
       this.etiqueta = new JLabel();
       this.etiqueta.setText("Escoga una opción: ");  
       pFormato.gridy=fila; // posicion y 
       pFormato.gridx=0; // posicion x  = primera columna
       pFormato.gridwidth=1; // ancho en columnas.. (ocupa dos columnas) 
       pFormato.weighty=0.2; // separacion extra vertical
       p.add(etiqueta, pFormato);
       
       fila++;
       botonGridLayout = new JButton();
       botonGridLayout.setText("GridLayout");
       pFormato.gridy=fila; // posicion y 
       pFormato.gridx=0; // posicion x  = primera columna
       pFormato.gridwidth=1; // ancho en columnas.. (ocupa dos columnas) 
       pFormato.weighty=0.2; // separacion extra vertical
       pFormato.insets = new Insets(3, 3, 3, 3);
       p.add(botonGridLayout, pFormato);
       
       botonGridBagLayout = new JButton();
       botonGridBagLayout.setText("GridBagLayout");
       pFormato.gridy=fila; // posicion y 
       pFormato.gridx=1; // posicion x  = primera columna
       pFormato.gridwidth=1; // ancho en columnas.. (ocupa dos columnas) 
       pFormato.weighty=0.2; // separacion extra vertical;
       p.add(botonGridBagLayout,pFormato);
       
       fila++;
       botonSalir = new JButton();
       botonSalir.setText("Salir");
       pFormato.gridy=fila; // posicion y 
       pFormato.gridx=1; // posicion x  = primera columna
       pFormato.gridwidth=1; // ancho en columnas.. (ocupa dos columnas) 
       pFormato.weighty=0.2; // separacion extra vertical
       p.add(botonSalir,pFormato);
       /**********************/
       
       /*** AÑADIMOS EL PANEL A LA VENTANA ****/
       lienzo.add(p);
       
       this.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);  // ESTO ES PARA QUE PARE EL PROGRAMA CUANDO SE CIERRE LA VENTANA */
    }

}
