import java.util.ArrayList;
import java.util.Scanner;

class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJuros;

    // Construtor da classe Financiamento
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJuros) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJuros = taxaJuros;
    }

    // Métodos getters e setters
    public double getValorImovel() {
        return valorImovel;
    }

    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public void setPrazoFinanciamento(int prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    // Método para calcular o pagamento mensal
    public double calcularPagamentoMensal() {
        double taxaMensal = taxaJuros / 12;
        double parcelas = prazoFinanciamento * 12;
        return (valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -parcelas));
    }

    // Método para calcular o total a pagar
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    // Classe Usuario para interagir com o usuário e coletar dados
    static class Usuario {
        private Scanner scanner = new Scanner(System.in);

        // Método para solicitar o valor do imóvel
        public double solicitarValorImovel() {
            System.out.print("Digite o valor do imóvel: ");
            return scanner.nextDouble();
        }

        // Método para solicitar o prazo do financiamento
        public int solicitarPrazoFinanciamento() {
            System.out.print("Digite o prazo do financiamento em anos: ");
            return scanner.nextInt();
        }

        // Método para solicitar a taxa de juros anual
        public double solicitarTaxaDeJuros() {
            System.out.print("Digite a taxa de juros anual (em %): ");
            return scanner.nextDouble() / 100;
        }
    }

    public static void main(String[] args) {
        // Instanciando a classe Usuario para coletar dados do usuário
        Usuario usuario = new Usuario();

        // Coletando informações do financiamento
        double valorImovel = usuario.solicitarValorImovel();
        int prazoFinanciamentoAnos = usuario.solicitarPrazoFinanciamento();
        double taxaJuros = usuario.solicitarTaxaDeJuros();

        // Criando o objeto de financiamento com os dados coletados
        Financiamento novoFinanciamento = new Financiamento(valorImovel, prazoFinanciamentoAnos, taxaJuros);

        // Calculando o pagamento mensal e o total a pagar
        double pagamentoMensal = novoFinanciamento.calcularPagamentoMensal();
        double totalPagamento = novoFinanciamento.calcularTotalPagamento();

        // Exibindo os resultados para o usuário
        System.out.printf("Pagamento mensal: R$ %.2f%n", pagamentoMensal);
        System.out.printf("Total a pagar: R$ %.2f%n", totalPagamento);
    }
}
