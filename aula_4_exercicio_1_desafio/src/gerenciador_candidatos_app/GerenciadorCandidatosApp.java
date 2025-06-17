/* O candidato possui nome, número de filiação, se a candidatura é para deputado federal, distrital ou senador. Cada candidato tem direito a uma verba de campanha, de acordo com o seu tipo de candidatura. Se o candidato almejar candidatura para deputado distrital, a verba destinada a ele é de R$ 170.000,00, caso almeje deputado federal R$ 250.000,00, e, por fim, caso almeje senador R$ 350.000,00. Outra característica de candidato é se ele já foi ou não reeleito, caso ele já tenha sido reeleito a verba de campanha será dobrada. 

Sabe-se que será informado um número fixo de candidatos, pergunte ao usuário a quantidade e receba os dados do mesmo. Após o recebimento dos dados, apresente, sem a necessidade de um menu de opções, as seguintes informações:

Apresente todos os candidatos informados pelo usuário.
Apresente todos os candidatos que já foram reeleitos.
Apresente o total gasto com os deputados que não foram reeleitos.
Apresente o total gasto com todos os candidatos.
Apresente todos os candidatos que se chamam Tiririca.
Apresente também a média de custo com os candidatos. */
package aula_4_exercicio_1_desafio.src.gerenciador_candidatos_app;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorCandidatosApp {
    // Lista estática para armazenar todos os objetos Candidato
    private static List<Candidato> candidatos = new ArrayList<>();

    public static void main(String[] args) {
        // Cria uma instância da classe Leitor para lidar com a entrada de dados
        Leitor leitor = new Leitor();

        // Solicita a quantidade de candidatos e seus daddos ao usuário
        solicitarDadosCandidatos(leitor);

        // Apresenta todos os relatórios processados
        apresentarRelatorios();

        // Fecha o scanner do Leitor para liberar recursos
        leitor.fecharScanner();
    }

    private static void solicitarDadosCandidatos(Leitor leitor) {
        int quantidadeCandidatos = leitor.obterQuantidadeCandidatos();
        for (int i = 0; i < quantidadeCandidatos; i++) {
            System.out.println("\n--- Dados do Candidato --- " + (i + 1) + " ---");
            String nome = leitor.obterStringEntrada("Nome: ");
            int numeroFiliacao = leitor.obterNumeroInteiro("Número de Filiação: ");
            String tipoCanditura = leitor.obterTipoCandidatura();
            boolean reeleito = leitor.obterStatusReeileicao();
            // Cria um novo objeto Candidato e o adiciona à lista
            candidatos.add(new Candidato(nome, numeroFiliacao, tipoCanditura, reeleito));

        }
    }

    private static void apresentarRelatorios() {
        System.out.println("\n--- Relatórios ---");
        apresentarTodosCandidatos();
        apresentarCandidatosReeleitos();
        apresentarTotalGastoNaoReeleitos();
        apresentarTotalGastoTodosCandidatos();
        apresentarCandidatosTiririca();
        apresentarMediaCustoCandidatos();
    }

    private static void apresentarTodosCandidatos() {
        System.out.println("\n1. Todos os Candidatos Cadastrados:");
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato cadastrado.");
        } else {
            // Utiliza o método toString() da classe Candidato para exibir os detalhes
            candidatos.forEach(System.out::println);
        }
    }

    public static void apresentarCandidatosReeleitos() {
        System.out.println("\n2. Candidatos Reeleitos:");
        boolean encontrouReeleito = false;
        for (Candidato c : candidatos) {
            if (c.isReeleito()) {
                System.out.println(c);
                encontrouReeleito = true;
            }
        }
        if (!encontrouReeleito) {
            System.out.println("Nenhum candidato reeleito encontrado.");
        }
    }

    private static void apresentarTotalGastoNaoReeleitos() {
        double totalGasto = 0.0;
        for (Candidato c : candidatos) {
            // Verifica se não foi reeleito e se é deputado (federal ou distrital)
            if (!c.isReeleito()
                    && (c.getTipoCandidatura().equals("federal") || c.getTipoCandidatura().equals("distrital"))) {
                totalGasto += c.getVerbaCampanha();
            }
        }
        System.out.printf("\n3. Total Gasto com Deputados (Federal ou Distrital) que Não foram Reeleitos: R$ %.2f%n",
                totalGasto);
    }

    private static void apresentarTotalGastoTodosCandidatos() {
        double totalGasto = calcularTotalGastoTodosCandidatos();
        System.out.printf("\n4. Total Gasto com Todos os Candidatos: R$ %.2f%n", totalGasto);
    }

    private static double calcularTotalGastoTodosCandidatos() {
        double total = 0.0;
        for (Candidato c : candidatos) {
            total += c.getVerbaCampanha();
        }
        return total;
    }

    private static void apresentarCandidatosTiririca() {
        System.out.println("\n5. Candidatos que se Chama 'Tiririca':");
        boolean encontrouTiririca = false;
        for (Candidato c : candidatos) {
            if (c.getNome().equalsIgnoreCase("Tiririca")) {
                System.out.println(c);
                encontrouTiririca = true;
            }
        }
        if (!encontrouTiririca) {
            System.out.println("Nenhum candidato chamado 'Tiririca' encontrado.");
        }
    }

    private static void apresentarMediaCustoCandidatos() {
        if (candidatos.isEmpty()) {
            System.out.println("\nNão é possível calcular a média de custo, pois nenhum candidato foi cadastrado.");
        } else {
            double totalGasto = calcularTotalGastoTodosCandidatos();
            double mediaCusto = totalGasto / candidatos.size();
            System.out.printf("\n6. Média de Custo por Candidato: R$ %.2f%n", mediaCusto);
        }
    }
}
