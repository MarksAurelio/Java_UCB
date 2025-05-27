package unidade_1_atividade_forum;

import java.util.Scanner;

public class Descriptografar {
    public static void main(String[] args) {

        // Inicializa a entrada de dados

        Scanner in = new Scanner(System.in);

        // Pede o texto criptografado

        System.out.print("Entre com o texto cifrado: ");

        String textoCifrado = in.nextLine();

        // Pede a chave para descriptografar o texto

        System.out.print("Entre com a chave para descriptografar: ");

        int chave = in.nextInt();

        // Passa o texto cifrado para maiúsculas

        textoCifrado = textoCifrado.toUpperCase();

        // Cria vetor contendo os caracteres do alfabeto

        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Descriptografa o texto, usando a chave

        String textoOriginal = "";

        for (int i = 0; i < textoCifrado.length(); i++) {

            // Recupera a posição do caractere do texto cifrado no alfabeto

            char caractereCifrado = textoCifrado.charAt(i);

            int posCaractereCifradoAlfabeto = alfabeto.indexOf(caractereCifrado);

            // Se o caractere cifrado não está no alfabeto (como um espaço), ignora a
            // codificação

            if (posCaractereCifradoAlfabeto == -1) {

                textoOriginal += caractereCifrado;

                continue;

            }

            // Descriptografa o caractere, usando a chave de criptografia

            int posCaractereOriginal = (posCaractereCifradoAlfabeto - chave + 26) % 26;

            char caractereOriginal = alfabeto.charAt(posCaractereOriginal);

            textoOriginal += caractereOriginal;

        }

        // Mostra o texto criptografado

        System.out.println("Texto original: " + textoOriginal);
        in.close();
    }

}
