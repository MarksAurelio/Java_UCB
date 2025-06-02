/* Você deve implementar uma calculadora. O usuário informará um valor, um operador e outro valor. Execute a operação e apresente o resultado. Faça uso do maior número de métodos que conseguir visualizar (na entrada de dados, nas operações). As operações disponíveis para esta calculadora são: adicionar, subtrair, dividir, multiplicar e expoente. Para o cálculo do expoente, pesquise no hiperlink. */
package aula_3_exercicio_3;

public class ProgramaCalculadora {
    public static void main(String[] args) {

        double valor1 = Leitor.lerDouble("Informe o primeiro valor: ");

        String operador = Leitor.lerString("Qual operador? +, -, *, / ou ^ para expoente:");

        double valor2 = Leitor.lerDouble("Informe o segundo valor: ");

        double resultado;
        boolean operacaoValida = true;

        switch (operador) {
            case "+":
                resultado = Calculadora.adicionar(valor1, valor2);
                break;
            case "-":
                resultado = Calculadora.subtrair(valor1, valor2);
                break;
            case "*":
                resultado = Calculadora.multiplicar(valor1, valor2);
                break;
            case "/":
                resultado = Calculadora.dividir(valor1, valor2);
                if (Double.isNaN(resultado)) {
                    operacaoValida = false;
                }
                break;
            case "ˆ":
                resultado = Calculadora.expoente(valor1, valor2);
                break;
            default:
                System.out.println("Operador inválido, escolha +, -, *, / ou ^ para expoente.");
                resultado = 0;
                operacaoValida = false;
                break;

        }
        if (operacaoValida) {
            System.out.printf("\nResultado da operação: %.2f %s %.2f = %.2f%n ", valor1, operador, valor1,
                    resultado);
        }
        Leitor.fecharScanner();

        System.out.println("Calculadora encerrada!");

    }
}
