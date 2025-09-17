package Tugas4;

import java.util.ArrayList;
import java.util.List;

public class Koperasi {
    private String namaKoperasi;
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
        // Menggunakan method toString() yang di-override oleh subclass
        for (Anggota anggota : daftarAnggota) {
            System.out.println(anggota);
        }
    }
}