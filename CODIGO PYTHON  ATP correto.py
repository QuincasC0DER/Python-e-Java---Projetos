 # Nome estudante = Lucas Quincas Suzin  Curso = ADS Disciplina = Raciocínio Computacional


estudantes = []  # Lista estudantes onde serao armazenados os nomes dos estudantes inseridos na opcão do segundo menu "Inserir"

escolha=1 # define o valor de seleção para a variável registro equivalente a string estudantes.


while escolha!= 7: # Loop infinito para seleção enquanto o usuário desejar navegar pelas opções.
        print("***** ----------------------------------Menu Principal--------------------------------------- ********") # Menu principal listando todas as opções do menu
        print("1- Gerenciar Estudantes.\n")
        print("2- Gerenciar Professores.\n")
        print("3- Gerenciar Disciplinas.\n")
        print("4- Gerenciar Turmas\n")
        print("5- Gerenciar Matriculas\n")
        print("7- Sair do Programa\n")
        print(estudantes)
        
        escolha = int(input("Digite a opcao de sua escolha aluno ! =   ")) # define um valor tipo string para cada opcão da variável registro e determina a codição para imprimir essa string na tela.
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
            print("Voce escolheu uma opcao inválida, tente novamente por favor")# mensagem a ser imprimida na tela caso o usúario de uma entrada inválida reiniciando o menu para uma nova entrada.
            continue
        
        opcao = 1 # seleciona a opção estudantes - incluir.

        while opcao!= 5: # loop infinito lista as opçoões do menu secundário e define o valor para a opção de voltar ao menu anterior >(Menu Principal).
            print("["+registro+"] Menu de Escolhas")
            print("[1]- Incluir\n")
            print("[2]- Listar\n")
            print("[3]- Atualizar\n")
            print("[4]- Excluir\n")
            print("[5]- Voltar ao menu principal\n")
            opcao = int(input("Selecione a opcao desejada acima =  ")) # entrada do valor numérico pelo usúario para seleção das opções do segundo menu.(menu(CRUD))
            #----------------------------------------------------------------------------------------------------------------
            if opcao == 1: # Define a condição de uma opção e o resultado se a opção for verdadeira(True) na estrutura condicional (if/elif/else).
              for i in range(1):    
                    nome = input("Por favor insira o Nome do estudante!:  \n  ")  
                    codigo = int(input("Por favor , digite o CODIGO DE ESTUDANTE?:  \n"))
                    cpf = (input("Digite por favor, seu CPF:  "))
                    
                    dicionario_estudante = {}
                    dicionario_estudante["nome"] = nome
                    dicionario_estudante["codigo"] = codigo
                    dicionario_estudante["cpf"] = cpf
                    
                    estudantes.append(dicionario_estudante) # insere o valor resgatado com o input da variavel (nomes) na lista [estudantes]
                    print("Estudante Incluido\n")                                                                                                                  
                         
          # -------------------------------------------------------------------------------------      
            if opcao == 2:
                print("Listando Registro estudantes\n")
                for estudante in estudantes:
                 print(estudantes)  #imprime a variavel estudantes.              
            #--------------------------------------------------------------------------------------
            if opcao == 3:                
             codigo_para_atualizar = int(input("Digite o codigo do estudante que deseja atualizar  "))            
                
                
             estudante_para_ser_atualizado = None
             for dicionario_estudante in estudantes:
                    
                 if dicionario_estudante['codigo'] == codigo_para_atualizar:
                         estudante_para_ser_atualizado = dicionario_estudante
                         break                                              
             if estudante_para_ser_atualizado is None:
                     print(f"Estudante de codigo {codigo_para_atualizar} nao foi encontrado")
                                        
             else:
                 estudante_para_ser_atualizado['codigo'] = int(input("Digite o novo codigo:  "))
                 estudante_para_ser_atualizado['cpf']= input("Digite o novo cpf:  ")
                 estudante_para_ser_atualizado['nome'] = input("Digite o novo nome  ")
                    
             for estudante in estudantes:
                                                               
                 print(estudante)                
            #-------------------------------------------------------------------------
            if opcao == 4:
                codigo_para_excluir = int(input('Digite o codigo para excluir  '))            
                
                estudante_para_ser_removido = None
                for dicionario_estudantes in estudantes:
                    if dicionario_estudante["codigo"] == codigo_para_excluir:
                            estudante_para_ser_removido = dicionario_estudante
                            break                                              
                if estudante_para_ser_removido is None:
                    print(f"Estudante de codigo {codigo_para_excluir} nao foi encontrado")
                
                else:
                    estudantes.remove(estudante_para_ser_removido)                    
                print(estudantes)
            # ---------------------------------------------------------------------------------------------------------------------    
            if opcao == 5:
                print("Voltando ao Menu Principal\n") # selecao para voltar ao menu principal sem encerar o programa devido a estrutura de loop (continue).
                continue        
            else:
                continue # faz com que o menu seja executado enquanto nao for fornecido uma entrada válida pelo usuario.
print("Finalizando Operacao")            




