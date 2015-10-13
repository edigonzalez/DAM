/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2_a2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class Verificador {
    static boolean flag = false;
    static String usuarioAutenticado, usuarioAutenticadoPerfil;

    
    public Verificador (String usuario, String password, String perfil) throws FileNotFoundException, IOException{
        File fichero = new File ("config.txt");
        String linea;
        String[] capturarDatos = null;
        
        if ( !fichero.exists()){
               JOptionPane.showMessageDialog(null, "Almacén de claves no encontrado.");
        }
        
        try{
            FileReader ficheroClaves = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(ficheroClaves);
            
            while ( (linea = bf.readLine() ) != null){   
               capturarDatos = linea.split(",");
               if (capturarDatos[0].equalsIgnoreCase(usuario) && capturarDatos[1].equals(password) && capturarDatos[2].equals(perfil)){
                    flag = true; //Damos el ok al login porque los datos de acceso son correctos
                    usuarioAutenticado = capturarDatos[0];
                    usuarioAutenticadoPerfil = capturarDatos[2];
                }
            }
            if (!flag){
                JOptionPane.showMessageDialog(null, "¡DATOS DE ACCESO INCORRECTOS!");  
            }
            bf.close();
            ficheroClaves.close();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "No puedo leer del fichero, eror: " + e); 
        }
    }
}
