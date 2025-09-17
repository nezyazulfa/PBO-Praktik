package Tugas4;

public class AnggotaPrioritas extends Anggota {
    private static final double BUNGA = 0.05; // 5% bunga

    public AnggotaPrioritas(int idAnggota, String nama, double saldoAwal) {
        // Memanggil constructor superclass
        super(idAnggota, nama, saldoAwal);
    }

    @Override
    public void setor(double jumlah) {
        double bonus = jumlah * BUNGA;
        // Memanggil method setor() superclass untuk melakukan penyetoran
        super.setor(jumlah + bonus);
        System.out.println("Anda mendapatkan bonus bunga sebesar Rp" + bonus);
    }

    @Override
    public String toString() {
        return "Anggota Prioritas | " + super.toString();
    }
}