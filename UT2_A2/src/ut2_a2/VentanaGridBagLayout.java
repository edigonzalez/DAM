/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_a2;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

/**
 *
 * @author Eduardo
 */
public class VentanaGridBagLayout extends JDialog{ //El Objeto VentanaPrincipal va a contener estos atributos
    
    JLabel user, pass, perfil;
    JTextField usuario, contraseña;
    JComboBox comboPerfil;
    JButton botonAcceso, botonCancelar;
    JPanel panelGridBagLayout;
    String[] perfilStrings = {"Perfil...", "Cliente", "Proveedor", "Administrador"}; //items del combobox
    int tipo=1; //para indicar que es un gridbaglayout a postacceso
    
    private void ejecutaCancelar(){ //cuando pinchamnos en el boton cancelar ejecuta esto
        dispose(); //mata o destruye el objeto, es decir, cierra la ventana.
    }
    
    public void limpiarCampos(){ //método para limpiar los campos del formulario
        this.usuario.setText(null);
        this.contraseña.setText(null);
        this.comboPerfil.setSelectedIndex(0);
    }
    
    private void ejecutaAcceso() throws IOException{//cuando pinchamnos en el boton acceso ejecuta esto
    //Si hay algún campo vacio. Muestra una ventana informandonos que faltan campos por cumplimentar
        if ("".equals(this.usuario.getText()) || "".equals(this.contraseña.getText()) || "Perfil...".equals(this.comboPerfil.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, "Introduzca Usuario, Contraseña y Perfil de acceso");
            limpiarCampos();
        }
        else{ //le pasamos al objeto Verificador, el usuario, contraseña, y perfil para su comprobación
            Verificador controlAcceso = new Verificador (this.usuario.getText(), this.contraseña.getText(), this.comboPerfil.getSelectedItem().toString());//construimos el objeto Verificador pasandole el usuario y contraseña escritos
            if (controlAcceso.flag){ //Si el acceso ha sido correcto llamamos al objeto PostAcceso y ponemos el flag en false para el siguiente acceso
                PostAcceso vPostAcceso = new PostAcceso(Verificador.usuarioAutenticado, Verificador.usuarioAutenticadoPerfil, tipo); //le pasamos al constructor del objeto PostAcceso el usuario del objeto Verificador, perfil del objeto Verificador y el tipo de layout
                Verificador.flag=false; //ponemos el flag en false para el siguiente acceso.
                vPostAcceso.setVisible(true); //Hacemos visible la ventana PostAcceso
                limpiarCampos(); //llamamos al metodo limpiarCampos
            }
        }
    }
    
    public VentanaGridBagLayout(){ //Constructor del Objeto VentanaGridBagLayout
        this.setSize(300,170); // tamaño de la ventana
        this.setLocation(350,200);// posicion 
        this.setResizable(false);  //evitamos el cambio de tamaño
        this.setTitle("EDUARDO_UT2_A2 ACCESO GRIDBAGLAYOUT"); //Título de la ventana
        
        Container lienzo = this.getContentPane();//Creamos el contenedor. Que va a contener el panel donde estarán nuestro botones, textfield, etc.
        
         /*** CONSTRUIMOS EL PANEL ***/
        panelGridBagLayout = new JPanel();
        panelGridBagLayout.setLayout(new GridBagLayout());
        GridBagConstraints formato = new GridBagConstraints(); // este objeto nos sirve para indicar donde y como queremos que se pongan los componentes dentro del panel
        
        formato.fill = GridBagConstraints.HORIZONTAL;
        formato.insets = new Insets(3,3,3,3); //Este campo especifica el relleno externo del componente, es decir, la cantidad mínima de espacio entre el componente y los bordes de su área de visualización. Se aplica a toda la fila 
        
        user = new JLabel();
        user.setText("Usuario: ");
        user.setForeground(new Color(102, 102, 153));
        formato.gridx = 0; //fila
        formato.gridy = 0; //columna
        panelGridBagLayout.add(user,formato); //añadimos el componente y su formato
        
        usuario = new JTextField();
        formato.gridx = 1;
        formato.gridy = 0;
        panelGridBagLayout.add(usuario,formato); //añadimos el componente y su formato
        
        pass = new JLabel();
        pass.setText("Clave de Acceso: ");
        pass.setForeground(new Color(102, 102, 153));
        formato.gridx = 0;
        formato.gridy = 1;
        panelGridBagLayout.add(pass,formato); //añadimos el componente y su formato
        
        contraseña = new JPasswordField();
        formato.gridx = 1;
        formato.gridy = 1;
        panelGridBagLayout.add(contraseña,formato); //añadimos el componente y su formato
        
        perfil = new JLabel();
        perfil.setText("Perfil: ");
        perfil.setForeground(new Color(102, 102, 153));
        formato.gridx = 0;
        formato.gridy = 2;
        panelGridBagLayout.add(perfil,formato); //añadimos el componente y su formato
        
        comboPerfil = new JComboBox(perfilStrings);
        formato.gridx = 1;
        formato.gridy = 2;
        panelGridBagLayout.add(comboPerfil,formato); //añadimos el componente y su formato
        
        formato.insets = new Insets(8,3,3,3); //Este campo especifica el relleno externo del componente, es decir, la cantidad mínima de espacio entre el componente y los bordes de su área de visualización. Se aplica a toda la fila 
        
        botonAcceso = new JButton();
        botonAcceso.setText("Acceso");
        formato.gridx = 0;
        formato.gridy = 3;
        ActionListener actionAcceso;   // creamos un actionlistener para el boton 
        actionAcceso = new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent evento) {
                try {
                    ejecutaAcceso(); // llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
                } catch (IOException ex) {
                    Logger.getLogger(VentanaGridLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        };                         
        botonAcceso.addActionListener(actionAcceso); // que hacer si pincamos aqui
        panelGridBagLayout.add(botonAcceso,formato); //añadimos el componente y su formato
        
        botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        formato.gridx = 1;
        formato.gridy = 3;
        botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        ActionListener actionCancelar;   // creamos un actionlistener para el boton 
        actionCancelar = new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent evento) {
                ejecutaCancelar(); // llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
            } 
        };                         
        botonCancelar.addActionListener(actionCancelar); // que hacer si pinchamos en el boton
        panelGridBagLayout.add(botonCancelar,formato); //añadimos el componente y su formato
        
        lienzo.add(panelGridBagLayout); //añadimos el panel al contenedor
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// le decimos que al cerrar la ventana, solamente la cierre y no salga del programa
    }
}
