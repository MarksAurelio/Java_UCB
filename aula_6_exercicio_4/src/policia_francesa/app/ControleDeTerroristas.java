/* Hoje pela manhã, a França iniciou a caça ao mentor dos ataques terroristas em Paris. Entre os envolvidos, 2 cometeram suicídio e outros foram capturados. O governo francês declarou que não vai parar por aí. Entretanto, o governo precisa de um sistema para controlar os Terroristas capturados pela polícia especializada, que cometeram atos terroristas ou que morreram em consequência disto.

A polícia afirma que existem dois tipos de terroristas: os suicidas e não suicidas. Sobre os suicidas, a polícia deseja catalogar o nome, a religião, a quantidade de explosivos encontrados. Já, para os não suicidas, deseja saber o nome, a quantidade de explosivos e o País de origem.

A polícia afirma também que existe um grau de periculosidade dos terroristas que é calculado de forma distinta para cada um dos casos, conforme abaixo:

Suicida – é o produto do dobro da quantidade de explosivos com a constante de Religião. Se for do Islamismo, 5. Caso contrário, 2.

Não suicida – é o triplo da quantidade de explosivos adicionado com a constante do País. Se for da Arábia, 7. Senão, 5.

Após receber todos os dados necessários de todos os terroristas, faça o seguinte:

Apresente todas as informações de todos os terroristas informados pelo usuário.
Apresente todos os terroristas que possuem grau de periculosidade maior que 50.
Mostre todos os terroristas que possuem MOHAMED no nome, em qualquer formato.
A quantidade de terroristas encontrados com mais de 10 explosivos.
O percentual de terroristas que não são do 'Egito'. */
package policia_francesa.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import policia_francesa.model.Terrorista;
import policia_francesa.model.TerroristaSuicida;
import policia_francesa.model.TerroristaNaoSuicida;

public class ControleDeTerroristas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Terrorista> listaTerroristas = new ArrayList<>();

        System.out.println("--- Sistema de Controle de Terroristas - Polícia Francesa ---");

        boolean continuarCadastro = true;
        while (continuarCadastro) {
            System.out.println("\n--- Cadastro de Novo Terrorista ---");
            System.out.println("Qual o tipo de Terrorista? (S para Suicida / N para Não Suicida / X para sair)");
            String tipoTerrorista = scanner.nextLine().trim().toUpperCase();

            if (tipoTerrorista.equals("X")) {
                continuarCadastro = false;
                break;
            }
            // Coleta de Dados comuns
            String nome = "";
            double quantidadeExplosivos = 0.0;
            boolean dadosComunsValidos = false;

            while (!dadosComunsValidos) {
                try {
                    System.out.println("Nome Terrorista: ");
                    nome = scanner.nextLine();
                    if (nome.isEmpty())
                        throw new IllegalArgumentException("Nome não pode ser vazio.");

                    System.out.println("Quantidade de Explosivos (Kg): ");
                    quantidadeExplosivos = scanner.nextDouble();
                    scanner.nextLine();
                    if (quantidadeExplosivos < 0)
                        throw new IllegalArgumentException("Quantidade de Explosivos não pode ser negativo");

                    dadosComunsValidos = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro na entrada: " + e.getMessage());
                }
            }
            // Coleta de Dados específicos e criação do objeto
            Terrorista novoTerrorista = null;
            try {
                if (tipoTerrorista.equals("S")) {
                    System.out.println("Religião: ");
                    String religiao = scanner.nextLine();
                    novoTerrorista = new TerroristaSuicida(nome, quantidadeExplosivos, religiao);
                } else if (tipoTerrorista.equals("N")) {
                    System.out.println("País de Origem: ");
                    String paisOrigem = scanner.nextLine();
                    novoTerrorista = new TerroristaNaoSuicida(nome, quantidadeExplosivos, paisOrigem);
                } else {
                    System.out.println("Tipo Terrorista inválido. Tente novamente.");
                    continue;
                }
                listaTerroristas.add(novoTerrorista);
                System.out.println("Terrorista '" + nome + "' adicionado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao criar terrorista " + e.getMessage());
            }
        } // Fim do loop
          // Apresentação dos Relatórios
        System.out.println("\n--- Relatórios de Controle de Terroristas ---");

        if (listaTerroristas.isEmpty()) {
            System.out.println("Nenhum terrorista cadastrado.");
        } else {
            // 1. Apresentar todas as informações de todos os terroristas
            System.out.println("\n--- Todos os Terroristas Cadastrados ---");
            for (Terrorista terrorista : listaTerroristas) {
                System.out.println(terrorista.toString());
                System.out.println("-----------------------------------");
            }
            // 2. Apresentar terroristas com grau de periculosidade > 50
            boolean periculosidadeAltaEncontrada = false;
            for (Terrorista terrorista : listaTerroristas) {
                if (terrorista.calcularGrauDePericulosidade() > 50) {
                    System.out.println(terrorista.toString());
                    System.out.println("------------------------------------");
                    periculosidadeAltaEncontrada = true;
                }
            }
            if (!periculosidadeAltaEncontrada) {
                System.out.println("Nenhum terrorista encontrado com grau de periculosidade maior que 50.");
            }
            // 3. Mostre todos os terroristas que possuem MOHAMED no nome, em qualquer
            // formato
            System.out.println("\n--- Terroristas com 'Mohamed' no nome ---");
            boolean mohamedEncontrado = false;
            for (Terrorista terrorista : listaTerroristas) {
                if (terrorista.getNome().toLowerCase().contains("mohamed")) {
                    System.out.println(terrorista.toString());
                    System.out.println("--------------------------");
                    mohamedEncontrado = true;
                }
            }
            if (!mohamedEncontrado) {
                System.out.println("Nenhum terrorista encontrado com 'Mohamed' no nome.");
            }
            // 4. Quantidade de terroristas encontrados com mais de 10 explosivos
            int countExplosivoMaisDe10 = 0;
            for (Terrorista terrorista : listaTerroristas) {
                if (terrorista.getQuantidadeExplosivos() > 10) {
                    countExplosivoMaisDe10++;
                }
            }
            System.out.println("Quantidade de terroristas com mais de 10Kg de explosivos: " + countExplosivoMaisDe10);

            // 5. O percentual de terroristas que não são do 'Egito'
            System.out.println("--- Percentual de Terroristas Não nativos do Egito ---");
            int totalNaoSuicidas = 0;
            int naoEgito = 0;

            for (Terrorista terrorista : listaTerroristas) {
                if (terrorista instanceof TerroristaNaoSuicida) { // Verifica se é um não-suicida
                    totalNaoSuicidas++;
                    TerroristaNaoSuicida naoSuicida = (TerroristaNaoSuicida) terrorista; // Cast para acessar paisOrigem
                    if (!naoSuicida.getPaisOrigem().equalsIgnoreCase("Egito")) {
                        naoEgito++;
                    }
                }
            }
            if (totalNaoSuicidas > 0) {
                double percentualNaoEgito = (double) naoEgito / totalNaoSuicidas * 100;
                System.out.printf("Percentual de terrorista Não suicidas que não são do Egito: %.2f%%%n ",
                        percentualNaoEgito);
            } else {
                System.out.println(
                        "Não há terroristas Não suicidas cadastrados para calcular o percentual por país de origem.");
            }
        }
        scanner.close();
        System.out.println("\n--- Fim do Sistema de Controle ---");
    }
}