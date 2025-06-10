package sistema_funcionario;

public class Professor extends Funcionario {
    private String titulacao;

    public Professor(String nome, String cpf, double salario, String titulacao) {
        super(nome, cpf, salario);
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    // Método para calcular o imposto de renda 23% do salário
    public double getImpostoRenda() {
        return getSalario() * 0.23;
    }

    public String toString(){
        return super.toString() + "\n" +
                                    "Titulação: " + titulacao + "\n" +
                                    "Imposto de Renda (23%): R$" + String.format("%.2f", getImpostoRenda());
    }
}
