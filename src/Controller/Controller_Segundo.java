package Controller;

import Model_Repository.Repository;
import Model_Repository.Produto;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controller_Segundo {
    private Repository repository;
    private Scanner scanner;

    public Controller_Segundo(Repository repository) {
        this.repository = repository;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarSistema() {
        boolean sair = false;

        while (!sair) {
            exibirMenu();
            String opcao = scanner.nextLine();

            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um valor válido.");
                scanner.nextLine(); // Limpa o buffer do scanner
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }
    }

    private void exibirMenu() {
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Atualizar Produto");
        System.out.println("4 - Remover Produto");
        System.out.println("5 - Sair");
        System.out.println("Entre com a opção desejada:");
    }

    private void adicionarProduto() {
        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = Double.parseDouble(scanner.nextLine());

        repository.add(new Produto(codigo, nome, preco));
        System.out.println("Produto adicionado com sucesso!");
    }

    private void listarProdutos() {
        List<Produto> produtos = repository.getAll();
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos disponíveis.");
        } else {
            System.out.println("\nProdutos disponíveis:");
            for (Produto produto : produtos) {
                System.out.printf("%s - %s - R$%.2f\n", produto.getCodigo(), produto.getNome(), produto.getPreco());
            }
        }
    }

    private void atualizarProduto() {
        System.out.print("Digite o código do produto que deseja atualizar: ");
        String codigo = scanner.nextLine();

        Produto produto = repository.getById(codigo);
        if (produto != null) {
            System.out.print("Digite o novo nome do produto: ");
            produto.setNome(scanner.nextLine());
            System.out.print("Digite o novo preço do produto: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void removerProduto() {
        System.out.print("Digite o código do produto que deseja remover: ");
        String codigo = scanner.nextLine();

        if (repository.remove(codigo)) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
