// 14.Faça um Programa que pergunte quanto você ganha por hora e o número de horas
// trabalhadas no mês. Calcule e mostre o total do seu salário no referido mês, sabendo-se
// que são descontados 11% para o Imposto de Renda, 8% para o INSS e 5% para o
// sindicato, faça um programa que nos dê:
// a. salário bruto.
// b. quanto pagou ao INSS.
// c. quanto pagou ao sindicato.
// d. o salário líquido.
// e. calcule os descontos e o salário líquido, conforme a tabela abaixo:
// f. + Salário Bruto : R$
// g. - IR (11%) : R$
// h. - INSS (8%) : R$
// i. - Sindicato ( 5%) : R$
// j. = Salário Liquido : R$
// Obs.: Salário Bruto - Descontos = Salário Líquido.

import java.util.Scanner;

public class ex14 {
    public static void main (String[] arg){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Salário: ");
        int Salario = scanner.nextInt();
        System.out.println("Horas/mês: ");
        int Horas = scanner.nextInt();
        System.out.println("Bruto: " + Salario);
        System.out.println("Inss: " + Salario * 8 /100);
        int Inss = scanner.nextInt();
        System.out.println("Líquido: " + (Salario - Inss - (Salario * 11/100 ) - (Salario * 5 / 100)));

    }

}
