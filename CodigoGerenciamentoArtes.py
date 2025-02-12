import tkinter as tk
from tkinter import ttk, messagebox

dicionario = {} # Dicionario para armazenar os Dados das Artes 

def listar_modelos(): # Função para Listar as Artes de Modelos 
    if not dicionario:
        messagebox.showinfo("Lista de Modelos", "Nenhum modelo adicionado.")
    else:
        modelos_texto = "\n".join([f"Nome: {modelo}, Quantidade: {dicionario[modelo][0]}, Preço: {dicionario[modelo][1]}" for modelo in dicionario])
        messagebox.showinfo("Lista de Modelos", modelos_texto)
        with open("Artes Registradas Listagem.txt", 'a') as arquivo:
            for modelo, (quantidade, preco) in dicionario.items():
                arquivo.write(f"Nome: {modelo}, Quantidade: {quantidade}, Preço: {preco}\n")
        print("Modelos Listados")

def adicionar_modelos():
    modelo = entry_modelo.get()
    quantidade = entry_quantidade.get()
    preco = entry_preco.get()  
    if modelo and quantidade and preco:
        try:
            quantidade = int(quantidade)
            preco = float(preco)
            dicionario[modelo] = (quantidade, preco)
            messagebox.showinfo("Sucesso", f"Modelo '{modelo}' adicionado com sucesso! Quantidade: {quantidade}, Preço: {preco}")
            # Adicionando ao arquivo
            with open("Artes Registradas Adição.txt", 'a') as arquivo:
                arquivo.write(f"Nome: {modelo}, Quantidade: {quantidade}, Preço: {preco}\n")
            print(f"Modelo Adicionado: {modelo}, Quantidade: {quantidade}, Preço: {preco}")
        except ValueError:
            messagebox.showerror("Erro", "Por favor, insira valores válidos.")
    else:
        messagebox.showerror("Erro", "Por favor, preencha todos os campos.")

def editar_modelos():
    modelo = entry_modelo.get()
    quantidade = entry_quantidade.get()
    preco = entry_preco.get() 
    if modelo in dicionario:
        try:
            nova_quantidade = int(quantidade)
            novo_preco = float(preco)
            dicionario[modelo] = (nova_quantidade, novo_preco)
            messagebox.showinfo("Sucesso", f"Modelo '{modelo}' editado com sucesso! Nova Quantidade: {nova_quantidade}, Novo Preço: {novo_preco}")
            # Editando no arquivo de logs
            with open("Artes Registradas Editadas.txt", 'a') as arquivo:
                arquivo.write(f"Nome: {modelo}, Quantidade: {nova_quantidade}, Preço: {novo_preco}\n")
            print(f"Modelo Editado: {modelo}, Quantidade: {nova_quantidade}, Preço: {novo_preco}")
        except ValueError:
            messagebox.showerror("Erro", "Por favor, insira valores válidos.")
    else:
        messagebox.showerror("Erro", f"O modelo '{modelo}' não existe.")

def excluir_modelos():
    modelo = entry_modelo.get()
    if modelo in dicionario:
        del dicionario[modelo]
        messagebox.showinfo("Sucesso", f"Modelo '{modelo}' excluído com sucesso!")
        # Excluindo no arquivo de logs
        with open("Artes Registradas Exclusão.txt", 'a') as arquivo:
            arquivo.write(f"Modelo excluído: {modelo}\n")
        print(f"Modelo Excluído: {modelo}")
    else:
        messagebox.showerror("Erro", f"O modelo '{modelo}' não existe.")

def vender_modelo():
    modelo = entry_modelo.get()
    quantidade = entry_quantidade.get()
    preco = entry_preco.get() 
    if modelo in dicionario:
        try:
            quantidade = int(quantidade)
            preco = float(preco)
            estoque, preco_registrado = dicionario[modelo]
            if estoque >= quantidade:
                dicionario[modelo] = (estoque - quantidade, preco_registrado)
                # Registrando a venda no arquivo
                with open("Artes Registradas Vendas.txt", 'a') as arquivo:
                    arquivo.write(f"Modelo: {modelo}, Quantidade Vendida: {quantidade}, Preço: {preco}\n")
                messagebox.showinfo("Venda realizada com Sucesso", f"Modelo '{modelo}' foi vendido.")
                print(f"Venda Realizada: Modelo: {modelo}, Quantidade: {quantidade}, Preço: {preco}")
            else:
                messagebox.showerror("Erro", f"Estoque insuficiente para o modelo '{modelo}'.")
        except ValueError:
            messagebox.showerror("Erro", "Por favor, insira valores válidos.")
    else:
        messagebox.showerror("Erro", f"O modelo '{modelo}' não existe.")

def criar_interface():
    global entry_modelo, entry_quantidade, entry_preco

    root = tk.Tk()
    root.title("Sistema de Gerenciamento de Modelos")
    root.geometry("400x300")
    root.config(bg="#363636")  # Cor do Fundo do Aplicativo. 

    # Estilos modernizados
    style = ttk.Style()
    style.configure("TButton",
                    background="#34495E",
                    foreground="#2F4F4F",
                    font=("Times New Roman", 12, "bold"),
                    padding=10)
    style.configure("TLabel",
                    background="#2C3E50",
                    foreground="#ECF0F1",
                    font=("Helvetica", 12))

    # Labels e entradas
    ttk.Label(root, text="Nome do Modelo:" ).grid(row=0, column=0, padx=10, pady=5, sticky="w")
    entry_modelo = ttk.Entry(root, width=25)
    entry_modelo.grid(row=0, column=1, padx=10, pady=5)

    ttk.Label(root, text="Quantidade:").grid(row=1, column=0, padx=10, pady=5, sticky="w")
    entry_quantidade = ttk.Entry(root, width=25)
    entry_quantidade.grid(row=1, column=1, padx=10, pady=5)

    ttk.Label(root, text="Preço:").grid(row=2, column=0, padx=10, pady=5, sticky="w")
    entry_preco = ttk.Entry(root, width=25)
    entry_preco.grid(row=2, column=1, padx=10, pady=5)

    # Botões
    ttk.Button(root, text="Adicionar Modelo", command=adicionar_modelos).grid(row=3, column=0, padx=10, pady=10, sticky="ew")
    ttk.Button(root, text="Editar Modelo", command=editar_modelos).grid(row=3, column=1, padx=10, pady=10, sticky="ew")
    ttk.Button(root, text="Excluir Modelo", command=excluir_modelos).grid(row=4, column=0, padx=10, pady=10, sticky="ew")
    ttk.Button(root, text="Vender Modelo", command=vender_modelo).grid(row=4, column=1, padx=10, pady=10, sticky="ew")
    ttk.Button(root, text="Listar Modelos", command=listar_modelos).grid(row=5, column=0, columnspan=2, padx=10, pady=10, sticky="ew")

    root.mainloop()

if __name__ == "__main__":
    criar_interface()
