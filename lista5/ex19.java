package lista4;

import java.util.*;
import java.io.*;

public class ex19 {
    static double mediaDescartandoPior(double[] saltos){
        double soma = 0;
        double pior = saltos[0];
        for (int i = 0; i < saltos.length; i++){
            soma += saltos[i];
            if (saltos[i] < pior) pior = saltos[i];
        }
        return (soma - pior) / (saltos.length - 1);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        String[] nomes;
        double[][] saltos;
        System.out.print("Deseja ler de arquivo? (s/n): ");
        String op = scanner.nextLine().trim().toLowerCase();
        if (op.equals("s")){
            System.out.print("Arquivo para ler: ");
            String arq = scanner.nextLine().trim();
            try {
                Scanner fs = new Scanner(new File(arq));
                n = fs.nextInt();
                nomes = new String[n];
                saltos = new double[n][5];
                for (int i = 0; i < n; i++) nomes[i] = fs.next();
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < 5; j++) saltos[i][j] = fs.nextDouble();
                }
                fs.close();
                double[] medias = new double[n];
                for (int i = 0; i < n; i++) medias[i] = mediaDescartandoPior(saltos[i]);
                int idxMax = 0;
                int idxMin = 0;
                for (int i = 1; i < medias.length; i++){
                    if (medias[i] > medias[idxMax]) idxMax = i;
                    if (medias[i] < medias[idxMin]) idxMin = i;
                }
                System.out.println("Saltos e médias:");
                for (int i = 0; i < saltos.length; i++){
                    System.out.print(nomes[i] + ": ");
                    for (int j = 0; j < 5; j++){
                        System.out.print(saltos[i][j] + (j==4?"":" "));
                    }
                    System.out.printf(" Média %.2f%n", medias[i]);
                }
                System.out.printf("Média do campeão: %.2f%n", medias[idxMax]);
                System.out.printf("Média do último: %.2f%n", medias[idxMin]);
                System.out.print("Deseja salvar em arquivo? (s/n): ");
                String op2 = scanner.nextLine().trim().toLowerCase();
                if (op2.equals("s")){
                    System.out.print("Arquivo para salvar: ");
                    String arq2 = scanner.nextLine().trim();
                    PrintWriter pw = new PrintWriter(new File(arq2));
                    pw.println(saltos.length);
                    for (int i = 0; i < saltos.length; i++) pw.print((i==0?"":" ") + nomes[i]);
                    pw.println();
                    for (int i = 0; i < saltos.length; i++){
                        for (int j = 0; j < 5; j++){
                            pw.print(saltos[i][j]);
                            pw.print(j==4?"\n":" ");
                        }
                    }
                    pw.flush();
                    pw.close();
                    System.out.println("Salvo");
                }
                return;
            } catch(Exception e){
                System.out.println("Falha ao ler arquivo");
                return;
            }
        } else {
            System.out.print("Quantidade de atletas: ");
            n = Integer.parseInt(scanner.nextLine().trim());
            nomes = new String[n];
            saltos = new double[n][5];
            for (int i = 0; i < n; i++){
                System.out.print("Nome do atleta " + (i+1) + ": ");
                nomes[i] = scanner.nextLine().trim();
                for (int j = 0; j < 5; j++){
                    System.out.print("Salto " + (j+1) + ": ");
                    saltos[i][j] = Double.parseDouble(scanner.nextLine().trim());
                }
                double med = mediaDescartandoPior(saltos[i]);
                System.out.printf("Média do atleta: %.2f%n", med);
            }
            double[] medias = new double[saltos.length];
            for (int i = 0; i < saltos.length; i++) medias[i] = mediaDescartandoPior(saltos[i]);
            int idxMax = 0;
            int idxMin = 0;
            for (int i = 1; i < medias.length; i++){
                if (medias[i] > medias[idxMax]) idxMax = i;
                if (medias[i] < medias[idxMin]) idxMin = i;
            }
            System.out.println("Saltos e médias:");
            for (int i = 0; i < saltos.length; i++){
                System.out.print(nomes[i] + ": ");
                for (int j = 0; j < 5; j++){
                    System.out.print(saltos[i][j] + (j==4?"":" "));
                }
                System.out.printf(" Média %.2f%n", medias[i]);
            }
            System.out.printf("Média do campeão: %.2f%n", medias[idxMax]);
            System.out.printf("Média do último: %.2f%n", medias[idxMin]);
            System.out.print("Deseja salvar em arquivo? (s/n): ");
            String op2 = scanner.nextLine().trim().toLowerCase();
            if (op2.equals("s")){
                System.out.print("Arquivo para salvar: ");
                String arq = scanner.nextLine().trim();
                try {
                    PrintWriter pw = new PrintWriter(new File(arq));
                    pw.println(saltos.length);
                    for (int i = 0; i < saltos.length; i++) pw.print((i==0?"":" ") + nomes[i]);
                    pw.println();
                    for (int i = 0; i < saltos.length; i++){
                        for (int j = 0; j < 5; j++){
                            pw.print(saltos[i][j]);
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
}