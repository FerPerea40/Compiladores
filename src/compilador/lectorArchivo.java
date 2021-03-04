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
import static java.lang.System.exit;
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
    char comparar;
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
        int caract = archivos.read();
        if (caract == -1) {
            exit(0);
        }
        return (char) caract;
    }

    public void imprimiendo(char caracter) {
        System.out.println(caracter);
    }

    public static void main(String[] args) throws IOException {
        int fers;
        int carliwis;
        char caracterprincipal;
        lectorArchivo la = new lectorArchivo();
        FileReader archivos = new FileReader(la.leerDatos());
        la.comparar = la.leyendo(archivos);
        String palabra = la.tokenizar(archivos);
        String palabra2 = la.tokenizar(archivos);
        String palabra3 = la.tokenizar(archivos);
        String palabra4 = la.tokenizar(archivos);
        System.out.println(palabra);
        System.out.println(palabra2);
        System.out.println(palabra3);
        System.out.println(palabra4);
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//
//        //AQUI SE PASA DE LOS DATOS DEL ARCHIVO
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));
//        System.out.println(la.leyendo(archivos));

    }

    public String tokenizar(FileReader archivos) throws IOException {
        String cadena = "";
        char caract = comparar;
        if (caract == 95 || (caract >= 65 && caract <= 90) || (caract >= 97 && caract <= 122)) {
            cadena += caract;
            caract = leyendo(archivos);
            while ((caract >= 65 && caract <= 90) || (caract >= 97 && caract <= 122)) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            if (caract == 95 || (caract >= 48 && caract <= 57)) {
                cadena += caract;
                caract = leyendo(archivos);
                while (caract >= 48 && caract <= 57) {
                    cadena += caract;
                    caract = leyendo(archivos);
                }
            }
            comparar = caract;
            //System.out.println(comparar);
            return cadena;
        } else if (caract >= 48 && caract <= 57) {
            cadena += caract;
            caract = leyendo(archivos);
            while (caract >= 48 && caract <= 57) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            if (caract == 46) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            while (caract >= 48 && caract <= 57) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            //System.out.println(comparar);
            return cadena;
        }else if(caract == 60 || caract == 62 || caract == 33 || caract == 47 || caract == 42 || caract == 43 || caract == 45){
            cadena+=caract;
            caract = leyendo(archivos);
            if(caract == 61){
                cadena+=caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        }else if(caract == 38){
            cadena+=caract;
            caract = leyendo(archivos);
            if(caract == 38){
                cadena+=caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        } else if(caract == 124){
            cadena+=caract;
            caract = leyendo(archivos);
            if(caract == 124){
                cadena+=caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        }else if(caract == 43){
            cadena+=caract;
            caract = leyendo(archivos);
            if(caract == 43){
                cadena+=caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        }else if(caract == 45){
            cadena+=caract;
            caract = leyendo(archivos);
            if(caract == 45){
                cadena+=caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        }else if(caract == 61){
            cadena+=caract;
            caract = leyendo(archivos);
            if(caract == 61){
                cadena+=caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        }else {
            cadena += caract;
            comparar = leyendo(archivos);
            return cadena;
        }

    }

    public String tokenizar2(FileReader archivos) throws IOException {
        String cadena = "";
        char caract = leyendo(archivos);

        if (caract == 95 || (caract >= 65 && caract <= 90) || (caract >= 97 && caract <= 122)) {
            cadena += caract;
            caract = leyendo(archivos);
            while ((caract >= 65 && caract <= 90) || (caract >= 97 && caract <= 122)) {
                caract = leyendo(archivos);
                cadena += caract;
            }
            if (caract == 95 || (caract >= 48 && caract <= 57)) {//ESTE IF
                caract = leyendo(archivos);
                cadena += caract;
                while (caract >= 48 && caract <= 57) {
                    caract = leyendo(archivos);
                    cadena += caract;
                }
            }
            return cadena;
        } else if (caract >= 48 && caract <= 57) {
            caract = leyendo(archivos);

            cadena += caract;
            while (caract >= 48 && caract <= 57) {
                caract = leyendo(archivos);
                cadena += caract;
            }
            if (caract == 46) { // ESTE IF
                caract = leyendo(archivos);
                cadena += caract;
            }
            while (caract >= 48 && caract <= 57) {
                caract = leyendo(archivos);

                cadena += caract;
            }
            return cadena;
        }else {

            System.out.println("ee" + caract);
            String cad = "" + caract;
            return cad;
        }

    }
    // (_)?([a-z]|[A-Z])+(_)?([0-9])*
    // [0-9]+ (/.)* [0-9]*
    //_ -> 95
    //A-Z -> 65 - 90
    //a -z -> 97 - 122
    //0-9 -> 48 - 57
    //. -> 46
}
