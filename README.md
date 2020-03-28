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
