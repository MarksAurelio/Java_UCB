/* Escreva um programa em Java que leia a idade e a altura de 10 pessoas. Calcule e informe a média das alturas das pessoas com mais de 50 anos. Para isso, use for. */
import java.util.Scanner;

public class IdadeAltura {
    public static void main(String[] args) {
        int idade;
        double altura;
        double somaAltura50Anos = 0.0;
        int contador50Anos = 0;
        double mediaAltura50Anos;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a idade e a altura de 10 pessoas: ");

        for (int i = 1; i < 10; i++) {
            System.out.println("\nPessoa " + i);

            System.out.print("Digite a idade: ");
            idade = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite a altura (em metros - ex 1.70): ");
            altura = scanner.nextDouble();
            scanner.nextLine();

            if (idade > 50) {
                somaAltura50Anos += altura;
                contador50Anos++;
            }
        }
        scanner.close();
        if (contador50Anos > 0) {
            mediaAltura50Anos = somaAltura50Anos / contador50Anos;
            System.out.println("Total de pessoas com mais de 50 anos: " + contador50Anos);
            System.out.println("A média das alturas das pessoas com mais de 50 anos: "
                    + mediaAltura50Anos + " metros.");
        } else {
            System.out.println("Nenhuma pessoa com mais de 50 anos foi informada.");
        }
    }
}
