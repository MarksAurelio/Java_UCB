/* Crie uma entrada de dados validada e protegida contra exceções para todos os tipos primitivos apresentados na Aula 2. Crie uma classe Leitor que ofereça esse serviço para outros programadores utilizarem. */
package util;

public class TesteLeitor {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Teste da Classe Leitor de Entradas ---");

        // Testando a leitura int
        int idade = Leitor.lerInt("Digite a idade: ");
        System.out.println("A idade é: " + idade);

        System.out.println("----------------------------");

        // Testando Double
        double altura = Leitor.lerDouble("Digite sua altura ex(1.73):");
        System.out.println("A altura é: " + altura);

        System.out.println("------------------------------");
        // Boolean
        boolean casado = Leitor.lerBoolean("Você é casado? (Sim/Não)");
        System.out.println("Status casado " + casado);

        System.out.println("------------------------------");

        // Short
        short anoNascimento = Leitor.lerShort("Digite o ano de nascimento: ");
        System.out.println("O ano de nascimento digitado foi: " + anoNascimento);

        System.out.println("--------------------------------");

        // Long
        long populacao = Leitor.lerLong("Digite a população de uma cidade qualquer: ");
        System.out.println("A população digitada foi: " + populacao);

        System.out.println("-----------------------------------");

        // Float
        float peso = Leitor.lerFloat("Qual o peso? ");
        System.out.println("O peso digitado foi: " + peso);

        System.out.println("-----------------------------------");

        // Char
        char inicial = Leitor.lerChar("Digite a inicial do seu nome: ");
        System.out.println("A inicial do nome digitado é: " + inicial);

        Leitor.fecharScanner();
    }
}
