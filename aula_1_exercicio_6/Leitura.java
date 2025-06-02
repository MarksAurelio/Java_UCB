package aula_1_exercicio_6;

import java.util.Scanner;

public class Leitura {
    @SuppressWarnings("resource")
    public static void main(String []args) {
        double salario;
        System.out.println("Informe um salário: ");
        salario = new Scanner(System.in).nextDouble();
        int idade;
        System.out.println("Informe a idade: ");
        idade = new Scanner(System.in).nextInt();
        System.out.printf("O salário informado foi: %.2f", salario);
        System.out.println("\nA idade informada foi: " + idade);
    }
}
