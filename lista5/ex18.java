package lista4;

import java.util.*;
import java.io.*;

public class ex18 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        String[] nomes;
        double[][] notas;
        System.out.print("Deseja ler de arquivo? (s/n): ");
        String op = scanner.nextLine().trim().toLowerCase();
        if (op.equals("s")){
            System.out.print("Arquivo para ler: ");
            String arq = scanner.nextLine().trim();
            try {
                Scanner fs = new Scanner(new File(arq));
                n = fs.nextInt();
                nomes = new String[n];
                notas = new double[n][2];
                for (int i = 0; i < n; i++) nomes[i] = fs.next();
                for (int i = 0; i < n; i++){
                    notas[i][0] = fs.nextDouble();
                    notas[i][1] = fs.nextDouble();
                }
                fs.close();
            } catch(Exception e){
                System.out.println("Falha ao ler arquivo");
                return;
            }
        } else {
            System.out.print("Quantidade de alunos: ");
            n = Integer.parseInt(scanner.nextLine().trim());
            nomes = new String[n];
            notas = new double[n][2];
            for (int i = 0; i < n; i++){
                System.out.print("Nome do aluno " + (i+1) + ": ");
                nomes[i] = scanner.nextLine().trim();
                System.out.print("Nota 1: ");
                notas[i][0] = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Nota 2: ");
                notas[i][1] = Double.parseDouble(scanner.nextLine().trim());
            }
        }
        System.out.println("Notas e médias:");
        double somaMedias = 0;
        double maiorNota = -1;
        double menorNota = 101;
        String alunoMaiorNota = "";
        String alunoMenorNota = "";
        double maiorMedia = -1;
        double menorMedia = 101;
        String alunoMaiorMedia = "";
        String alunoMenorMedia = "";
        int nAlunos;
        if (op.equals("s")){
            nAlunos = Integer.parseInt("0");
        }
        double[] medias;
        if (op.equals("s")){
            Scanner tmp = new Scanner("");
            medias = new double[0];
        } else {
            medias = new double[nomes.length];
        }
        if (op.equals("s")){
            nAlunos = 0;
        }
        for (int i = 0; i < notas.length; i++){
            double media = (notas[i][0] + notas[i][1]) / 2.0;
            if (medias.length == 0){
                medias = new double[notas.length];
            }
            medias[i] = media;
            somaMedias += media;
            System.out.println(nomes[i] + " " + notas[i][0] + " " + notas[i][1] + " Média " + media);
            if (notas[i][0] > maiorNota){ maiorNota = notas[i][0]; alunoMaiorNota = nomes[i]; }
            if (notas[i][1] > maiorNota){ maiorNota = notas[i][1]; alunoMaiorNota = nomes[i]; }
            if (notas[i][0] < menorNota){ menorNota = notas[i][0]; alunoMenorNota = nomes[i]; }
            if (notas[i][1] < menorNota){ menorNota = notas[i][1]; alunoMenorNota = nomes[i]; }
            if (media > maiorMedia){ maiorMedia = media; alunoMaiorMedia = nomes[i]; }
            if (media < menorMedia){ menorMedia = media; alunoMenorMedia = nomes[i]; }
        }
        double mediaGeral = somaMedias / notas.length;
        System.out.println("Maior nota: " + maiorNota + " " + alunoMaiorNota);
        System.out.println("Menor nota: " + menorNota + " " + alunoMenorNota);
        System.out.println("Maior média: " + maiorMedia + " " + alunoMaiorMedia);
        System.out.println("Menor média: " + menorMedia + " " + alunoMenorMedia);
        System.out.printf("Média geral da turma: %.2f%n", mediaGeral);
        System.out.println("Acima da média geral:");
        for (int i = 0; i < notas.length; i++) if (medias[i] >= mediaGeral) System.out.println(nomes[i]);
        System.out.println("Abaixo da média geral:");
        for (int i = 0; i < notas.length; i++) if (medias[i] < mediaGeral) System.out.println(nomes[i]);
        System.out.print("Deseja salvar em arquivo? (s/n): ");
        String op2 = scanner.nextLine().trim().toLowerCase();
        if (op2.equals("s")){
            System.out.print("Arquivo para salvar: ");
            String arq = scanner.nextLine().trim();
            try {
                PrintWriter pw = new PrintWriter(new File(arq));
                pw.println(notas.length);
                for (int i = 0; i < notas.length; i++) pw.print((i==0?"":" ") + nomes[i]);
                pw.println();
                for (int i = 0; i < notas.length; i++){
                    pw.println(notas[i][0] + " " + notas[i][1]);
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