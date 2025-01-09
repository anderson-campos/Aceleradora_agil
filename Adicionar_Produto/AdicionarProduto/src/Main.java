import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Gerenciamento de Inventário ===");

        boolean continuar = true;
        while(continuar){
            System.out.println("\nMenu: ");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Buscar Produto");
            System.out.println("5. Filtrar por Categoria");
            System.out.println("6. Ordenar Produtos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            try{
                int opcao = Integer.parseInt(scanner.nextLine());

                if (opcao == 1){
                    GerenciadorInventario.adicionarProdutos();
                } else if (opcao == 2) {
                    GerenciadorInventario.atualizarProduto();
                } else if (opcao == 3) {
                    GerenciadorInventario.excluirProduto();
                } else if (opcao == 4) {
                    GerenciadorInventario.buscarProduto();
                } else if (opcao == 5) {
                    GerenciadorInventario.filtrarPorCategoria();
                } else if (opcao == 6) {
                    GerenciadorInventario.ordenarProdutos();
                } else if (opcao == 7) {
                    continuar = false;
                    System.out.println("Encerrando o sistema...");
                } else {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO: Entrada inválida. Por favor, digite um número para escolher a opção.");
            }
        }
        scanner.close();
    }
}
