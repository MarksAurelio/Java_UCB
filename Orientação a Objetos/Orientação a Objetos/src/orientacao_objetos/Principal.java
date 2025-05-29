package orientacao_objetos;

public class Principal {
    public static void main(String[] args) {
        Livro livro = new Livro();

        livro.nome = "Aprendendo Java";
        livro.descricao = "Livro sobre conhecimentos Java";
        livro.isbn = "05874875847051";
        livro.preco = 23.45;
        livro.autor = "Autor desconhecido";
        livro.dataPub = "29/05/2025";

        // System.out.printf("A data da publicação do livro %s é %s%n", livro.nome,
        // livro.dataPub);

        livro.dadosLivro();

    }

}
