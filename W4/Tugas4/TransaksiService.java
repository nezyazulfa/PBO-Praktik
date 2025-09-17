package Tugas4;

public class TransaksiService {

    private static int jumlahTransaksi = 0;

    public boolean prosesSetor(Anggota anggota, double jumlah) {
        if (anggota != null && jumlah > 0) {
            // Method setor() ini akan memanggil method setor() yang di-override jika anggota adalah AnggotaPrioritas
            anggota.setor(jumlah);
            jumlahTransaksi++;
            System.out.println("Setor berhasil: Rp" + jumlah + " ke rekening " + anggota.getNama());
            return true;
        }
        System.out.println("Setor gagal! Jumlah tidak valid atau anggota tidak ditemukan.");
        return false;
    }

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

    public static int getJumlahTransaksi() {
        return jumlahTransaksi;
    }
}