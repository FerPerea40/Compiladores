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
            if (tokens.get(tokens.lastIndexOf(pos)).equals("}")) {
                System.out.println("Compilo Correctamente");
            } else {
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
            case 5:
                System.out.println("Error 5: Se esperaba ; al final");
                break;
            case 6:
                System.out.println("Error 6: Tipo de dato inválido");
                break;
            case 7:
                System.out.println("Error 7: Instrucción inválida");
                break;
            case 8:
                System.out.println("Error 8: Se esperaba un =");
                break;
            case 9:
                System.out.println("Error 9: Se esperaba un ( al inicio");
                break;
            case 10:
                System.out.println("Error 10: Se esperaba un ) al final");
                break;
            case 11:
                System.out.println("Error 11: Error en la instrucción while, se esperaba un make");
                break;
            case 12:
                System.out.println("Error 12: Error en la instrucción ifsito, se esperaba un then");
                break;
            case 13:
                System.out.println("Error 13: Identificador o número inválido");
                break;
            case 14:
                System.out.println("Error 14: Se esperaba un ; o una ,");
                break;
            case 15:
                System.out.println("Error 15: Operador inválido");
                break;
            case 16:
                System.out.println("Error 16: Comparador inválido");
                break;
            case 17:
                System.out.println("Error 17: Operador lógico inválido");
                break;
        }

    }

//<Aux21>::=  ; <Aux55>
//<Aux21>::= = <Aux2> ;
//FIRST(Aux21) = {“;” + “=”} 
    private void aux21() {

        pos++;
        switch (tokens.get(pos)) {

            case ";":
                aux55();
                break;
            case "=":
                aux2();
                pos++;
                if (tokens.get(pos).equals(";")) {

                } else {
                    error(5);
                }

                break;

        }

    }

//<Tipo>::= Enterito
//<Tipo>::= Flotantito
//<Tipo>::= Doublesito
//<Tipo>::= Stringsito
//<Tipo>::= Charsito
//<Tipo>::= Enterito
//
//FIRST(Tipo)={“Enterito”+”Flotantito”+”Doublesito”+”Stringsito”+”Charsito”+”Enterito”}
    private void tipo() {
        pos++;
        switch (tokens.get(pos)) {
            case "Enterito":

                break;
            case "Flotantito":

                break;
            case "Doublesito":

                break;
            case "Stringsito":

                break;
            case "Charsito":

                break;
            default:
                error(6);
                break;
        }
    }

//    <Aux5>::= Ident <Aux7>
//    FIRST(Aux5)= Ident
    private void aux5() {
        pos++;
        if (lectorArchivo.validarCadena(tokens.get(pos))) {
            aux7();
        } else {
            error(3);
        }
    }

//<Instrucciones>::= ifsito(<Condición>)then<Instrucciones>;<AuxSino>
//<Instrucciones>::= whilesito(<Condicion>)make<Instrucciones>;<Aux8>
//<Instrucciones>::= Run(Ident);
//<Instrucciones>::= Ident = <Aux2> <Operadores><Aux9>
//
//FIRST(Instrucciones) = {“ifsito” + “whilesito” + “Run” + “Ident”}
//FOLLOW(Instrucciones) = {FIRST(Aux3) + “returnsito” + “;” + FIRST(Pie)} = {“funcioncita” + “mainsito” + “voidsito” + “returnsito” + “;” + “funcioncita” + “mainsito” + “voidsito”}
    private void instrucciones() {
        pos++;
        switch (tokens.get(pos)) {
            case "ifsito":
                pos++;
                if (tokens.get(pos).equals("(")) {
                    Condicion();
                    pos++;
                    if (tokens.get(pos).equals(")")) {
                        pos++;
                        if (tokens.get(pos).equals("then")) {
                            instrucciones();
                            pos++;
                            if (tokens.get(pos).equals(";")) {
                                auxSino();
                            } else {
                                error(5);
                            }
                        } else {
                            error(12);
                        }
                    } else {
                        error(10);
                    }

                } else {
                    error(9);
                }
                break;
            case "whilesito":
                pos++;
                if (tokens.get(pos).equals("(")) {
                    Condicion();
                    pos++;
                    if (tokens.get(pos).equals(")")) {
                        pos++;
                        if (tokens.get(pos).equals("make")) {
                            instrucciones();
                            pos++;
                            if (tokens.get(pos).equals(";")) {
                                aux8();
                            } else {
                                error(5);
                            }
                        } else {
                            error(11);
                        }
                    } else {
                        error(10);
                    }

                } else {
                    error(9);
                }
                break;
            case "Run":
                pos++;
                if (tokens.get(pos).equals("(")) {
                    pos++;
                    if (lectorArchivo.validarCadena(tokens.get(pos))) {
                        pos++;
                        if (tokens.get(pos).equals(")")) {

                        } else {
                            error(10);
                        }
                    } else {
                        error(3);
                    }
                } else {
                    error(9);
                }
                break;
            default:
                if (lectorArchivo.validarCadena(tokens.get(pos))) {
                    pos++;
                    if (tokens.get(pos).equals("=")) {
                        aux2();
                        Operadores();
                        aux9();
                    } else {
                        error(8);
                    }
                } else {
                    error(7);
                }
                break;
        }
    }

    private void pie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aux55() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//<Aux2>::= Num
