package universidade;

public class Diretor extends Funcionario {
    private int tempoDecasaAnos;

    public Diretor(String nome, String matricula, String cpf, double salario, int tempoDecasaAnos) {
        super(nome, matricula, cpf, salario);
        if (tempoDecasaAnos < 0) {
            throw new IllegalArgumentException("Tempo de Casa não pode ser negativo");
        }
        this.tempoDecasaAnos = tempoDecasaAnos;
    }

    public int getTempoDecasaAnos() {
        return tempoDecasaAnos;
    }

    @Override
    public double getImpostoDeRenda() {
        return this.getSalario() * 0.23;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tipo: Diretor\n" +
                "Tempo de Casa: " + tempoDecasaAnos + "\n" +
                "Imposto de Renda (23%): R$" + String.format("%.2f", getImpostoDeRenda());
    }
}
