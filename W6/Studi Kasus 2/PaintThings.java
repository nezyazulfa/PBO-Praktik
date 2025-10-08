import java.text.DecimalFormat;

public class PaintThings {
    //-----------------------------------------
    // Membuat beberapa bentuk dan objek Paint
    // lalu mencetak jumlah cat yang dibutuhkan
    // untuk mengecat setiap bentuk.
    //-----------------------------------------
    public static void main(String[] args) {
        final double COVERAGE = 350;
        Paint paint = new Paint(COVERAGE);

        Rectangle deck;
        Sphere bigBall;
        Cylinder tank;

        double deckAmt, ballAmt, tankAmt;

        // 1. Buat instance dari tiga bentuk yang akan dicat
        deck = new Rectangle(20, 35);
        bigBall = new Sphere(15);
        tank = new Cylinder(10, 30);

        // 2. Hitung jumlah cat yang dibutuhkan untuk setiap bentuk
        deckAmt = paint.amount(deck);
        ballAmt = paint.amount(bigBall);
        tankAmt = paint.amount(tank);

        // 3. Cetak jumlah cat yang dibutuhkan untuk masing-masing.
        DecimalFormat fmt = new DecimalFormat("0.#");
        System.out.println("\nNumber of gallons of paint needed...");
        System.out.println("Deck " + fmt.format(deckAmt));
        System.out.println("Big Ball " + fmt.format(ballAmt));
        System.out.println("Tank " + fmt.format(tankAmt));
    }
}