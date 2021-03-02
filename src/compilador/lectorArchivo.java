/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class lectorArchivo {

    //Diseñar un programa que permita leer un archivo txt que contenga
    //caracteres alfanuméricos. Implementar un método que retorne el carácter en el que va en el archivo.
    //En otro método imprimir a pantalla los caracteres que arroja la 
    //clase anterior (Dependiendo de cuantas veces se mande llamar el primer método serían los caracteres que mostraría a pantalla).
    
     public static void leerDatos() throws IOException{
    // ventana para abrir el txt
    
     String texto, aux;
     ArrayList<String> lista = new ArrayList();
        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
           // FileReader fr = new FileReader("C:\\Users\\carli\\Desktop\\iris.data"); 
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                String[] caract =    texto.split("");
                    for(int i=0;i<caract.length;i++){
                            System.out.println(caract[i]);
}
                }
                lee.close();
                System.out.println(lista.size());
                

                         
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
       
     }


    public static void main(String[] args) throws IOException {
   int fers;
   int carliwis;
   
   lectorArchivo.leerDatos();
    }
    
}