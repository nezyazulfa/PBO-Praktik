package Tugas5;

// TestGoods.java

public class TestGoods {
    public static void main(String[] args) {
        // Uji kelas Food
        Food food = new Food("Apple", 1.5, 95);
        System.out.println("--- Food Item ---");
        food.display();
        System.out.println();

        // Uji kelas Toy
        Toy toy = new Toy("Ball", 5.0, 3);
        System.out.println("--- Toy Item ---");
        toy.display();
        System.out.println();

        // Uji kelas Book
        Book book = new Book("The Great Gatsby", 10.0, "F. Scott Fitzgerald");
        System.out.println("--- Book Item ---");
        book.display();
        System.out.println();
    }
}