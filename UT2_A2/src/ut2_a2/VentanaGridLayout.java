/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_a2;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Eduardo
 */
public class VentanaGridLayout extends JDialog{ //El Objeto VentanaPrincipal va a contener estos atributos
    
    JLabel user, pass, perfil;
    JTextField usuario, contraseña;
    JComboBox comboPerfil;
    JButton botonAcceso, botonCancelar;
    JPanel panelGridLayout;
    String[] perfilStrings = {"Perfil...", "Cliente", "Proveedor", "Administrador"}; //items del combobox
    int tipo=0; //para indicar que es un gridlayout que le pasamos como parámetro al objeto PostAcceso
    
    private void ejecutaCancelar(){ //cuando pinchamnos en el boton cancelar ejecuta esto
        dispose(); //mata o destruye el objeto, es decir, cierra la ventana.
    }
    
    public void limpiarCampos(){ //método para limpiar los campos del formulario
        this.usuario.setText(null);
        this.contraseña.setText(null);
        this.comboPerfil.setSelectedIndex(0);
    }
    
    private void ejecutaAcceso() throws IOException{ //cuando pinchamnos en el boton acceso ejecuta esto
        //Si hay algún campo vacio. Muestra una ventana informandonos que faltan campos por cumplimentar
        if ("".equals(this.usuario.getText()) || "".equals(this.contraseña.getText()) || "Perfil...".equals(this.comboPerfil.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, "Introduzca Usuario, Contraseña y Perfil de acceso");
            limpiarCampos();
        }
        else{ //le pasamos al objeto Verificador, el usuario, contraseña, y perfil para su comprobación
            Verificador controlAcceso = new Verificador (this.usuario.getText(), this.contraseña.getText(), this.comboPerfil.getSelectedItem().toString()); //construimos el objeto Verificador pasandole el usuario y contraseña escritos
            if (controlAcceso.flag){ //Si el acceso ha sido correcto llamamos al objeto PostAcceso y ponemos el flag en false para el siguiente acceso
                PostAcceso vPostAcceso = new PostAcceso(Verificador.usuarioAutenticado, Verificador.usuarioAutenticadoPerfil, tipo); //le pasamos al constructor del objeto el usuario, perfil y el tipo de layout
                Verificador.flag=false; //ponemos el flag en false para el siguiente acceso.
                vPostAcceso.setVisible(true); //Hacemos visible la ventana PostAcceso
                limpiarCampos(); //llamamos al metodo limpiarCampos
            }
        }
    }
    
    public VentanaGridLayout(){ //Constructor del Objeto VentanaGridLayout
        this.setSize(400,200); //Tamaño de la ventana (x,y)
        this.setLocation(350,200);//Localización de la ventana en la pantalla de nuestro ordenador (x,y)
        this.setResizable(false);  //No podemos cambiar el tamaño de la ventana
        this.setTitle("EDUARDO_UT2_A2 ACCESO GRIDLAYOUT"); //Título de la ventana
        
        Container lienzo = this.getContentPane(); //Creamos el contenedor. Que va a contener el panel donde estarán nuestro botones, textfield, etc.
        
        /*** CONSTRUIMOS EL PANEL ***/
        panelGridLayout = new JPanel();//Creamos el panel
        panelGridLayout.setLayout(new GridLayout(4, 2, 10, 6)); //Establecemos el tipo de layout a usar. GridLayout (filas, columnas, separación horizontal, separación vertical)
        
        user = new JLabel("Usuario: ");//creamos un campo etiqueta
        user.setForeground(new Color(102, 102, 153));//Le damos un color a la etiqueta
        
        usuario = new JTextField();//creamos un campo textfield
        
        pass = new JLabel("Clave de acceso: ");//creamos un campo etiqueta
        pass.setForeground(new Color(102, 102, 153));//Le damos un color a la etiqueta
        
        contraseña = new JPasswordField();//creamos un campo textfield pero de tipo password, es decir, lo que se escriba en él, se va a representar con puntos
        
        perfil = new JLabel("Perfil: ");//creamos un campo etiqueta
        perfil.setForeground(new Color(102, 102, 153));//Le damos un color a la etiqueta
        
        comboPerfil = new JComboBox(perfilStrings);//creamos un campo tipo combo. Los items del combo está predefinidos en los atributos del objeto.
        
        botonAcceso = new JButton(); //creamos un botón
        botonAcceso.setText("Acceso"); //damos un nombre al botón
        
        ActionListener actionAcceso;   // creamos un actionlistener para el botón 
        actionAcceso = new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent evento) {
                try {
                    ejecutaAcceso();// llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
                } catch (IOException ex) {
                    Logger.getLogger(VentanaGridLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        };                         
        botonAcceso.addActionListener(actionAcceso); // que hacer si pinchamos en el boton
        
        botonCancelar = new JButton(); //creamos un botón
        botonCancelar.setText("Cancelar");//damos un nombre al botón
        ActionListener actionCancelar;   // creamos un actionlistener para el boton 
        actionCancelar = new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent evento) {
                ejecutaCancelar();// llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
            } 
        };                         
        botonCancelar.addActionListener(actionCancelar); // que hacer si pinchamos en el boton
        
        /*** AÑADIMOS LOS COMPONENTES AL PANEL ***/
        panelGridLayout.add(user);
        panelGridLayout.add(usuario);
        panelGridLayout.add(pass);
        panelGridLayout.add(contraseña);
        panelGridLayout.add(perfil);
        panelGridLayout.add(comboPerfil);
        panelGridLayout.add(botonAcceso);
        panelGridLayout.add(botonCancelar);
        /********************************************/
        
        panelGridLayout.setBorder(new EmptyBorder(8, 8, 8, 8));//Establecemos un borde invisible al panel. Hará que los componentes agregado no se pegen al borde de la ventana
        
        lienzo.add (panelGridLayout); //añadimos el panel al contenedor
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  // le decimos que al cerrar la ventana, solamente la cierre y no salga del programa
    }
}
