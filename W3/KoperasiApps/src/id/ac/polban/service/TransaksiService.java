package id.ac.polban.service;

import id.ac.polban.model.Anggota;

public class TransaksiService {

    // STATIC VARIABLE: Menghitung total transaksi di seluruh aplikasi
    private static int jumlahTransaksi = 0;

    // DEPENDENCY: Method ini "uses-a" (menggunakan) objek Anggota
    public boolean prosesSetor(Anggota anggota, double jumlah) {
        if (anggota != null && jumlah > 0) {
            anggota.getTabungan().setor(jumlah);
            jumlahTransaksi++;
            System.out.println("Setor berhasil: Rp" + jumlah + " ke rekening " + anggota.getNama());
            return true;
        }
        System.out.println("Setor gagal! Jumlah tidak valid atau anggota tidak ditemukan.");
        return false;
    }

    // DEPENDENCY: Method ini "uses-a" (menggunakan) objek Anggota
    public boolean prosesTarik(Anggota anggota, double jumlah) {
        if (anggota != null && jumlah > 0 && anggota.getSaldo() >= jumlah) {
            anggota.getTabungan().tarik(jumlah);
            jumlahTransaksi++;
            System.out.println("Tarik tunai berhasil: Rp" + jumlah + " dari rekening " + anggota.getNama());
            return true;
        }
        System.out.println("Tarik tunai gagal! Saldo tidak cukup atau jumlah tidak valid.");
        return false;
    }

    // STATIC METHOD: Mengembalikan nilai dari static variable
    public static int getJumlahTransaksi() {
        return jumlahTransaksi;
    }
}

