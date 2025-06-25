package minha_loja;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TesteCliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();

        System.out.println("--- Sistema de Cadastro de Cliente da Loja ---");

        boolean continuarCadastro = true;

        while (continuarCadastro) {
            System.out.println("\n--- Cadastro de Novo Cliente ----");
            String nome = "";
            String endereco = "";
            int codigoFPagamento = 0;
            boolean dadosValidos = false;

            while (!dadosValidos) {
                try {
                    System.out.println("Nome do cliente (ou 'sair' para finalizar): ");
                    nome = scanner.nextLine();
                    if (nome.equalsIgnoreCase("sair")) {
                        continuarCadastro = false;
                        break;
                    }
                    if (nome.isEmpty()) {
                        throw new IllegalArgumentException("Nome não pode ser vazio.");
                    }
                    System.out.println("Endereço do Cliente: ");
                    endereco = scanner.nextLine().trim();
                    if (endereco.isEmpty()) {
                        throw new IllegalArgumentException("Endereço não pode ser vazio.");
                    }
                    System.out.println("Código da Forma de Pagamento (20 - Visa / 50 - Mastercard / 30 - Boleto): ");
                    codigoFPagamento = scanner.nextInt();
                    scanner.nextLine();

                    dadosValidos = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    e.printStackTrace();
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro de entrada " + e.getMessage());
                }
            }
            if (!continuarCadastro) {
                break;
            }
            try {
                // Atribuição do enumerador de acordo com o código informado
                EnumFPagamento formaPagamento = EnumFPagamento.getByCodigo(codigoFPagamento);
                Cliente novoCliente = new Cliente(nome, endereco, formaPagamento);
                listaClientes.add(novoCliente);
                System.out.println("Cliente " + nome + " cadastrado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar Cliente " + e.getMessage());
                e.printStackTrace();
            }
        }
        // Apresentação dos Clientes Cadastrados
        System.out.println("\n--- Clientes Cadastrados ---");
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente.toString());
                System.out.println("-------------------------");
            }
        }
        scanner.close();
        System.out.println("\n--- Fim do Sistema ---");
    }
}
