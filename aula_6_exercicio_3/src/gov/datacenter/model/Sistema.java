package gov.datacenter.model;

public abstract class Sistema {
    protected String nomeSistema;
    protected boolean isFullTimeNoAr;
    protected PessoaResponsavel responsavel;

    public Sistema(String nomeSistema, boolean isFullTimeNoAr, PessoaResponsavel responsavel) {
        if (nomeSistema == null || nomeSistema.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do sistema não pode ser vazio.");
        }
        if (responsavel == null) {
            throw new IllegalArgumentException("O sistema deve ter uma pessoa responsável.");
        }
        this.nomeSistema = nomeSistema;
        this.isFullTimeNoAr = isFullTimeNoAr;
        this.responsavel = responsavel;
    }

    public String getNomeSistema() {
        return nomeSistema;
    }

    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public boolean isFullTimeNoAr() {
        return isFullTimeNoAr;
    }

    public void setFullTimeNoAr(boolean isFullTimeNoAr) {
        this.isFullTimeNoAr = isFullTimeNoAr;
    }

    public PessoaResponsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(PessoaResponsavel responsavel) {
        this.responsavel = responsavel;
    }

    public abstract int calcularFuncionarioNecessarios();

    @Override
    public String toString() {
        return "Nome do Sistema: " + nomeSistema +
                "\n Full Time no Ar: " + (isFullTimeNoAr ? "Sim" : "Não") +
                "\n Responsável: [" + responsavel.toString() + "]";
    }
}
