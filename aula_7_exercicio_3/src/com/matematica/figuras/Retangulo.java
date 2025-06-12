package com.matematica.figuras;

public class Retangulo extends FiguraGeometrica {
    private double base; // Atributo para a base
    private double altura; // Atributo para a altura

    // Métodos Gets e Sets para os dois atributos(base, altura)
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Aqui sobrescrevo o método getArea para calcular a área do Retângulo
    @Override
    public double getArea() {
        return base * altura;
    }

    // Já aqui sobrescrevo o método getDescricao para mostrar base e altura do
    // Retângulo
    @Override
    public String getDescricao() {
        return "Retângulo - Nome: " + getNome() +
                ", Base: " + String.format("%.2f", base) +
                ", Altura: " + String.format("%.2f", altura);
    }
}
