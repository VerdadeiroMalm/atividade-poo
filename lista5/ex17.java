package lista4;

import java.util.*;
import java.io.*;

public class ex17 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double[][] precos;
        String[] supermercados = new String[5];
        String[] produtos = new String[5];
        for (int i = 0; i < 5; i++) produtos[i] = "Produto " + (i+1);
        for (int i = 0; i < 5; i++) supermercados[i] = "Supermercado " + (i+1);
        System.out.print("Deseja ler de arquivo? (s/n): ");
        String op = scanner.nextLine().trim().toLowerCase();
        if (op.equals("s")){
            System.out.print("Arquivo para ler: ");
            String arq = scanner.nextLine().trim();
            try {
                Scanner fs = new Scanner(new File(arq));
                precos = new double[5][5];
                for (int i = 0; i < 5; i++){
                    supermercados[i] = fs.next();
                }
                for (int j = 0; j < 5; j++){
                    produtos[j] = fs.next();
                }
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5; j++){
                        precos[i][j] = fs.nextDouble();
                    }
                }
                fs.close();
            } catch(Exception e){
                System.out.println("Falha ao ler arquivo");
                return;
            }
        } else {
            precos = new double[5][5];
            for (int i = 0; i < 5; i++){
                System.out.print("Nome do supermercado " + (i+1) + ": ");
                String nome = scanner.nextLine().trim();
                if (!nome.isEmpty()) supermercados[i] = nome;
            }
            for (int j = 0; j < 5; j++){
                System.out.print("Nome do produto " + (j+1) + ": ");
                String nome = scanner.nextLine().trim();
                if (!nome.isEmpty()) produtos[j] = nome;
            }
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    System.out.print(supermercados[i] + " - " + produtos[j] + ": ");
                    precos[i][j] = scanner.nextDouble();
                }
            }
            scanner.nextLine();
        }
        System.out.println("Preços por supermercado:");
        for (int i = 0; i < 5; i++){
            System.out.println(supermercados[i] + ":");
            for (int j = 0; j < 5; j++){
                System.out.println(produtos[j] + ": " + precos[i][j]);
            }
        }
        System.out.println("Média por produto:");
        for (int j = 0; j < 5; j++){
            double soma = 0;
            for (int i = 0; i < 5; i++) soma += precos[i][j];
            System.out.printf("%s: %.2f%n", produtos[j], soma/5.0);
        }
        System.out.println("Soma por supermercado:");
        double menor = Double.MAX_VALUE;
        double maior = -1;
        String nomeMenor = "";
        String nomeMaior = "";
        for (int i = 0; i < 5; i++){
            double soma = 0;
            for (int j = 0; j < 5; j++) soma += precos[i][j];
            System.out.println(supermercados[i] + ": " + soma);
            if (soma < menor){
                menor = soma;
                nomeMenor = supermercados[i];
            }
            if (soma > maior){
                maior = soma;
                nomeMaior = supermercados[i];
            }
        }
        System.out.println("Total no mais barato: " + nomeMenor + " = " + menor);
        System.out.println("Total no mais caro: " + nomeMaior + " = " + maior);
        System.out.print("Deseja salvar em arquivo? (s/n): ");
        String op2 = scanner.nextLine().trim().toLowerCase();
        if (op2.equals("s")){
            System.out.print("Arquivo para salvar: ");
            String arq = scanner.nextLine().trim();
            try {
                PrintWriter pw = new PrintWriter(new File(arq));
                for (int i = 0; i < 5; i++){
                    pw.print(supermercados[i]);
                    pw.print(i==4?"\n":" ");
                }
                for (int j = 0; j < 5; j++){
                    pw.print(produtos[j]);
                    pw.print(j==4?"\n":" ");
                }
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5; j++){
                        pw.print(precos[i][j]);
                        pw.print(j==4?"\n":" ");
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