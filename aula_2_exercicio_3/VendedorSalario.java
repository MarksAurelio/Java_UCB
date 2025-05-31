/* Implemente um programa em Java que leia o nome de um vendedor, o seu salário fixo e o total de vendas efetuadas por ele no mês. Sabendo que este vendedor ganha 15% de comissão sobre suas vendas efetuadas, o programa deve mostrar como resultado o seu nome e o seu salário no final do mês */
import java.util.Scanner;

public class VendedorSalario {
    public static void main(String[] args) {
        String nomeVendedor;
        double salario;
        double totalVendasMes;
        double comissaoVendas;
        double salarioFinal;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do vendedor: ");
        nomeVendedor = scanner.nextLine();

        System.out.print("Digite o salário do vendedor(a): ");
        salario = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Total das vendas do vendedor(a): ");
        totalVendasMes = scanner.nextDouble();
        scanner.nextLine();

        comissaoVendas = totalVendasMes * 0.15;

        salarioFinal = salario + comissaoVendas;

        System.out.println("Nome do Vendedor: " + nomeVendedor);
        System.out.println("Salário Fixo: R$ " + String.format("%.2f", salario));
        System.out.println("Comissão sobre Vendas: R$ " + String.format("%.2f", comissaoVendas));
        System.out.println("Salário Total no Final do Mês: R$ " + String.format("%.2f", salarioFinal));

        scanner.close();
    }
}
