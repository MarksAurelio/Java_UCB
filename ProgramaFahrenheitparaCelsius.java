import java.util.Scanner;

public class ProgramaFahrenheitparaCelsius{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a temperatura em graus Celsius: ");
        double celsius = scanner.nextDouble();
        
        // Fórmula Celsius para Fahrenheit
        double fahrenheit = (9 * celsius + 160) / 5;

        System.out.printf("%.2f graus Celsius equivalem a %.2f graus Fahrenheit.%n", celsius, fahrenheit);

        scanner.close();
    }
}
