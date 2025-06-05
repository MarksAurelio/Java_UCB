package programa_aluno;
public class Aluno {
    private String nome;
    private double nota1;
    private double nota2;

    private static final double MEDIA_APROVACAO = 7.0;

    // Construtor para criar um objeto Aluno.
    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;

    }

    // Métodos Getters (para acessar os valores dos atributos)
    public String getNome() {
        return nome;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    // Calcula a média das duas notas do aluno.
    public double calcularMedia() {
        return (nota1 + nota2) / 2.0;
    }

    // Verifica se o aluno está aprovado com base na média de aprovação
    // (MEDIA_APROVACAO).
    // true se a média do aluno for maior ou igual à MEDIA_APROVACAO, false caso
    // contrário.
    public boolean estaAprovado() {
        return calcularMedia() >= MEDIA_APROVACAO;
    }

    // Retorna uma representação em String de todos os dados do aluno (nome, notas,
    // média).
    public String toString() {
        return "Nome: " + nome +
                "\nNota1: " + String.format("%.2f", nota1) +
                "\nNota2: " + String.format("%.2f", nota2) +
                "\nMédia " + String.format("%.2f", calcularMedia());
    }
}
