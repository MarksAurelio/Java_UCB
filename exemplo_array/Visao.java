public class Visao {
    public static Aluno lerAluno() {
        Aluno a = new Aluno();
        a.nome = Leitor.lerString("Informe o nome do(a) aluno: ");
        a.matricula = Leitor.lerString("Informe a matrícula do(a) " + a.nome + ":");
        a.situacao = Leitor.lerCaractere("Informe a situação do(a) " + a.nome + ";");
        return a;
    }
}
