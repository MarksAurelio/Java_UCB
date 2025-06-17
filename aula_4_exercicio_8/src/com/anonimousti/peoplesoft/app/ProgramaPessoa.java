/* Crie uma classe pessoa com nome, código inteiro e salário. A classe social de uma pessoa é calculada conforme o seguinte:

Classe

A1: inclui as famílias com renda mensal maior que R$ 14.400

Classe A2: maior que R$ 8.100

Classe B: maior que R$ 4.600

Classe C: maior que R$ 2.300

Classe D: maior que R$ 1.400

Classe E: maior que R$ 950

Classe F: maior que R$ 400

Receba do usuário os dados de uma pessoa e apresente todas as informações da pessoa, inclusive a classe por meio do método toString. Atenção! O método toString não deve fazer o cálculo de classe da pessoa. 

Utilizando a mesma modelagem do exercício anterior, receba os dados de várias pessoas e armazene em um ArrayList. Entretanto, não é permitido armazenar duas pessoas com o mesmo código (sobrescreva o equals). Após receber os dados, enquanto o usuário desejar, apresente todas as pessoas informadas usando o toString. Além da implementação do equals e toString, realize o empacotamento e distribua suas classes sabendo que você trabalha na empresa anonimousti e ela possui um site: www.anonimousti.com.br. O nome do sistema é peoplesoft. */
package com.anonimousti.peoplesoft.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.anonimousti.peoplesoft.model.Pessoa;

public class ProgramaPessoa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> listaPessoas = new ArrayList<>(); // Lista para armazenar as pessoas

        System.out.println("--- Sistema PeopleSoft da Anonimousti ---");
        System.out.println("--- Cadastro de Pessoa e consulta de Classe Social ---");

        boolean continuarCadastro = true;
        // Loop para garantir que todas as entradas (nome, código e salário) sejam
        // válidas
        while (continuarCadastro) {
            System.out.println("\n--- Nova Pessoa ---");
            String nome = "";
            int codigo = 0;
            double salario = 0.0;
            boolean entradaValida = false; // Uma flag para controlar a validação da entrada

            while (!entradaValida) {
                try {
                    System.out.println("Informe o nome: ");
                    nome = scanner.nextLine();
                    if (nome.trim().isEmpty()) {
                        System.out.println("Nome não pode ser vazio. Digite novamente.");
                        continue; // Pede o nome novamente
                    }
                    System.out.println("Informe o código (dever ser um número inteiro): ");
                    codigo = scanner.nextInt();
                    scanner.nextLine();
                    if (codigo <= 0) {
                        System.out.println("Código deve ser um número positivo.");
                        continue; // Pede o código novamente
                    }
                    System.out.println("Informe o salário a pessoa: ");
                    salario = scanner.nextDouble();
                    scanner.nextLine();
                    if (salario <= 0) {
                        System.out.println("Salário não pode ser negativo.");
                        continue; // Pede o salário novamente
                    }
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite o tipo de dado correto.");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) { // Captura exceções lançadas pelo construtor de Pessoa
                    System.out.println("Erro ao validar dados: " + e.getMessage());
                }
            }
            Pessoa novaPessoa = null;
            try {
                // Instancia um objeto Pessoa com os dados coletados
                novaPessoa = new Pessoa(nome, codigo, salario);
                // Verifica se já existe uma pessoa com o mesmo código na lista
                if (listaPessoas.contains(novaPessoa)) { // 'contains' usa o método equals que foi sobrescrevido
                    System.out.println("Erro: Já existe uma pessoa com o código.");
                } else {
                    listaPessoas.add(novaPessoa);
                    System.out.println("Pessoa '" + nome + "' (Código: " + codigo + ") adicionado com sucesso!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao criar pessoa: " + e.getMessage());
            }
            System.out.println("\nDeseja cadastrar outra pessoa? (S/N): ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            if (!resposta.equals("S")) { // Se a resposta não for 'S', para o cadastro
                continuarCadastro = false;
            }
        }
        // Apresentar todas as pessoas cadastradas
        System.out.println("\n--- Relatório de Pessoas Cadastradas ---");
        if (listaPessoas.isEmpty()) {
            System.out.println("\nNenhuma pessoa foi cadastrada.");
        } else {
            System.out.println("\n--- Pessoas Cadastradas no Sistema PeopelSoft ---");
            for (int i = 0; i < listaPessoas.size(); i++) {
                System.out.println("\n--- Pessoa " + (i + 1) + " ---");
                System.out.println(listaPessoas.get(i).toString()); // toString é chamado para exibir os detal
            }
        }
        scanner.close();
        System.out.println("\n --- Fim do Sistema PeopleSoft ---");
    }
}
