/* Faça um programa Java que receba duas notas de um estudante em valores double. Na sequência, apresente todos os valores informados, a média, e se ele está aprovado ou reprovado. Detalhe: você não deve permitir que os valores informados como notas sejam inferiores a 0 ou superiores a 10. Para validação, use do/while.*/
import java.util.Scanner;

public class MediaNota {
    public static void main(String[] args) {
        double notaUm;
        double notaDois;
        double mediaNota;
        final double NOTA_APROVACAO = 7.0;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Digite a primeira nota: ");
            notaUm = scanner.nextDouble();
            if (notaUm < 0 || notaUm > 10) {
                System.out.println("Valor inválido, por favor digite um valor entre 0 e 10: ");
            }
        } while (notaUm < 0 || notaUm > 10);

        scanner.nextLine();
        do {
            System.out.print("Digite a segunda nota: ");
            notaDois = scanner.nextDouble();
            if (notaDois < 0 || notaDois > 10) {
                System.out.println("Valor inválido, por favor digite um valor entre 0 e 10: ");
            }
        } while (notaDois < 0 || notaDois > 10);

        scanner.nextLine();

        mediaNota = (notaUm + notaDois) / 2;
        System.out.println("Primeira nota: " + notaUm);
        System.out.println("Segunda nota: " + notaDois);
        System.out.println("Média das notas: " + mediaNota);

        if (mediaNota >= NOTA_APROVACAO) {
            System.out.println("Aprovado!");
        } else {
            System.out.println("Reprovado!");
        }

        scanner.close();
    }
}
