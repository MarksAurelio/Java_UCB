package gerenciador_turma_app;

public class Aluno {
    private String nome;
    private double nota1;
    private double nota2;
    private double media;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.calcularMedia();
    }

    private void calcularMedia() {
        this.media = (this.nota1 + this.nota2) / 2;
    }

    public String getNome() {
        return nome;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getMedia() {
        return media;
    }

    public String toString() {
        return "Nome: " + nome +
                ", Nota 1: " + String.format("%.2f", nota1) +
                ", Nota 2: " + String.format("%.2f", nota2) +
                ", Média: " + String.format("%.2f", media);
    }
}
