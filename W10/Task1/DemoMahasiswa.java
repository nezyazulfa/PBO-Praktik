import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class DemoMahasiswa {

    public static void main(String[] args) {

        System.out.println("--- Bagian 1: ArrayList (Sort by Name) ---");
        
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        Mahasiswa m1 = new Mahasiswa("S001", "Charlie", "Fisika", "123 Main St");
        Mahasiswa m2 = new Mahasiswa("S002", "Alice", "Ilmu Komputer", "456 Oak Ave");
        Mahasiswa m3 = new Mahasiswa("S003", "Bob", "Matematika", "789 Pine Ln");
        Mahasiswa m4 = new Mahasiswa("S004", "Eve", "Biologi", "321 Elm Blvd");
        Mahasiswa m5 = new Mahasiswa("S005", "David", "Kimia", "654 Maple Dr");

        daftarMahasiswa.add(m1);
        daftarMahasiswa.add(m2);
        daftarMahasiswa.add(m3);
        daftarMahasiswa.add(m4);
        daftarMahasiswa.add(m5);

        System.out.println("\n--- SEBELUM DIURUTKAN ---");
        for (Mahasiswa m : daftarMahasiswa) {
            System.out.println(m);
        }

        Collections.sort(daftarMahasiswa);

        System.out.println("\n--- SETELAH DIURUTKAN (berdasarkan Nama) ---");
        for (Mahasiswa m : daftarMahasiswa) {
            System.out.println(m);
        }

        System.out.println("\n============================================\n");

        System.out.println("--- Bagian 2: Vector (Filter by Department) ---");

        Vector<Mahasiswa> vektorMahasiswa = new Vector<>();

        Mahasiswa v1 = new Mahasiswa("V001", "Grace", "Sejarah", "111 First St");
        Mahasiswa v2 = new Mahasiswa("V002", "Heidi", "Ilmu Komputer", "222 Second St");
        Mahasiswa v3 = new Mahasiswa("V003", "Ivan", "Sastra", "333 Third St");
        Mahasiswa v4 = new Mahasiswa("V004", "Judy", "Ilmu Komputer", "444 Fourth St");
        Mahasiswa v5 = new Mahasiswa("V005", "Mallory", "Fisika", "555 Fifth St");

        vektorMahasiswa.add(v1);
        vektorMahasiswa.add(v2);
        vektorMahasiswa.add(v3);
        vektorMahasiswa.add(v4);
        vektorMahasiswa.add(v5);

        System.out.println("\n--- Mahasiswa di Jurusan 'Ilmu Komputer' ---");
        for (Mahasiswa m : vektorMahasiswa) {
            
            if (m.getJurusan().equals("Ilmu Komputer")) {
                System.out.println(m);
            }
        }
    }
}