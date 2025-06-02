/* Implemente um programa em Java que calcule o juro de uma dívida que você contraiu no mês passado no crediário de uma loja. A taxa de juros mensal e o valor da dívida serão fornecidos pelo usuário. A dívida deve ser calculada por método criado por você chamado: calcularDivida e deve receber como parâmetro os valores necessários para o cálculo e retornar a referida dívida */
package aula_3_exercicio_1;

public class ProgramaCrediario {
    public static void main(String[] args) {
        double divida = Leitor.lerDouble("Qual a dívida: ");

        double jurosMensal = Leitor.lerDouble("Qual o juros mensal(exemplo para 5% digite 5): ");

        double juros = jurosMensal / 100.0;

        double totalDevido = Calculadora.calcularDivida(divida, juros);

        System.out.printf("Divida inical: %.2f%n", divida);
        System.out.printf("Taxa de juros Mensal: %.2f%%%n", jurosMensal);
        System.out.printf("Total a pagar (divida + juros) R$ %.2f%n", totalDevido);

        Leitor.fecharScanner();
    }

}
