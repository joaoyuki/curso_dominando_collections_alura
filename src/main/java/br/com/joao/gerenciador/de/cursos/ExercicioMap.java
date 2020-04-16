/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joao.gerenciador.de.cursos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author João
 */
public class ExercicioMap {
    
    public static void main(String[] args) {
        
        Map<Integer, String> pessoas = new HashMap<>();

        pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");
        
        pessoas.keySet().forEach(p -> System.out.println(pessoas.get(p)));
        
    }
    
}
