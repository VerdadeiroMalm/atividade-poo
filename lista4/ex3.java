package lista4;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double notas[] = new double[4];
        for (int i = 0; i < notas.length; i++){
            System.out.print("Digite a nota " + (i+1) + ": ");
            notas[i] = scanner.nextDouble();
        }
        scanner.close();
        double soma = 0;
        for (int i = 0; i < notas.length; i++){
            System.out.println(notas[i]);
            soma += notas[i];
        }
        double media = soma / notas.length;
        System.out.println("Média: " + media);
    }
}