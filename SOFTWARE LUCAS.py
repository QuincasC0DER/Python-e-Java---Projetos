

def menu_principal():
    print("===================================== Bem Vindo ao  [Menu Principal] de sua instituicao , como podemos te ajudar hoje, digite o nome da opcao por completo e sem espaco em caixa alta ")
    print(".1 [ESTUDANTES]\n")
    print("2. [DISCIPLINAS]\n")
    print("3. [PROFESSORES] \n")
    print("4. [TURMAS]\n")
    print("5. [MATRICULAS]\n")
    print("6.[SAIR]\n")
    
    return int(input("Escolha uma das opcoes =  "))
    
def menu_secundario():
    print("1. [INCLUIR]\n")
    print("2.[LISTAR]\n")
    print("3. [EDITAR]\n")
    print("4. [EXCLUIR]\n") 
    print("5. [VOLTAR AO MENU PRINCIPAL]\n")
    
    return int(input("Escolha uma das opcoes = "))

def cadastro_dados():
     nome = input("Digite o nome do estudandade = ")                           
     cpf = input("Digite o CPF do estudante = ")                           
     codigo = int(input("Digite o Codigo do estudante = "))                
     novo_cadastro = {
     "Codigo" : codigo,
     "Nome" : nome,
     
     "CPF" : cpf
                }           
     cadastros.append(novo_cadastro) 
     print(f"Estudante Incluido com Sucesso {cadastros } ")
            
def listar_dados():
    if len(cadastros) == 0:
     print("Ninguem Cadastrado :( ")
    else:
     print(f"Voce escolheu a opcao {opcao_secundaria} ")
     for cadastro in cadastros:
      print(f"Os dados do estudante sao {cadastro}")

def editar_dados():
    print(f"Voce escolheu a opcao numero {opcao_secundaria}")
    codigo = int(input("Digite o codigo do estudante para ser editado = "))
    for cadastro in cadastros:
     if cadastro["Codigo"] == codigo:
      cadastro["Nome"] = input("Digite um novo nome  ")
      cadastro["CPF"] = input("Digite o novo CPF  ")
      cadastro["Codigo"] = int(input("Digite o novo codigo  "))               
      print(f"Esta e a lista de estudantes atualizada {cadastros} ")
      break                                             
                 
     if codigo not in cadastros:
      print("O codigo nao existe!")                                  

def excluir_dados():
    codigo = int(input("Digite o codigo do estudante a ser removido"))
                
    cadastro_para_remover = None
                                                                                   
    for cadastro in cadastros:
     if cadastro["Codigo"] == codigo:                        
      cadastro_para_remover = cadastro
      break
    if cadastro_para_remover is not None:
      cadastros.remove(cadastro_para_remover)
      print("Estudante removido com sucesso!")
      
    else:
     print("Ops... parece que esse estudante nao existe verifique a digitacao e tente novamente")
    
     if input == 5:
      print("Voltando ao menu principal")

def cadastrar_dados_diciplinas():
    nome = input("Digite o nome da disciplina = ")
    codigo = int(input("Digite o Codigo do estudante = "))     
    novo_cadastro = { 
                     "Nome" : nome,
                     "Codigo" : codigo
                     }
    cadastros.append(novo_cadastro) 
    print(f"Estudante Incluido com Sucesso {cadastros } ")

def cadastrar_dados_turmas():
    codigo = int(input("Digite o codigo da turma"))
    novo_cadastro = {
     "Codigo" : codigo
    }
    cadastros.append(novo_cadastro)

def cadastrar_matriculas():
    codigo = input("Digite o codigo de matricula")
    novo_cadatro = {
        "Codigo" : codigo
        }
    cadastros.append(novo_cadatro) 
    print(f"Estudante Incluido com Sucesso {cadastros } ")        
def listar_matriculas():
    if len(cadastros) == 0:
     print("Nenhuma matricula registrada :( ")
    else:
     print(f"Voce escolheu a opcao {opcao_secundaria} ")
     for cadastro in cadastros:
      print(f"Os dados da matricula sao  {cadastro}")

def editar_matriculas():
    for matricula_para_remover in cadastros:
        matricula_para_remover["Nome"] = input("Digite o nome para ser removido")
        matricula_para_remover["CPF"] = input("Digite o novo CPF  ")
        matricula_para_remover["Codigo"] = int(input("Digite o novo codigo  "))               
        print(f"Esta e a lista de estudantes atualizada {cadastros} ")
        break                                             
                 
    if matricula_para_remover not in cadastros:
      print("O codigo nao existe!")                                  

    if matricula_para_remover is not None:
      cadastros.remove(matricula_para_remover)
      print(" Matricula removido com sucesso!")
      
    else:
     print("Ops... parece que essa matricula nao existe verifique a digitacao e tente novamente")
    
     if input == "VOLTAR":
      print(f"Voce selecionou a {opcao_secundaria}")
    
        
    codigo = int(input("Digite o codigo da matricula a ser editado"))
    for cadastro in cadastros:
      if cadastro["Codigo"] == "Codigo":
       cadastro["Nome"] = input("Digite um novo nome  ")
       cadastro["CPF"] = input("Digite o novo CPF  ")
       cadastro["Codigo"] = int(input("Digite o novo codigo  "))               
       print(f"Esta e a lista de matriculas atualizada {cadastros} ")
       break                                             
                 
      if codigo not in cadastros:
       print("A matricula nao existe!")                                  

