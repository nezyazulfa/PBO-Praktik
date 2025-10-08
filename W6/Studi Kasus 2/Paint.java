public class Paint {
    private double coverage; // jumlah kaki persegi per galon

    // Constructor: Mengatur objek cat.
    public Paint(double c) {
        coverage = c;
    }

    // Menghitung dan mengembalikan jumlah cat (dalam galon) yang
    // dibutuhkan untuk mengecat bentuk yang diberikan sebagai parameter.
    public double amount(Shape s) {
        System.out.println("Computing amount for " + s);
        return s.area() / coverage;
    }
}