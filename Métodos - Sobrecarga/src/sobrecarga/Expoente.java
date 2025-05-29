package sobrecarga;

public class Expoente {
    // Método que não calcula nada
    public static void quadrado() {
        System.out.println("Método não calcula nada...");
    }

    // Calcular o quadrado de a
    public static double quadrado(double a) {
        return a * a;
    }

    // Calcular o quadrado de a elevado a b
    public static double quadrado(double a, double b) {
        return Math.pow(a, b);
    }
}
