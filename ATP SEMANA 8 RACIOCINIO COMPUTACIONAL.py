import json

def exibir_menu_principal():
    print("============================================================== BEM VINDO AO MENU PRINCIPAL ESTUDANTE SELECIONE UMA DAS OPCOES LISTADAS :)=======================")       
    print(".1 [ESTUDANTES]\n")
    print("2. [DISCIPLINAS]\n")
    print("3. [PROFESSORES] \n")
    print("4. [TURMAS]\n")
    print("5. [MATRICULAS]\n")
    print("6.[SAIR]\n")
    
    return  int(input("Escolha uma das opcoes =  "))

def exibir_menu_de_operacoes():
    
    print("1. [INCLUIR]\n")
    print("2.[LISTAR]\n")
    print("3. [EDITAR]\n")
    print("4. [EXCLUIR]\n")
    print("5. [VOLTAR AO MENU PRINCIPAL]\n")
    
    return int(input("Digite a opcao desejada = "))
    

def incluir_estudante(nome_arquivo):
     nome = input("Digite o nome do estudandade = ")
     cpf = input("Digite o CPF do estudante = ")
     codigo = int(input("Digite o codigo do estudante = "))
     novo_estudante = {
     "Codigo": codigo,
     "Nome": nome,
     "CPF": cpf
                }
     lista_aleatoria = ler_arquivo(nome_arquivo)
     lista_aleatoria.append(novo_estudante)
     salvar_arquivo(lista_aleatoria, nome_arquivo)
     print(f"Estudante Incluido com Sucesso \n A Lista de Estudantes Atualizada = {lista_aleatoria}")

def listar_cadastro(nome_arquivo):
    lista_aleatoria = ler_arquivo(nome_arquivo)
    if len(lista_aleatoria) == 0:
        print("Ninguem Cadastrado :( ")
    else:
        print("Voce escolheu a {opcao_secundaria}")
    for cadastro in lista_aleatoria:
        print(f"Os dados do cadastro sao {cadastro}")

def editar_cadastro(codigo, nome_arquivo):
    lista_aleatoria = ler_arquivo(nome_arquivo)
    for cadastro in lista_aleatoria:
     if cadastro["Codigo"] == codigo:
         cadastro["Nome"] = input("Digite um novo nome=  ")
         cadastro["CPF"] = input("Digite o novo CPF=  ")                        
         cadastro["Codigo"] = int(input("Digite o codgigo= "))
         lista_aleatoria = ler_arquivo(nome_arquivo)
         salvar_arquivo(lista_aleatoria, nome_arquivo)
         return 
     if ["Codigo"] == codigo:
         print("Estudante Alterado com Sucesso! ")    
    else:
        print("Codigo nao encontrado, verifique o codigo e tente novamente")   
                       

def excluir_cadastro(codigo, nome_arquivo):
    cadastro_para_remover = None                                                                                   
    lista_aleatoria = ler_arquivo(nome_arquivo)
    for estudante in lista_aleatoria:
        if estudante["Codigo"] == codigo:                        
         cadastro_para_remover = estudante
         break
    if cadastro_para_remover is not None:
    
        lista_aleatoria.remove(cadastro_para_remover)
        salvar_arquivo(lista_aleatoria, nome_arquivo)
        print("Estudante removido com sucesso!")

def salvar_arquivo(lista_aleatoria, nome_arquivo):
    with open(nome_arquivo, "w") as arquivo_aberto:
        json.dump(lista_aleatoria, arquivo_aberto)
         
def ler_arquivo(nome_arquivo):
  try:   
      with open(nome_arquivo, 'r') as arquivo_aberto :
        lista_aleatoria = json.load(arquivo_aberto)
   
      return lista_aleatoria     
  except:
      return []     

def ler_menu_operacoes(opcao_secundaria, nome_arquivo):
     if opcao_secundaria == 1:
               
               incluir_estudante(nome_arquivo)
          
     elif opcao_secundaria == 2:
                
         listar_cadastro(nome_arquivo)       
          
     elif opcao_secundaria == 3:
        codigo = int(input("Digite o codigo do estudante a ser editado= "))
        editar_cadastro(codigo, nome_arquivo)
          
     elif opcao_secundaria == 4:
        codigo = int(input("Digite o codigo do estudante a ser removido"))
        excluir_cadastro(codigo,  nome_arquivo)    
           
     elif opcao_secundaria == 5:
        print("Voltando ao menu principal...")
        return False                       
     else:
        print("Voce digitou  uma opcao invalida")

     return True

arquivo_estudantes = "arquivo_estudantes.json"
arquivo_diciplinas = "arquivo_disciplinas.json"   
while True:
  opcao = exibir_menu_principal()

  if opcao == 1:

        while True:
          
          opcao_secundaria =  exibir_menu_de_operacoes()
          if not ler_menu_operacoes(opcao_secundaria, arquivo_estudantes):
              break
          if opcao_secundaria == 1:
               
               incluir_estudante(arquivo_estudantes)
          
          elif opcao_secundaria == 2:
                
                listar_cadastro(arquivo_estudantes)       
          
          elif opcao_secundaria == 3:
              codigo = int(input("Digite o codigo do estudante a ser editado= "))
              editar_cadastro(codigo, arquivo_estudantes)
          
          elif opcao_secundaria == 4:
              codigo = int(input("Digite o codigo do estudante a ser removido"))
              excluir_cadastro(codigo, arquivo_estudantes)    
           
          elif opcao_secundaria == 5:
             print("Voltando ao menu principal...")
             break                               
  
  elif opcao == 6:
        print("Ate Logo e Bons Estudos :)")  
        break
  
  
  if opcao == 2:
    print(f"Voce escolheu a {opcao} ")
    while True:
          opcao_secundaria =  exibir_menu_de_operacoes()
          if not ler_menu_operacoes(opcao_secundaria, arquivo_estudantes):
              break
             
  if opcao == 3:
      print(f"Voce escolheu a {opcao} ")                          
      while True:
          opcao_secundaria = exibir_menu_de_operacoes()
          if not ler_menu_operacoes(opcao_secundaria, arquivo_estudantes):
             break       
  if opcao == 4:
      print(f"Voce escolheu a {opcao} ")                          
      while True:
          opcao_secundaria = exibir_menu_de_operacoes()
          if not ler_menu_operacoes(opcao_secundaria, arquivo_estudantes):
             break  
   
  if opcao == 5:
      print(f"Voce escolheu a opcao{opcao}")
      while True:
          opcao_secundaria = exibir_menu_de_operacoes()
          if not ler_menu_operacoes(opcao_secundaria, arquivo_estudantes):
              break                    
  
  else:
      print("Saindo do Programa")
      break       