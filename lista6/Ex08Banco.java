package lista4;

import java.text.NumberFormat;
import java.util.Scanner;

class ContaBancaria {
    private final String numeroConta;
    private String nome;
    private double saldo;

    public ContaBancaria(String numeroConta, String nome, double saldoInicial) {
        if (numeroConta == null || numeroConta.isBlank()) throw new IllegalArgumentException("Número da conta obrigatório.");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório.");
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial não pode ser negativo.");
        this.numeroConta = numeroConta;
        this.nome = nome;
        this.saldo = saldoInicial;
    }

    public void alterarNome(String novoNome) {
        if (novoNome == null || novoNome.isBlank()) throw new IllegalArgumentException("Nome inválido.");
        this.nome = novoNome;
    }
    public boolean deposito(double valor) {
        if (!valorValido(valor)) return false;
        saldo += valor;
        return true;
    }
    public boolean saque(double valor) {
        if (!valorValido(valor)) return false;
        if (valor > saldo) return false;
        saldo -= valor;
        return true;
    }
    private boolean valorValido(double valor) { return valor > 0; }

    public String getNumeroConta() { return numeroConta; }
    public String getNome() { return nome; }
    public double getSaldo() { return saldo; }
}

public class Ex08Banco {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getCurrencyInstance;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Número da conta: ");
            String numero = sc.nextLine().trim();
            System.out.print("Nome do titular: ");
            String nome = sc.nextLine().trim();
            System.out.print("Saldo inicial (R$): ");
            double saldoInicial = sc.nextDouble();

            ContaBancaria conta = new ContaBancaria(numero, nome, saldoInicial);
            boolean loop = true;
            while (loop) {
                System.out.printf("\nTitular: %s | Conta: %s | Saldo: %s%n", conta.getNome(), conta.getNumeroConta(), nf.format(conta.getSaldo()));
                System.out.println("1-Depositar  2-Sacar  3-Alterar nome  0-Sair");
                System.out.print("Opção: ");
                int op = sc.nextInt();
                switch (op) {
                    case 1 -> {
                        System.out.print("Valor do depósito: ");
                        double v = sc.nextDouble();
                        if (conta.deposito(v)) System.out.println("Depósito realizado.");
                        else System.out.println("Valor inválido.");
                    }
                    case 2 -> {
                        System.out.print("Valor do saque: ");
                        double v = sc.nextDouble();
                        if (conta.saque(v)) System.out.println("Saque realizado.");
                        else System.out.println("Saque inválido (valor inválido ou saldo insuficiente).");
                    }
                    case 3 -> {
                        sc.nextLine(); // limpar quebra de linha
                        System.out.print("Novo nome: ");
                        String novo = sc.nextLine().trim();
                        try {
                            conta.alterarNome(novo);
                            System.out.println("Nome atualizado.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Falha: " + e.getMessage());
                        }
                    }
                    case 0 -> loop = false;
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }
}
