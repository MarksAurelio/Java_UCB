package gerenciador_triatletas_app;

public class Atleta {
    private int numeroInscricao; // Dever ser único
    private String nome;
    private int tempoProvasHoras;
    private int idade;
    private boolean elite; // Calculado pelo método isElite()

    public Atleta(int numeroInscricao, String nome, int tempoProvasHoras, int idade) {
        this.numeroInscricao = numeroInscricao;
        this.nome = nome;
        this.tempoProvasHoras = tempoProvasHoras;
        this.idade = idade;
        this.elite = isElite(); // Calcula o status de elite no momento da criação
    }

    // Um atleta é elite se o tempo de prova for menor que 5 horas
    public boolean isElite() {
        return this.tempoProvasHoras < 5;
    }

    public int getNumeroInscricao() {
        return numeroInscricao;
    }

    public String getNome() {
        return nome;
    }

    public int getTempoProvasHoras() {
        return tempoProvasHoras;
    }

    public int getIdade() {
        return idade;
    }

    // O getter para elite retorna o valor já calculado pelo construtor isElite()
    public boolean getEliteStatus() {
        return elite;
    }

    public String toString() {
        return "Inscrição: " + numeroInscricao +
                ", Nome: " + nome +
                ", Tempo de Prova: " + tempoProvasHoras +
                ", Idade: " + idade +
                ", Elite: " + (elite ? "Sim" : "Não");
    }
}
