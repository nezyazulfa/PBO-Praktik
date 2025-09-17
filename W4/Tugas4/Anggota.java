package Tugas4;

public class Anggota {
    private int idAnggota;
    private String nama;
    protected Tabungan tabungan; // Ganti private menjadi protected agar subclass bisa mengakses

    public Anggota(int idAnggota, String nama, double saldoAwal) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tabungan = new Tabungan(saldoAwal);
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public Tabungan getTabungan() {
        return tabungan;
    }
    
    public double getSaldo() {
        return this.tabungan.getSaldo();
    }
    
    public void setor(double jumlah) {
        this.tabungan.setor(jumlah);
    }
    
    @Override
    public String toString() {
        return "ID: " + idAnggota + ", Nama: " + nama + ", Saldo: " + getSaldo();
    }
}