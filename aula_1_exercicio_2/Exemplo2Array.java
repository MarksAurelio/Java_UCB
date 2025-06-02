package aula_1_exercicio_2;

public class Exemplo2Array {
    public static void main(String[] args) {
        Aluno[] alunos = Visao.criarAlunos(3);

        Visao.print(alunos);

    }
}

class Aluno {

    String nome;
    String matricula;
    char situacao;

}
