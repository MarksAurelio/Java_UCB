/*Crie um projeto Java no ambiente eclipse (sugestão de nome de projeto - Aula2Exercicio1). Na sequência, crie uma classe com o nome Programa. Nesta classe, você deve fazer a entrada de dados das seguintes informações: o salário de um professor, a idade de uma criança, se um servidor público tem plano de saúde ou não, se uma pessoa é casada (c) ou solteira (s) e, por fim, o nome de um aluno.

Ao terminar as entradas de dados, você deve fazer a apresentação dos valores utilizando System.out.println(). Além disso, coloque textos com valor significativo para o usuário, por exemplo: "O nome informado foi: João Silveira Neto". */

package aula_2_exercicio_1;

import java.util.Scanner;

public class Programa {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        double salarioProfessor;
        int idadeCrianca;
        boolean temPlanoSaude;
        char estadoCivil;
        String nomeAluno;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o salário do professor: ");
        salarioProfessor = scanner.nextDouble();

        System.out.println("Digite a idade da criança: ");
        idadeCrianca = scanner.nextInt();

        scanner.nextLine();

        System.out.println("O servidor público tem plano de saúde: (true/false): ");
        temPlanoSaude = scanner.nextBoolean();

        scanner.nextLine();

        System.out.println("A pessoa é casada (c) ou solteira (s): ");
        estadoCivil = scanner.nextLine().charAt(0);

        System.out.println("Nome do aluno(a): ");
        nomeAluno = scanner.nextLine();

        scanner.close();

        // Apresentação dos dados

        System.out.println("O salário do professor foi: " + String.format("%.2f", salarioProfessor));
        System.out.println("A idade da criança é: " + idadeCrianca + " anos. ");
        System.out.println("O servidor público tem plano de saúde? " + (temPlanoSaude ? "Possui" : "Não Possui")
                + " plano de saúde. ");
        String statusCivil = (estadoCivil == 'c' || estadoCivil == 'C') ? "Casado(a)"
                : (estadoCivil == 's' || estadoCivil == 'S') ? "Solteiro(a)" : "Estado civil inválido";
        System.out.println("O estado civil da pesso é: " + statusCivil + ".");
        System.out.println("O nome do aluno(a) é: " + nomeAluno + ".");
    }
}
