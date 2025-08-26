package lista4;

import java.util.Scanner;

public class ex14 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] idades = new int[30];
        double[] alturas = new double[30];
        for (int i = 0; i < 30; i++){
            System.out.print("Idade do aluno " + (i+1) + ": ");
            idades[i] = scanner.nextInt();
            System.out.print("Altura do aluno " + (i+1) + ": ");
            alturas[i] = scanner.nextDouble();
        }
        scanner.close();
        double somaAlt = 0;
        for (int i = 0; i < 30; i++){
            somaAlt += alturas[i];
        }
        double mediaAlt = somaAlt / 30.0;
        int cont = 0;
        for (int i = 0; i < 30; i++){
            if (idades[i] > 13 && alturas[i] < mediaAlt) cont++;
        }
        System.out.println(cont);
    }
}