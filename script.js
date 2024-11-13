let currentIndex = 0;
const slides = document.querySelectorAll('.slide fade');

function showSlide(index) {
    slides.forEach((slide, i) => {
        slide.style.display = (i === index) ? 'flex' : 'none';
    });
}

function nextSlide() {
    currentIndex = (currentIndex + 1) % slides.length; /*tamanho dos slides */
    showSlide(currentIndex); /* Exibe o slide selecionado pelo index */
}

showSlide(currentIndex);
setInterval(nextSlide, 1000); // Muda de slide a cada segundo (intervalo de 1 segundo)



let carrinho = [];

// Função para atualizar o carrinho na interface
function atualizarCarrinho() {
    const listaCarrinho = document.getElementById('carrinho-lista');
    const totalValor = document.getElementById('total-valor');
    
    // Limpa a lista de itens no carrinho
    listaCarrinho.innerHTML = '';
    
    let total = 0;
    
    // Adiciona cada produto do carrinho na lista
    carrinho.forEach(item => {
        const li = document.createElement('li');
        li.textContent = `${item.name} - R$ ${item.price.toFixed(2)}`;
        listaCarrinho.appendChild(li);
        total += item.price;
    });
    
    // Atualiza o valor total
    totalValor.textContent = total.toFixed(2);
}

// Função para adicionar item ao carrinho
function adicionarAoCarrinho(nome, preco) {
    carrinho.push({ name: nome, price: parseFloat(preco) });
    atualizarCarrinho();
}

// Adiciona os eventos de clique nos botões de "Adicionar ao Carrinho"
document.querySelectorAll('.btn-comprar').forEach(button => {
    button.addEventListener('click', function() {
        const produto = this.closest('.produto');
        const nomeProduto = produto.getAttribute('data-name');
        const precoProduto = produto.getAttribute('data-price');
        
        adicionarAoCarrinho(nomeProduto, precoProduto);
    });
});

// Evento para finalizar a compra
document.getElementById('finalizar-compra').addEventListener('click', function() {
    if (carrinho.length > 0) {
        alert('Compra finalizada com sucesso!');
        carrinho = []; // Limpa o carrinho após a compra
        atualizarCarrinho(); // Atualiza a interface
    } else {
        alert('Carrinho vazio! Adicione produtos ao carrinho antes de finalizar a compra.');
    }
});

