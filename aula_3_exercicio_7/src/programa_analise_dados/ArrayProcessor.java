package programa_analise_dados;
public class ArrayProcessor {

    // Calcula a média dos valores contidos em um array de inteiros.
    public static double calcularMedia(int[] array) {
        if (array == null || array.length == 0) { // array O array de inteiros.
            return 0.0; // A média aritmética dos valores (double). Retorna 0.0 se o array for nulo ou
                        // vazio.
        }
        long soma = 0; // Usando um 'long' para evitar overflow se os valores forem grandes
        for (int valor : array) {
            soma += valor;
        }
        return (double) soma / array.length; // Converte a soma para double antes da divisão

    }

    // Conta quantos valores em um array de inteiros são ímpares.
    public static int contarImpares(int[] array) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (int valor : array) {
            // Um número é ímpar se o resto da divisão por 2 NÃO for zero
            if (valor % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    /*
     * Imprime todos os valores de um array de inteiros na saída padrão. Para arrays
     * muito grandes, imprime uma mensagem a cada 1000 valores para indicar o
     * progresso.
     */
    public static void imprimirValores(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array vazio. Sem nenhum valor para imprimir.");
            return;
        }
        System.out.println("---Valores Informados---");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Valor %d: %d%n", (i + 1), array[i]);
            // Adiciona uma indicação de progresso para arrays muito grandes
            if (array.length >= 1000 && (i + 1) % 1000 == 0 && (i + 1) < array.length) {
                System.out.println("   (Continuando a imprimir...)");
            }
        }
        System.out.println("-------------------------");
    }
}
