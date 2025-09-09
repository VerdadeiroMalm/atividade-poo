package lista4;

import java.util.Scanner;

public class Ex02Intervalo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Informe o primeiro número: ");
            int a = sc.nextInt();
            System.out.print("Informe o segundo número: ");
            int b = sc.nextInt();

            if (a > b) {
                System.out.println("Aviso: valores em ordem inversa. Invertendo...");
                int tmp = a; a = b; b = tmp;
            }

            System.out.printf("Números no intervalo [%d, %d]:%n", a, b);
            for (int i = a; i <= b; i++) {
                System.out.println(i);
            }
        }
    }
}
