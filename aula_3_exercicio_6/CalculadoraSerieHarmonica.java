package aula_3_exercicio_6;

public class CalculadoraSerieHarmonica {
    // Calcula a soma da série harmônica S = 1 + 1/2 + 1/3 + ... + 1/n.
    public static double somarS(int n) {
        double soma = 0.0;
        for (int i = 1; i <= n; i++) {
            soma += 1.0 / i; // Importante: 1.0 / i garante que a divisão seja de ponto flutuante, e não uma divisão inteira que trunca os decimais.

        }
        return soma;
    }
}
