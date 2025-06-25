/* A era da internet ilimitada acabou, afirmou João Rezende, presidente da Anatel (Agência Nacional de Telecomunicações). Segundo a agência, não há mais possibilidade para que as operadoras de banda larga fixa ofereçam serviços sem uma limitação, o que obrigará o segmento a migrar para o modelo de franquias, semelhante aos serviços de internet móvel. A Anatel está criando um sistema de controle de franquias, que terá você como desenvolvedor. Uma franquia tem quantidade de GB, dia de expiração da franquia, preço da franquia, código da franquia e nome da empresa que fornece o serviço (VIVO, CLARO, OI ou TIM). Após receber do usuário todas as franquias que ele desejar informar. Sabe-se que o usuário irá informar a quantidade de franquias a ser informada, faça o seguinte:

Apresente todas as franquias.
A franquia mais barata.
As franquias oferecidas pela empresa VIVO.
As franquias que vão fornecer mais de 2GB.
Preço médio das franquias.
As franquias que vão vencer entre os dias 10 e 20.
Observações:

Considera-se mês contábil, de 1 a 30.
Não são aceitas franquias repetidas. */
package franquias_anatel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ControleFranquiaAnatel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Franquia> listaFranquias = new ArrayList<>();

        System.out.println("--- Sistema de Controle de Franquias Anatel ---");

        int quantidadeFranquias = 0;
        boolean inputInalido = false;
        while (!inputInalido) {
            try {
                System.out.println("Quantas franquias deseja informar?");
                quantidadeFranquias = scanner.nextInt();
                scanner.nextLine();
                if (quantidadeFranquias <= 0) {
                    throw new IllegalArgumentException("Quantidade de franquias deve ser um número positivo.");
                }
                inputInalido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                e.printStackTrace();
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        // Loop para cadastro de franquias
        for (int i = 0; i < quantidadeFranquias; i++) {
            System.out.println("\n--- Cadastro da Franquia # " + (i + 1) + " ---");
            boolean franquiaAdicionada = false;
            while (!franquiaAdicionada) {
                try {
                    System.out.println("Código da Franquia: ");
                    String codigo = scanner.nextLine();

                    System.out.println("Nome da Empresa (VIVO, TIM, CLARO ou OI): ");
                    String empresa = scanner.nextLine();

                    System.out.println("Quantidade de GB: ");
                    double gb = scanner.nextDouble();

                    System.out.println("Preço da Franquia: R$");
                    double preco = scanner.nextDouble();

                    System.out.println("Dia de Expiração: ");
                    int dia = scanner.nextInt();
                    scanner.nextLine();

                    Franquia novaFranquia = new Franquia(gb, dia, preco, codigo, empresa);

                    // Verifica se a franquia já existe na lista usando o método equals
                    if (listaFranquias.contains(novaFranquia)) {
                        System.out.println("Franquia com código " + codigo + " já existe. Insira um código único.");
                    } else {
                        listaFranquias.add(novaFranquia);
                        System.out.println("Franquia '" + codigo + "' cadastrada com sucesso!");
                        franquiaAdicionada = true; // Sai do loop interno
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    e.printStackTrace();
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        // Geração de Relatórios
        System.out.println("--- Relatórios das Franquias Cadastradas ---");

        if (listaFranquias.isEmpty()) {
            System.out.println("Nenhuma Franquia cadastrada para gerar Relatórios.");
        } else {
            // 1. Apresentar todas as franquias
            System.out.println("\n### Todas as Franquias ###");
            for (Franquia franquia : listaFranquias) {
                System.out.println(franquia);
            }
            // 2. A franquia mais barata
            System.out.println("\n### Franquia mais barata ###");
            Franquia maisBarata = listaFranquias.get(0); // Assume a primeira como a mais barata inicialmente
            for (int i = 0; i < listaFranquias.size(); i++) {
                if (listaFranquias.get(i).getPrecoFranquia() < maisBarata.getPrecoFranquia()) {
                    maisBarata = listaFranquias.get(i);
                }
            }
            System.out.println(maisBarata);

            // 3. As franquias oferecidas pela Empresa Vivo
            System.out.println("### Franquias da VIVO ###");
            boolean vivoEncontrada = false;
            for (Franquia franquia : listaFranquias) {
                if (franquia.getNomeEmpresa().equals("VIVO")) {
                    System.out.println(franquia);
                    vivoEncontrada = true;
                }
            }
            if (!vivoEncontrada) {
                System.out.println("Nenhuma franquia da Vivo encontrada.");
            }
            // 4. As franquias que vão fornecer mais de 2 GB
            System.out.println("### Franquias com mais de 2 GB ###");
            boolean maisDe2GBEncontrada = false;
            for (Franquia franquia : listaFranquias) {
                if (franquia.getQuantidadeGB() > 2.0) {
                    System.out.println(franquia);
                    maisDe2GBEncontrada = true;
                }
            }
            if (!maisDe2GBEncontrada) {
                System.out.println("Nenhuma franquia com mais de 2GB encontrada.");
            }
            // Preço médio das franquias
            System.out.println("### Preço médio das Franquias ###");
            double somaPrecos = 0;
            for (Franquia franquia : listaFranquias) {
                somaPrecos += franquia.getPrecoFranquia();
            }
            double precoMedio = somaPrecos / listaFranquias.size();
            System.out.printf("Preço Médio: R$%.2f%n", precoMedio);

            // Franquias que vão vencer entre os dias 10 e 20
            System.out.println("### Franquias com Vencimento entre os Dias 10 e 20 ###");
            boolean vencimentoEntreDias10e20Encontrado = false;
            for (Franquia franquia : listaFranquias) {
                if (franquia.getDiaExpiracao() >= 10 && franquia.getDiaExpiracao() <= 20) {
                    System.out.println(franquia);
                    vencimentoEntreDias10e20Encontrado = true;
                }
            }
            if (!vencimentoEntreDias10e20Encontrado) {
                System.out.println("Nenhum Franquia com vencimento encontrada entre os dias 10 a 20.");
            }
        }
        scanner.close();
        System.out.println("\n --- Fim do Sistema Anatel");
    }
}
