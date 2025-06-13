package geometria;

public class Retangulo extends Figura {
    public Retangulo(double base, double altura) {
        super(base, altura);
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base e altura devem ser positivos.");
        }
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return (base * altura) / 2;
    }

    @Override
    public String toString() {
        return "Retângulo - Base: " + String.format("%.2f", base) +
                ", Altura: " + String.format("%.2f", altura);
    }

}
