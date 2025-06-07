/* Um sindicato dos professores deseja um sistema que gerencie a contribuição sindical dos professores de uma cidade. Um professor possui nome, cpf, titulação (Doutor, Mestre, Graduado) e salário. Realize a entrada de dados para vários professores, enquanto o usuário desejar. Sabe-se que um Graduado contribui 1,2% do salário, já o Mestre 1,4% e o Doutor 1,6%. Ao final, após receber todos os dados dos professores, apresente o total arrecadado pelo sindicato e a quantidade de professores que são Mestre. Fique atento onde cada método e atributo estará distribuído na sua aplicação. */
package sindicato_app;

import java.util.ArrayList;
import java.util.List;

public class SindicatoApp {
    public static void main(String[] args) {
        Leitor leitor = new Leitor();
        List<Professor> professores = new ArrayList<>();

        System.out.println("--- Sistema de Gerenciamento de Contribuição Sindical ---");

        String continuar = "sim";
        while (continuar.equals("sim")) {
            System.out.println("--- Cadastro de Professores ---");
            String nome = leitor.obterStringEntrada("Nome: ");
            String cpf = leitor.obterStringEntrada("CPF: ");
            String titulacao = leitor.obterTitulacaoProfessor();
            double salario = leitor.obterNumeroDouble("Salário: ");

            Professor novoProfessor = new Professor(nome, cpf, titulacao, salario);
            professores.add(novoProfessor);

            System.out.println("Professor(a) " + nome + " adicionado com sucesso!");

            continuar = leitor.obterRespostaSimNao("Deseja cadastrar outro professor?");
        }
        System.out.println("--- Relátorio Final do Sindicato ---");
        // Verifica se há professores cadastrados
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor(a) foi cadastrado.");
        } else {
            // Calcular o total arrecado
            double totalArrecado = 0;
            int quantidadeMestres = 0;

            System.out.println("\nProfessores cadastrados:");
            for (Professor professor : professores) {
                System.out.println(professor);
                totalArrecado += professor.getContribuicaoSindical();
                if (professor.getTitulacao().equals("mestre")) {
                    quantidadeMestres++; // Conta professores Mestre
                }
            }
            System.out.println("\n--- Resumo ---");
            System.out.printf("Total arrecado: %.2f%n", totalArrecado);
            System.out.printf("Quantidade de professores (Mestre): %d%n", quantidadeMestres);
        }
        leitor.fecharScanner();
    }
}
