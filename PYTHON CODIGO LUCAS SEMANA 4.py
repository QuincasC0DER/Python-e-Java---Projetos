 # Nome estudante = Lucas Quincas Suzin  Curso = ADS Disciplina = Raciocínio Computacional


estudantes = [
             ]  # Lista estudantes onde serao armazenados os nomes dos estudantes inseridos na opcao do segundo menu "Inserir"

escolha=1 # define o valor de selecao para a variavel registro equivalente a string estudantes.

while escolha!= 7: # Loop infinito para selecao enquanto o usuário deseja navegar pelas opções
        print("***** ----------------------------------Menu Principal--------------------------------------- ********") # Menu principal listando todas as opções do menu
        print("1- Gerenciar Estudantes.\n")
        print("2- Gerenciar Professores.\n")
        print("3- Gerenciar Disciplinas.\n")
        print("4- Gerenciar Turmas\n")
        print("5- Gerenciar Matriculas\n")
        print("7- Sair do Programa\n")
        
        escolha = int(input("Digite a opcao de sua escolha aluno ! =   ")) # define um valor tipo string para cada opcão da variável registro e determina a codicao para imprimir essa string na tela.
        registro= ""
        if escolha == 1:
            registro = "Estudantes"
            
        elif escolha == 2:
            registro = "Professores"
        elif escolha == 3:
            registro = "Disciplinas"
        elif escolha == 4:
            registro = "Turmas"
        elif escolha == 5:
            registro = "Matriculas"
        elif escolha == 7:
            registro = "Sair" # Essa opção em particular possue um código de parada para encerrar o loop e finalizar o programa > (break) , encenrando o programa.
            break                    
        else:
            print("Voce escolheu uma opcao invalida, tente novamente por favor")# mensagem a ser imprimida na tela caso o usuario de uma entrada invalida reiniciando o menu para um nova entrada.
            continue
        
        opcao = 1 # seleciona a opcao estudantes - incluir

        while opcao!= 5: # loop infinito lista as opcoes do menu secundario e define o valor para a opcao de voltar ao menu anterior >(Menu Principal)
            print("["+registro+"] Menu de Escolhas")
            print("[1]- Incluir\n")
            print("[2]- Listar\n")
            print("[3]- Atualizar\n")
            print("[4]- Excluir\n")
            print("[5]- Voltar ao menu principal\n")
            opcao = int(input("Selecione a opcao desejada acima =  ")) # entrada do valor numerico pelo usuario para selecao das opcoes do segundo menu

            if opcao == 1: # Define a condicao de uma opcao e o resultado se a opcao for verdadeira(True) na estrutura condicional (if/elif/else)
                nomes = input("Nome do estudante\n  ")
                estudantes.insert(0, nomes)
                print("Estudante Incluido\n")
            elif opcao == 2:
                print("Listando Registro estudantes\n")
                print(estudantes)                
            elif opcao == 3:
                print("Em desenvolvimento\n")        
            elif opcao == 4:
                print("Em desenvolvimento\n")
            elif opcao == 5:
                print("Voltando ao Menu Principal\n") # selecao para voltar ao menu principal sem encerar o programa devido a estrutura de loop (continue)
                continue        
            else:
             print("Opcao Incorreta\n")
             print("Presione qualquer letra para continuar\n")
             continue # faz com que o menu seja executado enquanto nao for fornecido uma entrada valida pelo usuario
            
            
            
           
print("Finalizando as tarefas")  # Mensagem exibida ao finalizar o programa.              
            