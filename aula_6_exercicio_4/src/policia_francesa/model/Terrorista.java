package policia_francesa.model;

public abstract class Terrorista {
    protected String nome;
    protected double quantidadeExplosivos;

    public Terrorista(String nome, double quantidadeExplosivos) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (quantidadeExplosivos < 0) {
            throw new IllegalArgumentException("Quantidade de explosivos não pode ser negativo.");
        }
        this.nome = nome;
        this.quantidadeExplosivos = quantidadeExplosivos;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidadeExplosivos() {
        return quantidadeExplosivos;
    }

    public abstract double calcularGrauDePericulosidade();

    public String toString() {
        return "Nome: " + nome +
                "\n Quantidade de Explosivos: " + String.format("%.2f", quantidadeExplosivos);
    }
}
