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
public class VentanaGridBagLayout extends JDialog{
    
    JLabel user, pass, perfil;
    JTextField usuario, contraseña;
    JComboBox comboPerfil;
    JButton botonAcceso, botonCancelar;
    JPanel panelGridBagLayout;
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
        
        int tipo=1;

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
    
    public VentanaGridBagLayout(){
        this.setSize(250,170); // tamaño de la ventana
        this.setLocation(350,200);// posicion 
        this.setResizable(false);  //evitamos el cambio de tamaño
        this.setTitle("EDUARDO_UT2_A2 ACCESO");
        
        Container lienzo = this.getContentPane();
        panelGridBagLayout = new JPanel();
        
        panelGridBagLayout.setLayout(new GridBagLayout());
        GridBagConstraints formato = new GridBagConstraints(); // este objeto nos sirve para indicar donde y como queremos que se pongan
        
        formato.fill = GridBagConstraints.HORIZONTAL;
        formato.insets = new Insets(3,3,3,3);
        
        user = new JLabel();
        user.setText("Usuario: ");
        user.setForeground(new Color(102, 102, 153));
        formato.gridx = 0;
        formato.gridy = 0;
        panelGridBagLayout.add(user,formato);
        
        usuario = new JTextField();
        formato.gridx = 1;
        formato.gridy = 0;
        panelGridBagLayout.add(usuario,formato);
        
        pass = new JLabel();
        pass.setText("Clave de Acceso: ");
        pass.setForeground(new Color(102, 102, 153));
        formato.gridx = 0;
        formato.gridy = 1;
        panelGridBagLayout.add(pass,formato);
        
        contraseña = new JPasswordField();
        formato.gridx = 1;
        formato.gridy = 1;
        panelGridBagLayout.add(contraseña,formato);
        
        perfil = new JLabel();
        perfil.setText("Perfil: ");
        perfil.setForeground(new Color(102, 102, 153));
        formato.gridx = 0;
        formato.gridy = 2;
        panelGridBagLayout.add(perfil,formato);
        
        comboPerfil = new JComboBox(perfilStrings);
        formato.gridx = 1;
        formato.gridy = 2;
        panelGridBagLayout.add(comboPerfil,formato);
        
        formato.insets = new Insets(8,3,3,3);
        
        botonAcceso = new JButton();
        botonAcceso.setText("Acceso");
        formato.gridx = 0;
        formato.gridy = 3;
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
        panelGridBagLayout.add(botonAcceso,formato);
        
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
                ejecutaCancelar();
            } // llamamos al metodo de la clase ventanaPrincipal que nos lo va a controlar
        };                         
        botonCancelar.addActionListener(actionCancelar); // que hacer si pincamos aqui
        panelGridBagLayout.add(botonCancelar,formato);
        
        lienzo.add(panelGridBagLayout);
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
}
