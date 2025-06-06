package manipulador_strings_app;

public class ManipuladorStringsApp {
    public static void main(String[] args) {
        Leitor leitor = new Leitor();

        System.out.println("--- Manipulador de Strings ---");

        String textoDigitado = leitor.obterStringEntrada("Digite uma frase ou uma palavra:");

        ManipuladorStrings manipulador = new ManipuladorStrings(textoDigitado);

        System.out.println("--- Resultados ---");

        System.out.println("1. Caixa Alta: " + manipulador.paraCaixaAlta());

        System.out.println("2. Caixa Baixa: " + manipulador.paraCaixaBaixa());

        System.out.println("3. Quantidade de Caracteres: " + manipulador.contarCaracteres());

        // Se a frase digitada é igual ou não a "Eu estou estudando Java"
        boolean saoIguais = manipulador.compararComFrasePadrao();
        if (saoIguais) {
            System.out.println("4. A frase digitada é igual a \"Eu estou estudando Java\" (ignorando caixa).");
        } else {
            System.out.println("4. A frase digitada NÃO é igual a \"Eu estou estudando Java\".");
        }
        System.out.println("5. Quantidade de palavras: " + manipulador.contarPalavras());

        leitor.fecharScanner();
    }
}
