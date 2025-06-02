package aula_3_exercicio_5;

public class MyMath {
    // Calcula o fatorial de um número inteiro não negativo.
    public static long calcularFatorial(int numero) {
        if (numero < 0) {
            System.out.println("Erro: Não é possível calcular o fatorial de número negativo!");
            return -1;
        }
        if (numero == 0 || numero == 1) {
            return 1;
        }
        long fatorial = 1;
        for (int i = 2; i < numero; i++) {
            fatorial *= i;
        }
        return fatorial;
    }

    // Recebe dois valores e retorna o maior entre eles.
    public static double encontrarMaior(double valor1, double valor2) {
        if (valor1 >= valor2) {
            return valor1;
        } else {
            return valor2; // Ou simplesmente: return Math.max(valor1, valor2);
        }
    }

    // Verifica se número inteiro é par.
    public static boolean isPar(int numero) {
        // Um número inteiro é par se o resto da sua divisão for 0.
        return numero % 2 == 0;
    }

    // Verifica se um número inteiro é primo.
    // Um número primo é um número natural maior que 1 que não pode ser formado
    // pela multiplicação de dois números naturais menores.
    public static boolean isPrimo(int numero) {
        if (numero <= 1) {
            return false; // Números menores ou iguais a 1 não são primos
        }
        if (numero == 2) {
            return true; // 2 é o único número primo par
        }
        if (numero % 2 == 0) {
            return false; // Qualquer outro número par não é primo
        }
        // Testa divisores ímpares a partir de 3 até a raiz quadrada do número.
        // Se encontrar um divisor, não é primo.
        for (int i = 3; i * i <= numero; i += 2) { // Incrementa de 2 em 2 (somente ímpares)
            if (numero % i == 0) {
                return false;
            }
        }
        return true; // Se não encontrou divisores, é primo
    }
}
