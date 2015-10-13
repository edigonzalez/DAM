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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    
    private void HacerBotonSalir(){ // ejecutar cuando se intenta salir del programa
   
       if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar el programa?", "Salir del programa",  JOptionPane.YES_NO_OPTION)  
             !=  JOptionPane.YES_OPTION)     return; // si no confirma nos vamos...
     
                System.exit(0);//nos vamos...
         
    };
    
    private void ejecutaGridLayout(){
        VentanaGridLayout vGridlayout = new VentanaGridLayout();
        vGridlayout.setVisible(true); 
    }
    
    private void ejecutaGridBagLayout(){
        VentanaGridBagLayout vGridBaglayout = new VentanaGridBagLayout();
        vGridBaglayout.setVisible(true); 
    }
    
   public VentanaPrincipal(){
       this.setSize(300,140);
       this.setLocation(500,100);
       this.setResizable(false);
       this.setTitle("EDUARDO_UT2_A2");
       
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
       
       ActionListener actionListenerParaGridLayout;   // creamos un actionlistener para el boton 
       actionListenerParaGridLayout = new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent evento) {
                ejecutaGridLayout();
            } // llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
        };                         
       botonGridLayout.addActionListener(actionListenerParaGridLayout); // que hacer si pincamos aqui..     
       p.add(botonGridLayout, pFormato);
       
       
       botonGridBagLayout = new JButton();
       botonGridBagLayout.setText("GridBagLayout");
       pFormato.gridy=fila; // posicion y 
       pFormato.gridx=1; // posicion x  = primera columna
       pFormato.gridwidth=1; // ancho en columnas.. (ocupa dos columnas) 
       pFormato.weighty=0.2; // separacion extra vertical;
       
       ActionListener actionListenerParaGridBagLayout;   // creamos un actionlistener para el boton 
       actionListenerParaGridBagLayout = new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent evento) {
                ejecutaGridBagLayout();
            } // llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
        };                         
       botonGridBagLayout.addActionListener(actionListenerParaGridBagLayout); // que hacer si pincamos aqui..
       
       p.add(botonGridBagLayout,pFormato);
       
       fila++;
       botonSalir = new JButton();
       botonSalir.setText("Salir");
       pFormato.gridy=fila; // posicion y 
       pFormato.gridx=1; // posicion x  = primera columna
       pFormato.gridwidth=1; // ancho en columnas.. (ocupa dos columnas) 
       pFormato.weighty=0.2; // separacion extra vertical
       
       ActionListener actionListenerParaSalir; // creamos un actionlistener para el boton 
       actionListenerParaSalir = new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent evento){ 
                HacerBotonSalir(); 
            } // llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
        };   
             
        botonSalir.addActionListener( actionListenerParaSalir); // que hacer si pincamos aqui..
        
        p.add(botonSalir,pFormato);
       /**********************/
       
       /*** AÑADIMOS EL PANEL A LA VENTANA ****/
       lienzo.add(p);
       
       this.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);  // ESTO ES PARA QUE PARE EL PROGRAMA CUANDO SE CIERRE LA VENTANA */
    }

}
