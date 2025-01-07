import java.util.UUID;

class Produto {
    private String id;
    private String nome;
    private String categoria;
    private int quantidade;
    private double preco;

    public Produto(String nome, String categoria, int quantidade, double preco) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nCategoria: " + categoria +
                "\nQuantidade: " + quantidade +
                "\nPreço: " + preco;
    }
}