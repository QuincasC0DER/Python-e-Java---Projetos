import java.util.Scanner;

public class Banco {
    String nome;
    String cpf;
    int salario;
    Double conta;

    // Método para calcular o valor do empréstimo
    public void calcularEmprestimo() {
        // Exemplo de critério para o empréstimo
        // O valor do empréstimo pode ser, por exemplo, 3 vezes o salário do cliente,
        // desde que o saldo na conta seja suficiente.

        double limiteEmprestimo = salario * 3; // O cliente pode pegar até 3 vezes seu salário emprestado
        if (conta >= 1000) { // Apenas clientes com saldo na conta superior a R$ 1000,00 podem pedir
                             // empréstimo
            System.out.println("Empréstimo aprovado! Valor máximo do empréstimo: R$ " + limiteEmprestimo);
        } else {
            System.out.println("Saldo insuficiente para solicitar empréstimo.");
        }
    }

    // Método para definir o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para definir o CPF
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Método para definir o salário
    public void setSalario(int salario) {
        this.salario = salario;
    }

    // Método para definir a conta bancária
    public void setConta(Double conta) {
        this.conta = conta;
    }

    // Método para exibir os detalhes do cliente
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: R$ " + salario);
        System.out.println("Saldo na Conta: R$ " + conta);
    }

    public void coletarDadosCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite O nome do cliente");
        nome = scanner.nextLine();

        System.out.println("Digite o cpf do cliente ");
        cpf = scanner.nextLine();

        System.out.print("Digite o Salário ");
        salario = scanner.nextInt();

        System.out.println("Digite o saldo da conta do cliente");
        conta = scanner.nextDouble();

        scanner.close();
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();

        cliente1.coletarDadosCliente();
        cliente1.exibirDetalhes();
        cliente1.calcularEmprestimo();
    }

}
