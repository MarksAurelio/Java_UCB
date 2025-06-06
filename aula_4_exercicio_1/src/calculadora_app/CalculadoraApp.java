/* Crie um programa que seja uma calculadora, a partir de todos os conceitos que você aprendeu. Sua solução deve ter uma classe chamada Calculadora, que terá três atributos (dois operandos e um operador) e quatro métodos (que fazem as operações básicas: soma, subtração, multiplicação e divisão), que retornarão os resultados. Crie as leituras do usuário e faça a apresentação devida. */
package calculadora_app;

import java.util.InputMismatchException;

public class CalculadoraApp {
    public static void main(String[] args) {
        Leitor leitor = new Leitor();

        System.out.println("--- Calculadora Simples ---");

        double num1 = leitor.obterNumeroDouble("Digite o primeiro número:");
        String operador = leitor.obterOperador();
        double num2 = leitor.obterNumeroDouble("Digite o segundo número:");

        Calculadora calculadora = new Calculadora(num1, num2, operador);

        double resultado = 0;
        boolean operacaoSucesso = true;

        switch (operador) {
            case "+":
                resultado = calculadora.somar();
                break;
            case "-":
                resultado = calculadora.subtrair();
                break;
            case "*":
                resultado = calculadora.multiplicar();
                break;
            case "/":
                try {
                    resultado = calculadora.dividir();
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    operacaoSucesso = false;
                }
            default:
                System.out.println("Operador inválido. Digite o operador (+, -, * ou /):");
                operacaoSucesso = false;
                break;
        }
        if (operacaoSucesso) {
            System.out.println("--- Resultado ---");
            System.out.printf("O resultado da Operação de %.2f %s %.2f = %.2f%n", num1, operador, num2, resultado);
        }
        leitor.fecharScanner();
    }
}
