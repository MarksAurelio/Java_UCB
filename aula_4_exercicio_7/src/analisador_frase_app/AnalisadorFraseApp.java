package analisador_frase_app;

import java.util.Scanner;

public class AnalisadorFraseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String frase = "";

        boolean contemCorrupcao = false;
        while (!contemCorrupcao) {
            System.out.println("Digite uma frase (deve conter a palavra 'Corrupção'): ");
            frase = scanner.nextLine();
            if (frase.toLowerCase().contains("corrupção")) {
                contemCorrupcao = true;
                System.out.println("Frase aceita! Analisando...");
            } else {
                System.out.println("A frase não contêm a palavra 'Corrupção'.");
            }
        }
        System.out.println("\n --- Análise da Frase ---");
        // 1. A quantidade de letras A que a frase tem
        int contadorA = 0;
        for (int i = 0; i < frase.length(); i++) {
            char caractere = frase.charAt(i);
            // Verifica (a/ã) minúsculo e (A/Ã) maiúsculo
            if (caractere == 'a' || caractere == 'A' || caractere == 'ã' || caractere == 'Ã') {
                contadorA++;
            }
        }
        System.out.println("Quantidade de letras 'A' na frase: " + contadorA);

        // 2. O tamanho da frase (quantidade de caracteres)
        int tamanhoFrase = frase.length();
        System.out.println("Tamanho da frase (caracteres): " + tamanhoFrase);

        // 3. Qualificação da frase:
        // < que 10 caracteres PEQUENA
        // > que 9 < que 29 MÉDIA
        // > que 30 é Grande
        String qualificacao;
        if (tamanhoFrase < 10) {
            qualificacao = "PEQUENA";
        } else if (tamanhoFrase >= 10 && tamanhoFrase <= 29) {
            qualificacao = "MÉDIA";
        } else {
            qualificacao = "GRANDE";
        }
        System.out.println("A qualificação da frase é: " + qualificacao);

        // 4. Aprenta a frase em Caixa Alta
        String fraseCaixaAlta = frase.toUpperCase();
        System.out.println("Frase em CAIXA ALTA: " + fraseCaixaAlta);

        // 5. A quantidade de palavras que a frase contêm
        // Dividir a string por espaços e contar os segmentos.
        // Usar trim() para remover espaços extras no início/fim e split("\\s+") para
        // lidar com os espaços entre palavras.
        String[] palavras = frase.trim().split("\\s+");
        int quantidadePalavras = palavras.length;
        // Se a frase for vazia ou contiver apenas espaços, split retorna um array com
        // uma string vazia.
        // Se a frase original (após trim) for vazia, a quantidade de palavras é 0.
        if (frase.trim().isEmpty()) {
            quantidadePalavras = 0;
        }
        System.out.println("Quantidade de palavras na frase: " + quantidadePalavras);

        scanner.close();
    }
}
