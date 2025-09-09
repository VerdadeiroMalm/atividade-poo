import java.io.*;
import java.util.*;

public class desafio {
    public static void main(String[] args) {
        System.out.println("--- Iniciando o programa de DNA ---");

        String[] listaDeArquivos = {
                "dna-0.txt", "dna-1.txt", "dna-2.txt", "dna-3.txt",
                "dna-4.txt", "dna-5.txt", "dna-6.txt", "dna-7.txt", "dna-8.txt"
        };

        for (String nomeDoArquivo : listaDeArquivos) {

            String nomeDoArquivoDeSaida = nomeDoArquivo.replace(".txt", "-out.txt");

            processarUmArquivo(nomeDoArquivo, nomeDoArquivoDeSaida);
        }

        System.out.println("--- Fim do programa! Todos os arquivos foram processados. ---");
    }

    public static void processarUmArquivo(String nomeArquivoEntrada, String nomeArquivoSaida) {
        int totalDeFitas = 0;
        int fitasValidas = 0;
        int fitasInvalidas = 0;
        List<String> listaDasInvalidas = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivoEntrada));
             PrintWriter escritor = new PrintWriter(new FileWriter(nomeArquivoSaida))) {

            String linha;
            int numeroDaLinha = 0;

            while ((linha = leitor.readLine()) != null) {
                numeroDaLinha++;

                String fitaOriginal = linha.trim().toUpperCase();

                if (fitaOriginal.isEmpty()) {
                    continue;
                }

                totalDeFitas++;

                String fitaComplementar = criarFitaComplementar(fitaOriginal);

                if (fitaComplementar == null) {
                    escritor.println("**FITA INVALIDA - " + fitaOriginal);
                    fitasInvalidas++;
                    listaDasInvalidas.add("Linha " + numeroDaLinha + ": " + fitaOriginal);
                } else {
                    escritor.println(fitaComplementar);
                    fitasValidas++;
                }
            }
            System.out.println("Arquivo lido: " + nomeArquivoEntrada);
            System.out.println("Total de fitas encontradas: " + totalDeFitas);
            System.out.println("Fitas válidas (com A, T, C, G): " + fitasValidas);
            System.out.println("Fitas inválidas (com letras estranhas): " + fitasInvalidas);

            if (!listaDasInvalidas.isEmpty()) {
                System.out.println("Lista das fitas que deram erro:");
                for (String fitaErrada : listaDasInvalidas) {
                    System.out.println("  -> " + fitaErrada);
                }
            }
            System.out.println("-----------------------------------");

        } catch (IOException e) {
            System.out.println("Eita! Deu um erro com o arquivo: " + e.getMessage());
        }
    }

    public static String criarFitaComplementar(String fita) {
        String fitaNova = "";

        for (char letra : fita.toCharArray()) {
            if (letra == 'A') {
                fitaNova += 'T';
            } else if (letra == 'T') {
                fitaNova += 'A';
            } else if (letra == 'C') {
                fitaNova += 'G';
            } else if (letra == 'G') {
                fitaNova += 'C';
            } else {
                return null;
            }
        }
    }
}