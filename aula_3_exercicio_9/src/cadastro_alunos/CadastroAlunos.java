package cadastro_alunos;
import java.util.InputMismatchException;

public class CadastroAlunos {
    public static Aluno solicitarDadosDeUmAluno() {
        System.out.println("--- Cadastro de um Novo Aluno(a) ---");
        String nome = Leitor.lerString("Informe o nome do aluno(a):");
        String matricula = Leitor.lerString("Informe a matrícula do aluno(a):");

        SituacaoAluno situacao = null;
        boolean situacaoValida = false;
        while (!situacaoValida) {
            String inputSituacao = Leitor.lerString("Informe a situação do aluno(a) (REGULAR OU BOLSISTA):");
            try {
                situacao = SituacaoAluno.valueOf(inputSituacao); // Converte a string para o enum
                situacaoValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Situação inválida. Digite (REGULAR ou BOLSISTA).");
            }
        }
        return new Aluno(nome, matricula, situacao);
    }

    public static void apresentarTodosAlunos(Aluno[] alunos) {
        if (alunos == null || alunos.length == 0) {
            System.out.println("\nNenhum aluno cadastrado para apresentar.");
            return;
        }
        System.out.println("\n--- Alunos Cadastrados ---");
        for (int i = 0; i < alunos.length; i++) {
            System.out.printf("Aluno %d: %s%n", (i + 1), alunos[i].toString());
        }
        System.out.println("-------------------------");
    }

    public static void apresentarContagemPorSituacao(Aluno[] alunos) {
        if (alunos == null || alunos.length == 0) {
            System.out.println("\nNenhum aluno(a) para contar por situação.");
            return;
        }
        int countRegulares = 0;
        int countBolsistas = 0;

        for (Aluno aluno : alunos) {
            if (aluno.getSituacao() == SituacaoAluno.REGULAR) {
                countRegulares++;
            } else if (aluno.getSituacao() == SituacaoAluno.BOLSISTA) {
                countBolsistas++;
            }
        }
        System.out.println("\n--- Resumo por Situação ---");
        System.out.printf("Alunos Regulares: %d%n", countRegulares);
        System.out.printf("Aluno Bolsistas: %d%n", countBolsistas);
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Sistema de Cadastro de Alunos da Turma ---");

        int numAlunos = Leitor.lerInt("Informe quantos alunos existem na turma:");

        if (numAlunos <= 0) {
            System.out.println("Não é possível cadastrar 0 ou menos alunos. Programa Encerrado!");
            Leitor.fecharScanner();
            return;
        }
        Aluno[] turma = new Aluno[numAlunos]; // Cria um array para armazenar os alunos

        // 1. Recebe os dados de todos os alunos
        for (int i = 0; i < numAlunos; i++) {
            System.out.printf("\nColetando dados do Aluno %d de %d:%n", (i + 1), numAlunos);
            turma[i] = solicitarDadosDeUmAluno();
        }
        // 2. Apresentar todos os alunos informados
        apresentarTodosAlunos(turma);

        // 3. Apresentar a quantidade de alunos regulares e bolsistas
        apresentarContagemPorSituacao(turma);

        // 4. Fechar Scanner
        Leitor.fecharScanner();

        System.out.println("\nCadastro de alunos concluído!");
    }
}
