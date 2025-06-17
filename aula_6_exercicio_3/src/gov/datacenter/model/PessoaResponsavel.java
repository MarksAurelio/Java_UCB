package gov.datacenter.model;

public class PessoaResponsavel {
    private String nome;
    private String telefone;

    public PessoaResponsavel(String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do responsável não pode ser vazio.");
        }
        if (telefone == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio");
        }
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Telefone: " + telefone;
    }
}
