import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite dois números para realizar as operações:");

        // Lendo os números
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Realizando as operações
        int soma = a + b;
        int divisao = a / b; // Use / para divisão
        int multiplicacao = a * b;
        int subtracao = a - b;

        // Exibindo os resultados
        System.out.println("O resultado da soma é: " + soma);
        System.out.println("O resultado da divisão é: " + divisao);
        System.out.println("O resultado da multiplicação é: " + multiplicacao);
        System.out.println("O resultado da subtração é: " + subtracao);

        // Fechando o scanner
        scanner.close();
    }
}
