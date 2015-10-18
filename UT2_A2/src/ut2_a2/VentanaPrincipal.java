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
public class VentanaPrincipal extends JFrame{ //El Objeto VentanaPrincipal va a contener estos atributos
    
    private final JButton botonGridBagLayout;
    private final JButton botonGridLayout;
    private final JButton botonSalir;
    private final JLabel etiqueta;
    private final JPanel p;
    
    private void HacerBotonSalir(){ // ejecuta esto cuando se intenta salir del programa
        //creamos una ventiana tipo Pptionpane para preguntarno si queremos salir o no
       if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar el programa?", "Salir del programa",  JOptionPane.YES_NO_OPTION) !=  JOptionPane.YES_OPTION) 
            return; // si no confirma nos vamos...
       System.exit(0);//nos vamos...       
    };
    
    private void ejecutaGridLayout(){ //cuando pinchamnos en el boton gridlayout ejecuta esto
        
        VentanaGridLayout vGridlayout = new VentanaGridLayout(); //Crea e instancia el objeto Ventana GridLayout
        vGridlayout.setVisible(true); //la hacemos visible
    }
    
    private void ejecutaGridBagLayout(){ //cuando pinchamnos en el boton gridbaglayout ejecuta esto
        VentanaGridBagLayout vGridBaglayout = new VentanaGridBagLayout(); //Crea e instancia el objeto Ventana GridBagLayout
        vGridBaglayout.setVisible(true); //la hacemos visible
    }
    
   public VentanaPrincipal(){ //Constructor del Objeto VentanaPrincipal
       this.setSize(300,140); //Tamaño de la ventana (x,y)
       this.setLocation(500,100); //Localización de la ventana en la pantalla de nuestro ordenador (x,y)
       this.setResizable(false); //No podemos cambiar el tamaño de la ventana
       this.setTitle("EDUARDO_UT2_A2"); //Título de la ventana
       
       Container lienzo = this.getContentPane(); //Creamos el contenedor. Que va a contener el panel donde estarán nuestro botones, textfield, etc.
       
       /*** CONSTRUIMOS EL PANEL ***/
       p = new JPanel(); //Creamos el panel
       p.setLayout(new GridBagLayout()); //Establecemos el tipo de layout a usar. GridBagLayout =  tipo rejilla, pero que cada celda la podemos modificar
       
       GridBagConstraints pFormato = new GridBagConstraints(); //Instanciamos cómo se van a construir los componentes del layout
       pFormato.fill = GridBagConstraints.HORIZONTAL; //Este campo se utiliza cuando el área de visualización del componente es mayor que el tamaño solicitado del componente.

       int fila=0; // para ir indicando la fila donde se vamos a poner el primer componente.
     
       this.etiqueta = new JLabel(); //creamos un campo etiqueta
       this.etiqueta.setText("Escoga una opción: ");  //Establecemos el texto de la etiqueta
       pFormato.gridy=fila; // posicion y = fila en la rejilla
       pFormato.gridx=0; // posicion x  = columna en la rejilla
       pFormato.gridwidth=1; // ancho en columnas. Sólo ocupa una columna 
       pFormato.weighty=0.2; // separacion extra vertical entre celdas
       p.add(etiqueta, pFormato); //añadimos el componente al panel y su formato.
       
       fila++; //bajamos a la siguiente fila
       botonGridLayout = new JButton(); //Creamos un botón
       botonGridLayout.setText("GridLayout"); //establecemos el nombre del botón
       pFormato.gridy=fila; // posicion y = fila en la rejilla
       pFormato.gridx=0; // posicion x  = columna en la rejilla
       pFormato.gridwidth=1; // ancho en columnas. Sólo ocupa una columna 
       pFormato.weighty=0.2; // separacion extra vertical
       pFormato.insets = new Insets(3, 3, 3, 3); //Este campo especifica el relleno externo del componente, es decir, la cantidad mínima de espacio entre el componente y los bordes de su área de visualización. Se aplica a toda la fila       
       ActionListener actionListenerParaGridLayout;   // creamos un actionlistener para el botón
       actionListenerParaGridLayout = new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent evento) {
                ejecutaGridLayout(); // llamamos al metodo de la clase VentanaPrincipal que nos lo va a controlar
            } 
        };                         
       botonGridLayout.addActionListener(actionListenerParaGridLayout); // establecemos que hace el botón si pinchamos sobre él.     
       p.add(botonGridLayout, pFormato); //añadimos el componente al panel y su formato.
       
       botonGridBagLayout = new JButton(); //Creamos un botón
       botonGridBagLayout.setText("GridBagLayout"); //establecemos el nombre del botón
       pFormato.gridy=fila; // posicion y = fila en la rejilla
       pFormato.gridx=1; // posicion x  = columna en la rejilla
       pFormato.gridwidth=1; // ancho en columnas.
       pFormato.weighty=0.2; // separacion extra vertical;
       
       ActionListener actionListenerParaGridBagLayout;   // creamos un actionlistener para el boton 
       actionListenerParaGridBagLayout = new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent evento) {
                ejecutaGridBagLayout();// llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
            } 
        };                         
       botonGridBagLayout.addActionListener(actionListenerParaGridBagLayout); // establecemos que hace el botón si pinchamos sobre él.  
       p.add(botonGridBagLayout,pFormato); //añadimos el componente al panel y su formato.
       
       fila++; //bajamos una fila
       botonSalir = new JButton(); //Creamos un botón
       botonSalir.setText("Salir"); //establecemos el nombre del botón
       pFormato.gridy=fila; // posicion y = fila en la rejilla
       pFormato.gridx=1; // posicion x  = columna en la rejilla
       pFormato.gridwidth=1; // ancho en columnas.
       pFormato.weighty=0.2; // separacion extra vertical
       
       ActionListener actionListenerParaSalir; // creamos un actionlistener para el boton 
       actionListenerParaSalir = new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent evento){ 
                HacerBotonSalir(); // llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
            } 
        };   
        botonSalir.addActionListener( actionListenerParaSalir); // establecemos que hace el botón si pinchamos sobre él.  
        p.add(botonSalir,pFormato); //añadimos el componente al panel y su formato.
       /**** FIN DE CREACION DEL PANEL ************/
       
       /*** AÑADIMOS EL PANEL A LA VENTANA ****/
       lienzo.add(p); 
       
       this.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);  // ESTO ES PARA QUE PARE EL PROGRAMA CUANDO SE CIERRE LA VENTANA 
    }

}
