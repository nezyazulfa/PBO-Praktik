public class Sphere extends Shape {
    private double radius; // radius dalam satuan kaki

    // Constructor: Mengatur bola.
    public Sphere(double r) {
        super("Sphere");
        radius = r;
    }

    // Mengembalikan luas permukaan bola.
    public double area() {
        return 4 * Math.PI * radius * radius;
    }

    // Mengembalikan representasi String dari bola.
    public String toString() {
        return super.toString() + " of radius " + radius;
    }
}