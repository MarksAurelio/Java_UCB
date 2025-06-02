package aula_3_exercicio_4;

import java.util.InputMismatchException;
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
        int valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println(msg);
                valor = scanner.nextInt();
                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine();
            } finally {
                if (entradaValida) {
                    scanner.nextLine();
                }
            }
        }
        return valor;
    }

    public static int lerInt() {
        int valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                valor = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                scanner.nextLine();
            } finally {
                if (entradaValida) {
                    scanner.nextLine();
                }
            }
        }
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
        double valor = 0.0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println(msg);
                valor = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor digite um número decimal");
                scanner.nextLine();
            } finally {
                if (entradaValida) {
                    scanner.nextLine();
                }
            }
        }
        return valor;
    }

    public static double lerDouble() {
        double valor = 0.0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                valor = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor digite um número decimal");
                scanner.nextLine();
            } finally {
                if (entradaValida) {
                    scanner.nextLine();
                }
            }
        }
        return valor;
    }

    public static void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
