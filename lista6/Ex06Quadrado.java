package lista4;

import java.util.Scanner;

class Quadrado {
    private double lado;
    Quadrado(double lado) { setLado(lado); }
    public void setLado(double lado) {
        if (lado <= 0) throw new IllegalArgumentException("Lado deve ser positivo.");
        this.lado = lado;
    }
    public double getLado() { return lado; }
    public double calcularArea() { return lado * lado; }
}

public class Ex06Quadrado {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Informe o tamanho do lado (m): ");
            double lado = sc.nextDouble();
            Quadrado q = new Quadrado(lado);
            System.out.printf("Lado: %.2f m | Área: %.4f m²%n", q.getLado(), q.calcularArea());

            System.out.print("Deseja alterar o lado? (s/n): ");
            String resp = sc.next();
            if (resp.equalsIgnoreCase("s")) {
                System.out.print("Novo valor do lado: ");
                q.setLado(sc.nextDouble());
                System.out.printf("Atualizado -> Lado: %.2f m | Área: %.4f m²%n", q.getLado(), q.calcularArea());
            }
        }
    }
}
