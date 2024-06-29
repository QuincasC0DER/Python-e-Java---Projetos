
class Produto:
    def __init__(self, codigo, nome, preco, estoque):
        self.codigo = codigo
        self.nombre = nome
        self.precio = preco
        self.stock = estoque

    def mostrar_informacion(self):
        print(f"Código: {self.codigo}")
        print(f"Nome: {self.nome}")
        print(f"Preco: {self.preco}")
        print(f"Estoque: {self.estoque}")


class Cliente:
    def __init__(self, nome, email):
        self.nome = nome
        self.email = email
        email.append(clientes)
        nome.append(clientes)

class Registro_Compras:
    def __init__(self, nome):
        self.nome = nome
        self.produto = []

class agregar_produtos:
    def agregar_producto(self, produto):
        self.produtos.append(produto)



class exibir_produtos:
    def mostrar_produtos(self):
        print(f"Produtos eem {self.nome}:")
        for produto in self.produtos:
            produto.mostrar_informacao()

class busca_produtos:
    def buscar_produto(self, codigo):
        for produto in self.produtos:
            if produto.codigo == codigo:
                return produto
        return None

class vendas_produtos:
    def vender_producto(self, codigo, quantidade):
        produto = self.buscar_produto(codigo)
        if produto:
            if produto.stock >= quantidade:
                produto.stock -= quantidade
                print(f"Venda realizada: {quantidade} unidades de {produto}")
            else:
                print("Stock insuficiente.")
        else:
            print("Producto no encontrado.")

clientes = []

# Ejemplo de uso
print("Menu Sistema da Loja\n")
print("Exibir Informacoes Clientes\n")
print("Clientes\n")
print("Vendas\n")
print("sair\n")

while True:
    
    opcao = int(input("Digite a Opcao Desejada!\n"))
    if opcao == 1:
     
     agregar_produtos()
     print("Esta e a Lista de Produtos")
    
    if opcao == 2:
     Cliente()
     print("Este sao os dados dos clientes")
    
    elif opcao == 3:
     if Registro_Compras():
        print("Registro de Compras dos clientes")
    
    elif opcao == 4:
     if vendas_produtos():
        print("Lista de Produtos para Venda")
        
    else:
        print("Nao foi encontrado o produto")    
    break                    

print("Menu Secundaria para Selecao\n")
print("Condicoes de Pagamento\n")
print("A vista\n")
print("Prazo sem juros\n")
print("Prazo com juros\n")
