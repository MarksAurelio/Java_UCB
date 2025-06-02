package aula_3_exercicio_2;

import java.util.Scanner;

public class Leitor {
    private static final Scanner scanner = new Scanner(System.in);

    public static String lerString(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static double lerDouble(String msg) {
        System.out.println(msg);
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;

    }

    public static double lerDouble() {
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;

    }

    public static void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
