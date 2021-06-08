/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import static compilador.lectorArchivo.tabla;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author carli
 */
public class Semantico {

    public Map<String, ArrayList<Pair<String, String>>> variables;

    public Semantico() {
        variables = new HashMap<String, ArrayList<Pair<String, String>>>();
    }

    public void poner(String tipo, String ident, String valor) {
        Pair<String, String> igual = new Pair<String, String>(ident, valor);

        if (variables.containsKey(tipo)) {

            ArrayList<Pair<String, String>> identificadores = variables.get(tipo);
            if (identificadores.contains(igual)) {
                error(1);
            } else {
                variables.get(tipo).add(igual);
            }
        } else if (tipo.equals("Error")) {
            error(2);
        } else {
            ArrayList<Pair<String, String>> i = new ArrayList<>();
            i.add(igual);
            variables.put(tipo, i);
        }
        validarNum(tipo,valor);

    }

    public void verificarasignaión(String tipo, String valor) {

    }

    public void validarNum(String tipo, String cadena) {
        boolean verdad = false;
        if(cadena == null){}else{
        char[] evaluate = new char[cadena.length()];
        for (int i = 0; i < evaluate.length; i++) {
            evaluate[i] = cadena.charAt(i);
        }
        switch (tipo) {
            case "Enterito":

                if (evaluate[0] >= 48 && evaluate[0] <= 57) {

                    for (int i = 0; i < evaluate.length; i++) {
                        evaluate[i] = cadena.charAt(i);
                        if (evaluate[i] == '.') {
                            error(3);
                        }
                    }

                } else {
                    error(3);

                }
                break;
            case "Flotantito":
                if (evaluate[0] >= 48 && evaluate[0] <= 57) {

                } else {
                    error(3);

                }
                break;
            case "Doublesito":
                if (evaluate[0] >= 48 && evaluate[0] <= 57) {

                } else {
                    error(3);

                }
                break;
            case "Stringsito":
                if (evaluate[0] == 34 && evaluate[cadena.length() - 1] == 34) {

                } else {
                    error(3);

                }
                break;
            case "Charsito":
                if (evaluate.length == 3 && (evaluate[0] == 39 && evaluate[cadena.length() - 1] == 39)) {

                } else {
                    error(3);

                }
                break;
            default:

                break;
        }
        }
        
    }

    public void error(int i) {
        switch (i) {
            case 1:
                System.out.println("Error 1 : Variable declarada con anterioridad");
                break;
            case 2:
                System.out.println("Error 2 : Imposible declarar este tipo de variable");
                break;
            case 3:
                System.out.println("Error 3 : No coincide el tipo de dato");
                break;
            default:
                break;
        }
    }
}
