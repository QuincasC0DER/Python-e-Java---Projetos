import random

def jogar_forca(): # Funcao que inicializa o jogo com o placar zerado em erros e acertos.
    palavras = ['python', 'programacao', 'computador', 'algoritmo', 'dados']
    palavra_secreta = random.choice(palavras)
    letras_acertadas = ['_' for letra in palavra_secreta]
    enforcou = False
    acertou = False
    erros = 0

    print("Bem-vindo ao jogo da Forca!")  # Mensagem de Inicio

    while(not enforcou and not acertou): # Condicional While de negacao para enforcou e acertou executando a linha para digitar uma letra pela variavel chute.
        chute = input("Qual letra? ").strip().lower()

        if(chute in palavra_secreta): # Condicional para a entrada na variavel chute.
            index = 0 # Condicao do indice como zero para a letra chutada
            for letra in palavra_secreta: # altera o indice se o chute corresponder a uma letra da palavra secreta
                if (chute == letra):
                    letras_acertadas[index] = letra  # Atribui  o indice a letra somando - se 1 para os acertos. 
                index += 1
        else:
            erros += 1  # condicao para o erro , adiciona- se 1 a contagem erros se letra for diferente do chute .
            print("Você errou! Faltam {} tentativas".format(6-erros))

        enforcou = erros == 6 # Condicao para o enforcamento contabilizar 6 erros totais.
        acertou = '_' not in letras_acertadas # conta as letra acertadas 

        print(letras_acertadas)

    if(acertou):
        print("Você ganhou!") # condicao de vitoria ou seja acertar todas as letras antes de contabilizar 6 erros.
    else:
        print("Você perdeu!") # Condicao para mensagem de derrota ou seja errou em 6 tentativas
        print("A palavra era {}".format(palavra_secreta)) # Imprime a Palavra Secreta.

if(__name__ == "__main__"): # encerra a funcao jogo da forca e sai do programa.
    jogar_forca()