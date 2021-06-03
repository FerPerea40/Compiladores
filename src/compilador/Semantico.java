/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author carli
 */
public class Semantico {
    public Map<String, String> variables;
    
    public Semantico(){
        variables = new HashMap<String,String>();
    }
    
    public void poner(String tipo, String ident){
        
        if(variables.containsValue(ident)){
            error(1);
        }else if(tipo.equals("Error")){
            error(2);
        }else{
            variables.put(tipo, ident);
        }
        
    }
    
    public void error(int i){
        switch(i){
            case 1:
                System.out.println("Error 1 : Variable declarada con anterioridad");
                break;
            case 2:
                System.out.println("Error 2 : Imposible declarar este tipo de variable");
                break;
            default:
                break;
        }
    }
}
