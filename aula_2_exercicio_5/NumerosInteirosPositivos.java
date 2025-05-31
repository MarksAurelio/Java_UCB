/* Escreva um programa Java que leia 500 valores inteiros e positivos e:

Encontre o maior valor.
Encontre o menor valor.
Calcule a média dos números lidos.
Faça as apresentações para o usuário de forma organizada. */
import java.util.Scanner;

public class NumerosInteirosPositivos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maiorValor = 0;
        int menorValor = Integer.MAX_VALUE;
        long somaValores = 0;
        int contadorValores = 0;
        double mediaValores;
        final int QUANTIDADE_DE_VALORES = 500;

        System.out.println("Digite " + QUANTIDADE_DE_VALORES + " números positivos e inteiros.");

        for (int i = 1; i <= QUANTIDADE_DE_VALORES; i++) {
            int valorAtual;

            do {
                System.out.print("Digite o " + i + "ª ");
                valorAtual = scanner.nextInt();
                if (valorAtual <= 0) {
                    System.out.println("Valor inválido, digite um número POSITIVO inteiro. ");
                }
            } while (valorAtual <= 0);
            scanner.nextLine();

            if (valorAtual > maiorValor) {
                maiorValor = valorAtual;
            }

            if (valorAtual < menorValor) {
                menorValor = valorAtual;
            }

            somaValores += valorAtual;
            contadorValores++;

        }

        if (contadorValores > 0) {
            mediaValores = (double) somaValores / contadorValores;
        } else {
            mediaValores = 0;
        }

        System.out.println("Total de valores lidos: " + contadorValores);
        System.out.println("Maior valor encontrado: " + maiorValor);
        System.out.println("Menor valor encontrado: " + menorValor);
        System.out.println("Soma de todos os valores: " + somaValores);
        System.out.println("Média dos valores lidos: " + mediaValores);

        scanner.close();
    }
}
