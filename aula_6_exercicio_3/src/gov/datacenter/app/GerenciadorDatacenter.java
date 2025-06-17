/* O Datacenter corporativo do Governo está passando por uma adaptação no que tange à administração dos seus sistemas. Basicamente, existem dois tipos de sistema para o governo: Administrativo e Corporativo. O Administrador do Datacenter sobre os sistemas administrativos deseja saber quantos usuários simultâneos utilizam esse tipo de sistema, se deve ficar no ar full time ou não e o nome do sistema. Para os Corporativos, se deve ficar no ar full time ou não, nome do sistema e quantos acessos por minuto ele deve suportar.

Todo sistema tem uma pessoa responsável, que deve ser recebido o nome e telefone. Essa administração está acontecendo para que seja possível determinar quantos funcionários por plantão o governo irá pagar hora extra.

Sistemas Administrativos – Se for full time sempre deverá ter um funcionário e mais um adicional de 2 caso o sistema tenha mais 200 usuários simultâneos.

Sistemas Corporativos – Se for full time sempre deverá ter dois funcionários e caso entre 3000 e 5000 acessos inclusive, um adicional de 2, caso tenha mais de 5000 mil acessos, um adicional de 3.

O gerente, enquanto desejar, informará os dados dos sistemas.

Sabe-se que a classe Sistema (a mais genérica deve ser abstrata, assim como o método de saber a quantidade de funcionários).

Ao término do cadastro, ele deve ter acesso às seguintes informações:

Apresente todos os sistemas.
O sistema que demanda mais funcionários.
Os sistemas que o responsável tenha "Steve" em seu nome.
Uma proposta de projeto foi elaborada para este exercício a fim de auxiliá-lo a organizar suas entidades de negócio. Faça sua implementação a partir do projeto abaixo e complemente com as classes de entradas de dados e fluxo do programa. */
package gov.datacenter.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import gov.datacenter.model.PessoaResponsavel;
import gov.datacenter.model.Sistema;
import gov.datacenter.model.SistemaAdministrativo;
import gov.datacenter.model.SistemaCorporativo;

