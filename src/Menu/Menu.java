package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Model_Repository.Produto;
import util.Cores;

public class Menu {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
                + "*****************************************************");
        System.out.println("                                                     ");
        System.out.println("              E-COMMERCE ELETRO                      ");
        System.out.println("                                                     ");
        System.out.println("*****************************************************");
        System.out.println("                                                     ");
        System.out.println("            1 - Adicionar Produto                    ");
        System.out.println("            2 - Listar Produtos                      ");
        System.out.println("            3 - Atualizar Produto                    ");
        System.out.println("            4 - Remover Produto                      ");
        System.out.println("            5 - Sair                                 ");
        System.out.println("                                                     ");
        System.out.println("*****************************************************");
        System.out.println("Entre com a opção desejada:                          ");
        System.out.println("                                                     " + Cores.TEXT_RESET);
    }

    public void executarMenu() {
        boolean sair = false;
        while (!sair) {
            exibirMenu();
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    adicionarProduto();
                    break;
                case "2":
                    listarProdutos();
                    break;
                case "3":
                    atualizarProduto();
                    break;
                case "4":
                    removerProduto();
                    break;
                case "5":
                    sair = true;
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void adicionarProduto() {
        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = Double.parseDouble(scanner.nextLine());

        Produto produto = new Produto(codigo, nome, preco);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    public void listarProdutos() {
        System.out.println("\nProdutos disponíveis:");
        for (Produto produto : produtos) {
            System.out.printf("%s - R$%.2f\n", produto.getNome(), produto.getPreco());
        }
    }

    public void atualizarProduto() {
        System.out.print("Digite o código do produto que deseja atualizar: ");
        String codigo = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                System.out.print("Digite o novo nome do produto: ");
                produto.setNome(scanner.nextLine());
                System.out.print("Digite o novo preço do produto: ");
                produto.setPreco(Double.parseDouble(scanner.nextLine()));
                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void removerProduto() {
        System.out.print("Digite o código do produto que deseja remover: ");
        String codigo = scanner.nextLine();

        produtos.removeIf(produto -> produto.getCodigo().equals(codigo));
        System.out.println("Produto removido com sucesso!");
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.executarMenu();
    }
}
