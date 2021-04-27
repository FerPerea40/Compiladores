/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class lexico {

    ArrayList<String> tokens;
    int pos = 0;

    public lexico(ArrayList<String> palabritas) {
        this.tokens = palabritas;
    }
    
    
//<Programa>::= {<Encabezado><Instrucciones><Pie>}
//FIRST(Programa) = {“{”}
    public void programa() {
        if (tokens.get(pos).equals("{")) {
            encabezado();
            instrucciones();
            pie();
            if(tokens.get(tokens.lastIndexOf(pos)).equals("}")){
               System.out.println("Compilo Correctamente");
            }else{
              error(4);
            }
        } else {
            error(1);
        }
      }
    
//<Encabezado>::= CF<Tipo>Ident<Aux21>
//<Encabezado>::= Constant <Aux5>
//FIRST(Encabezado) = {“CF”+ “Constant”}
    public void encabezado() {
        pos++;
        switch (tokens.get(pos)) {

            case "CF":
                tipo();
                pos++;
                if (lectorArchivo.validarCadena(tokens.get(pos))) {
                    aux21();
                } else {
                    error(3);
                }
                break;
            case "Constant":
                aux5();
                break;
            default:
                error(2);
                break;

        }
    }

    public void error(int i) {

        switch (i) {

            case 1:
                System.out.println("Error 1 : Se espera una { al inicio");
                break;
            case 2:
                System.out.println("Error 2: Se espera CF o Constant ");

                break;
            case 3:
                System.out.println("Error 3:Identificador inválido");

                break;
             case 4:
                System.out.println("Error 4: Se esperaba } al final");

                break;
        }

    }

    private void aux21() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void tipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aux5() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void instrucciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
