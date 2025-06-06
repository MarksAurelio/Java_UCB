package manipulador_strings_app;

public class ManipuladorStrings {
    private String textoOriginal;
    private static final String FRASE_COMPARACAO = "Eu estou estudando Java";

    public ManipuladorStrings(String texto) {
        this.textoOriginal = texto;
    }

    public String paraCaixaAlta() {
        return this.textoOriginal.toUpperCase();
    }

    public String paraCaixaBaixa() {
        return this.textoOriginal.toLowerCase();
    }

    public int contarCaracteres() {
        return this.textoOriginal.length();
    }

    public boolean compararComFrasePadrao() {
        return this.textoOriginal.equalsIgnoreCase(FRASE_COMPARACAO);
    }

    public int contarPalavras() {
        if (this.textoOriginal == null || this.textoOriginal.trim().isEmpty()) {
            return 0; // Se a string for nula ou vazia (apenas espaços), não há palavras
        }
        // Usa expressão regular para dividir a string por um ou mais espaços em branco
        // O método .split("\\s+") retorna um array de strings (palavras)
        String[] palavras = this.textoOriginal.trim().split("\\s+");
        return palavras.length;
    }

    public String getTextoOriginal() {
        return textoOriginal;
    }
}
