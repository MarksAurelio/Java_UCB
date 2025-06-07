/* Você acabou de conhecer o ArrayList, uma coleção de objetos que é muito mais prática de usar frente os arrays tradicionais. Armazene os dados de uma turma em uma coleção de Alunos. Um aluno tem nome, duas notas e uma média, que é calculada a partir dos valores das notas. Após receber os dados de vários alunos, enquanto o usuário desejar, apresente a média da turma e a quantidade de alunos informados */
package gerenciador_turma_app;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTurmaApp {
    public static void main(String[] args) {
        Leitor leitor = new Leitor();
        List<Aluno> turma = new ArrayList<>();

        System.out.println("--- Gerenciador de Turmas ---");

        String continuar = "sim";
        while (continuar.equals("sim")) {
            System.out.println("--- Cadastro de Alunos ---");
            String nomeAluno = leitor.obterStringEntrada("Digite o nome do aluno(a):");
            double nota1 = leitor.obterNumeroDouble("Digite a primeira nota:");
            double nota2 = leitor.obterNumeroDouble("Digite a segunda nota:");

            Aluno novAluno = new Aluno(nomeAluno, nota1, nota2);
            turma.add(novAluno);

            System.out.println("Aluno " + nomeAluno + " adicionado com sucesso.");

            continuar = leitor.obterRepostaSimNao("Deseja cadastrar outro aluno?");
        }
        System.out.println("\n--- Resultados da Turma ---");

        if (turma.isEmpty()) {
            System.out.println("Nenhum aluno(a) foi cadastrado na turma.");
        } else {
            System.out.println("\nAlunos Cadastrados:");
            for (Aluno aluno : turma) {
                System.out.println(aluno);
            }
            double somaDasMedias = 0;
            for (Aluno aluno : turma) {
                somaDasMedias += aluno.getMedia();
            }
            double mediaTurma = somaDasMedias / turma.size();

            System.out.println("--- Resumo ---");
            System.out.println("Quantidade total de alunos: " + turma.size());
            System.out.printf("Média geral da turma: %.2f%n", mediaTurma);
        }
        leitor.fecharScanner();
    }
}
