import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Tabungan tabungan = new Tabungan(0);
        Penarikan penarikan = new Penarikan();

        int pilihan;
        do {
            System.out.println("\n=== MENU KOPERASI ===");
            System.out.println("1. Setor Tabungan");
            System.out.println("2. Tarik Tabungan");
            System.out.println("3. Cek Saldo");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah setor: Rp");
                    double setor = scanner.nextDouble();
                    tabungan.setor(setor);
                    break;

                case 2:
                    System.out.print("Masukkan jumlah tarik: Rp");
                    double tarik = scanner.nextDouble();
                    penarikan.tarik(tabungan, tarik);
                    break;

                case 3:
                    System.out.println("Saldo saat ini: Rp" + tabungan.getSaldo());
                    break;

                case 4:
                    System.out.println("Terima kasih, program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);

        scanner.close();
    }
}