def excluir_matriculas():
   for cadastro in cadastros:
       if cadastro["Codigo"]== "Codigo":
           cadastro.remove(cadastros)
           print("Matricula removido com Sucesso")  
 
    
            
cadastros = []

while True:
    opcao = menu_principal()
    
    if opcao == 1:
       
        print(f"Voce escolheu a OPCAO ESTUDANTES, estamos mais perto.Quase la, selecione a opcao do menu de operacaoes! = ")
          
        while True:
         
            opcao_secundaria =  menu_secundario()
            print("VOCE ESTA NAVEGANDO NO MENU SECUNDARIO ")
            if opcao_secundaria == 1:
                print("CADASTRO DADOS")
                cadastro_dados()     
                
            elif opcao_secundaria == 2:
                print("LISTAGEM DADOS")
                listar_dados()
                
            elif opcao_secundaria == 3: 
                print("EDICAO DE DADOS")
                editar_dados()                               
            
            elif opcao_secundaria == 4:                
               print("EXCLUSAO DE DADOS")
               excluir_dados() 
    
        
            elif opcao_secundaria == 5:
             print("VOLTANDO AO MENU PRINCIPAL) ")
             break  
                  
    if opcao == 6:
        break
         
while True:
    opcao = menu_principal()
    
    if opcao == 2:
         print(f"Voce escolheu a DISCIPLINAS, estamos mais perto.Quase la, selecione a opcao do menu de operacaoes! = ")
               
         while True:
            opcao_secundaria =  menu_secundario()
            print("VOCE ESTA NAVEGANDO NO MENU SECUNDARIO")
            if opcao_secundaria == 1:
                print("CADASTRO DICIPLINAS")
                cadastro_dados()
                
            elif opcao_secundaria == 2:
                print("LISTAGEM DE DISCIPLINAS")
                listar_dados()
                                     
            elif opcao_secundaria == 3:
                print("EDICAO DE DISCIPLINAS")
                editar_dados()
            
            elif opcao_secundaria == 4:
                print("EXCLUSAO DE DISCIPLINAS")
                excluir_dados()                
    elif opcao_secundaria == 5:
        print("SAINDO... ATE MAIS BONS ESTUDOS ;) ")  
        break  
    if opcao == 6:
        break
    else:
        print("voce digitou uma opcao invalida")

    
while True:
    opcao = menu_principal()
    
    if opcao == 3:
        
        print(f"Voce escolheu a OPCAO PROFESSORES, estamos mais perto.Quase la, selecione a opcao do menu de operacaoes! = ")
    
        while True:
            opcao_secundaria =  menu_secundario()
            
            if opcao_secundaria == 1:
                print("INCLUSAO DE PROFESSORES")
                cadastro_dados()     
               
            elif opcao_secundaria == 2:
                print("LISTAGEM DE PROFESSORES")
                listar_dados()
            
            elif opcao_secundaria == 3: 
                print("EDICAO DE PROFESSORES")
                editar_dados()                               
            
            elif opcao_secundaria == 4:                
               print("EXCLUSAO DE PROFESSORES")
               excluir_dados() 
            
    elif opcao_secundaria == 5:
        print("SAINDO ATE MAIS.... BONS ESTTUDOS ;") 
        break
    elif opcao == 6:
        break
    else:
        print("OPCAO INVALIDA... POR FAVOR TENTE NOVAMENTE")       

while True:
    opcao = menu_principal() 
    
    if opcao == 4:
        print("VOCE ESCOLHEU A OPCAO TURMAS")
        
        while True:
            opcao_secundaria =  menu_secundario()
            
            if opcao_secundaria == 1:
                print("INCLUSAO DE TURMAS")
                cadastrar_dados_turmas()
            
            if opcao_secundaria == 2:
                print("LISTAGENS DE TURMAS")
                listar_dados()
        
            if opcao_secundaria == 3:
                print("EDICAO DE DADOS")
                editar_dados()
        
            if opcao_secundaria == 4:
                print("EXCLUSAO DE TURMAS")
                excluir_dados()
    
    elif opcao_secundaria == 5:
        
        print("SAINDO .. ATE MAIS E BONS ESTUDOS :)")
        break
    
    else:
        print("OPCAO INVALIDA... POIS NAO ESTA NA LISTA DE OPCOES")
        
while True:
    opcao = menu_principal()
    
    if opcao  == 5:
        
        while True:
            opcao_secundaria =  menu_secundario()
                    
            if opcao_secundaria == 1:
                print("INCLUSAO DE MATRICULAS")
                cadastrar_matriculas()
            
            if opcao_secundaria == 2:
                print("LISTAGEM DE MATRICULAS")
                listar_matriculas()
            
            if opcao_secundaria == 3:
                print("EDICAO DE MATRICULAS")
                editar_matriculas()
             
            if opcao_secundaria == 4:
                print("EXCLUSAO DE MATRICULAS")
                excluir_matriculas()
    
    elif opcao_secundaria == 5:
        print("EXCLUSAO DE MATRICULAS!")
        break
    else:
        print("VOCE DIGITOU UM OPCAO INVALIDA POIS NAO ESTA NAS OPCOES")
        
        
                        
                
                
                    

                    
             
