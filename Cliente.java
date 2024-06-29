
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.SourceVersion;


public class Cliente {
    private String nome;
    private String cpf;
    private double rendaMensal;

    public Cliente(String nome, String cpf, double rendaMensal) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_22;
    }
}

public class Emprestimo {
    private Cliente cliente;
    private double valor;
    private double taxaJuros;
    private int prazo;

    public Emprestimo(Cliente cliente, double valor, double taxaJuros, int prazo) {
        this.cliente = cliente;
        this.valor = valor;
        this.taxaJuros = taxaJuros;
        this.prazo = prazo;
    }
 
    public double calcularMontanteTotal() {
        return valor * Math.pow((1 + taxaJuros), prazo);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public int getPrazo() {
        return prazo;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    private List<Emprestimo> emprestimos;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Solicitar Empréstimo");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            if (escolha == 1) {
                System.out.println("Nome: ");
                String nome = scanner.nextLine();
                System.out.println("CPF: ");
                String cpf = scanner.nextLine();
                System.out.println("Renda Mensal: ");
                double rendaMensal = scanner.nextDouble();

                Cliente cliente = new Cliente(nome, cpf, rendaMensal);
                banco.adicionarCliente(cliente);

                System.out.println("Cliente cadastrado com sucesso!");
            } else if (escolha == 2) {
                System.out.println("CPF do Cliente: ");
                String cpf = scanner.nextLine();
                Cliente cliente = banco.getClientes().stream()
                        .filter(c -> c.getCpf().equals(cpf))
                        .findFirst()
                        .orElse(null);

                if (cliente == null) {
                    System.out.println("Cliente não encontrado!");
                    continue;
                }

                System.out.println("Valor do Empréstimo: ");
                double valor = scanner.nextDouble();
                System.out.println("Taxa de Juros (por período): ");
                double taxaJuros = scanner.nextDouble();
                System.out.println("Prazo (em períodos): ");
                int prazo = scanner.nextInt();

                Emprestimo emprestimo = new Emprestimo(cliente, valor, taxaJuros, prazo);
                banco.adicionarEmprestimo(emprestimo);

                double montanteTotal = emprestimo.calcularMontanteTotal();
                System.out.println("Empréstimo solicitado com sucesso! Montante total a pagar: " + montanteTotal);
            } else if (escolha == 3) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}