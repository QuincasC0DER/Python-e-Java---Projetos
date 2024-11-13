document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o envio padrão do formulário

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;

    //  processa os dados

    const message = document.getElementById('message');
    message.textContent = `Obrigado, ${name}! Seu e-mail ${email} foi enviado.`;
    message.classList.remove('hidden');

    // Limpa o formulário
    this.reset();
});

//  executada ao tentar enviar o formulário
document.getElementById("formulario").addEventListener("submit", function(event) {
    // evita que o formulário seja enviado imediatamente
    event.preventDefault();
    
    // obtem os valores dos campos do formulário
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const telefone = document.getElementById("telefone").value;
    const endereco = document.getElementById("endereco").value;
    const numero = document.getElementById("numero").value;
    const logradouro = document.getElementById("logradouro").value;
    
    //  Verifica se todos os campos estão preenchidos se sim exibe uma mensagem de aviso da necessidade de preenchimento de todos os campos
    if (!name || !email || !telefone || !endereco || !numero || !logradouro) {
        showMessage("Por favor, preencha todos os campos!", "error");
        return;
    }
    
    // mensagem de envio do formulario quando este foi enviado com sucesso
    showMessage("Formulário enviado com sucesso!", "success");

    // limpa o formulário
    document.getElementById("formulario").reset();
});

// função para exibir mensagens de sucesso ou erro
function showMessage(message, type) {
    const messageElement = document.getElementById("message");
    messageElement.textContent = message;
    
    // Definindo a classe dependendo do tipo de mensagem
    if (type === "success") {
        messageElement.style.color = "green";
        messageElement.style.fontWeight = "bold";
    } else {
        messageElement.style.color = "red";
        messageElement.style.fontWeight = "bold";
    }
    
    // mostra a mensagem na tela
    messageElement.classList.remove("hidden");
    
    //  a mensagem sai da tela após 5 segundos
    setTimeout(() => {
        messageElement.classList.add("hidden");
    }, 5000);
}
