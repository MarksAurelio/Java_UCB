package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitor {
    private static final Scanner scanner = new Scanner(System.in);

    public static void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
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
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            } finally {

            }
        }
        return valor;
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
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            } finally {

            }
        }
        return valor;
    }

    public static boolean lerBoolean(String msg) {
        boolean valor = false;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println(msg);
                String input = scanner.next().trim().toLowerCase();
                if (input.equals("true") || input.equals("verdadeiro") || input.equals("sim") || input.equals("s")) {
                    valor = true;
                    entradaValida = true;
                } else if (input.equals("false") || input.equals("falso") || input.equals("não") || input.equals("nao")
                        || input.equals("n")) {
                    valor = false;
                    entradaValida = true;
                } else {
                    System.out.println("Entrada inválida. Tente novamente.");
                }
            } finally {
                scanner.nextLine();
            }
        }
        return valor;

    }

    public static String lerString(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static short lerShort(String msg) {
        short valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println(msg);
                valor = scanner.nextShort();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            }
        }
        return valor;
    }

    public static long lerLong(String msg) {
        long valor = 0L;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println(msg);
                valor = scanner.nextLong();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            }
        }
        return valor;
    }

    public static float lerFloat(String msg) {
        float valor = 0.0f;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println(msg);
                valor = scanner.nextFloat();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            }
        }
        return valor;
    }

    public static char lerChar(String msg) {
        String input;
        char caractere = ' ';
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println(msg);
            input = scanner.nextLine();
            if (input.length() == 1) {
                caractere = input.charAt(0);
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
        return caractere;
    }
}
