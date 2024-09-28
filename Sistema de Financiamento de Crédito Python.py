class Cliente:
    def __init__(self, nome, cpf, renda):
        self.nome = nome
        self.cpf = cpf
        self.renda = renda

    def __str__(self):
        return f"Nome: {self.nome}, CPF: {self.cpf}, Renda Mensal: {self.renda}"


class Emprestimo:
    def __init__(self, cliente, valor, taxa_juros, prazo):
        self.cliente = cliente
        self.valor = valor
        self.taxa_juros = taxa_juros
        self.prazo = prazo

    def calcular_montante_total(self):
        return self.valor * ((1 + self.taxa_juros) ** self.prazo)


class Banco:
    def __init__(self):
        self.clientes = []
        self.emprestimos = []

    def adicionar_cliente(self, cliente):
        self.clientes.append(cliente)

    def adicionar_emprestimo(self, emprestimo):
        self.emprestimos.append(emprestimo)

    def exibir_clientes(self):
        for cliente in self.clientes:
            print(cliente)

    def exibir_emprestimos(self):
        for emprestimo in self.emprestimos:
            print(f"Cliente: {emprestimo.cliente.nome}, Valor: {emprestimo.valor}, Montante Total: {emprestimo.calcular_montante_total()}")


def main():
    banco = Banco()

    while True:
        print("1 - Cadastrar Cliente")
        print("2 - Solicitar Empréstimo")
        print("3 - Exibir Clientes")
        print("4 - Exibir Empréstimos")
        print("5 - Sair")

        opcao = int(input("Digite uma das Opções Acima: "))

        if opcao == 1:
            nome = input("Digite o Nome do Cliente: ")
            cpf = input("Digite o CPF do Cliente: ")
            renda = float(input("Digite a Renda Mensal do Cliente: "))
            cliente = Cliente(nome, cpf, renda)
            banco.adicionar_cliente(cliente)
            print("Cliente cadastrado com sucesso!")

        elif opcao == 2:
            cpf = input("Digite o CPF do Cliente para solicitar o empréstimo: ")
            cliente = next((c for c in banco.clientes if c.cpf == cpf), None)
            if cliente is None:
                print("Cliente não encontrado!")
                continue

            valor = float(input("Digite o Valor do Empréstimo: "))
            taxa_juros = float(input("Digite a Taxa de Juros (por período): "))
            prazo = int(input("Digite o Prazo (em períodos): "))
            if valor > 100000:
                print("Empréstimo Negado, valor excede o limite de crédito.")
            else:
                emprestimo = Emprestimo(cliente, valor, taxa_juros, prazo)
                banco.adicionar_emprestimo(emprestimo)
                print("Empréstimo aprovado com sucesso!")

        elif opcao == 3:
            print("Lista de Clientes:")
            banco.exibir_clientes()

        elif opcao == 4:
            print("Lista de Empréstimos:")
            banco.exibir_emprestimos()

        elif opcao == 5:
            print("Encerrando...")
            break

        else:
            print("Opção inválida!")


if __name__ == "__main__":
    main()
