package lista4;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int vetor[] = new int[5];
        for (int i = 0; i < vetor.length; i++){
            System.out.print("Digite o número " + (i+1) + ": ");
            vetor[i] = scanner.nextInt();
        }
        scanner.close();
        for (int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }
    }
}