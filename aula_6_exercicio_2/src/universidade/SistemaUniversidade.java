/* Em uma universidade tem dois tipos de Funcionários: Diretores ou Professores. Um professor tem nome, matrícula, cpf, salário, ano de admissão. Em professor deve ter um método getImpostoDeRenda, que deverá retornar o imposto de renda do professor (20% do seu salário). Um diretor tem nome, matrícula, cpf, salário e tempo de casa. Em Diretor também tem o método para obter o imposto de renda. (23% do seu salário).

Pegue tudo que for comum às entidades e coloque em uma classe Funcionário, inclusive o método getImpostoDeRenda, para que ele possa ser sobrescrito pelas entidades filhas.

Não é aceito funcionário repetido nesta universidade. Use sobrescrita do equals para auxiliar nesta empreitada e para apresentação use o toString .

Para criar um funcionário, deve ser passada a matrícula no construtor obrigatoriamente.

Trabalhe com um ÚNICO ArrayList de Funcionário.

Receba os dados de vários funcionários e apresente a média do imposto de renda e o total do imposto de renda. */
package universidade;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaUniversidade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Funcionario> listaDeFuncionarios = new ArrayList<>();

        System.out.println("--- Sistema de Gestão de Funcionários da Universidade ---");

        boolean continuarCadastro = true;
        while (continuarCadastro) {
            System.out.println("--- Cadastro de novo Funcionário: ---");
            System.out.println("Qual o tipo de Funcionário? (P para Professor/ D para Diretor/ S para Sair) ");
            String tipo = scanner.nextLine().trim().toUpperCase();

            if (tipo.equals("S")) {
                continuarCadastro = false;
                break;
            }
            // Variáveis comuns a todos os funcionários
            String nome = "";
            String matricula = "";
            String cpf = "";
            double salario = 0.0;
            boolean dadosBasicosValida = false;

            while (!dadosBasicosValida) {
                try {
                    System.out.println("Nome: ");
                    nome = scanner.nextLine();
                    if (nome.isEmpty())
                        throw new IllegalArgumentException("Nome não pode ser vazio.");

                    System.out.println("Matrícula: ");
                    matricula = scanner.nextLine();
                    if (matricula.isEmpty())
                        throw new IllegalArgumentException("Matrícula não pode ser vazia.");

                    System.out.println("CPF: ");
                    cpf = scanner.nextLine();
                    if (cpf.isEmpty())
                        throw new IllegalArgumentException("Cpf não pode ser vazio.");

                    System.out.println("Salário: R$");
                    salario = scanner.nextDouble();
                    scanner.nextLine();
                    if (salario < 0)
                        throw new IllegalArgumentException("Salário não pode ser negativo");

                    dadosBasicosValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Informe um número para salário.");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro nos dados: " + e.getMessage());
                }
            }
            Funcionario novoFuncionario = null;

            if (dadosBasicosValida) {
                try {
                    if (tipo.equals("P")) {
                        System.out.println("Ano de Admissão: ");
                        int anoDeAdmissao = scanner.nextInt();
                        scanner.nextLine();
                        novoFuncionario = new Professor(nome, matricula, cpf, salario, anoDeAdmissao);
                    } else if (tipo.equals("D")) {
                        System.out.println("Tempo de Casa: ");
                        int tempoDecasaAnos = scanner.nextInt();
                        scanner.nextLine();
                        novoFuncionario = new Diretor(nome, matricula, cpf, salario, tempoDecasaAnos);
                    } else {
                        System.out.println("Tipo de funcionário inválido. Tente novamente.");
                        continue; // Volta para o ínicio do loop principal
                    }
                    // Adiciona o funcionário se não for duplicado
                    if (listaDeFuncionarios.contains(novoFuncionario)) {
                        System.out.println("Erro: Funcionário com matrícula " + novoFuncionario.getMatricula()
                                + " já cadastrado. Não adicionado.");
                    } else {
                        listaDeFuncionarios.add(novoFuncionario);
                        System.out.println("Funcionário cadastrado com sucesso!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida para o dado específico (ano de admissão/tempo de casa).");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao criar funcionário: " + e.getMessage());
                }
            }
        } // Fim do loope de cadastro
          // Apresentação de dados e cálculos finais
        System.out.println("--- Relação Final de Funcionários ---");
        if (listaDeFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            double totalImpostoDeRenda = 0;
            System.out.println("--- Detalhes dos Funcionário ---");
            for (Funcionario funcionario : listaDeFuncionarios) {
                System.out.println("\n-----------------------------");
                System.out.println(funcionario.toString()); // Polimorfismo: chama o toString específico
                totalImpostoDeRenda += funcionario.getImpostoDeRenda(); // Polimorfismo: chama o getImpostoDeRenda
                                                                        // específico
            }

            double mediaImpostoDeRenda = totalImpostoDeRenda / listaDeFuncionarios.size();
            System.out.println("--- Resumo de Impostos ---");
            System.out.printf("Total do Imposto de Renda de todos os Funcionários: R$%.2f%n", totalImpostoDeRenda);
            System.out.printf("Média do Imposto de Renda por Funcionário: R$%.2f%n", mediaImpostoDeRenda);
        }
        scanner.close();
        System.out.println("\n--- Fim do Sistema ---");
    }
}
