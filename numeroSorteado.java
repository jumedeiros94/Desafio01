//Você deve gerar um número aleatório e comparar com a resposta vinda do usuário.
// Caso seja o mesmo número o usuário ganha 10 pontos, caso seja número diferente o
// programa deve comparar para saber se o número está 1 acima ou 1 abaixo do número sorteado,
// caso esteja o usuário ganha 5 pontos, caso não esteja o usuário apenas perde.
// No fim deverá ser exibida a pontuação do usuário. Tudo via console.

import java.util.Random;
import java.util.Scanner;
import java.lang.System;

public class numeroSorteado {

    public static void main(String[] args) {

        Random rand = new Random();

        int numero = rand.nextInt(100) + 1;
        //Gerando número aleatório de 1 a 100

        Scanner entrada = new Scanner(System.in);

        int pontos = 0;
        // variável para armazenar os pontos do usuário

        int palpite = 0;
        // variável para armazenar o palpite do usuário

        boolean continuar = true;
        // variável para controlar o laço

        int tentativas = 10;
        // variável para limitar as tentativas


        System.out.println("----------------------------------------------------");
        System.out.println("Vamos jogar? Tente adivinhar o número que pensei... ");
        System.out.println("----------------------------------------------------");

        while (continuar) {
            System.out.println("Digite um número de 1 a 100: ");

            String resposta = entrada.nextLine();
            //lendo a resposta como string

            try {
                palpite = Integer.parseInt(resposta); // tentando converter string em inteiro
            } catch (NumberFormatException E) { // se a conversão falhar encerrar jogo
                System.out.println("Valor inválido. Fim do jogo!");

                continuar = false;
                break;
            }

            if (palpite == numero) {
                pontos += 10; // se  o usúario acertar adicionar 10 pontos
                System.out.println("Parabéns! Você acertou o número e ganhou 10 pontos. ");
                System.out.println("----------------------------------------------------");
                continuar = false;

            } else if (palpite > 0 && palpite < 101) { // se estiver no intervalo válido calcular a diferença
                int diferenca = Math.abs(palpite - numero);

                if (diferenca == 1) {
                    pontos += 5; // se a diferença for igual a 1 adicionar 5 pontos, vamos mostrar também uma dica
                    System.out.println("Quase! Você esta muito perto!");
                    if (palpite < numero) {
                        System.out.println("O número é maior que " + palpite);
                        System.out.println("-------------------------------");
                    } else {
                        System.out.println("O número é menor que " + palpite);
                        System.out.println("-------------------------------");
                    }
                } else {
                    pontos -= 1; // se a diferença for maior que 1 subtrair 1 ponto

                    System.out.println("Que pena, você errou!");
                    System.out.println("-------------------------");
                    if (palpite < numero) {
                        System.out.println("O número é maior que " + palpite);
                        System.out.println("-------------------------------");

                    } else {
                        System.out.println("O numero é menor que " + palpite);
                        System.out.println("-------------------------------");
                    }
                }

                tentativas--;

                if (tentativas == 0) {
                    System.out.println("Você esgotou suas tentativas. Fim de jogo!");
                    System.out.println("------------------------------------------");
                    continuar = false;
                } else {
                    System.out.println("Você ainda tem " + tentativas + " tentativas. ");
                    System.out.println("----------------------------------------------");
                }

            } else {
                System.out.println("----------------------------");
                System.out.println("Valor inválido! Fim do jogo.");
                System.out.println("----------------------------");
                continuar = false;
            }
    }

        System.out.println("Obrigada por jogar! Sua pontuação final foi: " + pontos );
        System.out.println("-------------------------------------------------------");

    }

}





