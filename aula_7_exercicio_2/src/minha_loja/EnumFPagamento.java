package minha_loja;

public enum EnumFPagamento {
    VISA("Visa", 20),
    MASTERCARD("Mastercard", 50),
    BOLETO("Boleto", 30);

    private String descricao;
    private int codigo;

    EnumFPagamento(String descricao, int codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    /**
     * Método static para obter o EnumFPagamento a partir do código
     * 
     * @param codigo 0 código numérico de forma de pagamento
     * @return O EnumFPagamento correspondente
     * @throws IllegalArgumentException Se o código informado não corresponder a
     *                                  nenhuma forma de pagamento
     */
    public static EnumFPagamento getByCodigo(int codigo) {
        for (EnumFPagamento fPagamento : EnumFPagamento.values()) {
            if (fPagamento.getCodigo() == codigo) {
                return fPagamento;
            }
        }
        throw new IllegalArgumentException("Código de forma de pagamenteo inválido: " + codigo);
    }
}
