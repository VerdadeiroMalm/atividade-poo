package lista4;

import java.util.Scanner;

class Pessoa {
    private String nome;
    private int idade;        // anos
    private double peso;      // kg
    private double altura;    // metros

    public Pessoa(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = Math.max(0, idade);
        this.peso = Math.max(0, peso);
        this.altura = Math.max(0, altura);
    }

    public void envelhecer(int anos) {
        if (anos <= 0) return;
        for (int i = 0; i < anos; i++) {
            if (idade < 21) {
                crescer(0.005); // 0,5 cm = 0,005 m
            }
            idade++;
        }
    }
    public void engordar(double kg) { if (kg > 0) peso += kg; }
    public void emagrecer(double kg) { if (kg > 0) peso = Math.max(0, peso - kg); }
    public void crescer(double metros) { if (metros > 0) altura += metros; }

    @Override
    public String toString() {
        return String.format("%s | Idade: %d anos | Peso: %.2f kg | Altura: %.3f m", 
                              nome, idade, peso, altura);
    }
}

public class Ex07Pessoa {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Idade (anos): ");
            int idade = sc.nextInt();
            System.out.print("Peso (kg): ");
            double peso = sc.nextDouble();
            System.out.print("Altura (m): ");
            double altura = sc.nextDouble();

            Pessoa p = new Pessoa(nome, idade, peso, altura);
            System.out.println(p);

            boolean loop = true;
            while (loop) {
                System.out.println("\n1-Envelhecer  2-Engordar  3-Emagrecer  4-Crescer  0-Sair");
                System.out.print("Escolha: ");
                int op = sc.nextInt();
                switch (op) {
                    case 1 -> { System.out.print("Anos: "); p.envelhecer(sc.nextInt()); }
                    case 2 -> { System.out.print("Kg a ganhar: "); p.engordar(sc.nextDouble()); }
                    case 3 -> { System.out.print("Kg a perder: "); p.emagrecer(sc.nextDouble()); }
                    case 4 -> { System.out.print("Crescer (m): "); p.crescer(sc.nextDouble()); }
                    case 0 -> loop = false;
                    default -> System.out.println("Opção inválida.");
                }
                System.out.println(p);
            }
        }
    }
}
