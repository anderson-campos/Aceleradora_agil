import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorInventario {
    private static ArrayList<Produto> inventario = new ArrayList<>();

    public static void adicionarProdutos() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.println("Digite a categoria do produto: ");
            String categoria = scanner.nextLine();

            System.out.println("Digite a quantidade em estoque: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            System.out.println("Digite o preço do produto: ");
            double preco = Double.parseDouble(scanner.nextLine());

            Produto produto = new Produto(nome, categoria, quantidade, preco);
            inventario.add(produto);

            System.out.println("\nProduto cadastrado com sucesso!");
            System.out.println(produto);
        } catch (NumberFormatException e) {
            System.out.println("ERRO: Entrada inválida. Certifique-se de digitar numeros corretamente para a quantidade e preço");
        }
    }
}