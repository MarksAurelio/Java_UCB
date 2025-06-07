package gerenciador_conceitos_app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitor {
    private Scanner scanner;

    public Leitor() {
        this.scanner = new Scanner(System.in);
    }

    public String obterStringEntrada(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public double obterNumeroDouble(String msg) {
        double numero = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println(msg);
                numero = scanner.nextDouble();
                if (numero < 0 || numero > 10) {
                    System.out.println("A nota dever estar entre 0.0 a 10.0.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return numero;
    }

    public String obterRespostaSimNao(String msg) {
        String resposta = "";
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println(msg + " (sim/não)");
            resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("sim") || (resposta.equals("não")) || (resposta.equals("nao"))) {
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida. Digite (sim/não).");
            }
        }
        return resposta;
    }

    public void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
