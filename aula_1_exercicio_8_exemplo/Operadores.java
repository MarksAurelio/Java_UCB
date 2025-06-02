package aula_1_exercicio_8_exemplo;

public class Operadores {
    int num_instancia;
    static int num_estatica;
public static void main(String[] args) {
    Operadores obj = new Operadores();
    System.out.println(obj.num_instancia);
    System.out.println(Operadores.num_estatica);
}
}
