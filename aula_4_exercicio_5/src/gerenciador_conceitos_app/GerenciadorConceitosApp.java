/* Faça um programa Java que mostre os conceitos finais dos alunos de uma turma, enquanto o professor quiser informar dados dos alunos:

Os dados de cada aluno (número de matrícula, alfanumérico, e nota, numérica) serão fornecidos pelo usuário.
A tabela de conceitos segue a seguir: 
* 0.0 a 4.9: D
* 5.0 a 6.9: C
* 7.0 a 8.9: B
* 9.0 a 10.0: A */
package gerenciador_conceitos_app;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorConceitosApp {
    public static void main(String[] args) {
        Leitor leitor = new Leitor();
        List<AlunoConceito> alunos = new ArrayList<>();

        System.out.println("--- Sistema de Conceitos Finais da Turma ---");

        String continuar = "sim";
        while (continuar.equals("sim")) {
            System.out.println("\n--- Cadastro de Alunos ---");
            String matricula = leitor.obterStringEntrada("Digite a matrícula: ");
            double nota = leitor.obterNumeroDouble("Digite a nota entre (0 a 10): ");

            AlunoConceito novoAluno = new AlunoConceito(matricula, nota);
            alunos.add(novoAluno);

            System.out.println("Aluno(a) matrícula " + matricula + " adicionado com sucesso!");

            continuar = leitor.obterRespostaSimNao("Deseja informar dados de outro aluno(a)?");
        }
        System.out.println("\n--- Relatórios de Conceitos Finais ---");

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno(a) foi cadastrado na turma.");
        } else {
            System.out.println("--- Conceitos de Alunos ---");
            for (AlunoConceito aluno : alunos) {
                System.out.println(aluno);
            }
            System.out.println("\n--- Resumo ---");
            System.out.println("Total de alunos informados: " + alunos.size());
        }
        leitor.fecharScanner();
    }
}
