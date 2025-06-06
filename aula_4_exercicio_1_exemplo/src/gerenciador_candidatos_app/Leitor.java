package gerenciador_candidatos_app;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitor {
    private Scanner scanner;

    public Leitor() {
        this.scanner = new Scanner(System.in);
    }

    public int obterQuantidadeCandidatos() {
        int quantidade = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("Informe a quantidade de candidatos para cadastro:");
                quantidade = scanner.nextInt();
                if (quantidade <= 0) {
                    System.out.println("A quantidade de candidatos deve ser um número positivo, maior que 0.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Informe um número inteiro.");
                scanner.next(); // Limpa o buffer do scanner para evitar um loop infinito
            }
        }
        scanner.nextLine(); // Consumir a quebra de linha pendente do nextInt()
        return quantidade;
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
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Informe um número inteiro.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return numero;

    }

    public String obterTipoCandidatura() {
        String tipoCandidatura = "";
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Tipo de candidatura: (Federal, Distrital ou Senador):");
            tipoCandidatura = scanner.nextLine().trim().toLowerCase();
            if (tipoCandidatura.equals("federal") || tipoCandidatura.equals("distrital")
                    || tipoCandidatura.equals("senador")) {
                entradaValida = true;
            } else {
                System.out.println("Tipo de candidatura inválida. Digite 'Federal', 'Distrital' ou 'Senador'.");
            }
        }
        return tipoCandidatura;
    }

    public boolean obterStatusReeileicao() {
        boolean reeleito = false;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Já foi reeleito (Sim ou Não)?");
            String respostaReeleito = scanner.nextLine().trim().toLowerCase();
            if (respostaReeleito.equals("sim")) {
                reeleito = true;
                entradaValida = true;
            } else if (respostaReeleito.equals("nao") || (respostaReeleito.equals("não"))) {
                reeleito = false;
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida. Digite (Sim ou Não).");
            }
        }
        return reeleito;
    }

    public void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
