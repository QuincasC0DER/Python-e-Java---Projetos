 // Função para capturar e mostrar o input de sugestão
 document.getElementById('enviarSugestao').addEventListener('click', function() {
    // Obter o valor do input de sugestão
    const sugestao = document.getElementById('sugestao').value;

    // Verificar se o campo não está vazio
    if (sugestao.trim() === "") {
        document.getElementById('resultado').textContent = "Por favor, insira uma sugestão.";
        document.getElementById('resultado').style.color = "red";
    } else {
        // Exibir a sugestão no campo de resultado
        document.getElementById('resultado').textContent = "Sugestão recebida: " + sugestao;
        document.getElementById('resultado').style.color = "green";
        
        // Aqui você pode realizar outras ações, como enviar esses dados para um servidor.
        // Por exemplo, usar fetch() para enviar para uma API ou armazenar localmente.
        
        // Limpar o campo de input após o envio
        document.getElementById('sugestao').value = "";
    }
});