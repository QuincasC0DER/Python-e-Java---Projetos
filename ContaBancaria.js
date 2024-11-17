class ContaBancaria {
    // Atributos da conta bancária
    constructor(titular, numeroConta, saldoInicial = 0) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.extrato = [];  // Array para armazenar as transações realizadas
    }

    // Método para depositar dinheiro na conta
    depositar(valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.extrato.push(`Depósito: R$ ${valor.toFixed(2)}`);
            console.log(`Depósito realizado com sucesso. Saldo atual: R$ ${this.saldo.toFixed(2)}`);
        } else {
            console.log("Valor de depósito inválido.");
        }
    }

    // Método para sacar dinheiro da conta
    sacar(valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            this.extrato.push(`Saque: R$ ${valor.toFixed(2)}`);
            console.log(`Saque realizado com sucesso. Saldo atual: R$ ${this.saldo.toFixed(2)}`);
        } else if (valor <= 0) {
            console.log("Valor de saque inválido.");
        } else {
            console.log("Saldo insuficiente para realizar o saque.");
        }
    }

    // Método para consultar o saldo
    consultarSaldo() {
        console.log(`Saldo atual: R$ ${this.saldo.toFixed(2)}`);
    }

    // Método para consultar o extrato
    consultarExtrato() {
        if (this.extrato.length === 0) {
            console.log("Nenhuma transação realizada até o momento.");
        } else {
            console.log("Extrato:");
            this.extrato.forEach(transacao => console.log(transacao));
        }
    }

    // Método para transferir valores para outra conta
    transferir(contaDestino, valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            contaDestino.depositar(valor);  // Deposita na conta de destino
            this.extrato.push(`Transferência para conta ${contaDestino.numeroConta}: R$ ${valor.toFixed(2)}`);
            console.log(`Transferência realizada com sucesso. Saldo atual: R$ ${this.saldo.toFixed(2)}`);
        } else if (valor <= 0) {
            console.log("Valor de transferência inválido.");
        } else {
            console.log("Saldo insuficiente para realizar a transferência.");
        }
    }
}

// Criando duas contas bancárias
let conta1 = new ContaBancaria("João Silva", "12345", 1000);
let conta2 = new ContaBancaria("Maria Oliveira", "67890", 500);

// Realizando operações
conta1.depositar(200);      // Depósito de R$ 200
conta1.sacar(150);         // Saque de R$ 150
conta1.consultarSaldo();   // Consulta de saldo
conta1.consultarExtrato(); // Consulta de extrato

conta1.transferir(conta2, 300);  // Transferência de R$ 300 para a conta2
conta2.consultarSaldo();         // Consulta saldo da conta2
conta2.consultarExtrato();       // Consulta extrato da conta2
