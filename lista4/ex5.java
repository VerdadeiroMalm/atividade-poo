package lista4;

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int vetor[] = new int[20];
        for (int i = 0; i < vetor.length; i++){
            System.out.print("Digite o número " + (i+1) + ": ");
            vetor[i] = scanner.nextInt();
        }
        scanner.close();
        int par[] = new int[20];
        int impar[] = new int[20];
        int cp = 0, ci = 0;
        for (int i = 0; i < vetor.length; i++){
            if (vetor[i] % 2 == 0){
                par[cp++] = vetor[i];
            } else {
                impar[ci++] = vetor[i];
            }
        }
        System.out.println("Vetor:");
        for (int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }
        System.out.println("Pares:");
        for (int i = 0; i < cp; i++){
            System.out.println(par[i]);
        }
        System.out.println("Ímpares:");
        for (int i = 0; i < ci; i++){
            System.out.println(impar[i]);
        }
    }
}