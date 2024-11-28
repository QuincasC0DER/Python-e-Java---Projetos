import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClientesLoja {
    private static final List<Map<String, String>> listaClientes = new ArrayList<>();
    private static final List<Map<String, String>> listaDebito = new ArrayList<>();
    private static final List<Map<String, List<Compra>>> listaHistorico = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static class Compra {
        private String item;
        private int quantidade;
        private double precoUnitario;
        private double total;

        // Construtor
        public Compra(String item, int quantidade, double precoUnitario) {
            this.item = item;
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.total = quantidade * precoUnitario;
        }

        // Getters
        public String getItem() {
            return item;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public double getPrecoUnitario() {
            return precoUnitario;
        }

        public double getTotal() {
            return total;
        }

        @Override
        public String toString() {
            return "Compra [Item: " + item + ", Quantidade: " + quantidade + ", Preço Unitário: " + precoUnitario
                    + ", Total: " + total + "]";
        }
    }

    public static void main(String[] args) {
        menuPrincipal(); // classe principal onde chama o metodo menuPrincipal Para inicializar o
                         // programa
    }

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("Menu Principal:");
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Histórico de Compras");
            System.out.println("4 - Débitos Pendentes");
            System.out.println("5 - Adicionar Compra");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consome uma linha após o input da opção

            switch (opcao) { // Switch com os cases > métodos relacionados aos clientes
                case 1 -> adicionarCliente();
                case 2 -> listarClientes();
                case 3 -> historicoCompras();
                case 4 -> debitoPendente();
                case 5 -> adicionarCompra();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5); // mantém o menu ativo até que a opção chegue a 5.
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

        // Cria um mapa com os valores de débito não pagos por cliente relacionados ao
        // nome e cpf para fazer a relação
        Map<String, String> debito = new HashMap<>();
        debito.put("nome", nome);
        debito.put("cpf", cpf);
        debito.put("debito", "não pago"); // Inicialmente assume que o débito não foi pago

        // Adiciona os mapas nas listas Cliente e débito
        listaClientes.add(cliente);
        listaDebito.add(debito);

        // Cria um histórico vazio para esse cliente
        Map<String, List<Compra>> historico = new HashMap<>();
        historico.put("cpf", new ArrayList<>()); // associando compras a esse CPF
        listaHistorico.add(historico);

        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Map<String, String> cliente : listaClientes) {
                System.out.println("Nome: " + cliente.get("nome") + ", CPF: " + cliente.get("cpf"));
            }
        }
    }

    private static void debitoPendente() {
        if (listaDebito.isEmpty()) {
            System.out.println("Não há débitos para serem quitados.");
        } else {
            System.out.println("Débitos pendentes:");
            for (Map<String, String> debito : listaDebito) {
                System.out.println("Nome: " + debito.get("nome") + ", CPF: " + debito.get("cpf") + ", Débito: "
                        + debito.get("debito"));
            }
        }
    }

    // Método para adicionar compras ao histórico de um cliente
    private static void adicionarCompra(String cpf, String item, Double precoUnitario, int quantidade) {
        Compra compra = new Compra(item, quantidade, precoUnitario);

        // Encontrando o cliente pelo CPF e adicionando a compra ao histórico
        for (Map<String, List<Compra>> historico : listaHistorico) {
            if (historico.containsKey("cpf") && historico.get("cpf") != null) {
                historico.get("cpf").add(compra);
                break;
            }
        }
        System.out.println("Compra registrada com sucesso!");
    }

    private static void historicoCompras() {
        System.out.print("Digite o CPF do cliente para consultar o histórico de compras: ");
        String cpfCliente = scanner.nextLine();

        boolean clienteEncontrado = false;
        for (Map<String, List<Compra>> historico : listaHistorico) {
            if (historico.containsKey("cpf") && historico.get("cpf") != null) {
                List<Compra> compras = historico.get("cpf");
                if (!compras.isEmpty()) {
                    System.out.println("Histórico de Compras do Cliente com CPF: " + cpfCliente);
                    for (Compra compra : compras) {
                        System.out.println(compra);
                    }
                    clienteEncontrado = true;
                } else {
                    System.out.println("Nenhuma compra registrada para este cliente.");
                    clienteEncontrado = true;
                }
            }
        }
        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado.");
        }
    }
}
