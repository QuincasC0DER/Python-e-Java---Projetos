import java.util.*;


public class ListaEsperaLivro {
    private Map<Livro, Queue<String>> listaEsperaPorLivro;

    public ListaEsperaLivro() {
        listaEsperaPorLivro = new HashMap<>();
    }

    // Adiciona um usuário à lista de espera de um livro
    public void adicionarNaListaEspera(Livro livro, String usuario) {
        listaEsperaPorLivro.putIfAbsent(livro, new LinkedList<>());
        listaEsperaPorLivro.get(livro).add(usuario);
    }

    // Remove e retorna o próximo usuário da lista de espera
    public String proximoDaLista(Livro livro) {
        if (!listaEsperaPorLivro.containsKey(livro) || listaEsperaPorLivro.get(livro).isEmpty()) {
            return null;
        }
        return listaEsperaPorLivro.get(livro).poll();
    }

    // Verifica se há lista de espera para um livro
    public boolean temListaEspera(Livro livro) {
        return listaEsperaPorLivro.containsKey(livro) && !listaEsperaPorLivro.get(livro).isEmpty();
    }

    // Mostra a lista de espera de um livro
    public void mostrarListaEspera(Livro livro) {
        if (!listaEsperaPorLivro.containsKey(livro) || listaEsperaPorLivro.get(livro).isEmpty()) {
            System.out.println("Não há lista de espera para este livro.");
            return;
        }
        
        System.out.println("Lista de espera para " + livro.getTitulo() + ":");
        int posicao = 1;
        for (String usuario : listaEsperaPorLivro.get(livro)) {
            System.out.println(posicao++ + ". " + usuario);
        }
    }
}