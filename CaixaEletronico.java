

import java.util.Scanner;
import java.util.logging.Logger;


public class CaixaEletronico {
    private static final Logger logger = Logger.getLogger(CaixaEletronico.class.getName());
    static int historicoSaque = 0;
    static int historicoDeposito = 0;
    static int historicoPagamentoEletronico = 0;
    private static int saldo = 1000;
    private static final String SALDO_ATUALIZADO_MSG = "Saldo atualizado: R$ %.2f";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        logger.info("\nBem-vindo ao Caixa Eletrônico do Banco do Brasil!");

        do {
            logger.info("\nEscolha uma das opções para operações bancárias:");
            logger.info("1 - Saque Eletrônico");
            logger.info("2 - Depósito Eletrônico");
            logger.info("3 - Pagamento Eletrônico");
            logger.info("4 - Consultar Histórico de Operações");
            logger.info("5 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    saqueEletronico(scanner);
                    break;
                case 2:
                    depositoEletronico(scanner);
                    break;
                case 3:
                    pagamentoEletronico(scanner);
                    break;
                case 4:
                    consultarHistoricoPagamento();
                    break;
                case 5:
                    logger.info("Saindo do Caixa Eletrônico. Até mais!");
                    break;
                default:
                    logger.warning("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void saqueEletronico(Scanner scanner) {
        logger.info("Digite o valor a ser sacado:");
        int valor = scanner.nextInt();

        if (valor <= 0) {
            logger.warning("Valor inválido para saque.");
            return;
        }

        if (valor > saldo) {
            logger.warning("Saldo insuficiente para realizar o saque.");
            return;
        }

        int[] notas = {100, 50, 20, 10, 5, 2, 1};
        int[] quantidadeNotas = new int[notas.length];
        int valorRestante = valor;

        for (int i = 0; i < notas.length; i++) {
            quantidadeNotas[i] = valorRestante / notas[i];
            valorRestante %= notas[i];
        }

        saldo -= valor;
        historicoSaque += valor;

            logger.info("Saque realizado com sucesso! Detalhes:");
            for (int i = 0; i < notas.length; i++) {
                if (quantidadeNotas[i] > 0 && logger.isLoggable(java.util.logging.Level.INFO)) {
                    logger.info(String.format("%d nota(s) de R$ %d", quantidadeNotas[i], notas[i]));
                }
            }
            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                logger.info(String.format(SALDO_ATUALIZADO_MSG, (float) saldo));
                logger.info(String.format(SALDO_ATUALIZADO_MSG, (float) saldo));
            }
        }
    

    public static void depositoEletronico(Scanner scanner) {
        try {
            logger.info("Digite o valor a ser depositado:");
            int valor = scanner.nextInt();

            if (valor <= 0) {
                logger.warning("Valor inválido para depósito.");
                return;
            }

            logger.info("Digite o número da Conta Corrente:");
            String contaCorrente = scanner.next();
            logger.info("Digite o número da Agência:");
            String agencia = scanner.next();
            logger.info("Digite o número do CPF do depositante:");
            String cpf = scanner.next();

            saldo += valor;
            historicoDeposito += valor;

            logger.info("Depósito realizado com sucesso!");
            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                logger.info(String.format("Conta Corrente: %s Agência: %s CPF: %s", contaCorrente, agencia, cpf));
            }
            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                logger.info(String.format(SALDO_ATUALIZADO_MSG, (float) saldo));
            }

        } catch (Exception e) {
            logger.severe("Erro ao realizar depósito: " + e.getMessage());
        }
    }

    public static void pagamentoEletronico(Scanner scanner) {
        logger.info("Digite o valor do pagamento:");
        int valor = scanner.nextInt();

        if (valor <= 0) {
            logger.warning("Valor inválido para pagamento.");
            return;
        }

        if (valor > saldo) {
            logger.warning("Saldo insuficiente para realizar o pagamento.");
            return;
        }

        saldo -= valor;
        historicoPagamentoEletronico += valor;

        logger.info("Pagamento realizado com sucesso!");
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info(String.format(SALDO_ATUALIZADO_MSG, (float) saldo));
        }
    }

    public static void consultarHistoricoPagamento() {
        logger.info("\nHistórico de Operações:");
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info(String.format("Total de Saques: R$ %.2f", (float) historicoSaque));
        }
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info(String.format("Total de Depósitos: R$ %.2f", (float) historicoDeposito));
        }
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info(String.format("Total de Pagamentos: R$ %.2f", (float) historicoPagamentoEletronico));
        }
    }

}
