/* Implemente um programa em Java que calcule o juro de uma dívida que você contraiu no mês passado no crediário de uma loja. A taxa de juros mensal e o valor da dívida serão fornecidos pelo usuário. */
package aula_2_exercicio_2;

import java.util.Scanner;

public class TaxaDeJuros {
    public static void main(String[] args) {
        // Declaração
        double divida;
        double jurosMensal;
        double juros;
        double total;

        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.println("Informe o valor total da dívida R$: ");
        divida = scanner.nextDouble();

        System.out.println("Informe a taxa de juros (sem % - ex: 5 para 5%): ");
        jurosMensal = scanner.nextDouble();

        // Cálculos
        double taxaDecimal = jurosMensal / 100.0;

        juros = divida * taxaDecimal * 1; // 1 refere-se ao mês ou seja o tempo para 1 mês o tempo é 1

        total = divida + juros;

        // Apresentação
        System.out.println("Valor da Dívida 0riginal: R$ " + String.format("%.2f", divida));
        System.out.println("Taxa de Juros Mensal: " + jurosMensal + "%");
        System.out.println("Valor do Juro (1 mês): R$ " + String.format("%.2f", juros));
        System.out.println("Total a Pagar (Dívida + Juros): R$ " + String.format("%.2f", total));

        scanner.close();
    }

}
