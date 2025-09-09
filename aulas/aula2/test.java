package aulas.aula2;

import java.util.Scanner;
/*public class aulas2 {
    public static void main(String[] args) {

        for (int x = 0; x < 10; x++)
        System.out.println(x);
 }
   int y = 10;
   while (y < 10){
       System.out.println(y);
       y++;
    }

   int z = 0;
   do {
    System.out.println(z);
    z++;
} while(z < 0);
 



}
   }
*/
  
/*public class Par {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int num;
        
        do {
            System.out.println("Número Par:");
            num = input.nextInt();
            if (num%2==0) {
                System.out.println("par é: "+num);
            } else {
                System.out.println("não é par: "+num);
            }
        } while (num%2!=0);
    
        input.close();
    }
}
*/
// O que é o system.out.println()?
// O que é o java.util.Scanner?


/*public class Par {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Número: ");
        int num = scanner.nextInt();

        if (num >= 0) {
            System.out.println("Número Positivo");
        } else {
            System.out.println("Número Negativo");
        }
        scanner.close();
}}*/

public class test {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Idade: ");
        int idade = scanner.nextInt();

        if (idade < 18){
            System.out.println("Menor de idade");
        } else if (idade >= 18 && idade <= 65){
            System.out.println("Adulto");
        } else if (idade > 65){
            System.out.println("Idoso");
        }else {
            System.out.println("Idade Inválida");
        }
        scanner.close();
    }

}
    

/*public class Par {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Número: ");
        int num = scanner.nextInt();

        switch (num){
            case 1:
            System.out.println("Num 1");
            break;
            case 2:
            System.out.println("Num 2");
            break;
            case 3:
            System.out.println("Num 3");
            break;
            default:
            System.out.println("Número Inválido");
            break;
        }
        scanner.close();

    }
}*/
