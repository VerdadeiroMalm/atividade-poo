package lista4;

import java.util.Scanner;

public class ExPinturaPiramide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ab (aresta da base): ");
        double ab = scanner.nextDouble();

        System.out.print("h (altura da pirâmide): ");
        double h = scanner.nextDouble();

        System.out.print("Tipo de tinta (1, 2 ou 3): ");
        int tipo = scanner.nextInt();

        final double LITROS_POR_M2 = 1.0 / 4.76; 
        final double LATA_LITROS = 18.0;
        final double PRECO_TIPO_1 = 127.90;
        final double PRECO_TIPO_2 = 258.98;
        final double PRECO_TIPO_3 = 344.34;

        double a1 = Math.sqrt((ab / 2) * (ab / 2) + h * h); 
        double areaTriangulo = (ab * a1) / 2;
        double areaBase = ab * ab;
        double areaTotal = areaBase + 4 * areaTriangulo;

        double litros = areaTotal * LITROS_POR_M2;

        double latas = Math.ceil(litros / LATA_LITROS);

        double precoTipo;
        if (tipo == 1) precoTipo = PRECO_TIPO_1;
        else if (tipo == 2) precoTipo = PRECO_TIPO_2;
        else precoTipo = PRECO_TIPO_3;

        double precoTotal = latas * precoTipo;

        double volume = (areaBase * h) / 3.0;


        System.out.println("ab: " + ab);
        System.out.println("h: " + h);
        System.out.println("a1: " + a1);
        System.out.println("Área Triângulo: " + areaTriangulo);
        System.out.println("Área Base: " + areaBase);
        System.out.println("Área Total: " + areaTotal);
        System.out.println("Tipo de Tinta: " + tipo);
        System.out.println("Litros: " + litros);
        System.out.println("Latas: " + latas);
        System.out.println("Preço: " + precoTotal);
        System.out.println("Volume: " + volume);

        scanner.close();
    }
}
