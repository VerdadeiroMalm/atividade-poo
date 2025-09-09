package lista4;

import java.text.NumberFormat;
import java.util.Scanner;

class BombaCombustivel {
    private String tipoCombustivel;
    private double valorLitro;
    private double quantidadeCombustivel; // em litros

    public BombaCombustivel(String tipo, double valorLitro, double quantidade) {
        this.tipoCombustivel = tipo;
        this.valorLitro = Math.max(0, valorLitro);
        this.quantidadeCombustivel = Math.max(0, quantidade);
    }

    public void abastecerPorValor(double valor) {
        if (valor <= 0) { System.out.println("Valor inválido."); return; }
        double litros = valor / valorLitro;
        if (litros > quantidadeCombustivel) {
            System.out.println("Quantidade insuficiente na bomba.");
            return;
        }
        quantidadeCombustivel -= litros;
        System.out.printf("Abastecido: %.3f L%n", litros);
    }
    public void abastecerPorLitro(double litros) {
        if (litros <= 0) { System.out.println("Litros inválidos."); return; }
        if (litros > quantidadeCombustivel) {
            System.out.println("Quantidade insuficiente na bomba.");
            return;
        }
        double valor = litros * valorLitro;
        quantidadeCombustivel -= litros;
        System.out.printf("Valor a pagar: R$ %.2f%n", valor);
    }
    public void alterarValor(double novoValor) {
        if (novoValor > 0) this.valorLitro = novoValor;
    }
    public void alterarCombustivel(String novoTipo) {
        if (novoTipo != null && !novoTipo.isBlank()) this.tipoCombustivel = novoTipo;
    }
    public void alterarQuantidadeCombustivel(double novaQtd) {
        if (novaQtd >= 0) this.quantidadeCombustivel = novaQtd;
    }
    public String getTipoCombustivel() { return tipoCombustivel; }
    public double getValorLitro() { return valorLitro; }
    public double getQuantidadeCombustivel() { return quantidadeCombustivel; }
}

public class Ex11BombaCombustivel {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getCurrencyInstance;
        try (Scanner sc = new Scanner(System.in)) {
            BombaCombustivel bomba = new BombaCombustivel("Gasolina", 5.99, 1000.0);
            boolean loop = true;
            while (loop) {
                System.out.printf("\n[%s | %s/L | %.2f L na bomba]%n", 
                    bomba.getTipoCombustivel(), nf.format(bomba.getValorLitro()), bomba.getQuantidadeCombustivel());
                System.out.println("1-Abastecer por valor  2-Abastecer por litro  3-Alterar valor  4-Alterar combustível  5-Alterar quantidade  0-Sair");
                System.out.print("Opção: ");
                int op = sc.nextInt();
                switch (op) {
                    case 1 -> { System.out.print("Valor (R$): "); bomba.abastecerPorValor(sc.nextDouble()); }
                    case 2 -> { System.out.print("Litros: "); bomba.abastecerPorLitro(sc.nextDouble()); }
                    case 3 -> { System.out.print("Novo valor do litro (R$): "); bomba.alterarValor(sc.nextDouble()); }
                    case 4 -> { sc.nextLine(); System.out.print("Novo tipo de combustível: "); bomba.alterarCombustivel(sc.nextLine()); }
                    case 5 -> { System.out.print("Nova quantidade na bomba (L): "); bomba.alterarQuantidadeCombustivel(sc.nextDouble()); }
                    case 0 -> loop = false;
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }
}
