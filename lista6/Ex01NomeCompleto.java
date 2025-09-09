package lista4;

import java.util.Locale;
import java.util.Scanner;

public class Ex01NomeCompleto {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite seu nome: ");
            String nome = sc.nextLine().trim();
            System.out.print("Digite seu sobrenome: ");
            String sobrenome = sc.nextLine().trim();
            System.out.println("Seu nome completo é: " + nome + " " + sobrenome);
        }
    }
}
