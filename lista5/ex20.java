package lista4;

import java.util.*;
import java.io.*;

public class ex20 {
    static int[] geraCartela(Random r){
        boolean[] usado = new boolean[61];
        int[] c = new int[6];
        int k = 0;
        while (k < 6){
            int v = 1 + r.nextInt(60);
            if (!usado[v]){
                usado[v] = true;
                c[k++] = v;
            }
        }
        Arrays.sort(c);
        return c;
    }
    static int[] lerNumerosValidos(Scanner scanner){
        boolean[] usado = new boolean[61];
        int[] v = new int[6];
        int k = 0;
        while (k < 6){
            System.out.print("Número " + (k+1) + " entre 1 e 60: ");
            int x = Integer.parseInt(scanner.nextLine().trim());
            if (x < 1 || x > 60){
                System.out.println("Inválido");
                continue;
            }
            if (usado[x]){
                System.out.println("Repetido");
                continue;
            }
            usado[x] = true;
            v[k++] = x;
        }
        Arrays.sort(v);
        return v;
    }
    static int acertos(int[] a, int[] b){
        int i = 0, j = 0, cont = 0;
        while (i < 6 && j < 6){
            if (a[i] == b[j]){ cont++; i++; j++; }
            else if (a[i] < b[j]) i++;
            else j++;
        }
        return cont;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        int n;
        int[][] cartelas;
        int[] sorteio;
        System.out.print("Deseja ler de arquivo? (s/n): ");
        String op = scanner.nextLine().trim().toLowerCase();
        if (op.equals("s")){
            System.out.print("Arquivo para ler: ");
            String arq = scanner.nextLine().trim();
            try {
                Scanner fs = new Scanner(new File(arq));
                n = fs.nextInt();
                cartelas = new int[n][6];
                sorteio = new int[6];
                for (int i = 0; i < 6; i++) sorteio[i] = fs.nextInt();
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < 6; j++) cartelas[i][j] = fs.nextInt();
                    Arrays.sort(cartelas[i]);
                }
                Arrays.sort(sorteio);
                fs.close();
            } catch(Exception e){
                System.out.println("Falha ao ler arquivo");
                return;
            }
        } else {
            System.out.print("Quantidade de cartelas: ");
            n = Integer.parseInt(scanner.nextLine().trim());
            cartelas = new int[n][6];
            for (int i = 0; i < n; i++){
                cartelas[i] = geraCartela(r);
            }
            System.out.println("Informe os números sorteados:");
            sorteio = lerNumerosValidos(scanner);
        }
        System.out.println("Sorteio:");
        for (int i = 0; i < 6; i++) System.out.print(sorteio[i] + (i==5?"\n":" "));
        for (int i = 0; i < cartelas.length; i++){
            int a = acertos(cartelas[i], sorteio);
            System.out.print("Cartela " + (i+1) + ": ");
            for (int j = 0; j < 6; j++) System.out.print(cartelas[i][j] + (j==5?" ":" "));
            System.out.println("Acertos " + a);
        }
        System.out.print("Deseja salvar em arquivo? (s/n): ");
        String op2 = scanner.nextLine().trim().toLowerCase();
        if (op2.equals("s")){
            System.out.print("Arquivo para salvar: ");
            String arq = scanner.nextLine().trim();
            try {
                PrintWriter pw = new PrintWriter(new File(arq));
                pw.println(cartelas.length);
                for (int i = 0; i < 6; i++){
                    pw.print(sorteio[i]);
                    pw.print(i==5?"\n":" ");
                }
                for (int i = 0; i < cartelas.length; i++){
                    for (int j = 0; j < 6; j++){
                        pw.print(cartelas[i][j]);
                        pw.print(j==5?"\n":" ");
                    }
                }
                pw.flush();
                pw.close();
                System.out.println("Salvo");
            } catch(Exception e){
                System.out.println("Falha ao salvar");
            }
        }
    }
}