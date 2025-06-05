package cadastro_alunos;
enum SituacaoAluno {
    REGULAR,
    BOLSISTA
}

public class Aluno {
    private String nome;
    private String matricula;
    private SituacaoAluno situacao;

    // Construtor para criar um objeto Aluno
    public Aluno(String nome, String matricula, SituacaoAluno situacao) {
        this.nome = nome;
        this.matricula = matricula;
        this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public SituacaoAluno getSituacao() {
        return situacao;
    }

    public String toString() {
        return String.format("Nome: %s, Matrícula: %s, Situação: %s", nome, matricula, situacao.name());
    }
}
