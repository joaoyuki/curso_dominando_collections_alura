/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joao.gerenciador.de.cursos;

/**
 *
 * @author João
 */
public class Aula implements Comparable<Aula>{
    
    private String titulo;
    private int tempoDeAula;

    public Aula(String titulo, int tempoDeAula) {
        this.titulo = titulo;
        this.tempoDeAula = tempoDeAula;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTempoDeAula() {
        return tempoDeAula;
    }

    @Override
    public String toString() {
        return "Aula{" + "titulo=" + titulo + ", tempoDeAula=" + tempoDeAula + '}';
    }

    @Override
    public int compareTo(Aula outraAula) {
        return this.titulo.compareTo(outraAula.titulo);
    }
    
}
