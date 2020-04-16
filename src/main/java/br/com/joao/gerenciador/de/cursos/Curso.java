/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joao.gerenciador.de.cursos;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author João
 */
public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new LinkedList<Aula>();
    private Set<Aluno> alunos = new HashSet<>();
    private Map<Integer, Aluno> matriculaParaAluno = new HashMap<Integer, Aluno>();

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public List<Aula> getAulas() {
        // Retornamos uma lista que não pode ser modificada para evitar que alguém adicione algo na nossa lista que não seja um método dessa classe
        return Collections.unmodifiableList(aulas);
    }
    
    public void adicionaAula(Aula aula) {
        this.aulas.add(aula);
    }

    public int getTempoTotal() {
        return this.aulas.stream().mapToInt(Aula::getTempoDeAula).sum();
    }
    
    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(alunos);
    }
    
    public void matricula(Aluno aluno){
        this.alunos.add(aluno);
        this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
    }
    
    public boolean estaMatriculado(Aluno aluno) {
        return this.alunos.contains(aluno);
    }     
    
    public Aluno buscaMatriculado(int matriculaAluno) {
        return this.matriculaParaAluno.get(matriculaAluno);
    }
    
}
