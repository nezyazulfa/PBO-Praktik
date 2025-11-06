import java.util.Scanner;

public class CountLetters {
  public static void main(String[] args) {
    int[] counts = new int[26];
    Scanner scan = new Scanner(System.in);

    // Dapatkan kata dari pengguna
    System.out.print("Enter a phrase (letters, numbers, symbols): ");
    String word = scan.nextLine();

    // Ubah menjadi huruf besar
    word = word.toUpperCase();

    // Hitung frekuensi setiap huruf dalam string
    for (int i = 0; i < word.length(); i++) {
      try {
        // Baris ini akan error jika karakternya bukan huruf
        counts[word.charAt(i) - 'A']++;
      } catch (ArrayIndexOutOfBoundsException e) {
        // Cetak pesan informatif ke pengguna
        System.out.println("Karakter '" + word.charAt(i) + "' bukan huruf dan diabaikan.");
      }
    }

    // Cetak frekuensi
    System.out.println();
    System.out.println("Frequency of letters:");
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] != 0) {
        System.out.println((char) (i + 'A') + ": " + counts[i]);
      }
    }
  }
}