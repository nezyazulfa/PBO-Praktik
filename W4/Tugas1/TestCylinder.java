public class TestCylinder {
    public static void main(String[] args) {
        // Uji constructor dan metode
        
        System.out.println("--- Menguji Cylinder dengan constructor default ---");
        Cylinder c1 = new Cylinder();
        System.out.println("Cylinder 1: radius=" + c1.getRadius() + ", height=" + c1.getHeight() + ", area=" + c1.getArea() + ", volume=" + c1.getVolume());
        System.out.println(c1.toString());

        System.out.println("\n--- Menguji Cylinder dengan tinggi tertentu ---");
        Cylinder c2 = new Cylinder(10.0);
        System.out.println("Cylinder 2: radius=" + c2.getRadius() + ", height=" + c2.getHeight() + ", area=" + c2.getArea() + ", volume=" + c2.getVolume());
        System.out.println(c2.toString());

        System.out.println("\n--- Menguji Cylinder dengan radius dan tinggi tertentu ---");
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("Cylinder 3: radius=" + c3.getRadius() + ", height=" + c3.getHeight() + ", area=" + c3.getArea() + ", volume=" + c3.getVolume());
        System.out.println(c3.toString());

        System.out.println("\n--- Menguji Cylinder dengan radius, tinggi, dan warna tertentu ---");
        Cylinder c4 = new Cylinder(3.0, 5.0, "green");
        System.out.println("Cylinder 4: radius=" + c4.getRadius() + ", height=" + c4.getHeight() + ", color=" + c4.getColor() + ", area=" + c4.getArea() + ", volume=" + c4.getVolume());
        System.out.println(c4.toString());
    }
}