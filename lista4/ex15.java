package lista4;

import java.util.Scanner;

public class ex15 {
    public static void main(String[] args){
        final int N = 10;
        Scanner scanner = new Scanner(System.in);
        int[] v = new int[N];
        for (int i = 0; i < N; i++){
            int x;
            while (true){
                System.out.print("Valor " + (i+1) + " entre 0 e 20: ");
                x = scanner.nextInt();
                if (x >= 0 && x <= 20) break;
                System.out.println("Valor inválido");
            }
            v[i] = x;
        }
        scanner.close();
        for (int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < v[i]; j++) sb.append("*");
            System.out.println(v[i] + " " + sb.toString());
        }
    }
}