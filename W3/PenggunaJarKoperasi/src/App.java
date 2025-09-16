// Tidak ada deklarasi package karena file ini langsung di dalam src/
import id.ac.polban.model.Koperasi;
import id.ac.polban.model.Anggota;

public class App {
    public static void main(String[] args) {
        System.out.println("Mencoba menggunakan library dari KoperasiApp.jar...");
        
        // Membuat objek dari kelas yang ada di dalam JAR
        Koperasi koperasiBaru = new Koperasi("Koperasi Pengguna JAR");
        koperasiBaru.tambahAnggota(new Anggota(201, "Citra", 100000));
        
        // Memanggil method dari objek yang dibuat
        koperasiBaru.tampilkanDaftarAnggota();
    }
}
