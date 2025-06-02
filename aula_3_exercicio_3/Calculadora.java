package aula_3_exercicio_3;

public class Calculadora {
    public static double adicionar(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtrair(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public static double dividir(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Erro: Divisão por zero não é permitida!");
            return Double.NaN;

        }
        return num1 / num2;
    }

    public static double expoente(double base, double expoente) {
        return Math.pow(base, expoente);
    }
}
