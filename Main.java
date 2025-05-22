import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GrafoLivros grafo = new GrafoLivros();
    private static SistemaRecomendacao sistema = new SistemaRecomendacao(grafo);
    private static ListaEsperaLivro listaEspera = new ListaEsperaLivro();
    private static HistoricoNavegacao historico = new HistoricoNavegacao();

    public static void main(String[] args) {
        sistema.inicializarLivros();
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n ________ Menu Principal ______:");
            System.out.println("1 - _______ Visualizar Todos os Livros ________");
            System.out.println("2 - _______ Buscar Recomendações _______");
            System.out.println("3 - _______ Gerenciar Lista de Espera _______");
            System.out.println("4 - _______ Ver Histórico de Navegação _______");
            System.out.println("5 - _______ Sair _______ ");
            System.out.print("Digite uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    visualizarLivros();
                    break;
                case 2:
                    buscarRecomendacoes();
                    break;
                case 3:
                    menuListaEspera();
                    break;
                case 4:
                    historico.mostrarHistorico();
                    break;
                case 5:
                    System.out.println("Saindo... Até mais e Boas Leituras !!!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void visualizarLivros() {
        System.out.println("\n Acervo Completo de Livros:");
        grafo.getTodosLivros().forEach(livro -> {
            System.out.println(livro);
            historico.adicionarAoHistorico(livro); // Adiciona ao histórico quando visualizado
        });
    }

    private static void buscarRecomendacoes() {
        System.out.print("Digite o título do livro de referência: ");
        String titulo = scanner.nextLine();
        
        Optional<Livro> livro = grafo.getTodosLivros().stream()
            .filter(l -> l.getTitulo().equalsIgnoreCase(titulo)) // Permite fazer as Buscas sem Diferenciar letras maisculas e minusculas
            .findFirst();

        if (livro.isPresent()) {
            historico.adicionarAoHistorico(livro.get()); // Adiciona ao histórico quando buscado
            sistema.recomendarLivros(livro.get());
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    private static void menuListaEspera() {
        System.out.println("\nMenu Lista de Espera:");
        System.out.println("1 - Adicionar à lista de espera");
        System.out.println("2 - Ver próximo da lista");
        System.out.println("3 - Ver lista completa");
        System.out.print("Digite uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o título do livro: ");
                String titulo = scanner.nextLine();
                System.out.print("Digite seu nome: ");
                String usuario = scanner.nextLine();
                
                Optional<Livro> livro = grafo.getTodosLivros().stream()
                    .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                    .findFirst();
                
                if (livro.isPresent()) {
                    listaEspera.adicionarNaListaEspera(livro.get(), usuario);
                    System.out.println("Você foi adicionado à lista de espera para " + livro.get().getTitulo());
                } else {
                    System.out.println("Livro não encontrado!");
                }
                break;
            case 2:
                System.out.print("Digite o título do livro: ");
                titulo = scanner.nextLine();
                
                livro = grafo.getTodosLivros().stream()
                    .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                    .findFirst();
                
                if (livro.isPresent()) {
                    String proximo = listaEspera.proximoDaLista(livro.get());
                    if (proximo != null) {
                        System.out.println("Próximo da lista: " + proximo);
                    } else {
                        System.out.println("Não há lista de espera para este livro.");
                    }
                } else {
                    System.out.println("Livro não encontrado!");
                }
                break;
            case 3:
                System.out.print("Digite o título do livro: ");
                titulo = scanner.nextLine();
                
                livro = grafo.getTodosLivros().stream()
                    .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                    .findFirst();
                
                if (livro.isPresent()) {
                    listaEspera.mostrarListaEspera(livro.get());
                } else {
                    System.out.println("Livro não encontrado!");
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}