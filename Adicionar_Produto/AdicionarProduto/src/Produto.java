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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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