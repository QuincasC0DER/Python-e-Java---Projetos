import tkinter as tk
from tkinter import messagebox

dicionario = {}
def listar_modelos():
    if not dicionario:
        messagebox.showinfo("Lista de Modelos", "Nenhum modelo adicionado.")
    else:
        modelos_texto = "\n".join([f"Nome: {modelo}, Quantidade: {dicionario[modelo]}" for modelo in dicionario])
        messagebox.showinfo("Lista de Modelos", modelos_texto)
def adicionar_modelos():
    modelo = entry_modelo.get()
    quantidade = entry_quantidade.get()  
    if modelo and quantidade:
        try:
            quantidade = int(quantidade)
            dicionario[modelo] = quantidade
            messagebox.showinfo("Sucesso", f"Modelo '{modelo}' adicionado com sucesso! Quantidade: {quantidade}")
        except ValueError:
            messagebox.showerror("Erro", "Por favor, insira uma quantidade válida (número).")
    else:
        messagebox.showerror("Erro", "Por favor, preencha todos os campos.")
def editar_modelos():
    modelo = entry_modelo.get()
    if modelo in dicionario:
        nova_quantidade = entry_quantidade.get()
        try:
            nova_quantidade = int(nova_quantidade)
            dicionario[modelo] = nova_quantidade
            messagebox.showinfo("Sucesso", f"Modelo '{modelo}' editado com sucesso! Nova Quantidade: {nova_quantidade}")
        except ValueError:
            messagebox.showerror("Erro", "Por favor, insira uma quantidade válida (número).")
    else:
        messagebox.showerror("Erro", f"O modelo '{modelo}' não existe.")
def excluir_modelos():
    modelo = entry_modelo.get()
    if modelo in dicionario:
        del dicionario[modelo]
        messagebox.showinfo("Sucesso", f"Modelo '{modelo}' excluído com sucesso!")
    else:
        messagebox.showerror("Erro", f"O modelo '{modelo}' não existe.")
def exibir_menu():
    menu_frame.pack_forget()
    frame_opcoes.pack()  
def voltar_menu_principal():
    frame_opcoes.pack_forget()  
    menu_frame.pack()  

janela = tk.Tk()
janela.title("Gerenciamento de Modelos")
janela.geometry("600x400")

menu_frame = tk.Frame(janela)

label = tk.Label(menu_frame, text="Sistema de Gerenciamento de Modelos de Artes", font=("Arial", 16))
label.pack(pady=20)

btn_adicionar = tk.Button(menu_frame, text="Adicionar Modelo", command=exibir_menu)
btn_adicionar.pack(pady=10)

btn_listar = tk.Button(menu_frame, text="Listar Modelos", command=listar_modelos)
btn_listar.pack(pady=10)

btn_sair = tk.Button(menu_frame, text="Sair", command=janela.quit)
btn_sair.pack(pady=10)

menu_frame.pack()

frame_opcoes = tk.Frame(janela)

label_modelo = tk.Label(frame_opcoes, text="Modelo:")
label_modelo.grid(row=0, column=0, padx=10, pady=10)

entry_modelo = tk.Entry(frame_opcoes)
entry_modelo.grid(row=0, column=1, padx=10, pady=10)

label_quantidade = tk.Label(frame_opcoes, text="Quantidade:")
label_quantidade.grid(row=1, column=0, padx=10, pady=10)

entry_quantidade = tk.Entry(frame_opcoes)
entry_quantidade.grid(row=1, column=1, padx=10, pady=10)

btn_adicionar_modelo = tk.Button(frame_opcoes, text="Adicionar Modelo", command=adicionar_modelos)
btn_adicionar_modelo.grid(row=2, column=0, padx=10, pady=10)

btn_editar_modelo = tk.Button(frame_opcoes, text="Editar Modelo", command=editar_modelos)
btn_editar_modelo.grid(row=2, column=1, padx=10, pady=10)

btn_excluir_modelo = tk.Button(frame_opcoes, text="Excluir Modelo", command=excluir_modelos)
btn_excluir_modelo.grid(row=3, column=0, padx=10, pady=10)

btn_voltar = tk.Button(frame_opcoes, text="Voltar ao Menu Principal", command=voltar_menu_principal)
btn_voltar.grid(row=3, column=1, padx=10, pady=10)


janela.mainloop()
