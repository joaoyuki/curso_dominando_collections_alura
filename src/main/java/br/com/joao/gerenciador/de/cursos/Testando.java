/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joao.gerenciador.de.cursos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author João
 */
public class Testando {
    
    public static void main(String[] args) {
        
        Aula a1 = new Aula("Java 01", 10);
        Aula a2 = new Aula("Java 02", 14);
        Aula a3 = new Aula("JavaScript 01", 21);
        Aula a4 = new Aula("Delphi 01", 30);
        
        ArrayList<Aula> aulas = new ArrayList<Aula>();
        aulas.add(a1);
        aulas.add(a2);
        aulas.add(a3);
        aulas.add(a4);
        
        // Antes de ordenar com o compareTo da classe aula
        System.out.println("Sem ordenação: " + aulas);
        
        // Após ordenar usando o método compareTo da classe aula
        Collections.sort(aulas);
        // As aulas foram ordenadas lexicalmente
        System.out.println("Ordenando pelo compareTo da classe aula: " + aulas);
        
        // Ordenando aulas por tempo de aula
        Collections.sort(aulas, new ComparandoPorTempoDeAula());
        
        System.out.println("Ordenando por tempo de aula: " + aulas);
        
        // Usando o Java 8 para fazer a comparação por tempo de aula sem precisar criar uma classe nova para isso
        aulas.sort(Comparator.comparing(Aula::getTempoDeAula));
        
        System.out.println("Ordenando por tempo de aula com java 8: " + aulas);
        
        
        
        
    }
    
}
