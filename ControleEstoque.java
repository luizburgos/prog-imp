import java.util.*;

class Produto {
    String nome;
    int quantidade;
    double preco;
    String categoria;
    int qtdMinima;
}

public class ControleEstoque {

    static Scanner scanner = new Scanner(System.in);
    static Produto[] estoque = new Produto[100];
    static int totalProdutos = 0;

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opção: ");
            switch (opcao) {
                case 1: cadastrarProduto(); break;
                case 2: listar(); break;
                case 3: filtrarPorCategoria(); break;
                case 4: ordenar(); break;
                case 5: removerProduto(); break;
                case 6: atualizarPreco(); break;
                case 7: listagemComSubtotal(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void exibirMenu() {
        System.out.println("\n===== CONTROLE DE ESTOQUE =====");
        System.out.println("1. Cadastrar produto");
        System.out.println("2. Listar produtos");
        System.out.println("3. Filtrar por categoria");
        System.out.println("4. Ordenar por nome");
        System.out.println("5. Remover produto");
        System.out.println("6. Atualizar preço");
        System.out.println("7. Listagem com subtotal por categoria");
        System.out.println("0. Sair");
        System.out.println("================================");
    }

    static void cadastrarProduto() {
        if (totalProdutos >= 100) {
            System.out.println("Estoque cheio!");
            return;
        }
        Produto p = new Produto();
        System.out.println("\n--- Cadastrar Produto ---");
        System.out.print("Nome/Descrição: ");
        p.nome = scanner.nextLine();
        p.quantidade = lerInt("Qtd em estoque: ");
        p.preco = lerDouble("Preço unitário: R$ ");
        System.out.print("Categoria: ");
        p.categoria = scanner.nextLine();
        p.qtdMinima = lerInt("Qtd mínima: ");

        estoque[totalProdutos] = p;
        totalProdutos++;
        System.out.println("Produto cadastrado com sucesso!");
    }

    static void listar() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Produtos ---");
        System.out.printf("%-5s %-20s %-10s %-12s %-15s %-8s%n",
                "ID", "Nome", "Qtd", "Preço", "Categoria", "Qtd Min");
        System.out.println("-".repeat(75));
        for (int i = 0; i < totalProdutos; i++) {
            Produto p = estoque[i];
            System.out.printf("%-5d %-20s %-10d R$%-10.2f %-15s %-8d%n",
                    i + 1, p.nome, p.quantidade, p.preco, p.categoria, p.qtdMinima);
            if (p.quantidade <= p.qtdMinima) {
                System.out.println("  ⚠  ATENÇÃO: Estoque abaixo do mínimo!");
            }
        }
    }

    static void filtrarPorCategoria() {
        System.out.print("\nDigite a categoria: ");
        String cat = scanner.nextLine().trim();
        boolean encontrou = false;
        System.out.printf("%-5s %-20s %-10s %-12s %-15s %-8s%n",
                "ID", "Nome", "Qtd", "Preço", "Categoria", "Qtd Min");
        System.out.println("-".repeat(75));
        for (int i = 0; i < totalProdutos; i++) {
            Produto p = estoque[i];
            if (p.categoria.equalsIgnoreCase(cat)) {
                System.out.printf("%-5d %-20s %-10d R$%-10.2f %-15s %-8d%n",
                        i + 1, p.nome, p.quantidade, p.preco, p.categoria, p.qtdMinima);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum produto na categoria: " + cat);
    }

    static void ordenar() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto para ordenar.");
            return;
        }
        for (int i = 0; i < totalProdutos - 1; i++) {
            for (int j = 0; j < totalProdutos - 1 - i; j++) {
                if (estoque[j].nome.compareToIgnoreCase(estoque[j + 1].nome) > 0) {
                    Produto tmp = estoque[j];
                    estoque[j] = estoque[j + 1];
                    estoque[j + 1] = tmp;
                }
            }
        }
        System.out.println("Produtos ordenados por nome!");
        listar();
    }

    static void removerProduto() {
        listar();
        if (totalProdutos == 0) return;
        int id = lerInt("Digite o ID do produto a remover: ") - 1;
        if (id < 0 || id >= totalProdutos) {
            System.out.println("ID inválido.");
            return;
        }
        System.out.println("Removendo: " + estoque[id].nome);
        for (int i = id; i < totalProdutos - 1; i++) {
            estoque[i] = estoque[i + 1];
        }
        estoque[totalProdutos - 1] = null;
        totalProdutos--;
        System.out.println("Produto removido com sucesso!");
    }

    static void atualizarPreco() {
        listar();
        if (totalProdutos == 0) return;
        int id = lerInt("Digite o ID do produto: ") - 1;
        if (id < 0 || id >= totalProdutos) {
            System.out.println("ID inválido.");
            return;
        }
        System.out.printf("Preço atual de '%s': R$ %.2f%n", estoque[id].nome, estoque[id].preco);
        estoque[id].preco = lerDouble("Novo preço: R$ ");
        System.out.println("Preço atualizado com sucesso!");
    }

    static void listagemComSubtotal() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        
        for (int i = 0; i < totalProdutos - 1; i++) {
            for (int j = 0; j < totalProdutos - 1 - i; j++) {
                if (estoque[j].categoria.compareToIgnoreCase(estoque[j + 1].categoria) > 0) {
                    Produto tmp = estoque[j];
                    estoque[j] = estoque[j + 1];
                    estoque[j + 1] = tmp;
                }
            }
        }

        System.out.println("\n===== LISTAGEM POR CATEGORIA =====");
        double totalGeral = 0;
        int i = 0;

        while (i < totalProdutos) {
            String catAtual = estoque[i].categoria;
            System.out.println("\nCategoria: " + catAtual);
            System.out.printf("  %-20s %-10s %-12s %-12s%n", "Nome", "Qtd", "Preço Unit.", "Valor Total");
            System.out.println("  " + "-".repeat(57));
            double subtotal = 0;

            while (i < totalProdutos && estoque[i].categoria.equalsIgnoreCase(catAtual)) {
                Produto p = estoque[i];
                double valorItem = p.quantidade * p.preco;
                System.out.printf("  %-20s %-10d R$%-10.2f R$%-10.2f%n",
                        p.nome, p.quantidade, p.preco, valorItem);
                subtotal += valorItem;
                i++;
            }

            System.out.printf("  Subtotal: R$ %.2f%n", subtotal);
            totalGeral += subtotal;
        }

        System.out.println("\n==================================");
        System.out.printf("TOTAL GERAL: R$ %.2f%n", totalGeral);
        System.out.println("==================================");
    }


    static int lerInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    static double lerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número decimal.");
            }
        }
    }
}