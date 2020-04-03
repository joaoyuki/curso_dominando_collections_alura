# curso_dominando_collections_alura

## Aula 02 - Lista de objetos

- Para que possamos ordenar uma lista de objetos, precisamos primeiro ensinar a uma classe como ela pode se ordenar. Para isso implementamos a interface **Comparable<>** e sobreescrevemos o método **compareTo()**

```java
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
```

- Podemos criar uma nova classe que possua um outro método que diz para a nossa classe aula como podemos ordenala. Para isso essa nova classe precisa implementar a interface **Comparator<>**
```java
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

```
- Testando as implementações:
 
```java
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

```

## Aula 03 - Relacionamentos com coleções

- ArrayList e LinkedList
- - São filhas de List
- - Mantem a ordem dos elementos que foram adicionados
- - Pode adicionar elementos repetidos

- ArrayList
- - Vantagem
- - - Possui o acesso mais rápido **(Random Access Memory)**
- - Desvantagem
- - - Caso eu queira adicionar um elemento no começo da lista o java vai precisar mudar todos os elementos do posição e isso vai gerar muito processamento a toa

- LinkedList
- - Vantagem
- - - É mais rapída para adicionar ou remover elementos no começo da lista
- - Desvantagem
- - - É mais lenta para pegar um elemento em uma posição específica, pois a LinkedList passa elemento por elemento até chegar na posição desejada. Caso tenha 1000 elementos e pedirmos para pegar o elemento 999, o java vai andar pelas 999 posições

- Comparando as duas listas

```java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joao.gerenciador.de.cursos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author João
 */
public class TesteListas {

 public static void main(String[] args) {

        System.out.println("**** ArrayList vs LinkedList ***");

        List<Integer> numerosArrayList = new ArrayList<>();
        List<Integer> numerosLinkedList = new LinkedList<>();
        int quantidadeElementos = 1000000;

        long tempoArrayList  = insereElementosNo(numerosArrayList, quantidadeElementos);
        long tempoLinkedList = insereElementosNo(numerosLinkedList, quantidadeElementos);

        System.out.println("Inserção na ArrayList demorou  " + tempoArrayList);
        System.out.println("Inserção na LinkedList demorou " + tempoLinkedList);

        tempoArrayList = removePrimeirosElementos(numerosArrayList);
        tempoLinkedList = removePrimeirosElementos(numerosLinkedList);

        System.out.println("Remoção da ArrayList demorou  " + tempoArrayList);
        System.out.println("Remoção da LinkedList demorou " + tempoLinkedList);
    }

    /*
     * removendo 100 elementos sempre na primeira posição
     */
    private static long removePrimeirosElementos(List<Integer> numeros) {
        long ini = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            numeros.remove(0); //removendo sempre o primeiro elemento
        }
        long fim = System.currentTimeMillis();
        return fim-ini;
    }

    private static long insereElementosNo(List<Integer> numeros, int quantidade) {
        long ini = System.currentTimeMillis();
        for (int i = 0; i < quantidade; i++) {
            numeros.add(i);
        }
        long fim = System.currentTimeMillis();
        return fim-ini;
    }
    
}

```

## Aula 05 - O poder dos Set's

- Set é parecido com conjuntos matemáticos
- Quando acionamos registros em um set, não temos a garantia que a ordem de adição dos objetos será mantida
- - Uma lista seria um sequencia de objetos e um set seria  um conjunto de objetos
- Não conseguimos pegar um registro de um set, não exite o comando **.get(index)**
- Todos os conjuntos (set) do Java, não aceitam elementos repetidos
- Buscar elementos em conjuntos (set) é muito mais rapido do que em List porque eles trabalham com **tabelas de espelhamento** e não comparam elemento por elemento

- Exemplo comparando inserção e pesquisa em ArrayList e HashSet.
- - Inserção é mais rápida em ArrayList mas a busca é mais demorada
- - Pesquisa é mais rápida em HashSet mas a inserção é mais lenta
```java
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

```