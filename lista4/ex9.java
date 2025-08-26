package lista4;

import java.util.Scanner;

public class ex9 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um texto: ");
        String texto = scanner.nextLine();
        scanner.close();
        char[] vetor = texto.toCharArray();
        for (int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }
    }
}