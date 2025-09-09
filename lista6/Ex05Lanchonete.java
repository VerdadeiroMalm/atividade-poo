package lista4;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex05Lanchonete {
    static class Item {
        final int codigo;
        final String nome;
        final double preco;
        Item(int codigo, String nome, double preco) {
            this.codigo = codigo; this.nome = nome; this.preco = preco;
        }
    }
    public static void main(String[] args) {
        Map<Integer, Item> cardapio = new LinkedHashMap<>();
        cardapio.put(100, new Item(100, "Cachorro Quente", 1.20));
        cardapio.put(101, new Item(101, "Bauru Simples",   1.30));
        cardapio.put(102, new Item(102, "Bauru com ovo",   1.50));
        cardapio.put(103, new Item(103, "Hambúrguer",      1.20));
        cardapio.put(104, new Item(104, "Cheeseburguer",   1.30));
        cardapio.put(105, new Item(105, "Refrigerante",    1.00));

        NumberFormat nf = NumberFormat.getCurrencyInstance;
        double total = 0.0;

        System.out.println("CARDÁPIO:");
        System.out.println("Código  Especificação       Preço");
        for (Item it : cardapio.values()) {
            System.out.printf("%-7d %-20s %s%n", it.codigo, it.nome, nf.format(it.preco));
        }
        System.out.println("(Digite 0 para encerrar o pedido)");

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("Código do item (0 para encerrar): ");
                int cod = sc.nextInt();
                if (cod == 0) break;
                Item it = cardapio.get(cod);
                if (it == null) {
                    System.out.println("Código inválido. Tente novamente.");
                    continue;
                }
                System.out.print("Quantidade: ");
                int qtd = sc.nextInt();
                if (qtd <= 0) {
                    System.out.println("Quantidade deve ser positiva.");
                    continue;
                }
                double subtotal = it.preco * qtd;
                total += subtotal;
                System.out.printf("%s x%d -> %s%n", it.nome, qtd, nf.format(subtotal));
            }
        }
        System.out.println("-------------------------------");
        System.out.println("TOTAL GERAL: " + nf.format(total));
    }
}
