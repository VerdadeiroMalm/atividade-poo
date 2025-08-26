package lista4;

import java.util.Scanner;

public class ex11 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite as palavras separadas por ; : ");
        String s = scanner.nextLine();
        scanner.close();
        String[] partes = s.split(";");
        for (int i = 0; i < partes.length; i++){
            System.out.println(partes[i]);
        }
    }
}