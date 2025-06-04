/* Faça um programa que receba 5 mil dados do usuário do tipo inteiro.

Sabe-se que valores negativos não são aceitos. Após receber esses valores e popular o array, imprima na saída padrão: a média dos valores, quantos valores são ímpares e todos os valores que foram informados. Para esta solução, utilize o maior número de métodos visualizados. */
public class ProgramaAnaliseDados {
    private static final int TAMANHO_ARRAY = 5;

    // Popula um array de inteiros com valores fornecidos pelo usuário.
    // Realiza validação para aceitar apenas números inteiros positivos (ou zero).

    public static void popularArray(int[] array) {
        System.out.println("--- Entrada de Dados ---");
        System.out.println("Informe " + array.length + " valores inteiros e não negativos.");

        for (int i = 0; i < array.length; i++) {
            int valor;
            boolean entradaValidaParaPositivo = false;
            while (!entradaValidaParaPositivo) {
                // Leitor.lerInt() já trata o input Não é um inteiro.
                // Aqui, validamos se o inteiro É POSITIVO (ou zero, ou não - negativo)
                valor = Leitor.lerInt("Informe o " + (i + 1) + "° valor: ");
                if (valor >= 0) {
                    array[i] = valor;
                    entradaValidaParaPositivo = true;
                } else {
                    System.out.println("Erro: Valores negativos não são aceitos. Informe um número positivo.");
                }
            }

        }
        System.out.println("--- Entrada de Dados Concluída---");
    }

    public static void main(String[] args) {
        int[] dados = new int[TAMANHO_ARRAY];

        // 1 - Popular o array com os dados do usuário, validando cada entrada
        popularArray(dados);

        // 2 - Calcular a média dos valores usando o ArrayProcessador
        double media = ArrayProcessor.calcularMedia(dados); 
        System.out.println("--- Resultado da Análise ---");
        System.out.printf("Média dos valores %.2f%n", media);

        // 3 - Contar quantos valores são ímpares com o ArrayProcessador
        int quantidadeImpares = ArrayProcessor.contarImpares(dados);
        System.out.printf("Quantidade de valores ímpares: %d%n", quantidadeImpares);

        // 4 - Imprimir todos os valores informados usando o ArrayProcessador
        ArrayProcessor.imprimirValores(dados);

        Leitor.fecharScanner();

        System.out.println("Programa de Análise de Dados encerrado! ");
    }
}
