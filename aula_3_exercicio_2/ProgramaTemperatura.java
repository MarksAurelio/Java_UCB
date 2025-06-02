package aula_3_exercicio_2;

public class ProgramaTemperatura {
    public static void main(String[] args) {
        double tempCelsius = Leitor.lerDouble("Informe a temperatura em graus Celsius: ");
        double tempFahrenheit = ConversorTemperatura.fahrenheit(tempCelsius);

        System.out.printf("Temperatura em Celsius: %.2f °C%n", tempCelsius);
        System.out.printf("Temperatura em Fahrenheit: %.2f °F%n", tempFahrenheit);

        Leitor.fecharScanner();
    }
}
