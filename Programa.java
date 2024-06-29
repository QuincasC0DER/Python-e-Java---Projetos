
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite seu nome: ");
            String nome = scanner.nextLine();

            System.out.println("Digite seu endereco: ");
            String endereco = scanner.nextLine();

            System.out.println("Estimativa para Orcamento compra");
            String resposta = scanner.nextLine();

            System.out.println("Digite sua idade: ");
            String idade = scanner.nextLine();

            System.out.println("Digite seu salario: ");
            double salario = scanner.nextDouble();

            System.out.println("Digite os produtos que deseja inserir: ");
            String produtos = scanner.nextLine();

            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("Saldo Carteira Digital:" + salario);
            System.out.println("Endereco:" + endereco);
            System.out.println("Estimativa de Gasto com as Compras:" + resposta);
            System.out.println("Produtose e tipos de Ingressos: " + produtos);

            List<String> listaProdutos = new ArrayList<>();
            listaProdutos.add("Ingresso Secao 01");
            listaProdutos.add("Ingresso 02");
            listaProdutos.add("ingresso 03");
            listaProdutos.add("Ingresos 04");
            listaProdutos.add("Ingresos 05");
            listaProdutos.add("Ingressos Area Vip");

            System.out.println("Tamanho da lista: " + listaProdutos.size());
            System.out.println("Primeiro produto da lista: " + listaProdutos.get(0));
            System.out.print("Segundo Produto da Lista: " + listaProdutos.get(1));
            System.out.println("Terceiro Produto da Lista: " + listaProdutos.get(2));

            List<Float> x = new ArrayList<>();
        
            List Preco = new ArrayList();

            Preco.add("2500");
            Preco.add("1500");
            Preco.add("1000");
            Preco.add("500,00");
            Preco.add("300,00");

            System.out.println("Aqui estao os precos dos produtos solicitados" + Preco);

            Dictionary precoNovo = new Hashtable();

            precoNovo.put("Ingresso A", "1,800");
            precoNovo.put("Ingresso B", "599,00");
            precoNovo.put("Ingreso C", "899,00");
            precoNovo.put("Ingreso D", "499,00");

            scanner.close();
        }
    }
}
  

            
        

    
    