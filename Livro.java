import java.util.Objects;

public class Livro {    // inicializando os atributos 
    private String titulo;
    private String autor;
    private String ano;

    public Livro(String titulo, String autor, String ano) { // criando a referencia para cada atributo
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    // Getters
    public String getTitulo() { return titulo; }   // metodo getter para ter o retorno do atributo pelo getAtributo > return Atributo.
    public String getAutor() { return autor; }
    public String getAno() { return ano; }

    // Para usar Livro como chave no HashMap
    @Override
    public boolean equals(Object resultadoPesquisa) { // pesquisa do livro por titulo e autor comparando se pertencendo ao mesmo para usar na base de livros a serem recomendados.
        if (this == resultadoPesquisa) return true;
        if (resultadoPesquisa == null || getClass() != resultadoPesquisa.getClass()) return false;
        Livro livro = (Livro) resultadoPesquisa;
        return titulo.equals(livro.titulo) && autor.equals(livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor); // cria um numero para identificação das informaçoes do livro
    }

    @Override
    public String toString() {
        return titulo + " (" + autor + ", " + ano + ")";  // passa as informaçoes associadas ao numero de maneira formatada , Titulo( Autor + Ano) assim cada livro tem uma identificação unica e fica mais facil localizalos.
    }
}