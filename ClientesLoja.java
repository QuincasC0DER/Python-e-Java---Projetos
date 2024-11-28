import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClientesLoja {
    private static final List<Map<String, String>> listaClientes = new ArrayList<>();  
    private static final List<Map<String, String>> listaDebito = new ArrayList<>();   
    private static final List<Map<String, String>> listaHistorico = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        menuPrincipal(); // classe principal onde chama o metodo menuPrincipal Para inicializar o programa
    }

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("Menu Principal:");
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Historico de Compras");
            System.out.println("4 - Debitos Pendentes");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consome uma linha após o input da opção

            switch (opcao) {   // Switch com os cases > metodos relacionados a os clientes 
                case 1 -> adicionarCliente();
                case 2 -> listarClientes();
                case 3 -> historicoCompras();
                case 4 -> debitoPendente();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
            // Switch com os cases > metodos relacionados a os clientes
                    } while (opcao != 5); // mantem o menu ativo até que a opção chega a  5.
    }

    private static void adicionarCliente() {
        System.out.println("Digite o nome do cliente para ser adicionado:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();

        // Cria um mapa para armazenar os dados de nome e cpf do cliente
        Map<String, String> cliente = new HashMap<>();
        cliente.put("nome", nome);
         cliente.put("cpf", cpf);

        // Cria um mapa com os valores de debitos não pagos porcliente relacionados ao nome e cpf para fazer a relação
        Map<String, String> debito = new HashMap<>();
        debito.put("nome", nome);
        debito.put("cpf", cpf);
        debito.put("debito", "não pago");  // Initially assume no debt

        Map<String, String> historico = new HashMap<>();
        historico.put("nome", nome);
        historico.put("cpf", cpf);
        historico.put("historico", "não listado");
        
        
        // Adiciona os mapas as listas Cliente e debito
        listaClientes.add(cliente);
        listaDebito.add(debito);
        listaHistorico.add(historico);

         System.out.println("Cliente adicionado com sucesso!");
    }

    private static void listarClientes() {   // metodo para a listagem de cliente com condicionais para verificar se a lista de clientes está vazia antes de fazer a listagem
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Lista de Clientes:"); 
            for (Map<String, String> cliente : listaClientes) {
                System.out.println("Nome: " + cliente.get("nome") + ", CPF: " + cliente.get("cpf"));
            }
        }
    }

    private static void debitoPendente() {  // Metodo para verificar os debitos pendentes com condicional para verificar antes se há debitos pendentes assim caso ão haja diminui o numero de linhas que precisam ser processadas o codigo melhorando o desempenho poupando processamento desnecessário
        if (listaDebito.isEmpty()) {
            System.out.println("Não há débitos para serem quitados.");
        } else {
            System.out.println("Débitos pendentes:");
            for (Map<String, String> debito : listaDebito) {
                System.out.println("Nome: " + debito.get("nome") + ", CPF: " + debito.get("cpf") + ", Débito: " + debito.get("debito"));
            }
        }
    }

    private static void historicoCompras() {  // Metodo para a Listagem de historico de compras a partir do mapa criado com HashMap e adicionado nas listas
        // 
        System.out.println("Histórico de Compras ainda não implementado.");
    }

    public static List<Map<String, String>> getListaHistorico() {
        return listaHistorico;
    }
}
