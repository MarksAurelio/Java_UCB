package com.matematica.figuras;

import java.util.ArrayList;
import java.util.List;

public class TesteFiguras {
    public static void main(String[] args) {
        // 1. Criar objetos das figuras geométricas
        Retangulo retangulo = new Retangulo();
        Triangulo triangulo = new Triangulo();
        Circulo circulo = new Circulo();

        // 2. Alocar valores aos atributos dos objetos
        retangulo.setNome("Retângulo1");
        retangulo.setBase(10.0);
        retangulo.setAltura(5.0);

        triangulo.setNome("Triângulo1");
        triangulo.setBase(10);
        triangulo.setAltura(8.66);

        circulo.setNome("Círculo1");
        circulo.setRaio(10.0);

        // 3. Adicionando as figuras geométricas em uma lista 
        List<FiguraGeometrica> listaFiguraGeometricas = new ArrayList<>();
        listaFiguraGeometricas.add(retangulo);
        listaFiguraGeometricas.add(triangulo);
        listaFiguraGeometricas.add(circulo);

        // 4. Finalmente mostrar os dados das figuras geométricas
        System.out.println("--- Dados das Figuras Geométricas ---");
        // Usando foreach para percorrer a lista e captar os dados em uma ordem
        for (FiguraGeometrica figuraGeometrica : listaFiguraGeometricas) {
            // Usando getDescricao para mostrar cada uma das figuras
            System.out.println(figuraGeometrica.getDescricao());
            // Usando o printf de forma a mostrar cada uma das figuras com seus respectivos dados
            System.out.printf("Área da figura: %.2f \n", figuraGeometrica.getArea());
            
        }
        System.out.println("--- Fim Teste ---");
    }
}
/* Apresentação Impressas do Loop (for):

--- Dados das Figuras Geométricas ---
Retângulo - Nome: Retângulo1, Base: 10.00, Altura: 5.00
Área da figura: 50.00 
Triângulo - Nome: Triângulo1, Base: 10.00, Altura: 8.66
Área da figura: 86.60 
Círculo - Nome: Círculo1, Raio: 10.00
Área da figura: 314.16  */ 