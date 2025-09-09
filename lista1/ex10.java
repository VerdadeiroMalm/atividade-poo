// 10.Faça um Programa que peça 2 números inteiros e um número real. Calcule e mostre:
// a. o produto do dobro do primeiro com metade do segundo .
// b. a soma do triplo do primeiro com o terceiro.
// c. o terceiro elevado ao cubo.
import java.util.Scanner;


public class ex10 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numero 1: ");
        int Int1 = scanner.nextInt();
        System.out.println("Numero 2: ");
        int Int2 = scanner.nextInt();
        System.out.println("Numero 3 (Real): ");
        float Real = scanner.nextFloat();
        double num = 3;
        double expo = Math.pow(Real, num);
        System.out.println("Produto/Metade segundo: " + (Int1 * 2 - Int2 / 2));
        System.out.println("Soma triplo...: " + (Int1 * 3 + Real));
        System.out.println("Cubo do terceiro: " + expo);

    }    
}