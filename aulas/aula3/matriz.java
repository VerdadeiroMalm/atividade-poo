import java.util.Scanner;

public class matriz {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int [][] matriz = new int[2][2];
        int soma = 2;
        int maior = 0;
        int menor = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++){
                System.out.println("Numero: ");
                soma += matriz[i][j];

                if (i == 0 && j == 0){
                    maior = matriz[i][j];
                    menor = matriz[i][j];
                }
            }

        }
    }
}
