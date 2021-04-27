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
import java.util.HashMap;
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
    static HashMap<Integer, String> tabla = new HashMap();

    public File leerDatos() throws IOException {
        // ventana para abrir el txtr

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
            return 0;
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
        la.generarTabla();
        
        ArrayList<String> palabritas = new ArrayList<>();
      
       for (int i = 0; i < 63; i++) {
            String palabra = la.tokenizar(archivos);
            System.out.println(palabra);
            palabritas.add(palabra);
            System.out.println(la.mensaje(la.validarCadena(palabra)));
            System.out.println();
        }
       
       lexico lex =  new lexico(palabritas);
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
        } else if (caract == 33) { //!!...
            cadena += caract;
            caract = leyendo(archivos);
            if (caract == 33) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            comparar = caract;
            return cadena;
        } else if (caract == 124) {
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
        } else if (caract == 34) {
            cadena += caract;
            caract = leyendo(archivos);
            while (caract == 32 || caract == 33 || (caract >= 35 && caract <= 126)) {
                cadena += caract;
                caract = leyendo(archivos);
            }
            if (caract == 34) {
                cadena += caract;
                caract = leyendo(archivos);
            }

            comparar = caract;
            //System.out.println(comparar);
            return cadena;
        } else if (caract == 32) {
            caract = leyendo(archivos);
            comparar = caract;
            return tokenizar(archivos);
        } else if (caract == 13) {
            caract = leyendo(archivos);
            caract = leyendo(archivos);

            comparar = caract;
            return tokenizar(archivos);
        } else {
            cadena += caract;
            comparar = leyendo(archivos);
            return cadena;
        }

    }

    public void generarTabla() {
        tabla.put(1, "whilesito");
        tabla.put(2, "ifsito");
        tabla.put(3, "enterito");
        tabla.put(4, "flotantito");
        tabla.put(5, "doublesito");
        tabla.put(6, "stringsito");
        tabla.put(7, "charsito");
        tabla.put(8, "returnsito");
        tabla.put(9, "mainsito");
        tabla.put(10, "funcioncita");
        tabla.put(11, "voidsito");
        tabla.put(12, ">=");
        tabla.put(13, "<=");
        tabla.put(14, ">");
        tabla.put(15, "<");
        tabla.put(16, "!!");
        tabla.put(17, "==");
        tabla.put(18, "++");
        tabla.put(19, "--");
        tabla.put(20, "+");
        tabla.put(21, "-");
        tabla.put(22, "/");
        tabla.put(23, "*");
        tabla.put(24, "=");
        tabla.put(25, "&&");
        tabla.put(26, "oo");
        tabla.put(27, "CF");
        tabla.put(28, "constant");
        tabla.put(29, "then");
        tabla.put(30, "make");
        tabla.put(31, "run");
            tabla.put(31, ":");
    }

    public static boolean validarCadena(String cadena) {
        boolean verdad = false;
        char[] evaluate = new char[cadena.length()];
        for(int i=0; i<evaluate.length; i++){
            evaluate[i] = cadena.charAt(i);
        }
        if (tabla.containsValue(cadena)) {
            verdad = true;
        }else if(cadena.equals(";") || cadena.equals("{") || cadena.equals("}") || cadena.equals("(") || cadena.equals(")") ){
            verdad = true;
        }else if(evaluate[0] == 95 || (evaluate[0] >= 65 && evaluate[0] <= 90) || (evaluate[0] >= 97 && evaluate[0] <= 122)){
            verdad = true;
        }else if(evaluate[0] >= 48 && evaluate[0] <= 57){
            verdad = true;
        }else if(evaluate[0] == 34 && evaluate[cadena.length()-1]==34){
            verdad = true;
        }
        return verdad;
    }

    public String mensaje(boolean yesno) {
        String mensajin = "";
        if (yesno) {
            mensajin = "Cadena válida";
        } else {
            mensajin = "No es un símbolo válido";
        }
        return mensajin;
    }
    // (_)?([a-z]|[A-Z])+(_)?([0-9])*
    // [0-9]+ (/.)* [0-9]*
    //_ -> 95
    //A-Z -> 65 - 90
    //a -z -> 97 - 122
    //0-9 -> 48 - 57
    //. -> 46
}
