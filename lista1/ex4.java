import java.util.Scanner;

public class ex4 {
    public static void main(String[] args){
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nota 1:");
        int nota1 = scanner1.nextInt();
        System.out.println("Nota 2: ");
        int nota2 = scanner2.nextInt();
        System.out.println("Nota 3: ");
        int nota3 = scanner3.nextInt();
        System.out.println("Nota 4:");
        int nota4 = scanner4.nextInt();
        System.out.println("Média: " + (nota1 + nota2 + nota3 + nota4) / 4);

        scanner1.close();
        scanner2.close();
        scanner3.close();
        scanner4.close();
    }
}
