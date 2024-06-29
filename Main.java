
import java.util.ArrayList;
import java.util.Scanner;

class Financiamento {   // clase financiamento armazena as variveis valor imovel , prazo do finaciamento, taxa de juros

    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJuros;

    Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {   // metodo para a classe financiamento e os parametros setados para o metodo
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJuros = taxaJurosAnual;
    }

    public double getValorImovel() {  // Coleta de uma valor para a variavel Valor Imovel e o retorno do valor coletado agora atrivuido a variavel valor imovel
        return valorImovel;
    }

    public void setValorImovel(double valorImovel) {  // define a variavel valor imovel como parametro sem retorno
        this.valorImovel = valorImovel;
    }

    public int getPrazoFinanciamento() { // Coleta o prazo de financiamento com o get e retorno o valor coletado.
        return prazoFinanciamento;
    }

    public void setPrazoFinanciamento(int prazoFinanciamento) { // define prazoFinanciamento com o parametro tipo int prazo financiamento
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public double getTaxaJuros() {  // Coletra a Taxa de juros e retorna o valor da taxa de Juros.
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {  // Define taxa de juros com o parametro taxaJuros Double
        this.taxaJuros = taxaJuros;
    }

    double calcularPagamentoMensal() {   // Metodo Calcular Pagamento Mensal - contendo as equacoes de taxaMensal, Parcelas, ValorIMovel * TaxaMensal
        double taxaMensal = taxaJuros / 12;
        double parcelas = prazoFinanciamento * 12;
        return (valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -parcelas));
    }

    double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12; // Metodo para o calculo do pagamento Mensal e o valor do prazo vezes os 12 meses do ano

    }

    static class Usuario {  // Cria-se a nova classe chamda Usuario onde estarao Todas as opercaoes do Usuario

        Scanner scanner = new Scanner(System.in);  // Metodo Scaner chamado pelo import aqui aberto

        double solicitarValorImovel() {
            System.out.print("Digite o valor do imovel: "); // resgate do metodo SolicitarValorImovel Impressao da Mensagem e o retorno do valor coletado pelo Scanner
            return scanner.nextDouble();
        }

        int solicitarPrazoFinanciamento() {  // Resgate do metodo solicitarPrazoFinanciamneto Impressao da mensagem e o retorno do valor coletado pelo scannner.
            System.out.print("Digite o prazo do financiamento em anos: ");
            return scanner.nextInt();
        }

        double solicitarTaxadeJuros() { // Metodo solicitaTaxadeJuros Impressao da Mensagem e retorno do valor coletado pelo escanner utilizado o metodo.
            System.out.print("Digite a taxa de juros anual (em %): ");
            return scanner.nextDouble() / 100;
        }

    }

    public class Main {  // Classe Principal aqui e onde estao as operacoes globais do programa que efetivamente sera exibidas na tela apos a coleta dos dados e imprime na tela segundo o formado de saido dentro da funcao Imprimir
// concentra as variaveis seguidas dos metodos.

        public static void main(String[] args) {
            ArrayList<financiamentos> financiamentos = new ArrayList<>();

            financiamentos.add(new financiamentos("Lucas", 5000.00, 12));

            System.out.print(financiamentos);
            Usuario usuario = new Usuario();

            double valorImovel = usuario.solicitarValorImovel();
            int prazoFinanciamentoAnos = usuario.solicitarPrazoFinanciamento();
            double taxaJuros = usuario.solicitarTaxadeJuros();

            Financiamento novoFinanciamento = new Financiamento(valorImovel, prazoFinanciamentoAnos, taxaJuros);

            double pagamentoMensal = novoFinanciamento.calcularPagamentoMensal();
            double totalPagamento = novoFinanciamento.calcularTotalPagamento();

            System.out.printf("Pagamento mensal: R$ %.2f%n", pagamentoMensal); // Impressao de saida sera exibio no console apos realizar as iteracoes do codigo.
            System.out.printf("Total a pagar: R$ %.2f%n", totalPagamento);

        }
    }
}
