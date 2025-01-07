import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Sistema de Gerenciamento de Inventário ===");

        boolean continuar = true;
        while(continuar){
            System.out.println("\nMenu: ");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Sair");
            System.out.println("Escolha uma opção: ");

            try{
                int opcao = Integer.parseInt(scanner.nextLine());

                if (opcao == 1){
                    GerenciadorInventario.adicionarProdutos();
                } else if (opcao == 2) {
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
