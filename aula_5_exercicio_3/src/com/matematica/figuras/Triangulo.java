package com.matematica.figuras;

public class Triangulo extends FiguraGeometrica {
    private double base; // Atributo para base
    private double altura; // Atributo para altura

    // Métodos Gets e Sets para os atributos (base, altura)
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

    // Aqui sobrescrevo o método getArea para calcular a área do Triângulo
    @Override
    public double getArea() {
        return base * altura;
    }

    // Sobrescrevo o método getDescricao agora para mostrar a base e altura do
    // Triânngulo
    @Override
    public String getDescricao() {
        return "Triângulo - Nome: " + getNome() +
                ", Base: " + String.format("%.2f", getBase()) +
                ", Altura: " + String.format("%.2f", getAltura());
    }
}
