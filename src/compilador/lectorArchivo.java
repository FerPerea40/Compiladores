/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
    public File leerDatos() throws IOException {
        // ventana para abrir el txt

        String texto, aux;
        ArrayList<String> lista = new ArrayList();
        
            //llamamos el metodo que permite cargar la ventana
           JFileChooser file = new JFileChooser();
           file.showOpenDialog(file);
            // FileReader fr = new FileReader("C:\\Users\\carli\\Desktop\\iris.data"); 
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
              // System.out.print("saque: "+leyendo(abre));
                 return abre;
            }
        
     return null;
    }

    public char leyendo(FileReader archivos) throws FileNotFoundException, IOException {

        BufferedReader lee = new BufferedReader(archivos);
        int caract = archivos.read();
//        if (caract == -1) {
//        //    imprimiendo((char)caract);
//                     
//        return 0;
//        }else{
//        caract = archivos.read();   
//            return (char)caract;
//        }
        if(caract == -1){
      return 0;}
        //return 0;
       return (char)caract;

    }
    
    public void imprimiendo(char caracter){
        System.out.println(caracter);
    }
    public static void main(String[] args) throws IOException {
        int fers;
        int carliwis;
        lectorArchivo la = new lectorArchivo();
        FileReader archivos = new FileReader(la.leerDatos());
     System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
     System.out.println(la.leyendo(archivos));
  System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
     System.out.println(la.leyendo(archivos));
       System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
     System.out.println(la.leyendo(archivos));
  System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
     System.out.println(la.leyendo(archivos));
     System.out.println(la.leyendo(archivos));
  System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
     System.out.println(la.leyendo(archivos));
       System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
     System.out.println(la.leyendo(archivos));
  System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
System.out.println(la.leyendo(archivos));
     System.out.println(la.leyendo(archivos));
  System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
       System.out.println(la.leyendo(archivos));
  System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
System.out.println(la.leyendo(archivos));
     System.out.println(la.leyendo(archivos));
  System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
      
      
      System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
            
      
      System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));
      System.out.println(la.leyendo(archivos));

    }

}