public class GerenciadorDatacenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Sistema> listaSistemas = new ArrayList<>();

        System.out.println(("--- Administração de Sistemas do Datacenter Corporativo do Governo ---"));

        boolean continuarCadastro = true;
        while (continuarCadastro) {
            System.out.println("\n--- Cadastro de Novo Sistema ---");
            System.out.println("Qual o tipo de sistema? (A para Administrativo / C para Corporativo / S para Sair)");
            String tipoSistema = scanner.nextLine().trim().toUpperCase();

            if (tipoSistema.equals("S")) {
                continuarCadastro = false;
                break;
            }
            // Coletar os dados comuns a todos os sistemas
            String nomeSistema = "";
            boolean isFullTimeNoAr = false;
            String nomeResponsavel = "";
            String telefoneResponsavel = "";
            boolean entradaComumValida = false;

            while (!entradaComumValida) {
                try {
                    System.out.println("Nome do Sistema: ");
                    nomeSistema = scanner.nextLine();
                    if (nomeSistema.isEmpty())
                        throw new IllegalArgumentException("Nome do sistema não pode ser vazio.");

                    System.out.println("Fica no ar Full Time? (S/N): ");
                    String fullTimeStr = scanner.nextLine().trim().toUpperCase();
                    if (!fullTimeStr.equals("S") && !fullTimeStr.equals("N")) {
                        throw new IllegalArgumentException("Resposta inválida para Full Time (S/N).");
                    }
                    isFullTimeNoAr = fullTimeStr.equals("S");

                    System.out.println("Nome do Responsável: ");
                    nomeResponsavel = scanner.nextLine();
                    if (nomeResponsavel.isEmpty())
                        throw new IllegalArgumentException("Nome do responsável não pode ser vazio.");

                    System.out.println("Telefone do Responsável: ");
                    telefoneResponsavel = scanner.nextLine();
                    if (telefoneResponsavel.isEmpty())
                        throw new IllegalArgumentException("Número do telefone não pode ser vazio.");

                    entradaComumValida = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro de entrada: " + e.getMessage());
                }

            }
            PessoaResponsavel responsavel = null;
            try {
                responsavel = new PessoaResponsavel(nomeResponsavel, telefoneResponsavel);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao criar responsável: " + e.getMessage());
                continue; // Volta para o início do loop principal de cadastro
            }
            // Coleta de dados específicos e criação do objeto
            Sistema novoSistema = null;
            try {
                if (tipoSistema.equals("A")) {
                    System.out.println("Número de Usuários Simultâneos: ");
                    int usuariosSimultaneos = scanner.nextInt();
                    scanner.nextLine();
                    novoSistema = new SistemaAdministrativo(nomeSistema, isFullTimeNoAr, responsavel,
                            usuariosSimultaneos);
                } else if (tipoSistema.equals("C")) {
                    System.out.println("Número de acessos por minuto: ");
                    int acessosPorMinuto = scanner.nextInt();
                    scanner.nextLine();
                    novoSistema = new SistemaCorporativo(nomeSistema, isFullTimeNoAr, responsavel, acessosPorMinuto);
                } else {
                    System.out.println("Tipo de sistema inválido. Tente novamente.");
                    continue; // Volta para o início do loope principal
                }
                listaSistemas.add(novoSistema);
                System.out.println("Sistema '" + nomeSistema + "' cadastrado com sucesso!");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Informe um número inteiro.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao criar sistema: " + e.getMessage());
            }
        } // Fim do loop de cadastro
          // Apresentar os relatórios finais
        System.out.println("\n--- Relatórios do Datacenter ---");

        if (listaSistemas.isEmpty()) {
            System.out.println("Nenhuma sistema foi cadastrado.");
        } else {
            // 1. Apresentar todos os sistemas
            System.out.println("\n--- Todos os Sistemas Cadastrados ---");
            for (Sistema sistema : listaSistemas) {
                System.out.println(sistema.toString());
                System.out.println("------------------------------------");
            }
            // 2. O sistema que demanda mais funcionários
            System.out.println("--- Sistema que Demanda Mais Funcionários ---");
            Sistema sistemaMaisDemandante = null;
            int maxFuncionarios = -1;

            for (Sistema sistema : listaSistemas) {
                int funcionariosAtuais = sistema.calcularFuncionarioNecessarios();
                if (funcionariosAtuais > maxFuncionarios) {
                    maxFuncionarios = funcionariosAtuais;
                    sistemaMaisDemandante = sistema;
                }
            }
            if (sistemaMaisDemandante != null) {
                System.out
                        .println("Sistema com maior demanda de funcionários (" + maxFuncionarios + " funcionários): ");
                System.out.println(sistemaMaisDemandante.getNomeSistema() + " (Responsável: "
                        + sistemaMaisDemandante.getResponsavel().getNome() + ")");
                System.out.println("Detalhes:\n " + sistemaMaisDemandante.toString());
            } else {
                System.out.println("Não foi possível determinar o sistema com mais funcionários.");
            }
            // 3. Os sistemas que o responsável tenha "Steve" em seu nome
            System.out.println("\n--- Sistema com Responsável 'Steve' ---");
            boolean encontradoSteve = false;
            for (Sistema sistema : listaSistemas) {
                // toLowerCase para busca case-insensitive
                if (sistema.getResponsavel().getNome().toLowerCase().contains("steve")) {
                    System.out.println(sistema.toString());
                    System.out.println("----------------------------");
                    encontradoSteve = true;
                }
            }
            if (!encontradoSteve) {
                System.out.println("Nenhum sistema encontrado com 'Steve' no nome do responsável.");
            }
        }
        scanner.close();
        System.out.println("\n--- Fim da Administração do Datacenter ---");
    }
}
