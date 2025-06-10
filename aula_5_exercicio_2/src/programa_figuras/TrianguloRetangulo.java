package programa_figuras;

public class TrianguloRetangulo extends FiguraGeometrica {

    public TrianguloRetangulo(double base, double altura) {
        super(base, altura);
    }

    // Implementa o método abstrato para calcular área para o Triângulo Retângulo
    public double calcularArea() {
        return (base * altura) / 2;
    }

    // Método específico para calcular a hipotenusa
    public double calcularHipotenusa() {
        // Teorema de Pitágoras: hipotenusa² = base² * altura²
        return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }

    // Sobrescreve o toString para identificar o tipo de figura e incluir a
    // hipotenusa
    public String toString() {
        return "Triângulo Retângulo - " + super.toString() +
                ", Área: " + String.format("%.2f", calcularArea()) +
                ", Hipotenusa: " + String.format("%.2f", calcularHipotenusa());
    }
}
