/* Faça um programa que receba 5 mil dados do usuário do tipo inteiro. Sabe-se que valores negativos não são aceitos. Após receber esses valores e popular o array, imprima na saída padrão a média dos valores, quantos valores são ímpares e todos os valores que foram informados. */
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumerosInteirosPositivosaImpares {
    public static void main(String[] args) {
        final int QUANTIDADE_DE_VALORES = 20;
        int[] dados = new int[QUANTIDADE_DE_VALORES];
        long somaValores = 0;
        int contadorImpares = 0;
        double mediaValores;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite " + QUANTIDADE_DE_VALORES + " números inteiros e positivos: ");

        for (int i = 0; i < QUANTIDADE_DE_VALORES; i++) {
            int valorDigitado;
            boolean entradaValida;

            do {
                System.out.println("Digite o " + (i + 1) + "ª número: ");
                entradaValida = true;
                try {
                    valorDigitado = scanner.nextInt();

                    if (valorDigitado <= 0) {
                        System.out.println("Valor inválido digite um número inteiro e positivo: ");
                        entradaValida = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Entrada inválida. Por favor, digite um NÚMERO inteiro.");
                    scanner.next();
                    valorDigitado = -1;
                    entradaValida = false;
                } finally {
                    scanner.nextLine();
                }

            } while (!entradaValida || valorDigitado <= 0);

            dados[i] = valorDigitado;
            somaValores += valorDigitado;

            if (valorDigitado % 2 != 0) {
                contadorImpares++;
            }
        }
        scanner.close();

        mediaValores = (double) somaValores / QUANTIDADE_DE_VALORES;

        System.out.println("Total de valores lidos: " + QUANTIDADE_DE_VALORES);
        System.out.println("Média dos valores lidos: " + String.format("%.2f", mediaValores));
        System.out.println("Quantidade de valores ímpares: " + contadorImpares);

        System.out.println("\n--- Todos os Valores Informados ---");

        for (int i = 0; i < QUANTIDADE_DE_VALORES; i++) {
            System.out.print(dados[i] + "\t"); // Imprime o valor e um tab
            if ((i + 1) % 10 == 0) { // A cada 10 valores, pula para a próxima linha
                System.out.println();
            }
        }

    }
}
