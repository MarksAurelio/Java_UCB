package gerenciador_conceitos_app;

public class AlunoConceito {
    private String matricula;
    private double nota;
    private char conceito; // A, B, C ou D

    public AlunoConceito(String matricula, double nota) {
        this.matricula = matricula;
        this.nota = nota;
        this.calcularConceito(); // Calcula o conceito assim que o aluno é criado
    }

    /**
     * Calcula o conceito do aluno com base na nota, seguindo a tabela:
     * 0.0 a 4.9: D
     * 5.0 a 6.9: C
     * 7.0 a 8.9: B
     * 9.0 a 10.0: A
     */
    public void calcularConceito() {
        if (nota >= 9.0 && nota <= 10.9) {
            this.conceito = 'A';
        } else if (nota >= 7.0 && nota <= 8.9) {
            this.conceito = 'B';
        } else if (nota >= 5.0 && nota <= 6.9) {
            this.conceito = 'C';
        } else if (nota >= 0.0 && nota <= 4.9) {
            this.conceito = 'D';
        } else {
            this.conceito = '?';
            System.err.println("Atenção: Nota inválida para a matrícula " + this.matricula + ". Conceito indefinido.");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public double getNota() {
        return nota;
    }

    public char getConceito() {
        return conceito;
    }

    public String toString() {
        return "Matrícula: " + matricula +
                ", Nota: " + String.format("%.2f", nota) +
                ", Conceito: " + conceito;
    }
}
