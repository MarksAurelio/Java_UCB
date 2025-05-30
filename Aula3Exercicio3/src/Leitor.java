import java.util.Scanner;

public class Leitor {
    private static final Scanner scanner = new Scanner(System.in);

    public static int lerInt(String msg) {
        System.out.println(msg);
        return scanner.nextInt();
    }

    public static int lerInt() {
        return scanner.nextInt();
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
        return scanner.nextDouble();
    }

    public static double lerDouble() {
        return scanner.nextDouble();
    }

    public static void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
