import java.util.UUID;

class Produto {
    private String id = UUID.randomUUID().toString(); // ID único gerado automaticamente
    private String nome, categoria;
    private int quantidade;
    private double preco;

    public Produto(String nome, String categoria, int quantidade, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Categoria: " + categoria +
                " | Estoque: " + quantidade +
                " | Preço: R$ " + preco;
    }
}