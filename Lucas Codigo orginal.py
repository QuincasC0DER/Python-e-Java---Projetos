# Projeto > Menu principal sera impresso na tela. e sera solicitado um entrada dentre as opcoes.
while True:
        print("------------------XX------------------------------------- BEM VINDO AO MENU DE ENTRADA--------------------------------------------XX----------------.\n")    
        print(" Gerenciar Estudantes. (1) \n")
        print(" Gerenciar Professores. (2) \n")
        print(" Gerenciar Disciplinas. (3) \n")
        print(" Gerenciar Turmas. (4) \n")
        print(" Gerenciar Matrículas. (5)\n")
        print("Sair (0)\n")

# Solicitacao de entrada de uma opção  ao usuário no menu de entrada
        print("----------------------------------------------------Como podemos te ajudar Hoje Aluno!-----------------------------------------------------------------")
        opcao = int(input(" Escolha a opção desejada =   "))
        if opcao == (1) or opcao == (2) or opcao == (3) or opcao == (4) or opcao == (5):
             print(f"Voce selecionou a opção desejada = {opcao}  ")             
        elif opcao == 0:
             print("ATE LOGO E BONS ESTUDOS!!!")
             break      
        else:            
             print(" OPERAÇAÕ INVÁLIDA!!!  ")
             print(" Digite um valor listado no menu de entrada !  ")
             continue    
             
# Menu Secundário sera impresso na tela aqui e sera solicitado uma entrada ao usuario dentro de uma das opcoes.
        while True:
            print(" ---------------------+++-------------------------BEM VINDO AO MENU DE LISTAGENS, QUASE LA. ------------------------------+++------------------------------------\n")        
            print(" Incluir. (1) \n")
            print(" Listar. (2) \n")
            print(" Atualizar. (3) \n")
            print(" Excluir. (4) \n")
            print(" Voltar ao Menu Principal. (5) \n")
            
# Aqui o usuario vai selecionar a opcao desejada
            opcao_secundaria = int(input(" Digite a opção secundária desejada =   "))        
            if opcao_secundaria == (1) or opcao_secundaria == (2) or opcao_secundaria == (3) or opcao_secundaria == (4):
                print(f"Você escolheu a opção secundária = {opcao_secundaria} ")            
            elif opcao_secundaria == 5 :
                print("VOLTANDO AO MENU INICIAL......")
                break          
            else:
                print(" OPERAÇAÕ INVÁLIDA!!!  ") 
                print(" Tente novamente utilizando um valor listado no menu de listagens !  ")
                continue        








