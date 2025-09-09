// Faça um Programa que peça a temperatura em graus Farenheit, transforme e mostre a
// temperatura em graus Celsius.
// C = (5 * (F-32) / 9) / C = (F – 32) / 1,8
import java.util.Scanner;


public class ex9 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Temperatura Farenheit: ");
        int Farenheit = scanner.nextInt();
        System.out.println("Celsius: " + (Farenheit - 32) / 9 );

    }

}
