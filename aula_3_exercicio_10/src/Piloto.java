public class Piloto {
    private String nome;
    private String escudeira;
    private double tempoVolta; // Minutos

    // Construtor para criar o ojeto Piloto
    public Piloto(String nome, String escudeira, double tempoVolta) {
        this.nome = nome;
        this.escudeira = escudeira;
        this.tempoVolta = tempoVolta;
    }

    // Métdos Getters
    public String getNome() {
        return nome;
    }

    public String getEscudeira() {
        return escudeira;
    }

    public double getTempoVolta() {
        return tempoVolta;
    }

    // Retorna uma representação de String de todos os dados do piloto
    // para imprimir facilmente as informações
    public String toString() {
        return String.format("Nome: %s, Escudeira: %s, Tempo Volta: %.2f min", nome, escudeira, tempoVolta);
    }
}
