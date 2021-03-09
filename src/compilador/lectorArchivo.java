/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.swing.JFileChooser;

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
  //      if (caract == -1) {
     //       exit(0);
    //    }
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
        
        for(int i=0 ;i<31;i++){
                String palabra = la.tokenizar(archivos);
        System.out.println(palabra);

        
        }
//        String palabra = la.tokenizar(archivos);
//        String palabra2 = la.tokenizar(archivos);
//        String palabra3 = la.tokenizar(archivos);
//        String palabra4 = la.tokenizar(archivos);
//        String palabra5 = la.tokenizar(archivos);
//        String palabra6 = la.tokenizar(archivos);
//        String palabra7 = la.tokenizar(archivos);
//        String palabra8 = la.tokenizar(archivos);
//        String palabra9= la.tokenizar(archivos);
//        String palabra10 = la.tokenizar(archivos);
//        String palabra11 = la.tokenizar(archivos);
//        String palabra12 = la.tokenizar(archivos);
//        String palabra13 = la.tokenizar(archivos);
//        String palabra14 = la.tokenizar(archivos);
//        String palabra15 = la.tokenizar(archivos);
//        String palabra16 = la.tokenizar(archivos);
//        System.out.println(palabra);
//        System.out.println(palabra2);
//        System.out.println(palabra3);
//        System.out.println(palabra4);
//        System.out.println(palabra5);
//        System.out.println(palabra6);
//        System.out.println(palabra7);
//        System.out.println(palabra8);   
//        System.out.println(palabra9);
//        System.out.println(palabra10);
//        System.out.println(palabra11);
//        System.out.println(palabra12);
//        System.out.println(palabra13);
//        System.out.println(palabra14);
//        System.out.println(palabra15);
//        System.out.println(palabra16);
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
            // (_)?([a-z]|[A-Z])+(_)?([0-9])*

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
        } else if (caract == 60 || caract == 62 || caract == 47 || caract == 42 || caract == 43 || caract == 45) {
            cadena += caract;
            caract = leyendo(archivos);
            if (caract == 61) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        } else if (caract == 38) {
            cadena += caract;
            caract = leyendo(archivos);
            if (caract == 38) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        }  else if (caract == 33) { //!!...
            cadena += caract;
            caract = leyendo(archivos);
            if (caract == 33) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        }else if (caract == 124) {
            cadena += caract;
            caract = leyendo(archivos);
            if (caract == 124) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        } else if (caract == 43) {
            cadena += caract;
            caract = leyendo(archivos);
            if (caract == 43) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        } else if (caract == 45) {
            cadena += caract;
            caract = leyendo(archivos);
            if (caract == 45) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        } else if (caract == 61) {
            cadena += caract;
            caract = leyendo(archivos);
            if (caract == 61) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        } else {
            cadena += caract;
            comparar = leyendo(archivos);
            return cadena;
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
