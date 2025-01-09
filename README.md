<section>
    <p>Este projeto é um sistema simples de gerenciamento de inventário desenvolvido em Java. Ele permite que o usuário cadastre, atualize, exclua, busque e ordene produtos armazenados em uma lista. Abaixo está uma descrição detalhada de cada funcionalidade e das motivações por trás de cada escolha de design.</p>
</section>

<section>
    <h2>Estrutura do Código</h2>
    <article>
        <h3>Classe <code>Produto</code></h3>
        <p>A classe <code>Produto</code> é usada para representar um item do inventário. Cada produto possui os seguintes atributos:</p>
        <ul>
            <li><strong><code>id</code></strong>: Um identificador único gerado automaticamente para cada produto usando <code>UUID</code>.</li>
            <li><strong><code>nome</code></strong>: O nome do produto.</li>
            <li><strong><code>categoria</code></strong>: A categoria à qual o produto pertence.</li>
            <li><strong><code>quantidade</code></strong>: A quantidade em estoque do produto.</li>
            <li><strong><code>preco</code></strong>: O preço do produto.</li>
        </ul>
        <p>A classe também inclui:</p>
        <ul>
            <li>Construtor para inicializar os atributos do produto.</li>
            <li>Métodos getter e setter para acessar e modificar os valores dos atributos.</li>
            <li>Um método <code>toString</code> para formatar a exibição de informações do produto.</li>
        </ul>
    </article>

  <article>
        <h3>Classe <code>GerenciadorInventario</code></h3>
        <p>Essa classe gerencia a lista de produtos do inventário e oferece as funcionalidades principais:</p>

  <h4>1. Adicionar Produtos</h4>
        <ul>
            <li>Permite que o usuário insira os dados de um novo produto.</li>
            <li>Valida os dados de entrada, garantindo que a quantidade e o preço sejam números válidos.</li>
            <li>Adiciona o produto à lista de inventário.</li>
        </ul>
<h4>2. Atualizar Produto</h4>
        <ul>
            <li>Busca um produto pelo seu <code>id</code>.</li>
            <li>Permite que o usuário escolha qual atributo atualizar: nome, categoria, quantidade ou preço.</li>
            <li>Valida as entradas do usuário antes de aplicar as modificações.</li>
        </ul>
        <h4>3. Excluir Produto</h4>
        <ul>
            <li>Busca um produto pelo seu <code>id</code>.</li>
            <li>Exibe os detalhes do produto encontrado e solicita confirmação do usuário antes de excluí-lo.</li>
            <li>Remove o produto da lista caso a confirmação seja positiva.</li>
        </ul>
        <h4>4. Buscar Produto</h4>
        <p>Oferece duas formas de busca:</p>
        <ul>
            <li><strong>Por ID</strong>: Encontra um produto exato pelo identificador.</li>
            <li><strong>Por Nome ou Parte do Nome</strong>: Busca produtos cujo nome contenha o termo inserido pelo usuário (ignora maiúsculas/minúsculas).</li>
        </ul>
        <h4>5. Ordenar Produtos</h4>
        <p>Permite ordenar os produtos com base em diferentes critérios:</p>
        <ul>
            <li>Nome (alfabético).</li>
            <li>Quantidade (ordem crescente).</li>
            <li>Preço (ordem crescente).</li>
        </ul>
        <p>A ordenação é realizada usando comparadores, garantindo que a lista permaneça consistente.</p>
    </article>
    <article>
        <h3>Classe <code>Main</code></h3>
        <p>Essa classe implementa o ponto de entrada do programa e exibe o menu principal para o usuário.</p>
        <h4>Menu Principal</h4>
        <ul>
            <li>O programa exibe as opções de funcionalidade em um loop.</li>
            <li>Recebe a entrada do usuário e chama o método correspondente na classe <code>GerenciadorInventario</code>.</li>
            <li>Inclui tratamento de erros para entradas inválidas, como letras em vez de números.</li>
        </ul>
    </article>
</section>

<section>
    <h2>Decisões de Design</h2>
    <ul>
        <li><strong>Uso de UUID</strong>: Garante que cada produto tenha um identificador único, reduzindo o risco de conflitos.</li>
        <li><strong>Encapsulamento</strong>: Os atributos da classe <code>Produto</code> são privados e acessíveis por meio de métodos getter e setter. Isso segue boas práticas de programação orientada a objetos.</li>
        <li><strong>Flexibilidade do Menu</strong>: O menu principal usa um loop que permite ao usuário realizar múltiplas operações sem reiniciar o programa. Tratamento de exceções evita que entradas inválidas quebrem o programa.</li>
        <li><strong>Separação de Responsabilidades</strong>: A classe <code>GerenciadorInventario</code> concentra as funcionalidades relacionadas ao inventário, enquanto a classe <code>Main</code> gerencia a interface com o usuário.</li>
        <li><strong>Validação de Dados</strong>: Os dados inseridos pelo usuário são validados para evitar entradas incorretas e garantir a integridade do sistema.</li>
    </ul>
</section>

<footer>
    <p>Este sistema foi projetado com foco em simplicidade e boas práticas de programação. Ele serve como base para um sistema de inventário mais robusto e completo.</p>
</footer>
