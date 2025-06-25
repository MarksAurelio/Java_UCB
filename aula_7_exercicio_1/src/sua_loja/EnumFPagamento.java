package sua_loja;

public enum EnumFPagamento {
    VISA("Visa"),
    MASTERCARD("Mastercard"),
    BOLETO("Boleto");

    private String descricao;

    EnumFPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
