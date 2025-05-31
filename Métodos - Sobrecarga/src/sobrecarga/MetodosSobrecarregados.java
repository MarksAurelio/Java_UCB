public class MetodosSobrecarregados {
    public static void main(String[] args) {
        double a = 3;
        double b = 4;

        System.out.printf("O quadrado de %.2f é %.2f\n", a, Expoente.quadrado(a));
        System.out.printf("%.2f elevado a %.2f é %.2f\n", a, b, Expoente.quadrado(a, b));
        Expoente.quadrado();
    }
}
