# Lista global para armazenar os cadastros
cadastros = {
    'estudantes': [],
    'disciplinas': [],
    'professores': [],
    'turmas': [],
    'matriculas': []
}

def menu_principal():
    """Exibe o menu principal e retorna a opção escolhida."""
    print("\n===== Menu Principal =====")
    print("1. Estudantes")
    print("2. Disciplinas")
    print("3. Professores")
    print("4. Turmas")
    print("5. Matrículas")
    print("6. Sair")
    
    while True:
        try:
            opcao = int(input("\nEscolha uma opção (1-6): "))
            if 1 <= opcao <= 6:
                return opcao
            print("Opção inválida. Digite um número entre 1 e 6.")
        except ValueError:
            print("Entrada inválida. Digite um número.")

def menu_secundario():
    """Exibe o menu secundário e retorna a opção escolhida."""
    print("\n===== Operações =====")
    print("1. Incluir")
    print("2. Listar")
    print("3. Editar")
    print("4. Excluir")
    print("5. Voltar ao Menu Principal")
    
    while True:
        try:
            opcao = int(input("\nEscolha uma opção (1-5): "))
            if 1 <= opcao <= 5:
                return opcao
            print("Opção inválida. Digite um número entre 1 e 5.")
        except ValueError:
            print("Entrada inválida. Digite um número.")

def cadastrar_item(tipo, campos):
    """Função genérica para cadastrar itens."""
    novo_cadastro = {}
    for campo, tipo_campo in campos.items():
        while True:
            valor = input(f"Digite {campo}: ")
            try:
                novo_cadastro[campo] = tipo_campo(valor)
                break
            except ValueError:
                print(f"Valor inválido para {campo}. Tente novamente.")
    
    cadastros[tipo].append(novo_cadastro)
    print(f"\n{tipo.title()} cadastrado(a) com sucesso!")

def listar_itens(tipo):
    """Função genérica para listar itens."""
    if not cadastros[tipo]:
        print(f"\nNenhum(a) {tipo} cadastrado(a).")
        return
    
    print(f"\n===== Lista de {tipo.title()} =====")
    for item in cadastros[tipo]:
        print(item)

def editar_item(tipo, campos):
    """Função genérica para editar itens."""
    if not cadastros[tipo]:
        print(f"\nNenhum(a) {tipo} cadastrado(a).")
        return

    codigo = int(input(f"Digite o código do(a) {tipo} para editar: "))
    
    for item in cadastros[tipo]:
        if item.get('codigo') == codigo:
            for campo, tipo_campo in campos.items():
                while True:
                    valor = input(f"Digite novo {campo} (Enter para manter atual): ")
                    if not valor:
                        continue
                    try:
                        item[campo] = tipo_campo(valor)
                        break
                    except ValueError:
                        print(f"Valor inválido para {campo}. Tente novamente.")
            print(f"\n{tipo.title()} atualizado(a) com sucesso!")
            return
    
    print(f"\nCódigo de {tipo} não encontrado.")

def excluir_item(tipo):
    """Função genérica para excluir itens."""
    if not cadastros[tipo]:
        print(f"\nNenhum(a) {tipo} cadastrado(a).")
        return

    codigo = int(input(f"Digite o código do(a) {tipo} para excluir: "))
    
    for item in cadastros[tipo]:
        if item.get('codigo') == codigo:
            cadastros[tipo].remove(item)
            print(f"\n{tipo.title()} excluído(a) com sucesso!")
            return
    
    print(f"\nCódigo de {tipo} não encontrado.")

def main():
    """Função principal do programa."""
    CAMPOS = {
        'estudantes': {'codigo': int, 'nome': str, 'cpf': str},
        'disciplinas': {'codigo': int, 'nome': str},
        'professores': {'codigo': int, 'nome': str, 'cpf': str},
        'turmas': {'codigo': int, 'disciplina': str, 'professor': str},
        'matriculas': {'codigo': int, 'estudante': int, 'turma': int}
    }
    
    TIPOS = ['estudantes', 'disciplinas', 'professores', 'turmas', 'matriculas']
    
    while True:
        opcao_principal = menu_principal()
        
        if opcao_principal == 6:
            print("\nSaindo... Até mais! 👋")
            break
            
        if 1 <= opcao_principal <= 5:
            tipo_atual = TIPOS[opcao_principal - 1]
            print(f"\nGerenciando {tipo_atual.title()}")
            
            while True:
                opcao_secundaria = menu_secundario()
                
                if opcao_secundaria == 5:
                    break
                    
                if opcao_secundaria == 1:
                    cadastrar_item(tipo_atual, CAMPOS[tipo_atual])
                elif opcao_secundaria == 2:
                    listar_itens(tipo_atual)
                elif opcao_secundaria == 3:
                    editar_item(tipo_atual, CAMPOS[tipo_atual])
                elif opcao_secundaria == 4:
                    excluir_item(tipo_atual)

if __name__ == "__main__":
    main()