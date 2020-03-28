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
public class ComparandoPorTempoDeAula implements Comparator<Aula>{

    @Override
    public int compare(Aula o1, Aula o2) {
        if (o1.getTempoDeAula() < o2.getTempoDeAula()) {
            return -1;
        }
        
        if (o1.getTempoDeAula() > o2.getTempoDeAula()) {
            return 1;
        } else {
            return 0;
        }        
        
    }

    
}
