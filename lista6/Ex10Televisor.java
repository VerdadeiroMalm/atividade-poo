package lista4;

import java.util.Scanner;

class Televisor {
    private int canal;     // 1..999
    private int volume;    // 0..100

    public Televisor(int canalInicial, int volumeInicial) {
        setCanal(canalInicial);
        setVolume(volumeInicial);
    }
    public void setCanal(int novoCanal) {
        if (novoCanal < 1) novoCanal = 1;
        if (novoCanal > 999) novoCanal = 999;
        this.canal = novoCanal;
    }
    public void setVolume(int novoVolume) {
        if (novoVolume < 0) novoVolume = 0;
        if (novoVolume > 100) novoVolume = 100;
        this.volume = novoVolume;
    }
    public void aumentarVolume() { setVolume(volume + 1); }
    public void diminuirVolume() { setVolume(volume - 1); }
    public int getCanal() { return canal; }
    public int getVolume() { return volume; }
}

public class Ex10Televisor {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Televisor tv = new Televisor(10, 20);
            boolean loop = true;
            while (loop) {
                System.out.printf("\nCanal: %d | Volume: %d%n", tv.getCanal(), tv.getVolume());
                System.out.println("1-Trocar canal  2+Vol  3-Vol-  4-Set volume  0-Sair");
                System.out.print("Opção: ");
                int op = sc.nextInt();
                switch (op) {
                    case 1 -> { System.out.print("Novo canal (1-999): "); tv.setCanal(sc.nextInt()); }
                    case 2 -> tv.aumentarVolume();
                    case 3 -> tv.diminuirVolume();
                    case 4 -> { System.out.print("Volume (0-100): "); tv.setVolume(sc.nextInt()); }
                    case 0 -> loop = false;
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }
}
