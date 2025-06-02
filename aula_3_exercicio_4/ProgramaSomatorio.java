/* Implemente um programa em Java que calcule o somatório de um número inteiro positivo recebido pelo usuário (efetue a validação para garantir esta premissa). Um método chamado somatório deve ser criado por você. Como parâmetro, ele deve receber um número, e o retorno deve ser a soma de todos os números anteriores até o zero. Por exemplo: se for passado 3 para o método, deve retornar a soma de 0 + 1 + 2 + 3. */
package aula_3_exercicio_4;

public class ProgramaSomatorio {
    public static void main(String[] args) {
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            numero = Leitor.lerInt("Informe um número inteiro: ");

            if (numero >= 0) {
                entradaValida = true;
            } else {
                System.out.println("Erro: O número deve ser inteiro e positivo (ou zero). Tente novamente.");
            }
        }
        int resultadoSomatorio = CalculadoraSomatorio.somatorio(numero);

        System.out.printf("O resultado do somatório de 0 até %d é: %d%n", numero, resultadoSomatorio);

        Leitor.fecharScanner();
    }
}
