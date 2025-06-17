package gov.datacenter.model;

public class SistemaAdministrativo extends Sistema {
    private int usuariosSimultaneos;

    public SistemaAdministrativo(String nomeSistema, boolean isFullTimeNoAr, PessoaResponsavel responsavel,
            int usuariosSimultaneos) {
        super(nomeSistema, isFullTimeNoAr, responsavel);
        if (usuariosSimultaneos < 0) {
            throw new IllegalArgumentException("Número de usuários simultâneos não pode ser negativo.");
        }
        this.usuariosSimultaneos = usuariosSimultaneos;
    }

    public int getUsuariosSimultaneos() {
        return usuariosSimultaneos;
    }

    public void setUsuariosSimultaneos(int usuariosSimultaneos) {
        this.usuariosSimultaneos = usuariosSimultaneos;
    }

    @Override
    public int calcularFuncionarioNecessarios() {
        if (this.isFullTimeNoAr()) {
            int funcionarios = 1; // Sempre um funcinário ser for fullTime
            if (this.usuariosSimultaneos > 200) {
                funcionarios += 2; // Mais de funcionários se tiver mais de 200 acessos
            }
            return funcionarios;
        }
        return 0; // Se não for fullTime(sem acesso), não precisa de funcinário
    }

    @Override
    public String toString() {
        return "--- Sistema Administrativo ---\n" +
                super.toString() +
                "\n Usuários Simultâneos: " + usuariosSimultaneos +
                "\n Funcionários Necessários: " + calcularFuncionarioNecessarios();
    }
}
