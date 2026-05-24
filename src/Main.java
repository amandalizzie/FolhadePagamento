import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static List<Funcionario> lista = new ArrayList<>();

    public static void main(String[] args) {
        // ✅ RESOLVIDO: Inicializei a variável com valor 0
        int opcao = 0;

        do {
            System.out.println("\n===== SISTEMA FOLHA DE PAGAMENTO =====");
            System.out.println("Salário Base: R$ 2000.00");
            System.out.println("1 - Cadastrar Funcionário Padrão");
            System.out.println("2 - Cadastrar Funcionário Comissionado");
            System.out.println("3 - Cadastrar Funcionário Produção");
            System.out.println("4 - Listar Todos os Funcionários");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            // Tratamento para quando digita LETRAS ao invés de número
            if (!entrada.hasNextInt()) {
                System.out.println("❌ Opção inválida! Digite apenas números de 0 a 4.");
                entrada.nextLine(); // limpa o que foi digitado errado
                continue; // volta para o começo do menu
            }

            opcao = entrada.nextInt();
            entrada.nextLine(); // limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    cadastrarPadrao();
                    break;
                case 2:
                    cadastrarComissionado();
                    break;
                case 3:
                    cadastrarProducao();
                    break;
                case 4:
                    listarFuncionarios();
                    break;
                case 0:
                    System.out.println("✅ Sistema encerrado.");
                    break;
                default:
                    System.out.println("❌ Opção inválida! Escolha entre 0 e 4.");
            }
        } while (opcao != 0);
    }

    public static void cadastrarPadrao() {
        System.out.println("\n--- CADASTRO FUNCIONÁRIO PADRÃO ---");

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Matrícula: ");
        String matricula = entrada.nextLine();

        lista.add(new FuncionarioPadrao(nome, matricula));
        System.out.println("✅ Funcionário cadastrado com sucesso!");
    }

    public static void cadastrarComissionado() {
        System.out.println("\n--- CADASTRO FUNCIONÁRIO COMISSIONADO ---");

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Matrícula: ");
        String matricula = entrada.nextLine();

        System.out.print("Valor total de vendas: R$ ");
        String txtVendas = entrada.nextLine();
        Double vendas = null;
        if (!txtVendas.isBlank()) {
            try {
                vendas = Double.parseDouble(txtVendas.replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("❌ Valor inválido! Será considerado não informado.");
            }
        }

        System.out.print("Percentual de comissão: ");
        String txtPercentual = entrada.nextLine();
        Double percentual = null;
        if (!txtPercentual.isBlank()) {
            try {
                percentual = Double.parseDouble(txtPercentual.replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("❌ Valor inválido! Será considerado não informado.");
            }
        }

        lista.add(new FuncionarioComissionado(nome, matricula, vendas, percentual));
        System.out.println("✅ Funcionário cadastrado com sucesso!");
    }

    public static void cadastrarProducao() {
        System.out.println("\n--- CADASTRO FUNCIONÁRIO PRODUÇÃO ---");

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Matrícula: ");
        String matricula = entrada.nextLine();

        System.out.print("Valor por peça produzida: R$ ");
        String txtValor = entrada.nextLine();
        Double valorPeca = null;
        if (!txtValor.isBlank()) {
            try {
                valorPeca = Double.parseDouble(txtValor.replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("❌ Valor inválido! Será considerado não informado.");
            }
        }

        System.out.print("Quantidade de peças produzidas: ");
        String txtQtd = entrada.nextLine();
        Integer quantidade = null;
        if (!txtQtd.isBlank()) {
            try {
                quantidade = Integer.parseInt(txtQtd);
            } catch (NumberFormatException e) {
                System.out.println("❌ Valor inválido! Será considerado não informado.");
            }
        }

        lista.add(new FuncionarioProducao(nome, matricula, valorPeca, quantidade));
        System.out.println("✅ Funcionário cadastrado com sucesso!");
    }

    public static void listarFuncionarios() {
        System.out.println("\n===== FOLHA DE PAGAMENTO =====");
        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        double totalGeral = 0;
        for (Funcionario f : lista) {
            System.out.println(f.mostrarDados());
            totalGeral += f.calcularSalario();
        }

        System.out.println("----------------------------------");
        System.out.printf("TOTAL GERAL DA FOLHA: R$ %.2f\n", totalGeral);
        System.out.println("================================");
    }
}