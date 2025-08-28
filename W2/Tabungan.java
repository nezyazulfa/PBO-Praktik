public class Tabungan {
    private double saldo;

    public Tabungan(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    public void setor(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Berhasil setor: Rp" + jumlah);
        } else {
            System.out.println("Jumlah setor tidak valid!");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void kurangiSaldo(double jumlah) {
        saldo -= jumlah;
    }
}
