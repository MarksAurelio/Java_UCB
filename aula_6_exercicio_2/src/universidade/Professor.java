package universidade;

public class Professor extends Funcionario {
    private int anoDeAdmissao;

    public Professor(String nome, String matricula, String cpf, double salario, int anoDeAdmissao) {
        super(nome, matricula, cpf, salario);
        if (anoDeAdmissao <= 1900 || anoDeAdmissao > java.time.Year.now().getValue()) {
            throw new IllegalArgumentException("Ano de admissão inválido.");
        }
        this.anoDeAdmissao = anoDeAdmissao;
    }

    public int getAnoDeAdmissao() {
        return anoDeAdmissao;
    }

    @Override
    public double getImpostoDeRenda() {
        return this.getSalario() * 0.20;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tipo: Professor\n" +
                "Ano de admissão: " + anoDeAdmissao + "\n" +
                "Imposto de Renda (20%): R$" + String.format("%.2f", getImpostoDeRenda());
    }
}
