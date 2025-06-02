package aula_3_exercicio_1;

import java.util.Scanner;

public class Leitor {
    private static final Scanner scanner = new Scanner(System.in);

    public static String lerString(String msg) {
        System.out.println(msg);
        return scanner.nextLine();

    }

    public static int lerInt(String msg) {
        System.out.println(msg);
        int valor = scanner.nextInt();
        return valor;

    }

    public static double lerDouble(String msg) {
        System.out.println(msg);
        double valor = scanner.nextDouble();
        return valor;
    }

    public static void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
