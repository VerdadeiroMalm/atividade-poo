package lista4;

import java.util.Scanner;

public class Ex03Calculadora {
    public static double somar(double a, double b) { return a + b; }
    public static double subtrair(double a, double b) { return a - b; }
    public static double multiplicar(double a, double b) { return a * b; }
    public static Double dividir(double a, double b) { return b == 0 ? null : a / b; }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite o primeiro número: ");
            double a = sc.nextDouble();
            System.out.print("Digite o segundo número: ");
            double b = sc.nextDouble();

            System.out.printf("Soma: %.4f%n", somar(a, b));
            System.out.printf("Subtração: %.4f%n", subtrair(a, b));
            System.out.printf("Multiplicação: %.4f%n", multiplicar(a, b));
            Double div = dividir(a, b);
            if (div == null) System.out.println("Divisão: impossível (divisão por zero).");
            else System.out.printf("Divisão: %.4f%n", div);
        }
    }
}
