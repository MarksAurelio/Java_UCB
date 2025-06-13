package geometria;

public abstract class Figura {
    protected double base; // Para acesso direto pelas subclasses
    protected double altura; // Para acesso direto pelas subclasses

    // Construtor
    public Figura(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base e altura deve ter valores positivos");
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

    // Método abstract para calcular a área
    public abstract double getArea();
}
