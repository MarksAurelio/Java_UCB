package sindicato_app;

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
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número:");
                scanner.next();
            }
        }
        scanner.nextLine();
        return numero;
    }

    public String obterRespostaSimNao(String msg) {
        String resposta = "";
        boolean respostaValida = false;
        while (!respostaValida) {
            System.out.println(msg + " (sim/não):");
            resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("sim") || (resposta.equals("não")) || (resposta.equals("nao"))) {
                respostaValida = true;
            } else {
                System.out.println("Entrada inválida. Digite (sim/não).");
            }
        }
        return resposta;
    }

    public String obterTitulacaoProfessor() {
        String titulacao = "";
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Digite a titulação do professor (Graduado, Mestre ou Doutor):");
            titulacao = scanner.nextLine().trim().toLowerCase();
            if (titulacao.equals("graduado") || (titulacao.equals("mestre")) || (titulacao.equals("doutor"))) {
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida. Digite (Graduado, Mestrado ou Doutorado).");
            }
        }
        return titulacao;
    }

    public void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
