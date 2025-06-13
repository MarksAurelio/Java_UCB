/* Um matemático trabalha com dois tipos de figuras os triângulos retângulos e os retângulos. Crie um programa Java (classes) que representem a modelagem para abstrair este problema. Ambos têm dois dados comuns: Base e Altura. Cada uma tem um cálculo de forma distinta de área. O triângulo retângulo é base * altura / 2, já do retângulo é apenas base * altura. Um cálculo diferente somente para o triângulo retângulo deve ser realizado que é a hipotenusa.

Crie um método em todas as entidades com a seguinte assinatura:

public static double getArea();

Um método construtor que receba a base e altura deve ser criado em Figura.

public Figura (double base, double altura){ ...

Ao final do programa, faça uma classe main e aplique o conceito do polimorfismo. Faça com que uma referência de figura consiga calcular a área de um triângulo retângulo e na sequência faça para o retângulo. */
package geometria;

public class TesteFigurasGeometricas {
    public static void main(String[] args) {
        System.out.println("--- Demonstração de Polimorfismo com Figuras Geométricas ---");
        // 1. Criando uma referência do tipo figura
        Figura figuraGenerica;

        // 2. Referência figura apontando para o objeto TriânguloRetângulo
        System.out.println("\nCalculando para um Triângulo Retângulo: ");
        try {
            figuraGenerica = new TrianguloRetangulo(10.0, 5.0);
            System.out.println(figuraGenerica.toString()); // Exibe a descrição do TriânguloRetângulo
            System.out.printf("Área (via referência Figura): %.2f%n", figuraGenerica.getArea()); // Chama o getArea do
                                                                                                 // Triângulo Retângulo
            // Para chamar métodos específicos do TriânguloRetângulo é preciso um cast
            if (figuraGenerica instanceof TrianguloRetangulo) {
                TrianguloRetangulo tr = (TrianguloRetangulo) figuraGenerica;
                System.out.printf("Hipotenusa (acesso específico): %.2f%n", tr.calcularHipotenusa());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar Triângulo " + e.getMessage());
        }
        // 3. Referência Figura apontado para um objeto Retângulo
        System.out.println("\nCalculando para um Retângulo: ");
        try {
            figuraGenerica = new Retangulo(10.0, 10);
            System.out.println(figuraGenerica.toString());
            System.out.printf("Área (via referência Figura): %.2f%n", figuraGenerica.getArea());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar Retângulo " + e.getMessage());
        }
        // 4. Exemplo com valors inválidos para testar as validações do Construtor
        System.out.println("\nTentanto criar figura com valores inválidos: ");
        try {
            figuraGenerica = new Retangulo(-10.0, 5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        System.out.println("\n--- Fim da Demonstração ---");
    }
}
