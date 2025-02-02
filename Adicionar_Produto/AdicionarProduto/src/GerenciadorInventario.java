import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GerenciadorInventario {
    private static ArrayList<Produto> inventario = new ArrayList<>();

    public static void adicionarProdutos() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a categoria do produto: ");
            String categoria = scanner.nextLine();

            System.out.print("Digite a quantidade em estoque: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite o preço do produto: ");
            double preco = Double.parseDouble(scanner.nextLine());

            Produto produto = new Produto(nome, categoria, quantidade, preco);
            inventario.add(produto);

            System.out.println("\nProduto cadastrado com sucesso!");
            System.out.println("\n"+ produto + "\n");
        } catch (NumberFormatException e) {
            System.out.println("ERRO: Entrada inválida. Certifique-se de digitar numeros corretamente para a quantidade e preço");
        }
    }

    public static void atualizarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do produto que deseja atualizar: ");
        String id = scanner.nextLine();

        Produto produto = null;
        for (Produto p : inventario){
            if (p.getId().equals(id)){
                produto = p;
                break;
            }
        }

        if (produto == null){
            System.out.println("Erro: Produto com ID " + id + " não encontrado!");
            return;
        }

        System.out.println("\nProduto encontrado");
        System.out.println(produto);

        System.out.println("\nEscolha o campo para atualizar: ");
        System.out.println("1. Nome");
        System.out.println("2. Categoria");
        System.out.println("3. Quantidade");
        System.out.println("4. Preço");
        System.out.print("Opção: ");

        try{
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao){
                case 1:
                    System.out.print("Digite o novo nome: ");
                    produto.setNome(scanner.nextLine());
                    break;

                case 2:
                    System.out.print("Digite a nova categoria: ");
                    produto.setCategoria(scanner.nextLine());
                    break;

                case 3:
                    System.out.print("Digite a nova quantidade: ");
                    produto.setQuantidade(Integer.parseInt(scanner.nextLine()));
                    break;

                case 4:
                    System.out.print("Digite o novo preço: ");
                    produto.setPreco(Double.parseDouble(scanner.nextLine()));
                    break;

                default:
                    System.out.println("Opção inválida! Nenhuma alteração foi feita.");
                    return;
            }

            System.out.println("\nProduto atualizado com sucesso!");
            System.out.println("\n" + produto + "\n");

        } catch (NumberFormatException e){
            System.out.println("Erro: Entrada inválida. Certifique-se de digitar números corretamente.");
        }

    }

    public static void excluirProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID do produto que deseja excluir: ");
        String id = scanner.nextLine();

        Produto produto = buscarProdutoPorId(id);

        if (produto == null){
            System.out.println("Erro: Produto com ID: " + id + "não encontrado!");
            return;
        }

        System.out.println("\nProduto encontrado");
        System.out.println(produto);

        System.out.println("Tem certeza que deseja excluir este produto? (s/n): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("s")){
            inventario.remove(produto);
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Ação de exclusão cancelada.");
        }
    }

    public static void filtrarPorCategoria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a categoria para filtrar: ");
        String categoria = scanner.nextLine();

        List<Produto> filtrados = new ArrayList<>();

        for (Produto produto : inventario){
            if (produto.getCategoria().equalsIgnoreCase(categoria)){
                filtrados.add(produto);
            }
        }

        if (filtrados.isEmpty()){
            System.out.println("Nenhum produto encontrado na categoria: " + categoria);
        }else {
            System.out.println("Produto na categoria " + categoria + ": ");
            for (Produto produto : filtrados){
                System.out.println(produto);
                System.out.println();
            }
        }
    }

    public static void ordenarProdutos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEscolha o critério de ordenação:");
        System.out.println("1. Nome");
        System.out.println("2. Quantidade");
        System.out.println("3. Preço");
        System.out.print("Opção: ");

        try {
            int criterio = Integer.parseInt(scanner.nextLine());

            Comparator<Produto> comparator;
            if (criterio == 1){
                comparator = Comparator.comparing(Produto::getNome);
            } else if (criterio == 2){
                comparator = Comparator.comparingInt(Produto::getQuantidade);
            } else if (criterio == 3){
                comparator = Comparator.comparingDouble(Produto::getPreco);
            } else {
                System.out.println("Critério inválido!Retornando ao menu principal");
                return;
            }

            inventario.sort(comparator);

            System.out.println("Produtos ordenados: ");
            for (Produto produto : inventario){
                System.out.println(produto);
                System.out.println();
            }
        }catch (NumberFormatException e){
            System.out.println("Erro: Entreada inválida. Por favor, digite um número válido.");
        }
    }

    public static void buscarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Buscar produto por:");
        System.out.println("1. ID");
        System.out.println("2. Nome (ou parte do nome)");
        System.out.print("Opção: ");

        try{
            int opcao = Integer.parseInt(scanner.nextLine());

            if(opcao == 1){
                System.out.print("Digite o ID do produto: ");
                String id = scanner.nextLine();
                Produto produto = buscarProdutoPorId(id);

                if (produto != null){
                    System.out.println("\nProduto encontrado");
                    System.out.println(produto);
                }else {
                    System.out.println("Nenhum produto encontrado com o ID fornecido.");
                }
            } else if (opcao == 2) {
                System.out.println("Digite o nome ou parte do nome do produto: ");
                String nome = scanner.nextLine();
                List<Produto>encontrados = new ArrayList<>();

                for (Produto produto : inventario){
                    if (produto.getNome().toLowerCase().contains(nome.toLowerCase())){
                        encontrados.add(produto);
                    }
                }

                if (encontrados.isEmpty()){
                    System.out.println("Nenhum produto fpoiencontrado co o nome ou parte do nome fornecido.");
                }else {
                    System.out.println("\nProdutos encontrados:");
                    for (Produto produto : encontrados){
                        System.out.println(produto);
                        System.out.println();
                    }
                }
            }else {
                System.out.println("Opção inválida!");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro: Entrada inválida. Por favor, digite um número válido.");
        }
    }

    public static Produto buscarProdutoPorId(String id) {
        for (Produto produto : inventario){
            if (produto.getId().equals(id)){
                return produto;
            }
        }
        return null;
    }

}