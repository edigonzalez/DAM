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
public class Verificador {//El Objeto Verificador va a contener estos atributos
    static boolean flag = false; //para indicar si ha sido correcto o no el acceso
    static String usuarioAutenticado, usuarioAutenticadoPerfil; //variables para guardar el usuario y el perfil para luego ponerlo en el título de la ventana de la clase PostAcceso

    
    public Verificador (String usuario, String password, String perfil) throws FileNotFoundException, IOException{
        File fichero = new File ("config.csv"); //indicamos el fichero a leer
        String linea; //creamos la variable linea para guardar linea a linea el fichero leído.
        String[] capturarDatos = null; //declaramos un array para guardar las palabaras de cada línea
        
        if ( !fichero.exists()){ //Si no existe el fichero muestra el siguiente mensaje
               JOptionPane.showMessageDialog(null, "Almacén de claves no encontrado.");
        }
        
        try{ //intentamos leer el fichero
            FileReader ficheroClaves = new FileReader(fichero); //instanciamos el objeto ficheroclave de la clase FileReader pasandole como parámetro el nombre del fichero
            BufferedReader bf = new BufferedReader(ficheroClaves); //BuffererdReader proporciona una lectura eficiente de caracteres, matrices y líneas.
            
            while ( (linea = bf.readLine() ) != null){ //mientras las líneas sean distintas de null, es decir, mientras haya líneas que leer...
               capturarDatos = linea.split(","); //guardamos cada palabra en un array. Las palabras de cada línea están separadas por comas
               if (capturarDatos[0].equalsIgnoreCase(usuario) && capturarDatos[1].equals(password) && capturarDatos[2].equals(perfil)){ //como la estructura del fichero es usuario,contraseña,perfil... Sí el usuario, contraseña y perfil pasados como parámetros a la clase coinciden con el array entonces...
                    flag = true; //Damos el ok al login porque los datos de acceso son correctos
                    usuarioAutenticado = capturarDatos[0]; //guardamos el usuario para ponerlo en el título de la ventana de la clase PostAcceso
                    usuarioAutenticadoPerfil = capturarDatos[2]; //guardamos el perfil para ponerlo en el título de la ventana de la clase PostAcceso
                }
            }
            if (!flag){ //Si el acceso ha sido incorrecto...
                flag=false;
                JOptionPane.showMessageDialog(null, "¡DATOS DE ACCESO INCORRECTOS!"); //mostramos este mensaje
            }
            bf.close(); //cerramos el BufferReader
            ficheroClaves.close(); //cerramos el FileReader
        }//Si no puede leer el fichero mostramos el mensaje de error.
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "No puedo leer del fichero, eror: " + e); 
        }
    }
}
