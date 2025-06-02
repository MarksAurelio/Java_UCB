/* Escreva um programa Java que lê um valor n inteiro e positivo e que calcule a seguinte soma por meio de um método chamado somar S: S:= 1 + 1/2 + 1/3 + 1/4 + ... + 1/n */
package aula_3_exercicio_6;

public class ProgramaSerieHarmonica {
    public static void main(String[] args) {
        int n = 0;
        boolean entradaValida = false;

        // Loop de validação para garantir que 'n' seja um número inteiro e positivo
        while (!entradaValida) {
            n = Leitor.lerInt("Informe um número inteiro e positivo para 'n': ");

            if (n > 0) { // 'n' deve ser estritamente maior que zero para a série
                entradaValida = true;
            } else {
                System.out.println("Erro: O valor de 'n' deve ser um número inteiro e positivo. Tente novamente.");
            }
        }

        double resultadoSoma = CalculadoraSerieHarmonica.somarS(n);

        System.out.printf("Para n = %d, o somatório S é: %.6f%n", n, resultadoSoma);

        Leitor.fecharScanner();

        System.out.println("Programa Encerrado!");

    }
}
