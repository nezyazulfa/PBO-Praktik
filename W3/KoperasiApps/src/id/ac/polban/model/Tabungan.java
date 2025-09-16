package id.ac.polban.model;

public class Tabungan {
    private double saldo;

    public Tabungan(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    // Perbaikan: Tambahkan 'public' agar bisa diakses dari package 'service'
    public void setor(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
        }
    }

    // Perbaikan: Tambahkan 'public' agar bisa diakses dari package 'service'
    public void tarik(double jumlah) {
        if (jumlah > 0 && this.saldo >= jumlah) {
            this.saldo -= jumlah;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }
}

