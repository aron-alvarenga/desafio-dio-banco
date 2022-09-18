package com.aronalvarenga.application;

import com.aronalvarenga.entities.Cliente;
import com.aronalvarenga.entities.Conta;
import com.aronalvarenga.entities.ContaCorrente;
import com.aronalvarenga.entities.ContaPoupanca;

import java.util.Scanner;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Cliente fulano = new Cliente();

        System.out.println("BANCO DIO\n");
        System.out.println("--- Tela de Cadastro --");
        System.out.print("Digite seu nome: ");
        String nome = sc.next();
        fulano.setNome(nome);
        System.out.print("Digite seu RG: ");
        int rg = sc.nextInt();
        fulano.setRg(rg);
        System.out.print("Digite seu CPF: ");
        String cpf = sc.next();
        fulano.setCpf(cpf);
        Conta cc = new ContaCorrente(fulano);
        ContaPoupanca poupanca = new ContaPoupanca(fulano);
        System.out.println();
        System.out.println("Conta Corrente(+1 Conta Poupança) criada com sucesso!");
        System.out.println();

        boolean aux = true;
        do {
            System.out.println("-- Operações Bancárias --");
            System.out.println("Digite o número da ação desejada");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Fazer um depósito");
            System.out.println("3 - Fazer um saque");
            System.out.println("4 - Transferir para Conta Poupança");
            System.out.println("9 - Sair");
            System.out.print(">> ");
            int auxSwitch = sc.nextInt();

            switch (auxSwitch) {
                case 1:
                    System.out.println();
                    cc.imprimirExtrato();
                    poupanca.imprimirExtrato();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\n-- BANCO DIO --");
                    System.out.println("-- OPERAÇÃO DE DEPÓSITO BANCÁRIO -- ");
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = sc.nextDouble();
                    cc.depositar(valorDeposito);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\n-- BANCO DIO --");
                    System.out.println("-- OPERAÇÃO DE SAQUE BANCÁRIO -- ");
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = sc.nextDouble();
                    cc.sacar(valorSaque);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\n-- BANCO DIO --");
                    System.out.println("-- OPERAÇÃO DE TRANSFERÊNCIA PARA CONTA POUPANÇA -- ");
                    System.out.print("Digite o valor que deseja transferir(CONTA CORRENTE PARA CONTA POUPANÇA): ");
                    double valorTransferencia = sc.nextDouble();
                    cc.transferir(valorTransferencia, poupanca);
                    System.out.println();
                    break;
                case 9:
                    System.out.println();
                    System.out.println("Saindo ... ");
                    aux = false;
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");

            }

        } while (aux);

        System.out.println("\nObrigado pela confiança!\nAtenciosamente, Banco DIO");



        sc.close();

        /*Cliente fulano = new Cliente();
        fulano.setNome("Fulano");

        Conta cc = new ContaCorrente(fulano);
        ContaPoupanca poupanca = new ContaPoupanca(fulano);

        cc.depositar(100.50);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        cc.transferir(50, poupanca);

        System.out.println();
        System.out.println("|||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||\n");

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();*/
    }
}
