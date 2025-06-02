package aula_1_exercicio_4;

import java.util.Scanner;

public class ExercicioArray {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        // Inicializando Array
        int[] numeros = new int[5];
        // Populando Array
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Informe o " + (i + 1) + "ª número: ");
            numeros[i] = new Scanner(System.in).nextInt();
        }
        // Apresentar o Array
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

    }

}
