import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SimuladorNotasEscolares {
    private static List<Map<String, String>> listaAlunos = new ArrayList<>();
    private static List<Integer> listaNotas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void mediaNota() {
        System.out.print("Digite a Primeira Nota: ");
        int nota1 = scanner.nextInt();
        System.out.print("Digite a Segunda Nota: ");
        int nota2 = scanner.nextInt();
        int media = (nota1 + nota2) / 2;
        listaNotas.add(media);
        System.out.println("Esta é a nota da média entre as duas notas: " + media);
    }

    private static void mediaPonderada() {
        System.out.print("Digite a Primeira Nota: ");
        int nota1 = scanner.nextInt();
        System.out.print("Digite a Segunda Nota: ");
        int nota2 = scanner.nextInt();
        int peso1 = 1;
        int peso2 = 2;
        int mediaPonderada = (nota1 * peso1 + nota2 * peso2) / (peso1 + peso2);
        listaNotas.add(mediaPonderada);
        System.out.println("Esta é a média ponderada das duas notas: " + mediaPonderada);
    }

    private static void cadastroAluno() {
        scanner.nextLine(); // Consume newline
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do Aluno: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a turma do Aluno: ");
        String turma = scanner.nextLine();
        System.out.print("Digite a disciplina do aluno: ");
        String disciplina = scanner.nextLine();

        Map<String, String> aluno = new HashMap<>();
        aluno.put("nome", nome);
        aluno.put("cpf", cpf);
        aluno.put("turma", turma);
        aluno.put("disciplina", disciplina);
        listaAlunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void registroNotas() {
        List<Integer> notas = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            System.out.print("Digite o valor para a nota " + i + ": ");
            int nota = scanner.nextInt();
            notas.add(nota);
        }
        int mediaFinal = notas.stream().mapToInt(Integer::intValue).sum() / notas.size();
        listaNotas.add(mediaFinal);
        System.out.println("A média final é: " + mediaFinal);
    }

    private static void registrarReclamacao() {
        scanner.nextLine(); // Consume newline
        System.out.print("Digite sua reclamação para o registro: ");
        String reclamacao = scanner.nextLine();
        if (reclamacao.length() > 50) {
            System.out.println("Reclamação ultrapassou o limite de caracteres, reduza-os.");
        } else {
            System.out.println("Reclamação registrada com sucesso!");
        }
    }

    private static void contestarNotas() {
        System.out.println("Notas registradas: " + listaNotas);
        System.out.print("Digite o índice da nota contestada: ");
        int contestacao = scanner.nextInt();
        if (contestacao >= 0 && contestacao < listaNotas.size()) {
            System.out.println("Você contestou a nota: " + listaNotas.get(contestacao));
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void menuPrincipal() {
        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1 - Mostrar Notas");
            System.out.println("2 - Calcular Média Ponderada");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Encerrar Sistema");
            System.out.println("5 - Próximo Menu");

            System.out.print("Digite a opção a ser selecionada no menu: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Notas: " + listaNotas);
                    break;
                case 2:
                    mediaPonderada();
                    break;
                case 3:
                    cadastroAluno();
                    break;
                case 4:
                    System.out.println("Encerrando Sistema");
                    return;
                case 5:
                    System.out.println("Próximo Menu");
                    menuSecundario();
                    break;
                default:
                    System.out.println("Digite Inválido, voltando...");
            }
        }
    }

    private static void menuSecundario() {
        while (true) {
            System.out.println("\n--- Menu Secundário ---");
            System.out.println("1 - Registrar Notas");
            System.out.println("2 - Cadastrar Aluno");
            System.out.println("3 - Registrar Reclamação");
            System.out.println("4 - Contestar Notas");
            System.out.println("5 - Voltar ao Menu Principal");

            System.out.print("Digite a opção secundária: ");
            int opcaoSecundaria = scanner.nextInt();
            switch (opcaoSecundaria) {
                case 1:
                    registroNotas();
                    break;
                case 2:
                    cadastroAluno();
                    break;
                case 3:
                    registrarReclamacao();
                    break;
                case 4:
                    contestarNotas();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
