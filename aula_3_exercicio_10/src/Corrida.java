/* Um piloto tem nome, escuderia e tempo de volta (em minutos apenas não pode ser menor que 1 nem maior que 60). Faça um programa Java que receba os dados dos pilotos de uma corrida. Ao final mostre o seguinte:

O piloto mais rápido.
O piloto mais lento.
A média dos tempos.
DESAFIO: todos os pilotos ordenados pelo tempo. (Use o bubblesort) */
public class Corrida {
    // Solita ao usuário os dados de um piloto(nome, escuderia, tempo volta)
    public static Piloto solicitarDadosPiloto() {
        System.out.println("--- Cadastro de Piloto ---");
        String nome = Leitor.lerString("Informe o nome do piloto:");
        String escudeira = Leitor.lerString("Informe a escudeira do piloto:");

        double tempoVolta = 0.0;
        boolean tempoValida = false;
        while (!tempoValida) {
            tempoVolta = Leitor.lerDouble("Informe o tempo de volta em minutos de (1 a 60);");
            if (tempoVolta >= 1.0 && tempoVolta <= 60.0) {
                tempoValida = true;
            } else {
                System.out.println("Tempo de volta inválido. Dever ser um número entre 1 e 60.");
            }
        }
        return new Piloto(nome, escudeira, tempoVolta);
    }

    // Popula o array de objeto de Pilotos com dados solicitados do usuário, pilotos
    // 0 array do Piloto a ser preenchido
    public static void popularArrayPilotos(Piloto[] pilotos) {
        for (int i = 0; i < pilotos.length; i++) {
            System.out.printf("\nColetando dados do Piloto %d de %d:%n", (i + 1), pilotos.length);
            pilotos[i] = solicitarDadosPiloto();
        }
    }

    // Encontrar o piloto como tempo mais rápido
    public static Piloto encontrarPilotoMaisRapido(Piloto[] pilotos) {
        if (pilotos == null || pilotos.length == 0) {
            return null;
        }
        Piloto maisRapido = pilotos[0]; // Assume o primeiro como o mais rápido inicialmente
        for (int i = 1; i < pilotos.length; i++) {
            if (pilotos[i].getTempoVolta() < maisRapido.getTempoVolta()) {
                maisRapido = pilotos[i]; // Atualiza se encontrar um mais rápido
            }
        }
        return maisRapido;
    }

    // Encontra o piloto com mais tempo gasto na volta(o mais lento)
    public static Piloto encontrarPilotoMaisLento(Piloto[] pilotos) {
        if (pilotos == null || pilotos.length == 0) {
            return null;
        }
        Piloto maisLento = pilotos[0]; // Assume o primeiro como o mais lento inicialmente
        for (int i = 1; i < pilotos.length; i++) {
            if (pilotos[i].getTempoVolta() > maisLento.getTempoVolta()) {
                maisLento = pilotos[i]; // Atualiza se encontrar um mais lento
            }
        }
        return maisLento;
    }

    public static double calcularMediaTempos(Piloto[] pilotos) {
        if (pilotos == null || pilotos.length == 0) {
            return 0.0;
        }
        double somaTempos = 0.0;
        for (Piloto piloto : pilotos) { // Usa o for-each para somar os tempos
            somaTempos += piloto.getTempoVolta();
        }
        return somaTempos / pilotos.length;
    }

    // Ordena o array de pilotos pelo tempo de volta em ordem crescente utilizando o
    // algoritmo Bubble sort
    public static void ordenarPilotosPorTempo(Piloto[] pilotos) {
        if (pilotos == null || pilotos.length == 1) {
            return; // Não há o que ordenar se tiver 0 ou 1 piloto
        }
        int n = pilotos.length;
        boolean trocou; // Flag para otimizar, se nenhuma troca ocorrer em uma passagem, o array está
                        // ordenado

        // Loop externo para controlar as passagens
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            // Loop interno para comparar e trocar elementos adjacentes
            for (int j = 0; j < n - 1; j++) {
                // Compara o tempo de volta do piloto atual com o próximo
                if (pilotos[j].getTempoVolta() > pilotos[j + 1].getTempoVolta()) {
                    // Troca os pilotos de posição
                    Piloto temp = pilotos[i]; // Guarda o piloto atual temporariamente
                    pilotos[j] = pilotos[j + 1]; // Move o próximo para a posição atual
                    pilotos[j + 1] = temp; // Coloca o piloto guardado na próxima posição
                    trocou = true; // Indica que uma troca ocorreu
                }
            }
            // Se nenhuma troca ocorreu nesta passagem, o array já está ordenado, então pode
            // podemos parar
            if (!trocou) {
                break;
            }
        }

    }

    public static void imprimirPilotos(Piloto[] pilotos, String titulo) {
        System.out.println("\n---" + titulo + "---");
        if (pilotos == null || pilotos.length == 0) {
            System.out.println("Nenhum piloto para exibir");
            return;
        }
        for (int i = 0; i < pilotos.length; i++) {
            System.out.printf("%d. %s%n", (i + 1), pilotos[i].toString());
        }
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Análise de Tempos de Volta da Corrida ---");

        int numPilotos = 0;
        boolean numPilotosValido = false;
        while (!numPilotosValido) {
            numPilotos = Leitor.lerInt("Informe quantos pilotos participarão da corrida:");
            if (numPilotos > 0) {
                numPilotosValido = true;
            } else {
                System.out.println("O número de pilotos dever ser maior que 0. Tente novamente.");
            }
        }
        // Cria o array para armazenar os objetos Piloto
        Piloto[] pilotosCorridas = new Piloto[numPilotos];

        // Receber os dados de todos os pilotos
        popularArrayPilotos(pilotosCorridas);

        // Se por alguma razão (apesar da validação anteior) o array estiver vazio,
        // encerra
        if (pilotosCorridas.length == 0) {
            System.out.println("Não há pilotos para analisar. Programa Encerrado!");
            Leitor.fecharScanner();
            return;
        }
        // Apresentar o piloto mais rápido
        Piloto maisRapido = encontrarPilotoMaisRapido(pilotosCorridas);
        System.out.println("\n--- Resumo da Análise ---");
        System.out.println("Piloto mais rápido: " + maisRapido.toString());

        // Apresentar o piloto mais lento
        Piloto maisLento = encontrarPilotoMaisLento(pilotosCorridas);
        System.out.println("Piloto mais lento: " + maisLento.toString());

        // Apresentar a média dos tempos
        double mediaTempos = calcularMediaTempos(pilotosCorridas);
        System.out.printf("Média dos Tempos de Volta: %.2f minutos%n", mediaTempos);

        // Ordenar e apresentar todos os pilotos pelo tempo (Bubble Sort)
        // O Bubble Sort ordena o array 'pilotosCorrida' diretamente
        ordenarPilotosPorTempo(pilotosCorridas);
        imprimirPilotos(pilotosCorridas, "Pilotos Ordenados por Tempo (Mais Rápido ao Mais Lento)");

        // Fechar o Scanner
        Leitor.fecharScanner();
        System.out.println("\nAnálise da corrida concluída e programa encerrado!");
    }
}
