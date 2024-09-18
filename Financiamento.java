import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente {
    private String nome;
    private String cpf; // Classe Cliente com Objetos Privados noem, cpf, rendamensal
    private double rendaMensal;

    public Cliente(String nome, String cpf, double rendaMensal) {
        this.nome = nome; // instanciando os objetos nome , cpf , rendaMensal
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
    }

    public String getNome() { // Metodo Get para os objetos Instanciados Cpf, Renda, Nome
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) { // metodo set para os objetos instanciados no metodo get depois de
                                                     // coletados serão setados para nao retornar nenhum valor no
                                                     // momento so quando resgatados pelo proprio metodo.
        this.rendaMensal = rendaMensal;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Renda Mensal: " + rendaMensal; // Aqui retora-se os valores
                                                                                     // coletados pelo metodo get e set
                                                                                     // pelo regate por meio do termo
                                                                                     // Return seguido de uma string
                                                                                     // concatenado do objeto.
    }
}

class Emprestimo { // Classe Emprestimo - Objetos da Classe = cliente,valor,taxaJuros,prazo.
    private Cliente cliente;
    private double valor;
    private double taxaJuros;
    private int prazo;

    public Emprestimo(Cliente cliente, double valor, double taxaJuros, int prazo) { // Instanciando os Objetos
                                                                                    // cliente,valor,taxaJuros, prazo
        this.cliente = cliente;
        this.valor = valor;
        this.taxaJuros = taxaJuros;
        this.prazo = prazo;
    }

    public double calcularMontanteTotal() {
        return valor * Math.pow((1 + taxaJuros), prazo); // Metodo para calculo com retorno do resultado da expressão do
                                                         // calculo, utilizando os objetos instanciados com os valores
                                                         // de referencia para o calculo.
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + ", Valor: " + valor + ", Montante Total: " + calcularMontanteTotal(); // Coleta
                                                                                                                       // para
                                                                                                                       // a
                                                                                                                       // classe
                                                                                                                       // Cliente
                                                                                                                       // do
                                                                                                                       // nome
                                                                                                                       // valor
                                                                                                                       // e
                                                                                                                       // resultado
                                                                                                                       // do
                                                                                                                       // Montante
                                                                                                                       // para
                                                                                                                       // criar
                                                                                                                       // os
                                                                                                                       // financiamneto
                                                                                                                       // para
                                                                                                                       // determinado
                                                                                                                       // cliente.
    }
}

class Banco { // Classe Banco Cria- se as Listas Clientes e Emprestimos que armanezaram os
              // dados dos clientes e dos emprestimo tanto o cadastro dos clientes quanto os
              // de emprestimos
    private List<Cliente> clientes;
    private List<Emprestimo> emprestimos;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente); // Metodo para adicionar clientes a lista de clientes
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) { // aqui segue a mesma logica descrita acima
        emprestimos.add(emprestimo);
    }

    public List<Cliente> getClientes() {
        return clientes; // Metodo para exibir os clientes armazenados na lista cLientes
    }

    public List<Emprestimo> getEmprestimos() { // mesma logica descrita acima
        return emprestimos;
    }
}

public class Financiamento { // classe principal - contem o menu de navegacao que utilizara as lista objetos
                             // e metodos construidos ao longo do codigo
    public static void main(String[] args) {
        Banco banco = new Banco();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Cadastrar Cliente");
                System.out.println("2. Solicitar Empréstimo");
                System.out.println("3. Sair");
                System.out.println("4. Exibir Cadastros Concluídos");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                switch (escolha) { // Switch para selecionar cada caso de iteração oque deve ocorrer
                    case 1 -> { // no caso 1 ele coleta strings e Doubles e instancia como novo cliente e por
                                // fim adiciona as lista de clientes.
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Renda Mensal: ");
                        double rendaMensal = scanner.nextDouble();
                        Cliente cliente = new Cliente(nome, cpf, rendaMensal);
                        banco.adicionarCliente(cliente);
                        System.out.println("Cliente cadastrado com sucesso!");
                    }
                    case 2 -> {
                        System.out.print("CPF do Cliente: "); // Busca de Cliente pelo Objeto CPF se CPF for igual a CPF
                                                              // esse cliente consta nos dados e exibe o cliente e seus
                                                              // emprestimos caso contrario o cliente nao foi registrado
                                                              // informando o usuario disto.
                        String cpf = scanner.nextLine();
                        Cliente cliente = banco.getClientes().stream()
                                .filter(c -> c.getCpf().equals(cpf))
                                .findFirst()
                                .orElse(null);
                        if (cliente == null) {
                            System.out.println("Cliente não encontrado!");
                            continue;
                        }
                        System.out.print("Valor do Empréstimo: "); // Entao quando nao encontrado nenhum emprestimo o
                                                                   // codigo começara um novo emprestimo para registrar
                                                                   // pela primeira vez naquele CPF e assim entrar na
                                                                   // base de dados de CPF,s
                        double valor = scanner.nextDouble();
                        System.out.print("Taxa de Juros (por período): ");
                        double taxaJuros = scanner.nextDouble();
                        System.out.print("Prazo (em períodos): ");
                        int prazo = scanner.nextInt();
                        Emprestimo emprestimo = new Emprestimo(cliente, valor, taxaJuros, prazo);
                        banco.adicionarEmprestimo(emprestimo);
                        System.out.println("Empréstimo solicitado com sucesso! Montante total a pagar: "
                                + emprestimo.calcularMontanteTotal()); // por FIM adiciona os valores do emprestimo aos
                                                                       // dados linkando o emprestimo e o CPF
                    }
                    case 3 -> {
                        System.out.println("Encerrando..."); // Caso para a saida do Sistema
                        return; // Exit the program
                    }
                    case 4 -> { // Caso para a Listagem de clientes utilizando objeto cliente armazenados na
                                // lista cliente e exibindo no terminal
                        System.out.println("Lista de Clientes:");
                        for (Cliente cliente : banco.getClientes()) {
                            System.out.println(cliente);
                        }
                        System.out.println("Lista de Empréstimos:"); // emprestimo coletado utilizando objeto emprestimo
                                                                     // armazenado na lista emprestimo e exibindo no
                                                                     // terminal
                        for (Emprestimo emprestimo : banco.getEmprestimos()) {
                            System.out.println(emprestimo);
                        }
                    }
                    default -> System.out.println("Opção inválida!"); // caso na seja feita nenhuma das iterações acima
                                                                      // ele percorerra a iteração default(padrao)
                                                                      // quando nenhuma for feita imprimindo a mensagem
                                                                      // opçcao invalida
                }
            }
        }
    }
}
