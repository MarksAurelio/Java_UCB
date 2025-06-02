package orientacao_objetos;

public class Livro {
    String nome;
    String descricao;
    String autor;
    String isbn;
    double preco;
    String dataPub;

    void dadosLivro() {
        System.out.println("Nome do Livro: " + nome);
        System.out.println("Descrição: Livro sobre conhecimentos Java " + descricao);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: "+ isbn);
        System.out.println("Preço R$" + preco);
        System.out.println("Data da publicação: " + dataPub + "\n");
    }

}
