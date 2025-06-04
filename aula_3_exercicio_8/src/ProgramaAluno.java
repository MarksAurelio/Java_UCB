/* Crie uma entidade aluno, com nome e duas notas. Receba do usuário os dados deste aluno e, na sequência, apresente todos os dados deste aluno. Apresente também a média dele e se está aprovado ou reprovado. Crie o maior número de métodos que conseguir visualizar. */
public class ProgramaAluno {
    public static Aluno solicitarDadosAluno() {
        System.out.println("--- Cadastro de Aluno ---");
        String nome = Leitor.lerStringI("Informe o nome do aluno(a):");

        double nota1 = -1.0;
        boolean nota1Valida = false;
        while (!nota1Valida) {
            nota1 = Leitor.lerDouble("Informe a primeira nota do aluno(a) de (0 a 10):");
            // Validação da nota1
            if (nota1 >= 0 && nota1 <= 10) {
                nota1Valida = true;
            } else {
                System.out.println("Nota inválida. Informe uma nota de (0 a 10).");
            }
        }
        double nota2 = -1.0;
        boolean nota2Valida = false;
        while (!nota2Valida) {
            nota2 = Leitor.lerDouble("Informe a segunda nota do aluno(a) de (0 a 10):");
            // Validação da nota2
            if (nota2 >= 0 && nota2 <= 10) {
                nota2Valida = true;
            } else {
                System.out.println("Nota inválida. Informe uma nota de (0 a 10).");
            }
        }
        return new Aluno(nome, nota1, nota2);

    }

    public static void exibirDadosAluno(Aluno aluno) {
        System.out.println("--- Dados Detalhados do Aluno(a) ---");
        System.out.println(aluno.toString());

        String status = aluno.estaAprovado() ? "APROVADO" : "REPROVADO";
        System.out.printf("Status de Aprovação: %s%n", status);
        System.out.println("---------------------------");

    }

    public static void main(String[] args) {
        System.out.println("--- Sistema de Gerenciamento de Alunos ---");

        // 1. Chamar o método para exibir todos os dados e criar o objeto Aluno
        Aluno meAluno = solicitarDadosAluno();

        // 2. Chamar o método para exibir todos os dados e os status do aluno
        exibirDadosAluno(meAluno);

        // 3. Fechar o Scanner da classe Leitor
        Leitor.fecharScanner();

        System.out.println("Programa encerrado!");
    }
}
