package policia_francesa.model;

public class TerroristaSuicida extends Terrorista {
    private String religiao;

    public TerroristaSuicida(String nome, double quantidadeExplosivos, String religiao) {
        super(nome, quantidadeExplosivos);
        if (religiao == null || religiao.trim().isEmpty()) {
            throw new IllegalArgumentException("Religião não pode ser vazia.");
        }
        this.religiao = religiao;
    }

    public String getReligiao() {
        return religiao;
    }

    @Override
    public double calcularGrauDePericulosidade() {
        double constanteReligiao;
        // Case-insensitive check for Islamismo
        if (religiao.equalsIgnoreCase("Islamismo")) {
            constanteReligiao = 5;
        } else {
            constanteReligiao = 2;
        }
        return (2 * quantidadeExplosivos) * constanteReligiao;
    }

    @Override
    public String toString() {
        return "--- Terrorista Suicida ---\n" +
                super.toString() +
                "\n Religião: " + religiao +
                "\n Grau de Periculosidade: " + String.format("%.2f", calcularGrauDePericulosidade());
    }
}
