package metodosSomar;

import java.util.Scanner;

public class MetodoSomar {
    public static void main(String[] args) {
        double numUm, numDois;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        numUm = scanner.nextDouble();

        System.out.println("Digite o segundo número: ");
        numDois = scanner.nextDouble();

        double resultado = somar(numUm, numDois);
        System.out.println("O resultado da soma é: " + resultado);

        scanner.close();
    }

    public static double somar(double valorUm, double valorDois) {
        return (valorUm + valorDois);

    }

}
