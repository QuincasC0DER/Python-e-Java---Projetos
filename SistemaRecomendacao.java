import java.util.*;

public class SistemaRecomendacao {
    private GrafoLivros grafo;

    public SistemaRecomendacao(GrafoLivros grafo) { // instancia o Grafo e faz a referencia ao grafo para fazer a chamada
        this.grafo = grafo;
    }

    public void inicializarLivros() {
        // Adiciona 10 livros ao grafo
        Livro livro1 = new Livro("Contos Inacabados", "J.R.R Tolkien", "1968"); // Instancia objeto livro na Classe Livro sucessivamente livro1,livro2,livro3.... passa os parametros Titulo,Autor,Ano
        Livro livro2 = new Livro("1984", "George Orwell", "1948");
        Livro livro3 = new Livro("2001 - Uma Odisseia no Espaço", "Arthur C. Clarke", "1969");
        Livro livro4 = new Livro("Duna", "Frank Herbert", "1965");
        Livro livro5 = new Livro("O Hobbit", "J.R.R Tolkien", "1937");
        Livro livro6 = new Livro("Fahrenheit 451", "Ray Bradbury", "1953");
        Livro livro7 = new Livro("Fundação", "Isaac Asimov", "1951");
        Livro livro8 = new Livro("Neuromancer", "William Gibson", "1984");
        Livro livro9 = new Livro("Admirável Mundo Novo", "Aldous Huxley", "1932");
        Livro livro10 = new Livro("O Nome do Vento", "Patrick Rothfuss", "2007");

        // Adiciona livros ao grafo na mesma sequencia da instanciação acima começa pelo livro1 primeiro livro isntanciado até o livro10 ultimo livro isntanciado agora os 10 livros es~tao adicionados ao grafo
        grafo.adicionarLivro(livro1);
        grafo.adicionarLivro(livro2);
        grafo.adicionarLivro(livro3);
        grafo.adicionarLivro(livro4);
        grafo.adicionarLivro(livro5);
        grafo.adicionarLivro(livro6);
        grafo.adicionarLivro(livro7);
        grafo.adicionarLivro(livro8);
        grafo.adicionarLivro(livro9);
        grafo.adicionarLivro(livro10);

        // Cria recomendações de 2 Livros do mesmo Genero Fantasia, Distopia, Ficção Cientifica como Senhor dos Aneis recomenda Hobbit e O nome do Vento pertecem ao mesmo genero Fantasia tendo 2 recomendações.
        grafo.adicionarRecomendacao(livro1, livro5);  // Senhor dos Anéis -> O Hobbit
        grafo.adicionarRecomendacao(livro1, livro10); // Senhor dos Anéis -> O Nome do Vento
        grafo.adicionarRecomendacao(livro2, livro6);  // 1984 -> Fahrenheit 451
        grafo.adicionarRecomendacao(livro2, livro9);  // 1984 -> Admirável Mundo Novo
        grafo.adicionarRecomendacao(livro3, livro4);  // 2001 -> Duna
        grafo.adicionarRecomendacao(livro3, livro7);  // 2001 -> Fundação
        grafo.adicionarRecomendacao(livro4, livro3);  // Duna -> 2001
        grafo.adicionarRecomendacao(livro4, livro8);  // Duna -> Neuromancer
        grafo.adicionarRecomendacao(livro5, livro1);  // e assim por diante.
        grafo.adicionarRecomendacao(livro10, livro1);
        grafo.adicionarRecomendacao(livro6, livro2);
        grafo.adicionarRecomendacao(livro9, livro2);
        grafo.adicionarRecomendacao(livro3, livro4);
        grafo.adicionarRecomendacao(livro7, livro3);
        grafo.adicionarRecomendacao(livro4, livro3);
        grafo.adicionarRecomendacao(livro8, livro4);
    }

    public void recomendarLivros(Livro livroBase) { // metodo para as recomendaçoes de livros.
        Set<Livro> recomendacoes = grafo.getRecomendacoes(livroBase); // configura a recomendação com base no Livro com o Set<Livro> recomendaçoes e coleta a recomendação com base no livro base assim ele identifica com as corelações do livro base e exibes essa corelaões que são a recomendaçao dos proximos livros.
        if (recomendacoes.isEmpty()) { // verifica se Existe recomendação do livro no meu caso não ira percorre pois todos os livros possuem 2 recomendaçoes , mas caso não existise ele exibiria a mensagem abaixo no caso aqui evitaria um bug casso não houvesse nenhuma recomendação
            System.out.println("Nenhuma recomendação encontrada para " + livroBase.getTitulo()); // Mensagem da ausencia de recomendação.
        } else {
            System.out.println(" Recomendações para '" + livroBase.getTitulo() + "':"); // Recomendação para um determinado Livro Base.
            recomendacoes.forEach(System.out::println); // percorre as recomendaçoes do livro base e imprime na tela as mesmas.
        }
    }
}