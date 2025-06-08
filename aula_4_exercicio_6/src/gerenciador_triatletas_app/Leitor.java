package gerenciador_triatletas_app;

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

    public int obterNumeroInteiro(String msg) {
        int numero = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println(msg);
                numero = scanner.nextInt();
                if (numero < 0) {
                    System.out.println("A entrada dever ser um número inteiro e positivo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida o número deve ser inteiro e positivo.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return numero;
    }

    public int obterTempoProvasHoras(String msg) {
        int tempo = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            tempo = obterNumeroInteiro(msg);
            if (tempo <= 0) {
                System.out.println("O tempo de prova dever ser um número inteiro positivo.");
            } else {
                entradaValida = true;
            }
        }
        return tempo;
    }

    public int obterIdade(String msg) {
        int idade = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            idade = obterNumeroInteiro(msg);
            if (!(idade >= 10 && idade <= 99)) {
                System.out.println("Idade inválida, digite uma idade entre 10 e 99");
            } else {
                entradaValida = true;
            }
        }
        return idade;
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
