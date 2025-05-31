public class Exemplo2Array {
    public static void main(String[] args) {
        Aluno a = Visao.lerAluno();
        System.out.printf("Nome: %s\nMatrícula: %s\nSituação: %c\n", a.nome, a.matricula, a.situacao);
    }
}

class Aluno {

    String nome;
    String matricula;
    char situacao;
}
