package aula_3_exercicio_3_desafio.src.calculadora;

public class Calculadora {
    public static void main(String[] args) {
        double valorUm = Leitor.lerDouble("Informe o primeiro valor: ");
        char operador = Leitor.lerCaractere("Informe o operador: ");
        double valorDois = Leitor.lerDouble("Informe o segundo valor: ");
        double resultado = Matematica.calcular(valorUm, operador, valorDois);

        Impressora.printPane(valorUm, operador, valorDois, resultado);
    }

}
