package com.matematica.figuras;

public abstract class FiguraGeometrica {
    private String nome; // Atributo para o nome da figura

    // Método Get e Set para o atributo nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método abstract para calcular a área, será sobrescrito nas subclasses
    public abstract double getArea();

    // Método abstract para obter a descrição da figura, também será sobrescrito nas
    // subclasses
    public abstract String getDescricao();

}
