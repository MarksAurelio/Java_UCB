package corrida;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitor {
    private static final Scanner scanner = new Scanner(System.in);

    public static String lerString(String msg) {
        System.out.println(msg);
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
                System.out.println("Erro: Entrada inválida. Informe um número inteiro.");
                scanner.nextLine();
            } finally {
                if (entradaValida) {
                    scanner.nextLine();
                }
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
                System.out.println("Erro: Entrada inválida. Informe um número decimal");
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
