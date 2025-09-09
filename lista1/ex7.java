// Faça um Programa que calcule e mostre a área de um quadrado.
import java.util.Scanner;

public class ex7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lado x: ");
        int x = scanner.nextInt();
        System.out.print("Lado y: ");
        int y = scanner.nextInt();
        System.out.println("A área é: " + x * y);

    }
}
