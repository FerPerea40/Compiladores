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
                System.out.println("Error 5: Se esperaba ;");
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
            case 18:
                System.out.println("Error 18: Se esperaban :");
                break;
            case 19:
                System.out.println("Error 19: Se esperaban returnsito al final");
                break;
            case 20:
                System.out.println("Error 20: Función mal declarada");
                break;
            case 21:
                System.out.println("Error 21: Error en tu condición");
                break;
            case 22:
                System.out.println("Error 22: Error en el pie");
                break;
            case 23:
                System.out.println("Error 22: Operación invalida");
                break;
            case 24:
                System.out.println("Error 14: Se esperaba un : o una ,");
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

//<Pie>::= <Aux1>Ident : <Instrucciones> returnsito <Aux2><Aux3>
//<Pie>::= voidsito Ident : <Instrucciones><Aux3>
//FIRST(Pie) = {FIRST(Aux1) + “voidsito”} = {“funcioncita” + “mainsito” + “voidsito”}
    private void pie() {
        pos++;
        if (tokens.get(pos).equals("voidsito")) {
            pos++;
            if (lectorArchivo.validarCadena(tokens.get(pos))) {
                pos++;
                if (tokens.get(pos).equals(":")) {
                    instrucciones();
                    aux3();
                } else {
                    error(18);
                }
            } else {
                error(3);
            }
        } else if (tokens.get(pos).equals("funcioncita") || tokens.get(pos).equals("mainsito")) {
            pos--;
            aux1();
            pos++;
            if (lectorArchivo.validarCadena(tokens.get(pos))) {
                pos++;
                if (tokens.get(pos).equals(":")) {
                    instrucciones();
                    pos++;
                    if (tokens.get(pos).equals("returnsito")) {
                        aux2();
                        aux3();
                    } else {
                        error(19);
                    }
                } else {
                    error(18);
                }
            } else {
                error(3);
            }
        } else {
            error(22);
        }
    }

//<Aux55>::= ε 
//<Aux55>::= <Encabezado>
//FIRST(Aux55)= { “ε” + FIRST(Encabezado}= {“ε” + “CF” + “Constant”}
//FOLLOWS(Aux55)= {FOLLOWS(Aux21)+FOLLOWS(Aux4)} =  {“ifsito” + “whilesito” + “Run” + “Ident”} 
    private void aux55() {
        pos++;//TALVEZ!!!
        if (!tokens.get(pos).equals("ifsito")
                && !tokens.get(pos).equals("whilesito")
                && !tokens.get(pos).equals("Run")
                && !tokens.get(pos).equals("Ident")) {
            pos--;
            encabezado();
        } else {
            pos--;
        }

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

//<Aux9>::= <Aux2> <Operadores> 
//<Aux9>::= ;
//FIRST(Aux9) = {FIRST(Aux2) + “;”} = {“Num” + “Ident” + “;”}
    private void aux9() {
        pos++;
        if (lectorArchivo.validarCadena(tokens.get(pos))) {
            pos--;
            aux2();
            Operadores();
        } else if (tokens.get(pos).equals(";")) {

        } else {
            error(23);
        }
    }

//<Condición>::= <Aux2> <Comparadores> <Aux2> <Aux10>
//FIRST(Condición) = FIRST(Aux2) = {“Num” + “Ident} 
    private void Condicion() {
        aux2();
        comparadores();
        aux2();
        aux10();
    }

//<Aux8>::= <Instrucciones>;
//<Aux8>::= ε
//FIRST(Aux8) = {FIRST(Instrucciones) + “ε”} = {“ifsito” + “whilesito” + “Run” + “Ident” + “ε”}
//FOLLOW(Aux8) = {FOLLOW(Instrucciones)} = {“funcioncita” + “mainsito” + “voidsito” + “returnsito” + “;”}
    private void aux8() {
        pos++;
        if (!tokens.get(pos).equals("funcioncita")
                && !tokens.get(pos).equals("mainsito")
                && !tokens.get(pos).equals("voidsito")
                && !tokens.get(pos).equals("returnsito")
                && !tokens.get(pos).equals(";")) {
            pos--;
        instrucciones();
        }else{
         pos--;       
                
               }
    }

//<AuxSino>::= else then <Instrucciones>;
//<AuxSino>::= elsif (<Condición>)then<Instrucciones>;
//<AuxSino>::= ε
//FIRST(AuxSino) = {“else” + “elsif” + “ε”}
//FOLLOW(AuxSino) = {FOLLOW(Instrucciones)} = {“funcioncita” + “mainsito” + “voidsito” + “returnsito” + “;”}
    private void auxSino() {
        pos++;
        if (!tokens.get(pos).equals("funcioncita")
                && !tokens.get(pos).equals("mainsito")
                && !tokens.get(pos).equals("voidsito")
                && !tokens.get(pos).equals("returnsito")
                && !tokens.get(pos).equals(";")) {
            switch (tokens.get(pos)) {
                case "else":
                    break;
                case "elsif":
                    break;
                default:
                    error(21);
                    break;
            }
        } else {
            pos--;
        }
    }

//<Aux4>::= : <Tipo> := <Aux2> ; <Aux55>
//<Aux4>::=  , Ident <Aux5>
//FIRST(Aux4) = {“:” + “,”} 
    private void aux4() {
        pos++;
        switch (tokens.get(pos)) {
            case ":":
                tipo();
                pos++;
                if (tokens.get(pos).equals(":")) {
                    pos++;
                    if (tokens.get(pos).equals("=")) {
                        aux2();
                        pos++;
                        if (tokens.get(pos).equals(";")) {
                            aux55();
                        } else {
                            error(5);
                        }
                    } else {
                        error(8);
                    }
                } else {
                    error(18);
                }
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
                error(24);
                break;
        }
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
//FOLLOW(Aux10) = {FOLLOW(Condicion)} = {“)”}
//FOLLOW(Condicion)={“)”}
    private void aux10() {
        pos++; //TALVEZ!!!!!
        if (!tokens.get(pos).equals(")")) {
            pos--;
            aux11();
            aux2();
            comparadores();
            aux2();
        } else {
            pos--;
        }
    }

//<Aux11>::= && 
//<Aux11>::= oo
//FIRST(Aux11) = {“&&” + “oo”}
    private void aux11() {
        pos++;
        switch (tokens.get(pos)) {
            case "&&":

                break;
            case "oo":

                break;
            default:
                error(17);
                break;
        }
    }

//<Aux3>::= <Pie>
//<Aux3>::= ε
//FIRST(Aux3) = {FIRST(Pie) +  “ε”} = {“funcioncita” + “mainsito” + “voidsito” +  “ε”}
//FOLLOWS(Aux3) ={FOLLOWS(Pie) }={“}”}
    private void aux3() {
        pos++;
        if (!tokens.get(pos).equals("}")) {
            pos--;
            pie();
        } else {
            pos--;

        }
    }

//<Aux1>::= funcioncita
//<Aux1>::= mainsito
//FIRST(Aux1) = {“funcioncita” + “mainsito”}
    private void aux1() {
        pos++;
        switch (tokens.get(pos)) {
            case "funcioncita":
                break;
            case "mainsito":
                break;

            default:
                error(20);
                break;
        }
    }
}
