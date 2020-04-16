/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joao.gerenciador.de.cursos;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author João
 */
public class TestandoTreeSet {

    public static void main(String[] args) {
        
        Funcionario f1 = new Funcionario("João", 32);
        Funcionario f2 = new Funcionario("Felipe", 31);
        Funcionario f3 = new Funcionario("Rodrigues", 40);
        
        Set<Funcionario> funcionarios = new TreeSet<Funcionario>(new FuncionarioComparatorPorIdade());
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);
        
        funcionarios.forEach(a -> System.out.println(a.getNome()));
        
    }
    
}
