package com.matematica.figuras;

public class Circulo extends FiguraGeometrica {
    private double raio; // Atributo para raio

    // Métodos Get e Set para o atributo raio
    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    // Agora sobrescrever o método getArea para calcular a área do Círculo
    @Override
    public double getArea() {
        return Math.PI * raio * raio; // Fórmula para calcular a área usando a biblioteca Math
    }

    // Por fim, sobrescrever o método getDescricao agora para mostrar o raio do
    // Círculo
    @Override
    public String getDescricao() {
        return "Círculo - Nome: " + getNome() +
                ", Raio: " + String.format("%.2f", raio);
    }
}
