package id.ac.polban.model;

import java.util.ArrayList;
import java.util.List;

public class Koperasi {
    private String namaKoperasi;
    // AGGREGATION: Koperasi "has-a" list of Anggota
    private List<Anggota> daftarAnggota;

    public Koperasi(String namaKoperasi) {
        this.namaKoperasi = namaKoperasi;
        this.daftarAnggota = new ArrayList<>();
    }
    
    public void tambahAnggota(Anggota anggota) {
        this.daftarAnggota.add(anggota);
    }

    public Anggota getAnggota(int idAnggota) {
        for (Anggota anggota : daftarAnggota) {
            if (anggota.getIdAnggota() == idAnggota) {
                return anggota;
            }
        }
        return null; 
    }
    
    public void tampilkanDaftarAnggota() {
        System.out.println("=== Daftar Anggota " + this.namaKoperasi + " ===");
        for (Anggota anggota : daftarAnggota) {
            System.out.printf("ID: %d, Nama: %s, Saldo: Rp%.2f\n",
                anggota.getIdAnggota(), anggota.getNama(), anggota.getSaldo());
        }
    }
}

