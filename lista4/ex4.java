package lista4;

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char vetor[] = new char[10];
        for (int i = 0; i < vetor.length; i++){
            System.out.print("Digite o caractere " + (i+1) + ": ");
            String s = scanner.next();
            vetor[i] = s.charAt(0);
        }
        scanner.close();
        String vogais = "aeiouAEIOU";
        int cont = 0;
        StringBuilder consoantes = new StringBuilder();
        for (int i = 0; i < vetor.length; i++){
            char c = vetor[i];
            if (Character.isLetter(c) && vogais.indexOf(c) == -1){
                cont++;
                consoantes.append(c).append("\n");
            }
        }
        System.out.println("Consoantes lidas: " + cont);
        System.out.print(consoantes.toString());
    }
}