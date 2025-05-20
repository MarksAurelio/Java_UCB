import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        System.out.println("Digite um número: ");
        int numero = new Scanner(System.in).nextInt();
        int resultado = numero + 10;
        System.out.println("O resultado da soma de " + numero + " + 10 é igual a: " + resultado);
    }
}
