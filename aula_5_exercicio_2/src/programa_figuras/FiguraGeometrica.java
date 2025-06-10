package programa_figuras;

public abstract class FiguraGeometrica {
    protected double base;
    protected double altura;
    
    public FiguraGeometrica(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base e altura devem ser valores positivos");
        }
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    // Método abstrato para calcular a área. Cada figura implementa de forma
    // diferente
    public abstract double calcularArea();

    // Método toString básico para as informações comuns
    public String toString() {
        return "Base: " + String.format("%.2f", base) +
                ", Altura: " + String.format("%.2f", altura);

    }
}
