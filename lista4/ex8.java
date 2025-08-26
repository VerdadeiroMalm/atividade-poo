package lista4;

import java.util.Random;
import java.util.Scanner;

public class ex8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho da senha: ");
        int n = scanner.nextInt();
        scanner.close();
        if (n <= 0 || n >= 26){
            System.out.println("Tamanho inválido");
            return;
        }
        char[] letras = new char[26];
        for (int i = 0; i < 26; i++) letras[i] = (char)('a' + i);
        boolean[] isVogal = new boolean[26];
        String vs = "aeiou";
        for (int i = 0; i < vs.length(); i++) isVogal[vs.charAt(i) - 'a'] = true;
        Random r = new Random();
        StringBuilder senha = new StringBuilder();
        int alvo = n;
        for (int i = 0; i < n; i++){
            boolean precisaVogal = (i % 2 == 1);
            if (n % 2 == 1 && i == n - 1) precisaVogal = false;
            char c;
            while (true){
                c = letras[r.nextInt(26)];
                boolean ehVogal = isVogal[c - 'a'];
                if (precisaVogal && ehVogal) break;
                if (!precisaVogal && !ehVogal) break;
            }
            senha.append(c);
        }
        System.out.println(senha.toString());
    }
}