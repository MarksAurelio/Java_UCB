
import java.util.Scanner;

public class NotasMedia {
    public static void main(String[] args){

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite a primeira nota: ");
            double nota1 = scanner.nextDouble();

            System.out.println("Digite a segunda nota: ");
            double nota2 = scanner.nextDouble();

            double media = (nota1 + nota2) / 2;

            System.out.println("A média de notas é: " + media);
        }
    }
}

