package aula_1_exercicio_2;

import aula_3_exercicio_4.Leitor;

public class Visao {
    public static Aluno lerAluno() {
        Aluno a = new Aluno();
        a.nome = Leitor.lerString("Informe o nome do(a) aluno: ");
        a.matricula = Leitor.lerString("Informe a matrícula do(a) " + a.nome + ":");
        a.situacao = Leitor.lerCaractere("Informe a situação do(a) " + a.nome + ":");
        return a;
    }

    public static Aluno[] criarAlunos(int quantidade) {
        Aluno[] alunos = new Aluno[quantidade];
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = lerAluno();
        }
        return alunos;
    }

    public static void print(Aluno aluno) {
        System.out.println("Nome: " + aluno.nome);
        System.out.println("Matrícula: " + aluno.matricula);
        System.out.println("Situação: " + aluno.situacao);
        System.out.println();
    }

    public static void print(Aluno[] alunos) {
        for (int i = 0; i < alunos.length; i++) {
            print(alunos[i]);
        }

    }
}
