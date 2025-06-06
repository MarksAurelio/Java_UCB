package calculadora_app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitor {
    private Scanner scanner;

    public Leitor() {
        this.scanner = new Scanner(System.in);
    }

    public double obterNumeroDouble(String msg) {
        double numero = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println(msg);
                numero = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invália. Informe um número.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return numero;
    }

    public String obterStringEntrada(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public String obterOperador() {
        String operador = "";
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Digite o operador (+, -, * ou /):");
            operador = scanner.nextLine().trim();
            if (operador.equals("+") || (operador.equals("-")) || (operador.equals("*")) || (operador.equals("/"))) {
                entradaValida = true;
            } else {
                System.out.println("Operador inválido. Digite o operador (+, -, * ou /):");
            }
        }
        return operador;
    }

    public void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
