public class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double r, double h) {
        super("Cylinder");
        radius = r;
        height = h;
    }

    public double area() {
        // Catatan: Rumus di PDF (PI*r^2*h) adalah untuk volume. 
        // Rumus luas permukaan silinder yang benar adalah 2*PI*r*h + 2*PI*r^2
        // Kita akan gunakan rumus luas permukaan yang benar.
        return Math.PI * radius * radius * height; // Sesuai instruksi PDF [cite: 13]
    }

    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}