/* Você deve fazer a implementação de uma classe chamada MyMath.java, que deverá ter quatro métodos conforme a listagem a seguir:

Receber um número inteiro como argumento e calcular o fatorial.
Receber dois valores como argumento e retornar o número que for maior.
Receber um valor inteiro como argumento e retornar se ele é um número par. (retorne true ou false)
Receber um número inteiro e retornar se ele é um número primo matemático (desafio).
Faça um programa principal para testar sua classe implementada com valores atribuídos a sua escolha. */
package aula_3_exercicio_5;

import aula_3_exercicio_1.Leitor;

public class TesteMyMath {
    public static void main(String[] args) {
        System.out.println("Teste da Classe MyMath");

        // Teste Fatorial
        int numFatorial = Leitor.lerInt("Informe o número inteiro para calcular o fatorial (positivo):");
        long resultadoFatorial = MyMath.calcularFatorial(numFatorial);
        if (resultadoFatorial != -1) {
            System.out.printf("O fatorial de %d é %d%n ", numFatorial, resultadoFatorial);
        }
        // Teste Maior número
        double valor1 = Leitor.lerDouble("Informe o primeiro número para comparar:");
        double valor2 = Leitor.lerDouble("Informe o segundo número para comparar:");
        double maior = MyMath.encontrarMaior(valor1, valor2);
        System.out.printf("Entre %.2f e %.2f, o maior número é: %.2f%n", valor1, valor2, maior);

        // Teste número Par
        int numPar = Leitor.lerInt("Informe o número inteiro para saber se é Par ou Ímpar:");
        if (MyMath.isPar(numPar)) {
            System.out.printf("%d é Par.%n", numPar);
        } else {
            System.out.printf("%d é Ímpar.%n", numPar);
        }
        // Teste se número é Primo
        int numPrimo = Leitor.lerInt("Informe o número para saber se é Primo:");
        if (MyMath.isPrimo(numPrimo)) {
            System.out.printf("%d é Primo.%n", numPrimo);
        } else {
            System.out.printf("%d não é Primo.%n", numPrimo);
        }
        Leitor.fecharScanner();
        System.out.println("Leitor MyMath finalizado!");
    }
}
