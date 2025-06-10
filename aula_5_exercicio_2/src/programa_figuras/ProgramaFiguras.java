package programa_figuras;

public class ProgramaFiguras {
    public static void main(String[] args) {

        System.out.println("--- Teste de Figuras Geométricas ---");

        // 1. Instanciando e testando um Retângulo
        System.out.println("\nCalculando Retângulo: ");
        Retangulo retangulo1 = null;
        try {
            retangulo1 = new Retangulo(10.0, 5.0);
            System.out.println(retangulo1); // Chama toString do Retângulo
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar retângulo: " + e.getMessage());
        }
        // Testando outro Retângulo
        Retangulo retangulo2 = null;
        try {
            retangulo2 = new Retangulo(7.5, 3.2);
            System.out.println(retangulo2);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar retângulo: " + e.getMessage());
        }
        // Exemplo de Retângulo com valores inválidos para testar a validação
        System.out.println("\nTentando criar um Retângulo inválido:");
        Retangulo retanguloInvalido = null;
        try {
            retanguloInvalido = new Retangulo(0.0, 10.0);
            System.out.println(retanguloInvalido);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        // 2. Instanciando e testando um Trinãngulo Retângulo
        System.out.println("\nCalculando Triângulo Retângulo: ");
        TrianguloRetangulo triangulo1 = null;
        try {
            triangulo1 = new TrianguloRetangulo(6.0, 8.0);
            System.out.println(triangulo1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar Triângulo " + e.getMessage());
        }
        // 3. Testando outro Triângulo Retângulo
        TrianguloRetangulo triangulo2 = null;
        try {
            triangulo2 = new TrianguloRetangulo(3.0, 4.0);
            System.out.println(triangulo2);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar Triângulo " + e.getMessage());
        }
        // 4. Testando um Triângulo Retângulo inválido
        System.out.println("\nTentando criar um Triângulo Inválido: ");
        TrianguloRetangulo trianguloInvalido = null;
        try {
            trianguloInvalido = new TrianguloRetangulo(5.0, -2.0);
            System.out.println(trianguloInvalido);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        System.out.println("\n--- Fim do Teste ---");
    }
}
