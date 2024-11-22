import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Produto que representa um produto
class Produto {
    int id;
    String nome;
    double preco;

    Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
}

public class MenuPrincipal {
    String nomeUsuario;
    String historicoCompras = ""; // Histórico de compras
    String metodoPagamento;
    String carrinhoCompras = ""; // Carrinho de compras
    int produtoIdentidade; // ID do produto
    int quantidadeProduto; // Quantidade do produto
    double totalPagamento; // Total de pagamento
    int opcao;

    // Lista de produtos disponíveis
    List<Produto> baseProdutos = new ArrayList<>();

    // Método para adicionar produtos à lista de base
    public void adicionarProdutoBase() {
        baseProdutos.add(new Produto(1, "Produto A", 50.0));
        baseProdutos.add(new Produto(2, "Produto B", 30.0));
        baseProdutos.add(new Produto(3, "Produto C", 100.0));
    }

    // Método para calcular o total do pagamento com base na quantidade e no preço
    public double totalPagamento() {
        if (quantidadeProduto == 0) {
            System.out.println("O Carrinho está Vazio");
            return 0;
        } else {
            // Procurando o produto pelo ID na base de produtos
            Produto produto = null;
            for (Produto p : baseProdutos) {
                if (p.id == produtoIdentidade) {
                    produto = p;
                    break;
                }
            }

            if (produto == null) {
                System.out.println("Produto não encontrado.");
                return 0;
            }

            totalPagamento = quantidadeProduto * produto.preco;
            return totalPagamento;
        }
    }

    // Método que adiciona os produtos ao carrinho
    public void adicionarAoCarrinho(int produtoId, int quantidade) {
        this.produtoIdentidade = produtoId;
        this.quantidadeProduto = quantidade;

        if (quantidadeProduto == 0) {
            System.out.println("O carrinho de compras está vazio");
        } else {
            carrinhoCompras = "Produto ID: " + produtoIdentidade + ", Quantidade: " + quantidadeProduto;
            System.out.println("Produto adicionado ao carrinho: " + carrinhoCompras);
            System.out.println("O total a pagar é: R$ " + totalPagamento());
        }
    }

    // Exibe o Histórico de Compras
    public void historicoCompras() {
        if (totalPagamento > 0) {
            historicoCompras += "Produto ID: " + produtoIdentidade + ", Quantidade: " + quantidadeProduto + "\n";
            System.out.println("Exibindo o Histórico de Compras:\n" + historicoCompras);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MenuPrincipal menu = new MenuPrincipal();

            // Adicionando produtos à base
            menu.adicionarProdutoBase();

            // Entrada para o ID do Produto
            System.out.println("Digite o ID do produto para ser adicionado:");
            int produtoIdentidade = scanner.nextInt(); // Mudança para int

            // Entrada para a Quantidade do Produto
            System.out.println("Digite a quantidade do Produto para ser adicionado:");
            int quantidadeProduto = scanner.nextInt();

            // Adicionando o Produto ao Carrinho
            menu.adicionarAoCarrinho(produtoIdentidade, quantidadeProduto);

            // Exibe o Histórico de Compras
            menu.historicoCompras();
        }
    }

    public void listarProdutos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarProdutos'");
    }

}
