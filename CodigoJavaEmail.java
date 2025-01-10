import java.util.Scanner;

public class CodigoJavaEmail {

    // Classe Usuario
    public static class Usuario {
        private String nome;
        private String email;
        private String senha;

        // Construtor
        public Usuario(String nome, String email, String senha) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
        }

        // Métodos de Alteração
        public void alterarNome(String novoNome) {
            this.nome = novoNome;
        }

        public void alterarEmail(String novoEmail) {
            this.email = novoEmail;
        }

        public void alterarSenha(String novaSenha) {
            this.senha = novaSenha;
        }

        // Mostrar Dados
        public void mostrarDados() {
            System.out.println("Nome: " + this.nome);
            System.out.println("Email: " + this.email);
            System.out.println("Senha: " + this.senha);
        }
    }

    // Classe Compras
    public static class Compras {
        private String produto;
        private int quantidade;
        private double total;

        // Construtor
        public Compras() {
            this.produto = "";
            this.quantidade = 0;
            this.total = 0.0;
        }

        public void registrarCompra(String produto, int quantidade, double precoUnitario) {
            this.produto = produto;
            this.quantidade = quantidade;
            this.total = quantidade * precoUnitario;
        }

        public void mostrarCompra() {
            System.out.println("Produto: " + this.produto);
            System.out.println("Quantidade: " + this.quantidade);
            System.out.println("Total: R$ " + this.total);
        }
        
        public void finalizarCompra() {
            if (this.quantidade > 0) {
                System.out.println("Deseja Finalizar a Compra?");
                if (input.equals("Sim")) {
                    System.out.println("Compra Finalizada" + this.total);
                } else {
                    System.out.println("Compra Cancelada");
            
                }
            } else {
                System.out.println("Nenhuma Compra Registrada");
        }
        
    }
}

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Usuario usuario = new Usuario("Usuário", "email@exemplo.com", "senha123");
            Compras compras = new Compras();

            while (true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Alterar nome");
                System.out.println("2. Alterar email");
                System.out.println("3. Alterar senha");
                System.out.println("4. Registrar compra");
                System.out.println("5. Mostrar compra");
                System.out.println("0. Exibir dados do usuário");
                System.out.println("6. Sair");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        usuario.alterarNome(novoNome);
                        break;
                    case 2:
                        System.out.print("Digite o novo email: ");
                        String novoEmail = scanner.nextLine();
                        usuario.alterarEmail(novoEmail);
                        break;
                    case 3:
                        System.out.print("Digite a nova senha: ");
                        String novaSenha = scanner.nextLine();
                        usuario.alterarSenha(novaSenha);
                        break;
                    case 4:
                        System.out.print("Digite o nome do produto: ");
                        String produto = scanner.nextLine();
                        System.out.print("Digite a quantidade: ");
                        int quantidade = scanner.nextInt();
                        System.out.print("Digite o preço unitário: ");
                        double precoUnitario = scanner.nextDouble();
                        compras.registrarCompra(produto, quantidade, precoUnitario);
                        break;
                    case 5:
                        compras.mostrarCompra();
                        break;
                    case 0:
                        usuario.mostrarDados();
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }
}
