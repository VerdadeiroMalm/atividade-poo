package lista4;

import java.util.*;
import java.io.*;

public class ex16 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        int[][] m;
        System.out.print("Deseja ler de arquivo? (s/n): ");
        String op = scanner.nextLine().trim().toLowerCase();
        if (op.equals("s")){
            System.out.print("Arquivo para ler: ");
            String arq = scanner.nextLine().trim();
            try {
                Scanner fs = new Scanner(new File(arq));
                n = fs.nextInt();
                m = new int[n][n];
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){
                        m[i][j] = fs.nextInt();
                    }
                }
                fs.close();
            } catch(Exception e){
                System.out.println("Falha ao ler arquivo");
                return;
            }
        } else {
            while (true){
                System.out.print("Informe um inteiro ímpar entre 3 e 11: ");
                n = scanner.nextInt();
                if (n>=3 && n<=11 && n%2==1) break;
                System.out.println("Valor inválido");
            }
            m = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print("Valor para [" + i + "][" + j + "]: ");
                    m[i][j] = scanner.nextInt();
                }
            }
            scanner.nextLine();
        }
        long soma = 0;
        int maior = m[0][0];
        int menor = m[0][0];
        int pares = 0;
        int impares = 0;
        int diag1 = 0;
        int diag2 = 0;
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[i].length; j++){
                int v = m[i][j];
                soma += v;
                if (v > maior) maior = v;
                if (v < menor) menor = v;
                if (v % 2 == 0) pares++; else impares++;
                if (i == j) diag1 += v;
                if (i + j == m.length - 1) diag2 += v;
            }
        }
        double media = soma / (double)(m.length * m.length);
        System.out.println("Soma dos elementos: " + soma);
        System.out.printf("Média dos elementos: %.2f%n", media);
        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
        System.out.println("Contador de pares: " + pares);
        System.out.println("Contador de ímpares: " + impares);
        System.out.println("Soma da diagonal principal: " + diag1);
        System.out.println("Soma da diagonal secundária: " + diag2);
        System.out.println("Matriz:");
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[i].length; j++){
                System.out.printf("%5d", m[i][j]);
            }
            System.out.println();
        }
        System.out.print("Deseja salvar em arquivo? (s/n): ");
        String op2 = scanner.nextLine().trim().toLowerCase();
        if (op2.equals("s")){
            System.out.print("Arquivo para salvar: ");
            String arq = scanner.nextLine().trim();
            try {
                PrintWriter pw = new PrintWriter(new File(arq));
                pw.println(m.length);
                for (int i = 0; i < m.length; i++){
                    for (int j = 0; j < m[i].length; j++){
                        pw.print(m[i][j]);
                        pw.print(j==m[i].length-1 ? "\n" : " ");
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