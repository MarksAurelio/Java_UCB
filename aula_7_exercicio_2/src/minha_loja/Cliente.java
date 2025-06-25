package minha_loja;

public class Cliente {
    private String nome;
    private String endereco;
    private EnumFPagamento formaPagamento;

    public Cliente(String nome, String endereco, EnumFPagamento formaPagamento) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio");
        }
        if (formaPagamento == null) {
            throw new IllegalArgumentException("Forma de pagamento deve ser informada.");
        }
        this.nome = nome;
        this.endereco = endereco;
        this.formaPagamento = formaPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço do cliente não pode ser vazio.");
        }
        this.endereco = endereco;
    }

    public EnumFPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(EnumFPagamento formaPagamento) {
        if (formaPagamento == null) {
            throw new IllegalArgumentException("Forma de pagamento deve ser informada.");
        }
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "--- Dados dos Cliente ---\n" +
                "Nome: " + nome + "\n" +
                "Endereço: " + endereco + "\n" +
                "Forma de Pagamento: " + formaPagamento.getDescricao() + "(Código: " + formaPagamento.getCodigo() + ")";
    }
}
