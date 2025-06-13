package com.anonimousti.peoplesoft.model;

import java.util.Objects; // Importar para usar Objects.hash() no hashCode

public class Pessoa {
    private String nome;
    private int codigo;
    private double salario;

    public Pessoa(String nome, int codigo, double salario) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        if (codigo <= 0) {
            throw new IllegalArgumentException("O código deve ser um número positivo.");
        }
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo.");
        }
        this.nome = nome;
        this.codigo = codigo;
        this.salario = salario;
    }

    // Getters para acessar os atributos
    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getSalario() {
        return salario;
    }

    // Método para calcular a classe social (fora do toString)
    public String calcularClasseSocial() {
        if (salario > 14400.00) {
            return "A1";
        } else if (salario > 8100.00) {
            return "A2";
        } else if (salario > 4600.00) {
            return "B";
        } else if (salario > 2300.00) {
            return "C";
        } else if (salario > 1400.00) {
            return "D";
        } else if (salario > 950.00) {
            return "E";
        } else if (salario > 400.00) {
            return "F";
        } else {
            return "Não Classificado (renda igual ou menor que R$ 400)";
        }
    }

    // Sobrescrevendo equals para comparar Pessoas pelo código
    @Override
    public boolean equals(Object o) {
        // Se o objeto é o mesmo, são iguais
        if (this == o)
            return true;
        // Se o objeto é nulo ou de uma classe diferente, não são iguais
        if (this == null || getClass() != o.getClass())
            return false;
        // Faz o cast para Pesso
        Pessoa pessoa = (Pessoa) o;
        // Compara o objeto pelo atributo "código"
        return codigo == pessoa.codigo;
    }

    // --- Sobrescrevendo hashCode de acordo com o equals ---
    // É uma boa prática sobrescrever hashCode sempre que equals é sobrescrito,
    // garantindo que objetos iguais (pelo equals) tenham o mesmo hashCode.
    @Override
    public int hashCode() {
        return Objects.hash(codigo); // O hashCode é baseado em código
    }

    // Método toString para apresentar as informações, incluindo a classe social
    // calculada
    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Código: " + codigo + "\n" +
                "Salário: R$" + String.format("%.2f", salario) + "\n" +
                "Classe Social: " + calcularClasseSocial(); // Chama o método de calcula aqui
    }
}
