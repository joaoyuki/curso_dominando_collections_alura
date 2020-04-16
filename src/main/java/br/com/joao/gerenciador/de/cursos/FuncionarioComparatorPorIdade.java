/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joao.gerenciador.de.cursos;

import java.util.Comparator;

/**
 *
 * @author João
 */
public class FuncionarioComparatorPorIdade implements Comparator<Funcionario>{

    @Override
    public int compare(Funcionario o1, Funcionario o2) {
        return o1.getIdade() - o2.getIdade();
    }
    
}
