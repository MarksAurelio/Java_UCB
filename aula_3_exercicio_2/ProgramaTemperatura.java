/* Implemente um programa em Java que receba a temperatura em graus Celsius e apresente-a convertida em graus Fahrenheit. A fórmula de conversão é: FAR = (9 * CEL + 160) / 5, sendo FAR a temperatura em Fahrenheit e CEL em Celsius. Esta conversão deve ser feita por meio de um método com a seguinte assinatura: public static double fahrenheit(double celsius). O método deve receber a temperatura em Celsius e retornar em Fahrenheit. */
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
