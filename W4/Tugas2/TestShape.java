package Tugas2;

public class TestShape {
    public static void main(String[] args) {
        // Test Shape class
        Shape s1 = new Shape();
        System.out.println(s1);

        Shape s2 = new Shape("yellow", false);
        System.out.println(s2);

        // Test Circle class
        Circle c1 = new Circle();
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        Circle c2 = new Circle(5.0);
        System.out.println(c2);
        
        Circle c3 = new Circle(2.5, "blue", true);
        System.out.println(c3);

        // Test Rectangle class
        Rectangle r1 = new Rectangle();
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        
        Rectangle r2 = new Rectangle(4.0, 6.0);
        System.out.println(r2);
        
        Rectangle r3 = new Rectangle(1.5, 3.0, "orange", false);
        System.out.println(r3);
        
        // Test Square class
        Square sq1 = new Square(3.0);
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Perimeter: " + sq1.getPerimeter());
        
        Square sq2 = new Square(5.0, "purple", true);
        System.out.println(sq2);
    }
}