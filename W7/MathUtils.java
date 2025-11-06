public class MathUtils {
    /**
     * Returns the factorial of the argument given.
     * The argument must be non-negative and not greater than 16.
     * @param n the integer to compute the factorial of
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative or greater than 16
     */
    public static int factorial(int n) {
        // Cek jika argumen negatif
        if (n < 0) {
            throw new IllegalArgumentException("Angka tidak boleh negatif.");
        }
        // Cek jika argumen terlalu besar (menyebabkan overflow untuk tipe int)
        if (n > 16) {
            throw new IllegalArgumentException("Angka terlalu besar (maksimal 16).");
        }

        int fac = 1;
        for (int i = n; i > 0; i--) {
            fac *= i;
        }
        return fac;
    }
}