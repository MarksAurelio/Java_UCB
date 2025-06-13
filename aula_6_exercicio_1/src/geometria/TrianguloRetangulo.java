package geometria;

public class TrianguloRetangulo extends Figura {
    // Construtor que chama o construtor da classe pai
    public TrianguloRetangulo(double base, double altura) {
        super(base, altura);
    }

    // Implementa o método abstrato getArea() para TrianguloRetangulo
    @Override
    public double getArea() {
        return (base * altura) / 2;
    }

    // Método específico para calcular a hipotenusa
    public double calcularHipotenusa() {
        return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }

    // Método toString para representação textual
    public String toString() {
        return "Triângulo Retângulo - Base: " + String.format("%.2f", base) +
                ", Altura: " + String.format("%.2f", altura) +
                ", Hipotenusa: " + String.format("%.2f", calcularHipotenusa());
    }

}
