package lista4;

import java.util.Scanner;

public class ex13 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a[] = new int[10];
        int b[] = new int[10];
        for (int i = 0; i < 10; i++){
            System.out.print("Digite A[" + (i+1) + "]: ");
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < 10; i++){
            System.out.print("Digite B[" + (i+1) + "]: ");
            b[i] = scanner.nextInt();
        }
        scanner.close();
        int c[] = new int[20];
        int k = 0;
        for (int i = 0; i < 10; i++){
            c[k++] = a[i];
            c[k++] = b[i];
        }
        for (int i = 0; i < c.length; i++){
            System.out.println(c[i]);
        }
    }
}