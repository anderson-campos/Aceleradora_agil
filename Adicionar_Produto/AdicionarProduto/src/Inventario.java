import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar Produto\n2. Listar Produtos\n3. Sair");
            System.out.print("Escolha uma opção: ");

            // Verifica se a entrada é válida
            if (!scanner.hasNextInt()) {
                System.out.println("Opção inválida. Digite um número.");
                scanner.next(); // Consome a entrada inválida
                continue;
            }

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            if (opcao == 1) {
                System.out.print("Nome do Produto: ");
                String nome = scanner.nextLine();

                System.out.print("Categoria: ");
                String categoria = scanner.nextLine();

                System.out.print("Quantidade em Estoque: ");
                int quantidade = 0;
                while (true) {
                    if (scanner.hasNextInt()) {
                        quantidade = scanner.nextInt();
                        scanner.nextLine(); // Consumir quebra de linha
                        break;
                    } else {
                        System.out.print("Entrada inválida. Digite um número inteiro para a quantidade: ");
                        scanner.next(); // Consome a entrada inválida
                    }
                }

                System.out.print("Preço: ");
                double preco = 0.0;
                while (true) {
                    String input = scanner.nextLine();
                    try {
                        preco = Double.parseDouble(input.replace(",", "."));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Entrada inválida. Digite um valor numérico para o preço: ");
                    }
                }

                produtos.add(new Produto(nome, categoria, quantidade, preco));
                System.out.println("Produto adicionado com sucesso!");
            } else if (opcao == 2) {
                if (produtos.isEmpty()) {
                    System.out.println("Nenhum produto no inventário.");
                } else {
                    produtos.forEach(System.out::println);
                }
            } else if (opcao == 3) {
                System.out.println("Saindo do programa. Até logo!");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}