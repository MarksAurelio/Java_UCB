/* Faça um programa Java que receba o nome de um estudante e duas notas. Na sequência, apresente todos os valores informados, a média, e se ele está aprovado ou reprovado. Detalhe: você não deve permitir que os valores informados como notas sejam inferiores a 0 ou superiores a 10. O usuário deve informar se quer continuar a usar o programa informando S-Sim ou N-Não.*/
import java.util.Scanner;

public class MediaNotaContinuar {
    public static void main(String[] args) {
        String nomeEstudante;
        double notaUm;
        double notaDois;
        double mediaNota;
        final double NOTA_APROVACAO = 7.0;
        char continuar;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Digite o nome do(a) estudante: ");
            nomeEstudante = scanner.nextLine();

            do {
                System.out.println("Digite a primeira nota: ");
                notaUm = scanner.nextDouble();
                if (notaUm < 0 || notaUm > 10) {
                    System.out.println("Valor inválido, digite um valor entre 0 a 10: ");
                }
            } while (notaUm < 0 || notaUm > 10);
            scanner.nextLine();
            do {
                System.out.println("Digite a segunda nota: ");
                notaDois = scanner.nextDouble();
                if (notaDois < 0 || notaDois > 10) {
                    System.out.println("Valor inválido, digite um valor entre 0 a 10: ");
                }
            } while (notaDois < 0 || notaDois > 10);
            scanner.nextLine();

            mediaNota = (notaUm + notaDois) / 2.0;

            System.out.println("Nome do(a) estudante: " + nomeEstudante);
            System.out.println("Primeira Nota: " + notaUm);
            System.out.println("Segunda Nota: " + notaDois);
            System.out.println("A média das notas: " + mediaNota);

            if (mediaNota >= NOTA_APROVACAO) {
                System.out.println("Aprovado!");
            } else {
                System.out.println("Reprovado!");
            }

            System.out.println("Deseja continuar? (S/N): ");
            String inputContinuar = scanner.nextLine();
            continuar = inputContinuar.isEmpty() ? 'N' : Character.toUpperCase(inputContinuar.charAt(0));
        } while (continuar == 'S');

        System.out.println("Progrma Encerrado!");

        scanner.close();
    }
}
