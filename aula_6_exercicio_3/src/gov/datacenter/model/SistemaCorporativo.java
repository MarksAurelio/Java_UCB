package gov.datacenter.model;

public class SistemaCorporativo extends Sistema {
    private int acessosPorMinuto;

    public SistemaCorporativo(String nomeSistema, boolean isFullTimeNoAr, PessoaResponsavel responsavel,
            int acessosPorMinuto) {
        super(nomeSistema, isFullTimeNoAr, responsavel);
        if (acessosPorMinuto < 0) {
            throw new IllegalArgumentException("Número de pessoas por minuto não pode ser negativo.");
        }
        this.acessosPorMinuto = acessosPorMinuto;
    }

    public int getAcessosPorMinuto() {
        return acessosPorMinuto;
    }

    public void setAcessosPorMinuto(int acessosPorMinuto) {
        this.acessosPorMinuto = acessosPorMinuto;
    }

    @Override
    public int calcularFuncionarioNecessarios() {
        if (this.isFullTimeNoAr()) {
            int funcionarios = 2; // Sempre dois funcionários se for fullTime
            if (this.acessosPorMinuto >= 3000 && this.acessosPorMinuto <= 5000) {
                funcionarios += 2; // Mais 2 se entre 3000 e 5000 acessos
            } else if (this.acessosPorMinuto > 5000) {
                funcionarios += 3;
            }
            return funcionarios;
        }
        return 0; // Se não for fullTime, não precisa de funcionário
    }

    @Override
    public String toString() {
        return "--- Sistema Corporativo ---\n" +
                super.toString() +
                "\n Acesso por minuto: " + acessosPorMinuto +
                "\n Funcionários Necessários: " + calcularFuncionarioNecessarios();
    }
}
