package franquias_anatel;

import java.util.Objects;

public class Franquia {
    private double quantidadeGB;
    private int diaExpiracao;
    private double precoFranquia;
    private String codigoFranquia;
    private String nomeEmpresa;

    public Franquia(double quantidadeGB, int diaExpiracao, double precoFranquia, String codigoFranquia, String nomeEmpresa) {
        if (quantidadeGB <= 0) {
            throw new IllegalArgumentException("Quantidade GB deve ser maior que zero.");
        }
        if (diaExpiracao < 1 || diaExpiracao > 30) {
            throw new IllegalArgumentException("Dia Expiração deve ser entre 1 e 30.");
        }
        if (precoFranquia <= 0) {
            throw new IllegalArgumentException("Preço da Franquia deve ser maior que zero.");
        }
        if (codigoFranquia == null || codigoFranquia.trim().isEmpty()) {
            throw new IllegalArgumentException("Código da Franquia não deve ser vazio.");
        }
        if (nomeEmpresa == null || nomeEmpresa.trim().isEmpty() || !isValidEmpresa(nomeEmpresa)) {
            throw new IllegalArgumentException("Nome da Empresa inválido.");
        }
        this.quantidadeGB = quantidadeGB;
        this.diaExpiracao = diaExpiracao;
        this.precoFranquia = precoFranquia;
        this.codigoFranquia = codigoFranquia;
        this.nomeEmpresa = nomeEmpresa.toUpperCase();
    }
    // Método auxiliar para validar o nome da empresa
    private boolean isValidEmpresa(String empresa) {
        String upperEmpresa = empresa.toUpperCase();
        return upperEmpresa.equals("VIVO") || upperEmpresa.equals("TIM") || upperEmpresa.equals("Claro")
                || upperEmpresa.equals("OI");
    }

    public double getQuantidadeGB() {
        return quantidadeGB;
    }

    public int getDiaExpiracao() {
        return diaExpiracao;
    }

    public double getPrecoFranquia() {
        return precoFranquia;
    }

    public String getCodigoFranquia() {
        return codigoFranquia;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoFranquia);
    }

    @Override
    public String toString() {
        return "Código: " + codigoFranquia +
                " | Empresa: " + nomeEmpresa +
                " | GB: " + String.format("%.1f", quantidadeGB) +
                " | Preço: R$" + String.format("%.2f", precoFranquia) +
                " | Expira dia: " + diaExpiracao;
    }
}
