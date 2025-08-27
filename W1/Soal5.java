import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        System.out.println(A.length() + B.length());

        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        String capA = A.substring(0,1).toUpperCase() + A.substring(1);
        String capB = B.substring(0,1).toUpperCase() + B.substring(1);
        System.out.println(capA + " " + capB);

        sc.close();
    }
}
