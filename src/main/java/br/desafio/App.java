package br.desafio;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {

    /**
     * Deve realizar a impressão de uma escadaria com tamanho N (informado pelo usuário), com * e espaços em branco, os
     * asteriscos devem começar a aparecer no final da linha, e ao término da impressão não devem restar espaços em
     * brancos na escada.
     *
     * @param numero Número inteiro positivo para impressão da escada.
     * @return Retorna TRUE caso consiga realizar a impressão da escada com pelo menos o tamanho de 1
     */
    public static boolean imprimirTextoEmEscada(int numero){
        boolean possivelImprimir = numero > 0;

        if(possivelImprimir) {
            String textoImpressao = "";
            for (int i = 0; i < numero; i++) {
                textoImpressao = textoImpressao.concat(" ");
            }

            char[] charImpressao = textoImpressao.toCharArray();
            for (int i = numero; i > 0; i--) {
                charImpressao[i - 1] = '*';
                System.out.println(charImpressao);
            }
        } else {
            System.out.println("Não é possível realizar a impressão, número informado menor que zero. [ Número: " + numero + " ].");
        }

        return possivelImprimir;
    }

    /**
     * Deve realizar a validação de uma senha informada pelo usuário, e a mesma deve estar de acordo com os seguintes
     * critérios:
     *
     * - Possuir pelo menos um tamanho de 6 dígitos
     * - Possuir pelo menos 1 dígito númerico
     * - Possuir pelo menos 1 letra maiúscula
     * - Possuir pelo menos 1 letra minúscula
     * - Possuir pelo menos 1 caractere especial
     *
     * @param senha Senha no formato STRING
     * @return Retorna TRUE caso a senha informada cumpra todos os requisitos.
     */
    public static boolean validarSenhaForte(String senha){
        boolean senhaForte = true;

        Pattern p = Pattern.compile("[0-9]");
        if(!p.matcher(senha).find()){
            senhaForte = false;
            System.out.println("Sua senha deve conter pelo menos 1 número.");
        }

        p = Pattern.compile("[A-Z]");
        if(!p.matcher(senha).find()){
            senhaForte = false;
            System.out.println("Sua senha deve conter pelo menos 1 letra maiúscula.");
        }

        p = Pattern.compile("[a-z]");
        if(!p.matcher(senha).find()){
            senhaForte = false;
            System.out.println("Sua senha deve conter pelo menos 1 letras minúscula.");
        }

        p = Pattern.compile("[^a-zA-Z 0-9]");
        if (!p.matcher(senha).find()){
            senhaForte = false;
            System.out.println("Sua senha deve conter pelo menos 1 caractere especial.");
        }

        if (senha.length()<6){
        senhaForte = false;
            System.out.println("Sua senha deve conter pelos menos mais: " + (6-senha.length()) + " dígito(s).");
        }

        return senhaForte;
    }

    public static void main( String[] args ) {
        String n;
        boolean continuarPrograma = true;

        System.out.println("Bem vindo!");
        System.out.println("Qual programa deseja executar?");
        while(continuarPrograma) {
            System.out.println("0 - Imprimir escada | 1 - Validar senha forte | Insira qualquer outra tecla para encerrar.");
            n = new Scanner(System.in).nextLine();
            switch (n) {
                case "0":
                    System.out.printf("Insira o tamanho da escada que deve ser impressa (em números inteiros): ");
                    try {
                        int tamanhoEscada = new Scanner(System.in).nextInt();
                        imprimirTextoEmEscada(tamanhoEscada);
                    }catch (Exception e){
                        System.out.println("O valor informado não é um número inteiro válido!!!");
                    }
                    break;
                case "1":
                    System.out.printf("Insira a senha que deseja validar: ");
                    String senha = new Scanner(System.in).nextLine();
                    boolean senhaForte = validarSenhaForte(senha);
                    if(senhaForte){
                        System.out.println("A senha informada cumpre todos os requisitos!");
                    } else {
                        System.out.println("A senha informada não cumpre todos os requisitos.");
                    }
                    break;
                default:
                    continuarPrograma = false;
                    System.out.println("Até a próxima!");
                    break;
            }
            if(continuarPrograma) {
                System.out.println("Deseja executar novamente algum programa?");
            }
        }

    }

}
