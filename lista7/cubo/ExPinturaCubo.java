package lista4;

import java.util.Scanner;

public class ExPinturaCubo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a (lado do cubo): ");
        double a = scanner.nextDouble();

        System.out.print("Rendimento (m^2 por litro): ");
        double rendimento = scanner.nextDouble();

        System.out.print("Tipo de Tinta (1, 2 ou 3): ");
        int tipo = scanner.nextInt();

        final double LATA_LITROS = 18.0;
        final double PRECO_TIPO_1 = 101.90;
        final double PRECO_TIPO_2 = 212.45;
        final double PRECO_TIPO_3 = 345.56;

        double areaBase = a * a;          
        double areaTotal = 6 * areaBase;  
        double volume = a * a * a;         
        double diagonal = a * Math.sqrt(3);

        double litros = areaTotal / rendimento;

        double latas = Math.ceil(litros / LATA_LITROS);
        double precoTipo;
        if (tipo == 1) precoTipo = PRECO_TIPO_1;
        else if (tipo == 2) precoTipo = PRECO_TIPO_2;
        else precoTipo = PRECO_TIPO_3;

        double valorTotal = latas * precoTipo;

        System.out.println("a : " + a);
        System.out.println("Redimento : " + rendimento);
        System.out.println("Tipo de Tinta : " + tipo);
        System.out.println("————————–");
        System.out.println("Área da Base : " + areaBase);
        System.out.println("Área Total : " + areaTotal);
        System.out.println("Volume : " + volume);
        System.out.println("Diagonal do Cubo : " + diagonal);
        System.out.println("Litros de Tinta: " + litros);
        System.out.println("Latas de Tinta: " + latas);
        System.out.println("Valor Total: " + valorTotal);

        scanner.close();
    }
}
