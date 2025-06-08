/* Brasília é uma cidade que contém muitos triatletas amadores. A Federação precisa gerenciar a participação dos atletas nos eventos de triatlo. Cada atleta possui o número de inscrição (que deve ser único), nome, tempo de prova (em horas completas), idade e se o atleta é elite. Ele será considerado elite se o tempo de prova for menor que 5 horas. Um método isElite deve encapsular esse cálculo e retornará true, se for elite, e false, se não for. Sabe-se que participarão 1.200 atletas. Após receber os dados dos atletas, apresente o seguinte relatório:

A Quantidade de atletas da ELITE.
O melhor atleta da competição.
Todos os atletas da categoria 30 a 34 anos.
A média de tempo dos atletas.
Todos os atletas que não são ELITES.
Você deve trabalhar com ArrayList. */
package gerenciador_triatletas_app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GerenciadorTriatletaApp {
    public static void main(String[] args) {
        Leitor leitor = new Leitor();
        List<Atleta> atletas = new ArrayList<>();
        Set<Integer> inscricoesUsadas = new HashSet<>(); // Usado para garantir a unicidade do número de inscrição

        System.out.println("--- Sistema de Gerenciamento de Triatletas ---");

        String continuar = "sim";
        // Loop de cadastro: continua enquanto o usuário desejar e o limite de 1200
        // atletas não for atingido
        while (continuar.equals("sim") && atletas.size() < 1200) {
            System.out.println("\n--- Cadastro de Atleta " + (atletas.size() + 1) + " ---");

            int numeroInscricao;
            boolean inscricaoUnica = false;
            do {
                numeroInscricao = leitor.obterNumeroInteiro("Número Inscrição: ");
                if (inscricoesUsadas.contains(numeroInscricao)) {
                    System.out.println("Esse número de inscrição já foi usado. Digite um único.");
                } else {
                    inscricaoUnica = true;
                    inscricoesUsadas.add(numeroInscricao); // Adiciona o número da inscrição ao conjunto
                }
            } while (!inscricaoUnica);

            String nome = leitor.obterStringEntrada("Digite o nome do(a) atleta: ");
            // Por favor, verifique o nome exato do método em sua classe Leitor
            // (obterTempoProvaHoras vs. obterTempoProvasHoras).
            // Mantenho como 'obterTempoProvasHoras' para corresponder ao seu código.
            int tempoDeProvas = leitor.obterTempoProvasHoras("Tempo de prova (horas completas):");
            int idade = leitor.obterIdade("Idade: ");

            Atleta novoAtleta = new Atleta(numeroInscricao, nome, tempoDeProvas, idade);
            atletas.add(novoAtleta);

            System.out.println("Atleta " + nome + " cadastrado com sucesso!");

            // Pergunta ao usuário se deseja continuar, respeitando o limite de 1200 atletas
            if (atletas.size() < 1200) {
                continuar = leitor.obterRespostaSimNao("Deseja continuar (sim/não):");
            } else {
                System.out.println("Número máximo de 1200 atletas atingido.");
                continuar = "não"; // Força a saída do loop
            }
        }

        System.out.println("\n--- Relatório de Participação dos Triatletas ---");

        if (atletas.isEmpty()) {
            System.out.println("Nenhum triatleta foi cadastrado!");
        } else {
            // 1. Quantidade de Atletas da ELITE
            int quantidadeElite = 0;
            for (Atleta atleta : atletas) {
                if (atleta.getEliteStatus()) { // Usa o getter do status de elite
                    quantidadeElite++;
                }
            }
            System.out.println("\n1. Quantidade de Atletas da Elite: " + quantidadeElite);

            // 2. O melhor atleta da competição (menor tempo de prova)
            Atleta melhorAtleta = null;
            if (!atletas.isEmpty()) { // Garante que a lista não está vazia antes de procurar o melhor
                melhorAtleta = atletas.get(0); // Assume o primeiro como o melhor inicialmente
                for (int i = 1; i < atletas.size(); i++) {
                    // Por favor, verifique o nome exato do método em sua classe Atleta
                    // (getTempoProvaHoras vs. getTempoProvasHoras).
                    // Mantenho como 'getTempoProvasHoras' para corresponder ao seu código.
                    if (atletas.get(i).getTempoProvasHoras() < melhorAtleta.getTempoProvasHoras()) {
                        melhorAtleta = atletas.get(i);
                    }
                }
            }
            if (melhorAtleta != null) {
                System.out.println("\n2. O melhor atleta da competição (menor tempo): "); // Corrigi '\2' para '\n'
                System.out.println(melhorAtleta);
            } else {
                System.out.println("\n2. Não foi possível determinar o melhor atleta (nenhum cadastrado).");
            }

            // 3. Todos os atletas da categoria 30 a 34 anos
            System.out.println("\n3. Atletas da categoria 30 a 34 anos: ");
            boolean encontrouCategoria = false;
            for (Atleta atleta : atletas) {
                if (atleta.getIdade() >= 30 && atleta.getIdade() <= 34) {
                    System.out.println(atleta);
                    encontrouCategoria = true;
                }
            }
            if (!encontrouCategoria) {
                System.out.println("Nenhum atleta na categoria 30 a 34 anos.");
            }

            // 4. Média de tempo dos atletas
            double somaTempos = 0;
            for (Atleta atleta : atletas) {
                // Por favor, verifique o nome exato do método em sua classe Atleta.
                somaTempos += atleta.getTempoProvasHoras();
            }
            double mediaTempo = 0;
            if (!atletas.isEmpty()) { // Evita divisão por zero se não houver atletas
                mediaTempo = somaTempos / atletas.size();
            }
            System.out.printf("\n4. A média de tempo dos atletas: %.2f horas%n", mediaTempo);

            // 5. Todos os atletas que não são ELITES
            System.out.println("\n5. Atletas que NÃO são Elites: ");
            boolean encontrouNaoElite = false;
            for (Atleta atleta : atletas) {
                if (!atleta.getEliteStatus()) { // Se não é Elite (getEliteStatus() retorna false)
                    System.out.println(atleta);
                    encontrouNaoElite = true;
                }
            }
            if (!encontrouNaoElite) {
                System.out.println("Todos os atletas são Elites.");
            }
        }
        leitor.fecharScanner();
    }
}