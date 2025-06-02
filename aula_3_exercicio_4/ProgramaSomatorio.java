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
