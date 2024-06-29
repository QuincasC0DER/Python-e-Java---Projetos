total_ingressos = 100 # Sistema de Venda de Ingressos.
comum = 20 # Nesta Parte definimos os valores do Ingressos Tipo Comun - no caso 20 reais.
estudante = 10 # O mesmo vale para esse no caso ingresso estudante 10 reais.
quantidade_ingressos = int(input("Digite a quantidade que pretende comprar para verificar nosso estoque  "))
def calcular_preco(): # Funcao criada para fazer o calculo do preco dos Ingressos.
    quantidade = int(input("Digite a quantidade de ingressos que deseja comprar!"))
    tipo = estudante or comum # aqui há a opcao de escolha para o tipo de ingresso
    if tipo!= comum: # selecao se o ingresso for diferente de comun ele cai como tipo estudante.
     preco_final = estudante * quantidade # Operacao de Calculo do preco final
     print(f"O preco final e {preco_final}") # impressao da mensagem com resgate do valor da variavel preco_final
    else: # Se nao o tipo sera igual a comum logo percorera essa linha
        if tipo == comum:
            preco_final = comum * quantidade # Calculo do preco final para percorre o ingresso tipo comum.
            return preco_final  

def exibir_total_ingressos():
    print(f"tinhamos disponiveis {total_ingressos}")
    ingressos_restantes = total_ingressos - quantidade_ingressos
    print(f"restam{ingressos_restantes} ")
    
input("digite o tipo de ingresso que deseja comprar escolha")
print("Estudante - 01")
print("Comum - 02")
if input == comum:
    calcular_preco()
else:
    calcular_preco()
    
print("Exibiremos a quantidade de ingressos restantes a seguir")
exibir_total_ingressos()

print("Ola , como podemos ajudar voce hoje nessa compra")
input("Digite o tipo de ingresso que deseja comprar hoje!")
if input == "comum":
    total_pagar = quantidade_ingressos * comum
    print(f"Este e valor total dos ingressos a serem pagos{total_ingressos}")
else:
    input == "estudante"
    total_pagar = quantidade_ingressos *estudante
    print(f"Este e o valor do total de ingressos{total_pagar}")
    while True:
        input("Deseja realizar mais alguma compra")
        if input == "sim":
            continue




            