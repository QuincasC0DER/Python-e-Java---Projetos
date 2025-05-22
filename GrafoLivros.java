import java.util.*;

public class GrafoLivros {
    private Map<Livro, Set<Livro>> grafo; // Criando o Grafo para armazenar os Livros

    public GrafoLivros() {
        grafo = new HashMap<>(); // a partir do grafo instanciamos um novo HashMap
    }

    public void adicionarLivro(Livro livro) {
        grafo.putIfAbsent(livro, new HashSet<>()); // verifica se o livro existe se não adiciona o livro no grafo com um hashset vazio onde vai ficar suas recomendaçoes do livro, se ja existir ele não será executado.
    }

    public void adicionarRecomendacao(Livro origem, Livro destino) { // permite adicionar recomendaçoes de um livro base somente se ele existir
        if (!grafo.containsKey(origem) || !grafo.containsKey(destino)) { // verifica se origem e destino existem no grafo se não exibe um aviso
            throw new IllegalArgumentException("Livro não Catalogado!");
        }
        grafo.get(origem).add(destino); // aqui adiciona o livro de recomendação ao hashset ao livro de origem como parte das recomendaçoes.
    }

    public Set<Livro> getRecomendacoes(Livro livro) {
        return grafo.getOrDefault(livro, Collections.emptySet()); // Busca as recomendações de um livro específico no grafo. se o livro existir retorna o conjunto de recomendaçoes do livro base .
       
    }

    public Set<Livro> getTodosLivros() { // exibe todos os livros cadastrados no catologo dentro do grafo 
        return grafo.keySet(); 
        
    }
}