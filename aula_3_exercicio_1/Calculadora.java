package aula_3_exercicio_1;

public class Calculadora {
    public static double calcularDivida(double divida, double jurosMensal) {
        double juros = divida * jurosMensal;
        double total = divida + juros;
        return total;
    }
}
