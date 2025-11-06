import java.util.Objects;

public class Mahasiswa implements Comparable<Mahasiswa> {

    private String studentID;
    private String nama;
    private String jurusan; 
    private String alamat;

    public Mahasiswa(String studentID, String nama, String jurusan, String alamat) {
        this.studentID = studentID;
        this.nama = nama;
        this.jurusan = jurusan;
        this.alamat = alamat;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public void setStudentID(String studentID) {
        if (studentID != null && !studentID.isEmpty()) {
            this.studentID = studentID;
        }
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int compareTo(Mahasiswa other) {
        return this.nama.compareTo(other.getNama());
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "ID='" + studentID + '\'' +
                ", Nama='" + nama + '\'' +
                ", Jurusan='" + jurusan + '\'' +
                ", Alamat='" + alamat + '\'' +
                '}';
    }
}