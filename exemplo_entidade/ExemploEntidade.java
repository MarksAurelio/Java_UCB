public class ExemploEntidade {
    public static void main(String args[]) {
        // Na linha de baixo é criado seu 1º objeto
        /* L1 */ Aluno al = new Aluno();
        /* L2 */ al.nome = "João da Silva";
        // o acesso aos atributos se dá por(.), assim como no C.
        al.matricula = "UC17000000";
        al.situacao = 'B';

        System.out.print("O nome do estudante: " + al.nome);

        // acalme-se isso é um operador ternário, entendeu?
        String texto = (al.situacao == 'B' ? "BOLSISTA" : "REGULAR");

        System.out.print("\nSituação do aluno: " + texto);
    }
}

// Definição de uma entidade chamada Aluno FORA da classe ExemploEntidade
class Aluno {
    String nome;
    String matricula;
    char situacao; // B - Bolsista R - Regular
}
