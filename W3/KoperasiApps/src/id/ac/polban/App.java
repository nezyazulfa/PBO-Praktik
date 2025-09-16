// 1. Deklarasi package yang benar sesuai lokasi file
package id.ac.polban;

// 2. Import kelas-kelas yang relevan untuk Koperasi
import id.ac.polban.model.Anggota;
import id.ac.polban.model.Koperasi;
import id.ac.polban.service.TransaksiService;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 3. Logika program yang menggunakan kelas Koperasi, bukan Employee
        Scanner scanner = new Scanner(System.in);
        Koperasi koperasi = new Koperasi("Polban Sejahtera");
        TransaksiService transaksiService = new TransaksiService();

        // Menambahkan beberapa anggota awal
        koperasi.tambahAnggota(new Anggota(101, "Budi", 500000));
        koperasi.tambahAnggota(new Anggota(102, "Ani", 750000));

        int pilihan;
        do {
            System.out.println("\n=== MENU KOPERASI ===");
            System.out.println("1. Setor Tabungan");
            System.out.println("2. Tarik Tabungan");
            System.out.println("3. Cek Saldo Anggota");
            System.out.println("4. Tampilkan Semua Anggota");
            System.out.println("5. Cek Total Transaksi (Static Demo)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            int idAnggota;
            double jumlah;
            Anggota anggota;

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID Anggota: ");
                    idAnggota = scanner.nextInt();
                    anggota = koperasi.getAnggota(idAnggota);
                    if (anggota != null) {
                        System.out.print("Masukkan jumlah setor: Rp");
                        jumlah = scanner.nextDouble();
                        transaksiService.prosesSetor(anggota, jumlah);
                    } else {
                        System.out.println("Anggota tidak ditemukan.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan ID Anggota: ");
                    idAnggota = scanner.nextInt();
                    anggota = koperasi.getAnggota(idAnggota);
                    if (anggota != null) {
                        System.out.print("Masukkan jumlah tarik: Rp");
                        jumlah = scanner.nextDouble();
                        transaksiService.prosesTarik(anggota, jumlah);
                    } else {
                        System.out.println("Anggota tidak ditemukan.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Masukkan ID Anggota: ");
                    idAnggota = scanner.nextInt();
                    anggota = koperasi.getAnggota(idAnggota);
                    if (anggota != null) {
                        System.out.printf("Saldo %s: Rp%.2f\n", anggota.getNama(), anggota.getSaldo());
                    } else {
                        System.out.println("Anggota tidak ditemukan.");
                    }
                    break;
                
                case 4:
                    koperasi.tampilkanDaftarAnggota();
                    break;

                case 5:
                    // Memanggil static method langsung dari kelasnya
                    System.out.println("Total transaksi yang telah terjadi: " + TransaksiService.getJumlahTransaksi());
                    break;

                case 6:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 6);

        scanner.close();
    }
}

