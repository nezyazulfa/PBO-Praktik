import java.util.Scanner;

public class Soal1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        for (int i = 0; i < T; i++) {
            try {
                long n = sc.nextLong(); 
                System.out.println(n + " can be fitted in:");

                if (n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                if (n >= Long.MIN_VALUE && n <= Long.MAX_VALUE) {
                    System.out.println("* long");
                }
            } catch (Exception e) {
                
                String invalid = sc.next();
                System.out.println(invalid + " can't be fitted anywhere.");
            }
        }
        sc.close();
    }
}
