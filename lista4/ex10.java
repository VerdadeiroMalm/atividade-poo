package lista4;

import java.util.Scanner;

public class ex10 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma data dd/mm/aaaa: ");
        String s = scanner.nextLine();
        scanner.close();
        String[] p = s.split("/");
        if (p.length != 3){
            System.out.println("Data inválida");
            return;
        }
        int[] data = new int[3];
        try {
            data[0] = Integer.parseInt(p[0]);
            data[1] = Integer.parseInt(p[1]);
            data[2] = Integer.parseInt(p[2]);
        } catch (Exception e){
            System.out.println("Data inválida");
            return;
        }
        if (!valida(data[0], data[1], data[2])){
            System.out.println("Data inválida");
            return;
        }
        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);
    }
    static boolean valida(int d, int m, int a){
        if (a < 1 || m < 1 || m > 12 || d < 1) return false;
        int[] dias = {31,28,31,30,31,30,31,31,30,31,30,31};
        boolean bissexto = (a % 400 == 0) || (a % 4 == 0 && a % 100 != 0);
        if (bissexto) dias[1] = 29;
        if (d > dias[m-1]) return false;
        return true;
    }
}