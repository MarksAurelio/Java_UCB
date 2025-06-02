package aula_3_exercicio_3;

import java.util.Scanner;

public class Leitor {
    private static final Scanner scanner = new Scanner(System.in);

    public static String lerString(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static String lerString() {
        return scanner.nextLine();
    }

    public static int lerInt(String msg) {
        System.out.println(msg);
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public static int lerInt() {
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public static char lerCaractere(String msg) {
        System.out.println(msg);
        return scanner.next().charAt(0);
    }

    public static char lerCaractere() {
        return scanner.next().charAt(0);
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
