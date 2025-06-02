package aula_1_exercicio_1;

import java.util.Scanner;

public class Constante {
  private static final double LARGURA = 10.0;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println(("Entre com o comprimento: "));
    double comprimento = scanner.nextDouble();

    double area = calcularArea(LARGURA, comprimento);
    System.out.println("A área é " + area);

    scanner.close();
  }

  private static double calcularArea(double largura, double comprimento) {
    return largura * comprimento;
  }
}
