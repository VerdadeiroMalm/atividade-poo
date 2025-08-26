package lista4;

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double medias[] = new double[10];
        for (int i = 0; i < 10; i++){
            double soma = 0;
            for (int j = 0; j < 4; j++){
                System.out.print("Aluno " + (i+1) + " - nota " + (j+1) + ": ");
                soma += scanner.nextDouble();
            }
            medias[i] = soma / 4.0;
        }
        scanner.close();
        int cont = 0;
        for (int i = 0; i < medias.length; i++){
            if (medias[i] >= 7.0) cont++;
        }
        System.out.println("Alunos com média >= 7.0: " + cont);
    }
}