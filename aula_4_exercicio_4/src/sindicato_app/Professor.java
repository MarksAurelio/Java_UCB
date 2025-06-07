package sindicato_app;

public class Professor {
    private String nome;
    private String cfp;
    private String titulacao; // Doutor, Mestre ou Graduado
    private double salario;
    private double contribuicaoSindical;

    public Professor(String nome, String cfp, String titulacao, double salario) {
        this.nome = nome;
        this.cfp = cfp;
        this.titulacao = titulacao;
        this.salario = salario;
        this.calcularContribuicaoSindical();
    }
    /*
     * Calcula a contribuição sindical com base na titulação e no salário.
     * Graduado: 1.2%
     * Mestre: 1.4%
     * Doutor: 1.6%
     */
    private void calcularContribuicaoSindical() {
        double percentualContribuicao = 0.0;
        switch (this.titulacao.toLowerCase()) {
            case "graduado":
                percentualContribuicao = 0.012;
                break;
            case "mestre":
                percentualContribuicao = 0.014;
                break;
            case "doutor":
                percentualContribuicao = 0.016;
                break;
            default:
                System.err.println(
                        "Titulação inválida para o professor " + this.nome + ". Contribuição definida como 0.");
                break;
        }
        this.contribuicaoSindical = this.salario * percentualContribuicao;
    }

    public String getNome() {
        return nome;
    }

    public String getCfp() {
        return cfp;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public double getSalario() {
        return salario;
    }

    public double getContribuicaoSindical() {
        return contribuicaoSindical;
    }

    public String toString() {
        return "Nome: " + nome +
                ", CPF: " + cfp +
                ", Titulação: " + titulacao.substring(0, 1).toUpperCase() + titulacao.substring(1) +
                ", Salário: R$ " + String.format("%.2f", salario) +
                ", Contribuição Sindical: " + String.format("%.2f", contribuicaoSindical);
    }
}
