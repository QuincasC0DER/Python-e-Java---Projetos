import tkinter as tk
from tkinter import messagebox, simpledialog

class Produto:
    def __init__(self, id, nome, preco, estoque):
        self.id = id
        self.nome = nome
        self.preco = preco
        self.estoque = estoque

class Loja:
    def __init__(self):
        self.produtos = []

    def adicionar_produto(self, produto):
        self.produtos.append(produto)

    def listar_produtos(self):
        return [f"{p.id} - {p.nome}: R${p.preco:.2f} (Estoque: {p.estoque})" for p in self.produtos]

    def vender_produto(self, id_produto, quantidade):
        for produto in self.produtos:
            if produto.id == id_produto:
                if produto.estoque >= quantidade:
                    produto.estoque -= quantidade
                    total = quantidade * produto.preco
                    return f"Venda realizada: {quantidade}x {produto.nome} - Total: R${total:.2f}"
                else:
                    return "Estoque insuficiente."
        return "Produto não encontrado."

class App:
    def __init__(self, root):
        self.root = root
        self.root.title("Loja")
        self.loja = Loja()

        self.listagem = tk.Listbox(root, width=50)
        self.listagem.pack(pady=10)

        tk.Button(root, text="Adicionar Produto", command=self.adicionar_produto).pack(pady=5)
        tk.Button(root, text="Vender Produto", command=self.vender_produto).pack(pady=5)

    def atualizar_listagem(self):
        self.listagem.delete(0, tk.END)
        for produto in self.loja.listar_produtos():
            self.listagem.insert(tk.END, produto)

    def adicionar_produto(self):
        nome = simpledialog.askstring("Nome do Produto", "Digite o nome do produto:")
        preco = simpledialog.askfloat("Preço do Produto", "Digite o preço do produto:")
        estoque = simpledialog.askinteger("Estoque do Produto", "Digite a quantidade em estoque:")
        if nome and preco is not None and estoque is not None:
            id_produto = len(self.loja.produtos) + 1
            self.loja.adicionar_produto(Produto(id_produto, nome, preco, estoque))
            self.atualizar_listagem()
        else:
            messagebox.showerror("Erro", "Dados inválidos.")

    def vender_produto(self):
        id_produto = simpledialog.askinteger("ID do Produto", "Digite o ID do produto:")
        quantidade = simpledialog.askinteger("Quantidade", "Digite a quantidade:")
        if id_produto and quantidade:
            resultado = self.loja.vender_produto(id_produto, quantidade)
            messagebox.showinfo("Resultado da Venda", resultado)
            self.atualizar_listagem()
        else:
            messagebox.showerror("Erro", "Dados inválidos.")

if __name__ == "__main__":
    root = tk.Tk()
    app = App(root)
    root.mainloop()
