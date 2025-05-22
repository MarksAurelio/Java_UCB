package exercicio_media_nota;

import java.util.Scanner;

@SuppressWarnings("all")

public class Programa {
    public static void main(String[] args) {
        char opcao = 'N';
        do {
            System.out.print("Informe o nome do aluno(a): ");
            String nome = new Scanner(System.in).nextLine();

            double notaUm;
            do {
                System.out.print("Digite a primeira nota: ");
                notaUm = new Scanner(System.in).nextDouble();
                if (notaUm < 0 || notaUm > 10) {
                    System.out.println("Opção inválida!");
                }

            } while (notaUm < 0 || notaUm > 10);

            double notaDois;
            do {
                System.out.print("Digite a segunda nota: ");
                notaDois = new Scanner(System.in).nextDouble();
                if (notaDois < 0 || notaDois > 10) {
                    System.out.println("Opção inválida!");
                }

            } while (notaDois < 0 || notaDois > 10);

            double media = (notaUm + notaDois) / 2;
            if (media >= 7.0) {
                System.out.println("Aprovado");
            } else {
                System.out.println("Reprovado");
            }
            System.out.println("A média de " + nome + " é " + media);

            System.out.println("Deseja continuar? S - Sim ou N - Não");
            opcao = new Scanner(System.in).next().charAt(0);
        } while (opcao == 'S' || opcao == 's');
    }
}