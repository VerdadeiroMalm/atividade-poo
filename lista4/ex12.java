package lista4;

import java.util.Scanner;

public class ex12 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] idades = new int[5];
        double[] alturas = new double[5];
        for (int i = 0; i < 5; i++){
            System.out.print("Idade da pessoa " + (i+1) + ": ");
            idades[i] = scanner.nextInt();
            System.out.print("Altura da pessoa " + (i+1) + ": ");
            alturas[i] = scanner.nextDouble();
        }
        scanner.close();
        System.out.println("Ordem inversa:");
        for (int i = 4; i >= 0; i--){
            System.out.println("Idade: " + idades[i] + " Altura: " + alturas[i]);
        }
        int idxMaiorIdade = 0, idxMenorIdade = 0;
        int idxMaiorAltura = 0, idxMenorAltura = 0;
        for (int i = 1; i < 5; i++){
            if (idades[i] > idades[idxMaiorIdade]) idxMaiorIdade = i;
            if (idades[i] < idades[idxMenorIdade]) idxMenorIdade = i;
            if (alturas[i] > alturas[idxMaiorAltura]) idxMaiorAltura = i;
            if (alturas[i] < alturas[idxMenorAltura]) idxMenorAltura = i;
        }
        System.out.println("Mais velho: Idade " + idades[idxMaiorIdade] + " Altura " + alturas[idxMaiorIdade]);
        System.out.println("Mais novo: Idade " + idades[idxMenorIdade] + " Altura " + alturas[idxMenorIdade]);
        System.out.println("Mais alto: Idade " + idades[idxMaiorAltura] + " Altura " + alturas[idxMaiorAltura]);
        System.out.println("Mais baixo: Idade " + idades[idxMenorAltura] + " Altura " + alturas[idxMenorAltura]);
        double somaId = 0, somaAlt = 0;
        for (int i = 0; i < 5; i++){
            somaId += idades[i];
            somaAlt += alturas[i];
        }
        double mediaId = somaId / 5.0;
        double mediaAlt = somaAlt / 5.0;
        System.out.println("Abaixo da média de idade:");
        for (int i = 0; i < 5; i++){
            if (idades[i] < mediaId) System.out.println("Idade " + idades[i] + " Altura " + alturas[i]);
        }
        System.out.println("Acima da média de idade:");
        for (int i = 0; i < 5; i++){
            if (idades[i] >= mediaId) System.out.println("Idade " + idades[i] + " Altura " + alturas[i]);
        }
        System.out.println("Abaixo da média de altura:");
        for (int i = 0; i < 5; i++){
            if (alturas[i] < mediaAlt) System.out.println("Idade " + idades[i] + " Altura " + alturas[i]);
        }
        System.out.println("Acima da média de altura:");
        for (int i = 0; i < 5; i++){
            if (alturas[i] >= mediaAlt) System.out.println("Idade " + idades[i] + " Altura " + alturas[i]);
        }
    }
}