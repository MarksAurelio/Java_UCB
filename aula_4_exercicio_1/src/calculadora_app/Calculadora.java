package calculadora_app;

public class Calculadora {
    private double operando1;
    private double operando2;
    private String operador;

    public Calculadora(double operando1, double operando2, String operador) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operador = operador;
    }

    public double somar() {
        return this.operando1 + this.operando2;
    }

    public double subtrair() {
        return this.operando1 - this.operando2;
    }

    public double multiplicar() {
        return this.operando1 * this.operando2;
    }

    public double dividir() {
        if (this.operando2 == 0) {
            throw new ArithmeticException("Erro: divisão por 0 não é permitida.");
        }
        return this.operando1 / this.operando2;
    }

    public double getOperando1() {
        return operando1;
    }

    public double getOperando2() {
        return operando2;
    }

    public String getOperador() {
        return operador;
    }
}
