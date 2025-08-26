package lista4;

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int vetor[] = new int[5];
        for (int i = 0; i < vetor.length; i++){
            System.out.print("Digite o número " + (i+1) + ": ");
            vetor[i] = scanner.nextInt();
        }
        scanner.close();
        long soma = 0;
        long mult = 1;
        for (int i = 0; i < vetor.length; i++){
            soma += vetor[i];
            mult *= vetor[i];
        }
        System.out.println("Números:");
        for (int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }
        System.out.println("Soma: " + soma);
        System.out.println("Multiplicação: " + mult);
    }
}