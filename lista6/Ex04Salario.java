package lista4;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex04Salario {
    static final double PERC_IR = 0.11;
    static final double PERC_INSS = 0.08;
    static final double PERC_SIND = 0.05;

    static double salarioBruto(double ganhoHora, double horasMes) {
        return ganhoHora * horasMes;
    }
    static double descontoIR(double bruto) { return bruto * PERC_IR; }
    static double descontoINSS(double bruto) { return bruto * PERC_INSS; }
    static double descontoSindicato(double bruto) { return bruto * PERC_SIND; }
    static double totalDescontos(double bruto) {
        return descontoIR(bruto) + descontoINSS(bruto) + descontoSindicato(bruto);
    }
    static double salarioLiquido(double bruto) {
        return bruto - totalDescontos(bruto);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Quanto você ganha por hora (R$): ");
            double ganhoHora = sc.nextDouble();
            System.out.print("Horas trabalhadas no mês: ");
            double horasMes = sc.nextDouble();

            double bruto = salarioBruto(ganhoHora, horasMes);
            double ir = descontoIR(bruto);
            double inss = descontoINSS(bruto);
            double sind = descontoSindicato(bruto);
            double liquido = salarioLiquido(bruto);
            NumberFormat nf = NumberFormat.getCurrencyInstance;

            System.out.println("+ Salário Bruto : " + nf.format(bruto));
            System.out.println("- IR (11%)      : " + nf.format(ir));
            System.out.println("- INSS (8%)     : " + nf.format(inss));
            System.out.println("- Sindicato (5%): " + nf.format(sind));
            System.out.println("= Salário Líquido: " + nf.format(liquido));
            System.out.printf("Obs.: Salário Bruto - Descontos (%.2f%%) = Salário Líquido%n",
                    100.0*(PERC_IR+PERC_INSS+PERC_SIND));
        }
    }
}
