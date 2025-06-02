package aula_3_exercicio_4;

public class CalculadoraSomatorio {
    public static int somatorio(int num) {
        int soma = 0;
        for (int i = 0; i <= num; i++) {
            soma+=i;
        }
        return soma;
    }
}
