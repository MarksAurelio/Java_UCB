package aula_1_exercicio_10;
/* O programa Java apresentado a seguir codifica uma mensagem de texto, sem informar qual foi a chave para o processo de criptografia: */
import java.util.Scanner;

public class Criptografar {
public static void main(String[] args) { 

    // Inicializa a entrada de dados 

    Scanner in = new Scanner(System.in) ;     

    // Pede texto para criptografar 

    System.out.print("Entre com o texto para criptografar: "); 

    String textoOriginal = in.nextLine() ;     

    // Passa o texto informado para maiúsculas 

    textoOriginal = textoOriginal.toUpperCase(); 

// Cria vetor contendo os caracteres do alfabeto 

    String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 

        // Sorteia uma chave de 1 a 26 

    int chave = (int) (Math.random() * 25 + 1); 

        // Criptografa o texto, usando a chave 

    String textoCifrado = "";

    for(int i = 0; i < textoOriginal.length(); i++) { 

      // Recupera a posição do caractere do texto original no alfabeto 

      char caractereOriginal = textoOriginal.charAt(i); 

      int posCaractereOriginalAlfabeto = alfabeto.indexOf(caractereOriginal) ;      

       // Se o caractere nao está no alfabeto (como um espaço), ignora a codificação    

        if(posCaractereOriginalAlfabeto == -1) { 

        textoCifrado += caractereOriginal; 

        continue; 

      } 

 // Criptografa o caractere, usando a chave de criptografia 

      int posCaractereCifrado = (posCaractereOriginalAlfabeto + chave) % 26 ; 

      char caractereCifrado = alfabeto.charAt(posCaractereCifrado) ; 

      textoCifrado += caractereCifrado ; 

    }     

    // Mostra o texto criptografado 

    System.out.println("Texto criptografado: " + textoCifrado); 

    in.close();

  } 

} 



