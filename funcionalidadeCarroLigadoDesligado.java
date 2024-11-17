import java.util.Scanner;

public class funcionalidadeCarroLigadoDesligado {
    // Atributos
    public String marca;
    public int ano;
    public int marcha;
    public boolean ligado;

    // Métodos
    public void ligar() { // método ligar
        if (!this.ligado) { // Se o carro não estiver ligado
            this.ligado = true;
            System.out.println("Carro Ligado");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    public void desligar() { // método desligar
        if (this.ligado) { // Se o carro estiver ligado
            this.ligado = false;
            System.out.println("Carro Desligado");
        } else {
            System.out.println("O carro já está desligado.");
        }
    }

    public static void main(String[] args) {
        // Instanciando um objeto da classe Carro
        Carro citroen = new Carro();

        // Criando um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Exibindo menu para o usuário
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Ligar o carro");
        System.out.println("2 - Desligar o carro");
        System.out.println("3 - Sair");

        // Lendo a opção do usuário
        int opcao;
        do {
            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt(); // Lê a opção do usuário

            switch (opcao) {
                case 1:
                    citroen.ligar(); // Chama o método ligar
                    break;
                case 2:
                    citroen.desligar(); // Chama o método desligar
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            // Exibindo o menu novamente após a escolha
            if (opcao != 3) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Ligar o carro");
                System.out.println("2 - Desligar o carro");
                System.out.println("3 - Sair");
            }

        } while (opcao != 3); // O loop continua até o usuário escolher sair

        // Fechando o Scanner
        scanner.close();
    }
}
