public class Penarikan {
    public void tarik(Tabungan tabungan, double jumlah) {
        if (jumlah > 0 && jumlah <= tabungan.getSaldo()) {
            tabungan.kurangiSaldo(jumlah);
            System.out.println("Berhasil tarik: Rp" + jumlah);
        } else {
            System.out.println("Penarikan gagal! Saldo tidak cukup atau jumlah tidak valid.");
        }
    }
}
