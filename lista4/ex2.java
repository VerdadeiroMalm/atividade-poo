package lista4;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double vetor[] = new double[10];
        for (int i = 0; i < vetor.length; i++){
            System.out.print("Digite o número " + (i+1) + ": ");
            vetor[i] = scanner.nextDouble();
        }
        scanner.close();
        for (int i = vetor.length - 1; i >= 0; i--){
            System.out.println(vetor[i]);
        }
    }
}