//<Aux2>::= Ident
//FIRST(Aux2) = {“Num”+”Ident”}
    private void aux2() {
        pos++;
        if (lectorArchivo.validarCadena(tokens.get(pos))) {

        } else {
            error(13);
        }
    }

//<Aux7> ::= ; <Aux4>
//<Aux7>::= , Ident <Aux5>
//FIRST(Aux7) = {“;” + “,”}
    private void aux7() {
        pos++;
        switch (tokens.get(pos)) {
            case ";":
                aux4();
                break;
            case ",":
                pos++;
                if (lectorArchivo.validarCadena(tokens.get(pos))) {
                    aux5();
                } else {
                    error(3);
                }
                break;
            default:
                error(14);
                break;
        }
    }

//<Operadores>::= +
//<Operadores>::= -
//<Operadores>::= *
//<Operadores>::= /
//FIRST(Operadores) = {“+” + “-” + “*” + “/”}
    private void Operadores() {
        pos++;
        switch (tokens.get(pos)) {
            case "+":

                break;
            case "-":

                break;
            case "*":

                break;
            case "/":

                break;
            default:
                error(15);
                break;
        }
    }

    private void aux9() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//<Condición>::= <Aux2> <Comparadores> <Aux2> <Aux10>
//FIRST(Condición) = FIRST(Aux2) = {“Num” + “Ident} 

    private void Condicion() {
        aux2();
        comparadores();
        aux2();
        aux10();
    }

    private void aux8() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void auxSino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aux4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//<Comparadores>::= ==
//<Comparadores>::= !!
//<Comparadores>::= <
//<Comparadores>::= <=
//<Comparadores>::= >=
//<Comparadores>::= >
//FIRST(Comparadores) = {“==” + “!!” + “<” + “<=” + “>=” + “>”}

    public void comparadores() {
        pos++;
        switch (tokens.get(pos)) {
            case "==":

                break;
            case "!!":

                break;
            case "<":

                break;
            case "<=":

                break;
            case ">=":

                break;
            case ">":

                break;
            default:
                error(16);
                break;
        }
    }

//<Aux10>::= <Aux11> <Aux2> <Comparadores> <Aux2> 
//<Aux10>::= ε
//FIRST(Aux10) = {FIRST(Aux11) + “ε”} = {“&&” + “oo” + “ε”} 

    private void aux10() {
        aux11();
        aux2();
        comparadores();
        aux2();
    }
    
//<Aux11>::= && 
//<Aux11>::= oo
//FIRST(Aux11) = {“&&” + “oo”}

    private void aux11() {
        pos++;
        switch(tokens.get(pos)){
            case "&&":
                
                break;
            case "oo":
                
                break;
            default:
                error(17);
                break;
        }
    }
}
