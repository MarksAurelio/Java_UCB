package universidade;

import java.util.Objects;

public abstract class Funcionario {
    protected String nome;
    protected String matricula;
    protected String cpf;
    protected double salario;

    public Funcionario(String nome, String matricula, String cpf, double salario) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("Matrícula é obrigatória.");
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("Cpf não pode ser vazio.");
        }
        if (salario < 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo");
        }
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public abstract double getImpostoDeRenda();

    // Sobrescrevendo equals para não repetir mesmo número de matrícula
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Funcionario that = (Funcionario) o;
        return matricula.equals(that.matricula); // Comparação pela matrícula
    }

    // Sobrescrevendo hashCode em conjunto com equals
    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Matrícula: " + matricula + "\n" +
                "CPF: " + cpf + "\n" +
                "Salário: " + String.format("%.2f", getSalario());
    }
}
