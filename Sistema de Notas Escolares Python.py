print("Simulador Notas Escolares")

lista_alunos = []
lista_notas = []

def media_nota():
    nota1 = int(input("Digite a Primeira Nota: "))
    nota2 = int(input("Digite a Segunda Nota: "))
    media = (nota1 + nota2) // 2
    lista_notas.append(media)
    print(f"Esta é a nota da média entre as duas notas: {media}")

def media_ponderada():
    nota1 = int(input("Digite a Primeira Nota: "))
    nota2 = int(input("Digite a Segunda Nota: "))
    peso1 = 1
    peso2 = 2
    media_ponderada = (nota1 * peso1 + nota2 * peso2) // (peso1 + peso2)
    lista_notas.append(media_ponderada)
    print(f"Esta é a média ponderada das duas notas: {media_ponderada}")

def cadastro_aluno():
    nome = input("Digite o nome do aluno: ")
    cpf = input("Digite o CPF do Aluno: ")
    turma = input("Digite a turma do Aluno: ")
    disciplina = input("Digite a disciplina do aluno: ")
    
    aluno = {'nome': nome, 'cpf': cpf, 'turma': turma, 'disciplina': disciplina}
    lista_alunos.append(aluno)
    print("Aluno cadastrado com sucesso!")

def registro_notas():
    notas = []
    for i in range(1, 5):
        nota = int(input(f"Digite o valor para a nota {i}: "))
        notas.append(nota)
    mediaFinal = sum(notas) // len(notas)
    lista_notas.append(mediaFinal)
    print(f"A média final é: {mediaFinal}")

def registrar_reclamacao():
    reclamacao = input("Digite sua reclamação para o registro: ")
    if len(reclamacao) > 50:
        print("Reclamação ultrapassou o limite de caracteres, reduza-os.")
    else:
        print("Reclamação registrada com sucesso!")

def contestar_notas():
    print("Notas registradas:", lista_notas)
    contestacao = int(input("Digite o índice da nota contestada: "))
    if 0 <= contestacao < len(lista_notas):
        print(f"Você contestou a nota: {lista_notas[contestacao]}")
    else:
        print("Índice inválido.")

def menu_principal():
    while True:
        print("\n--- Menu Principal ---")
        print("1 - Mostrar Notas")
        print("2 - Calcular Média Ponderada")
        print("3 - Cadastrar Aluno")
        print("4 - Encerrar Sistema")
        print("5 - Próximo Menu")

        opcao = int(input("Digite a opção a ser selecionada no menu: "))
        if opcao == 1:
            print("Notas:", lista_notas)
        elif opcao == 2:
            media_ponderada()
        elif opcao == 3:
            cadastro_aluno()
        elif opcao == 4:
            print("Encerrando Sistema")
            break
        elif opcao == 5:
            print("Próximo Menu")
            menu_secundario()
        else:
            print("Digito Inválido, voltando...")

def menu_secundario():
        while True:
            print("\n--- Menu Secundário ---")
            print("1 - Registrar Notas")
            print("2 - Cadastrar Aluno")
            print("3 - Registrar Reclamação")
            print("4 - Contestar Notas")
            print("5 - Voltar ao Menu Principal")

            opcao_secundaria = int(input("Digite a opção secundária: "))
            if opcao_secundaria == 1:
                registro_notas()
            elif opcao_secundaria == 2:
                cadastro_aluno()
            elif opcao_secundaria == 3:
                registrar_reclamacao()
            elif opcao_secundaria == 4:
                contestar_notas()
            elif opcao_secundaria == 5:
                break
            else:
                print("Opção inválida.")

            menu_principal()
