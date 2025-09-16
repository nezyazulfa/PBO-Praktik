package id.ac.polban.model;

public class Anggota {
    private int idAnggota;
    private String nama;
    private Tabungan tabungan; // Setiap Anggota "memiliki" sebuah Tabungan

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
}

