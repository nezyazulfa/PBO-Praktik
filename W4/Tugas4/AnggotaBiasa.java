package Tugas4;

public class AnggotaBiasa extends Anggota {
    public AnggotaBiasa(int idAnggota, String nama, double saldoAwal) {
        // Memanggil constructor superclass
        super(idAnggota, nama, saldoAwal);
    }

    @Override
    public String toString() {
        // Menggunakan toString() superclass dan menambahkan label spesifik
        return "Anggota Biasa | " + super.toString();
    }
}