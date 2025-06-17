package policia_francesa.model;

public class TerroristaNaoSuicida extends Terrorista {
    private String paisOrigem;

    public TerroristaNaoSuicida(String nome, double quantidadeExplosivos, String paisOrigem) {
        super(nome, quantidadeExplosivos);
        if (paisOrigem == null || paisOrigem.trim().isEmpty()) {
            throw new IllegalArgumentException("País de Origem não pode ser vazio");
        }
        this.paisOrigem = paisOrigem;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    @Override
    public double calcularGrauDePericulosidade() {
        double constantePais;
        if (paisOrigem.equalsIgnoreCase("Arábia")) {
            constantePais = 7;
        } else {
            constantePais = 5;
        }
        return (3 * quantidadeExplosivos) + constantePais;
    }

    @Override
    public String toString() {
        return "--- Terrorista Não Suicida ---\n" +
                super.toString() +
                "\n País de Origem: " + paisOrigem +
                "\n Grau de Periculosidade: " + String.format("%.2f", calcularGrauDePericulosidade());
    }
}
