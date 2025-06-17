package aula_4_exercicio_1_desafio.src.gerenciador_candidatos_app;

public class Candidato {
    private String nome;
    private int numeroFiliacao;
    private String tipoCandidatura; // Federal, Distrital e Senador
    private boolean reeleito;
    private double verbaCampanha;

    public Candidato(String nome, int numeroFiliacao, String tipoCandidatura, boolean reeleito) {
        this.nome = nome;
        this.numeroFiliacao = numeroFiliacao;
        this.tipoCandidatura = tipoCandidatura;
        this.reeleito = reeleito;
        calcularVerbaCampanha(); // Chama o método para calcaular a verba
    }

    private void calcularVerbaCampanha() {
        switch (this.tipoCandidatura.toLowerCase()) {
            case "distrital":
                this.verbaCampanha = 170000.00;
                break;
            case "federal":
                this.verbaCampanha = 250000.00;
                break;
            case "senador":
                this.verbaCampanha = 350000.00;
                break;
            default:
                this.verbaCampanha = 0.00; // Define como 0 para tipos de candidaturas inválidos
                break;
        }
        if (this.reeleito) {
            this.verbaCampanha *= 2; // Dobra a verba do candidato ser for reeleito
        }
    }

    // Métodos Getters para acessar os atributos da classe
    public String getNome() {
        return nome;
    }

    public int getNumeroFiliacao() {
        return numeroFiliacao;
    }

    public String getTipoCandidatura() {
        return tipoCandidatura;
    }

    public boolean isReeleito() {
        return reeleito;
    }

    public double getVerbaCampanha() {
        return verbaCampanha;
    }

    public String toString() {
        return "Nome: " + nome +
                ", N° Filiação: " + numeroFiliacao +
                ", Candidatura: " + tipoCandidatura.substring(0, 1).toUpperCase() + tipoCandidatura.substring(1) +
                ", Reeleito: " + (reeleito ? "Sim" : "Não") +
                ", Verba de Campanha: R$ " + String.format("%.2f", verbaCampanha);
    }
}
