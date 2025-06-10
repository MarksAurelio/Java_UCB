/* Crie um programa Java que implemente o projeto da figura acima. Crie uma classe chamada Funcionario com os atributos (nome, cpf e salário). Crie uma classe Professor, que é um Funcionário e, além dos dados de funcionário, tem a titulação e o cálculo do seu imposto de renda por intermédio do método getImpostoRenda()que é 23 % do salário. Crie também a classe Adminsitrativo, que também é Funcionário e tem um dado que representa a quantidade de dependentes. Não se esqueça de criar o método getContribuicaoSindical(), que retornará 1% do salário.

Seu programa deve perguntar qual tipo de Funcionário deseja informar P - Professor e A - Administrativo. Quando o usuário escolher a opção receba os dados do respectivo objeto e apresente todas as suas informações. */
package sistema_funcionario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaFuncionario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Cadastro de Funcionários ---");
        System.out.println("Qual o tipo de funcionário deseja cadastrar? ");
        System.out.println("Digite 'P' para Professor ou 'A' para Adminstrativo: ");
        String tipoDeFuncionario = scanner.nextLine().trim().toUpperCase();

        // Variáveis para os dados comuns a todos os funcionários
        String nome = "";
        String cpf = "";
        double salario = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("Nome do funcionário: ");
                nome = scanner.nextLine();
                if (nome.isEmpty()) {
                    System.out.println("A entrada não pode ser vazia. Digite o nome do funcionário: ");
                    continue; // Volta para pedir o nome
                }
                System.out.println("CPF do funcionário: ");
                cpf = scanner.nextLine();
                if (cpf.isEmpty()) {
                    System.out.println("A entrada não pode ser vazia. Digite o cpf do funcionário: ");
                    continue;
                }
                System.out.println("Salário do funcionário: R$");
                salario = scanner.nextDouble();
                if (salario <= 0) {
                    System.out.println("O salário deve ser um valor positivo. Digite o salário: ");
                    scanner.nextLine();
                    continue;
                }
                entradaValida = true; // Se tudo deu certo até aqui, a entrada é válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida para salário. Digite um número: ");
                scanner.nextLine();
            }
        }
        Funcionario funcionario = null; // Variável para armazenar o objeto de funcionário

        // Cria o objeto específico (Professor ou Administrativo) com base na escolha do usuário
        if (tipoDeFuncionario.equals("P")) {
            // Consome a nova linha pendente após a leitura do salário (nextDouble())
            scanner.nextLine();
            System.out.println("Titulação do Professor (Ex: Mestre, Doutor)");
            String titulacao = scanner.nextLine();

            funcionario = new Professor(nome, cpf, salario, titulacao);
            System.out.println("--- Dados do Professor Cadastrado ---");
        } else if (tipoDeFuncionario.equals("A")) {
            int quantidadeDeDependentes = 0;
            entradaValida = false; // Reinicia a validação de dependentes
            while (!entradaValida) {
                try {
                    // Consome a nova linha pendente após a leitura do salário
                    scanner.nextLine(); // Importante antes de ler um int
                    System.out.println("Quantidade de dependentes do Administrativo: ");
                    quantidadeDeDependentes = scanner.nextInt();
                    if (quantidadeDeDependentes < 0) {
                        System.out.println("A quantidade de dependentes não pode ser negativa. Digite novamente.");
                    } else {
                        entradaValida = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número inteiro para dependentes. ");
                    scanner.nextLine();
                }
            }
            // Consome a nova linha pendente após a leitura da quantidade de dependentes
            scanner.nextLine();

            funcionario = new Administrativo(nome, cpf, salario, quantidadeDeDependentes);
            System.out.println("--- Dados do Administrativo Cadastrado ---");
        } else {
            System.out.println("Opção inválida. Nenhum funcionário foi cadastrado.");
        }
        if (funcionario != null) {
            System.out.println(funcionario);
        }
        scanner.close();
    }
}
