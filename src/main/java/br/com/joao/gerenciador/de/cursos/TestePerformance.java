/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joao.gerenciador.de.cursos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author João
 */
public class TestePerformance {
    
 public static void main(String[] args) {

        Collection<Integer> numeros = new ArrayList<Integer>();

        long inicioInserindo = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }
        
        long finalInserindo = System.currentTimeMillis();

        
        long inicioPesquisando = System.currentTimeMillis();
        for (Integer numero : numeros) {
            numeros.contains(numero);
        }
        long finalPesquisando = System.currentTimeMillis();
        

        long tempoDeExecucao = finalInserindo - inicioInserindo;

        System.out.println("Tempo gasto para inserir em ArrayList: " + tempoDeExecucao);
        
        
        long tempoDePesquisando = finalPesquisando - inicioPesquisando;
        System.out.println("Tempo gasto para pesquisar em ArrayList: " + tempoDePesquisando);
        
        
        Collection<Integer> numerosSet = new HashSet<Integer>();

        long inicioInserindoSet = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numerosSet.add(i);
        }
        
        long finalInserindoSet = System.currentTimeMillis();

        
        long inicioPesquisandoSet = System.currentTimeMillis();
        for (Integer numero : numerosSet) {
            numerosSet.contains(numero);
        }
        long finalPesquisandoSet = System.currentTimeMillis();
        

        long tempoDeExecucaoSet = finalInserindoSet - inicioInserindoSet;

        System.out.println("Tempo gasto para inserir em HashSet: " + tempoDeExecucaoSet);
        
        
        long tempoDePesquisandoSet = finalPesquisandoSet - inicioPesquisandoSet;
        System.out.println("Tempo gasto para pesquisar em HashSet: " + tempoDePesquisandoSet);        
        
    }    
    
}
