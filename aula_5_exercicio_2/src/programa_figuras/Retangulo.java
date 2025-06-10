package programa_figuras;

public class Retangulo extends FiguraGeometrica {

    public Retangulo(double base, double altura) {
        super(base, altura);
    }

    // Implementa o método abstrato para Retângulo
    public double calcularArea() {
        return base * altura;
    }

    // Sobrescreve o toString para identicar o tipo de figura
    public String toString() {
        return "Retângulo - " + super.toString() +
                ", Área: " + String.format("%.2f", calcularArea());
    }
}
