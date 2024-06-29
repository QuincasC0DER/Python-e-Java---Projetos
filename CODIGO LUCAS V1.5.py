 # Nome estudante = Lucas Quincas Suzin  Curso = ADS Disciplina = Raciocínio Computacional
def menu_principal():
    print("***** ----------------------------------Menu Principal--------------------------------------- ********")
    print("1- Gerenciar Estudantes.\n")
    print("2- Gerenciar Professores.\n")
    print("3- Gerenciar Disciplinas.\n")
    print("4- Gerenciar Turmas\n")
    print("5- Gerenciar Matriculas\n")
    print("7- Sair do Programa\n")
    print(estudantes)
        
    return int(input("Digite a opcao de sua escolha aluno ! =   "))

def menu_secundario():
    print(" Menu de Escolhas")
    print("[1]- Incluir\n")
    print("[2]- Listar\n")
    print("[3]- Atualizar\n")
    print("[4]- Excluir\n")
    print("[5]- Voltar ao menu principal\n")
    
    return int(input("Selecione a opcao desejada acima =  ")) # entrada do valor numérico pelo usúario para seleção das opções do segundo menu.(menu(CRUD))
            
def incluir_estudante():
    for i in range(1):    
        nome = input("Por favor insira o Nome do estudante!:  \n  ")  
        codigo = int(input("Por favor , digite o CODIGO DE ESTUDANTE?:  \n"))
        cpf = (input("Digite por favor, seu CPF:  "))
                        
        dicionario_estudante = {}
        dicionario_estudante["nome"] = nome
        dicionario_estudante["codigo"] = codigo
        dicionario_estudante["cpf"] = cpf
                        
        estudantes.append(estudantes) # insere o valor resgatado com o input da variavel (nomes) na lista [estudantes]
        print("Estudante Incluido\n")
                  

        
def listar_estudantes():
    print("Listando Registro estudantes\n")
    for estudante in estudantes:
         print(estudantes)

estudantes = []  # Lista estudantes onde serao armazenados os nomes dos estudantes inseridos na opcão do segundo menu "Inserir"

def atualizar_estudantes():
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
            return codigo_para_atualizar   
def excluir_estudantes():
                codigo_para_excluir = int(input('Digite o codigo para excluir  '))            
                
                estudante_para_ser_removido = None
                for dicionario_estudante in estudantes:
                         if dicionario_estudante["codigo"] == codigo_para_excluir:
                             estudante_para_ser_removido = dicionario_estudante
                             break                                              
                if estudante_para_ser_removido is None:
                    print(f"Estudante de codigo {codigo_para_excluir} nao foi encontrado")
                
                else:
                    estudantes.remove(estudante_para_ser_removido)                    
                print(estudantes)
                return codigo_para_excluir
def sair_do_programa():
                
 print("Voltando ao Menu Principal\n") # selecao para voltar ao menu principal sem encerar o programa devido a estrutura de loop (continue).
                        
                
def finalizar_programa():
    exit            


menu_principal()

opcao = 1 or 2 or 3 or 4 or 5

escolha=1 # define o valor de seleção para a variável registro equivalente a string estudantes.

menu_secundario()


while escolha!= 5: 
             
            
            
        if opcao == 1: 
                 incluir_estudante()                                                                                            
                 continue     
                
        if opcao == 2:
                  listar_estudantes()
                  continue
                             
        if opcao == 3:                
                 atualizar_estudantes()
                 continue  
        if opcao == 4:
                excluir_estudantes()
                continue           
        if opcao == 5:
                sair_do_programa()            
                break      


print("Finalizando Operacao")            
finalizar_programa()



