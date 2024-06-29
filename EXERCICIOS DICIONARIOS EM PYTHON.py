escolha=1
while escolha!= 0:
        print("***** ----------------------------------Menu Principal--------------------------------------- ********")
        print("1- Gerenciar Estudantes.\n")
        print("2- Gerenciar Professores.\n")
        print("3- Gerenciar Disciplinas.\n")
        print("4- Gerenciar Turmas\n")
        print("5- Gerenciar Matriculas\n")
        print("11- Sair do Programa\n")
        
        escolha = int(input("Digite a opcao de sua escolha aluno ! =   "))
        registro= ""
        if escolha == 1:
            registro = "Estudantes\n"
        elif escolha == 2:
            registro = "Professores\n"
        elif escolha == 3:
            registro = "Disciplinas\n"
        elif escolha == 4:
            registro = "Turmas\n"
        elif escolha == 5:
            registro = "Matriculas\n"
        elif escolha == 11:
            registro = "Sair\n"
            break                    
        else:
            print("Voce escolheu uma opcao invalida, tente novamente por favor")
            continue
        estudantes = []
        opcao = 1

while opcao!= 5:
        print("["+registro+"] Menu de Escolhas")
        print("[1]- Incluir\n")
        print("[2]- Listar\n")
        print("[3]- Atualizar\n")
        print("[4]- Excluir\n")
        print("[5]- Voltar ao menu principal\n")
        opcao = int(input("Selecione a opcao desejada acima =  \n"))

        if opcao == 1:
            print("Incluindo Registro\n")
        elif opcao == 2:
            print("Listando Registro\n")
        elif opcao == 3:
            print("Atualizando Registro\n")        
        elif opcao == 4:
            print("Excluindo Registro\n")
        elif opcao == 5:
            print("Voltando ao Menu Principal\n")
            continue        
        else:
            print("Opcao Incorreta\n")
            print("Presione qualquer letra para continuar\n")
            continue

print("Finalizando as tarefas\n")               
            