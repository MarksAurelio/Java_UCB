package sistema_funcionario;

public class Administrativo extends Funcionario {
    private int quantidadeDeDependentes;

    public Administrativo(String nome, String cpf, double salario, int quantidadeDeDependentes) {
        super(nome, cpf, salario);
        this.quantidadeDeDependentes = quantidadeDeDependentes;
    }

    public int getQuantidadeDeDependentes() {
        return quantidadeDeDependentes;
    }

    // Método para calcular a contribuição sindical (1%)
    public double getContribuicaoSindical() {
        return getSalario() * 0.01;
    }

    public String toString() {
        return super.toString() + "\n" +
                "Quantidade de Dependentes: " + quantidadeDeDependentes + "\n" +
                "Contribuição Sindical (1%): " + String.format("%.2f", getContribuicaoSindical());
    }
}
