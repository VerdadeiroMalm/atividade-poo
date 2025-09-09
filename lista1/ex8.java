// Faça um Programa que pergunte quanto você ganha por hora e o número de horas
// trabalhadas no mês. Calcule e mostre o total do seu salário no referido mês.
import java.util.Scanner;

public class ex8 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Salário por hora: ");
        int salario = scanner.nextInt();
        System.out.println("Horas trabalhadas por mês: ");
        int horas = scanner.nextInt();
        System.out.println("Total mês: " + salario * horas);
    }
}
