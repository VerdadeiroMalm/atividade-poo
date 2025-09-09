

//public class Hello {
//    public static void main (String[] args){
//        System.out.println("Hello World!");
//    }
//}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine(); // lê uma linha digitada

        System.out.println("Olá, " + nome + "! Seja bem-vindo.");
    }
}
