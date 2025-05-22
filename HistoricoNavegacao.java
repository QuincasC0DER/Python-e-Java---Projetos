import java.util.Stack;

public class HistoricoNavegacao {
    private Stack<Livro> historico;

    public HistoricoNavegacao() {
        historico = new Stack<>();
    }

    // Adiciona um livro ao histórico
    public void adicionarAoHistorico(Livro livro) {
        historico.push(livro);
    }

    // Remove e retorna o livro mais recente do histórico
    public Livro livroMaisRecente() {
        if (historico.isEmpty()) {
            return null;
        }
        return historico.pop();
    }

    // Mostra o histórico completo sem remover itens
    public void mostrarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Histórico de navegação vazio.");
            return;
        }
        
        System.out.println("Histórico de navegação:"); 
            for (Livro livro : historico) {
                System.out.println(livro);
            }     
        }
    }
