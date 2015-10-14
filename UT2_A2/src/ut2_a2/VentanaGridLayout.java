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
public class VentanaGridLayout extends JDialog{
    
    JLabel user, pass, perfil;
    JTextField usuario, contraseña;
    JComboBox comboPerfil;
    JButton botonAcceso, botonCancelar;
    JPanel panelGridLayout;
    String[] perfilStrings = {"Perfil...", "Cliente", "Proveedor", "Administrador"};
    
    private void ejecutaCancelar(){
        dispose();
    }
    
    private void limpiarCampos(){
        this.usuario.setText(null);
        this.contraseña.setText(null);
        this.comboPerfil.setSelectedIndex(0);
    }
    
    private void ejecutaAcceso() throws IOException{
        
        int tipo=0;

        if ("".equals(this.usuario.getText()) || "".equals(this.contraseña.getText()) || "Perfil...".equals(this.comboPerfil.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, "Introduzca Usuario, Contraseña y Perfil de acceso");
            limpiarCampos();
        }
        else{
            Verificador controlAcceso = new Verificador (this.usuario.getText(), this.contraseña.getText(), this.comboPerfil.getSelectedItem().toString());
            if (controlAcceso.flag){
                PostAcceso vPostAcceso = new PostAcceso(Verificador.usuarioAutenticado, Verificador.usuarioAutenticadoPerfil, tipo);
                Verificador.flag=false;
                vPostAcceso.setVisible(true);
                limpiarCampos();
            }
        }
    }
    
    public VentanaGridLayout(){
        this.setSize(400,200); // tamaño de la ventana
        this.setLocation(350,200);// posicion 
        this.setResizable(false);  //evitamos el cambio de tamaño
        this.setTitle("EDUARDO_UT2_A2 ACCESO");
        
        Container lienzo = this.getContentPane();
        /*** CONSTRUIMOS EL PANEL ***/
        panelGridLayout = new JPanel();
        panelGridLayout.setLayout(new GridLayout(4, 2, 10, 6));
        
        user = new JLabel("Usuario: ");
        user.setForeground(new Color(102, 102, 153));
        usuario = new JTextField();
        pass = new JLabel("Clave de acceso: ");
        pass.setForeground(new Color(102, 102, 153));
        contraseña = new JPasswordField();
        perfil = new JLabel("Perfil: ");
        perfil.setForeground(new Color(102, 102, 153));
        comboPerfil = new JComboBox(perfilStrings);
        
        botonAcceso = new JButton();
        botonAcceso.setText("Acceso");
        ActionListener actionAcceso;   // creamos un actionlistener para el boton 
        actionAcceso = new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent evento) {
                try {
                    ejecutaAcceso();
                } catch (IOException ex) {
                    Logger.getLogger(VentanaGridLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
            } // llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
        };                         
        botonAcceso.addActionListener(actionAcceso); // que hacer si pincamos aqui
        
        botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        ActionListener actionCancelar;   // creamos un actionlistener para el boton 
        actionCancelar = new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent evento) {
                ejecutaCancelar();
            } // llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
        };                         
        botonCancelar.addActionListener(actionCancelar); // que hacer si pincamos aqui
        
        panelGridLayout.add(user);
        panelGridLayout.add(usuario);
        panelGridLayout.add(pass);
        panelGridLayout.add(contraseña);
        panelGridLayout.add(perfil);
        panelGridLayout.add(comboPerfil);
        panelGridLayout.add(botonAcceso);
        panelGridLayout.add(botonCancelar);
        
        panelGridLayout.setBorder(new EmptyBorder(8, 8, 8, 8));
        lienzo.add (panelGridLayout);
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  // le decimos al java que al entrar a cerrar la ventana que le sistema no haga nada..
    }
}
