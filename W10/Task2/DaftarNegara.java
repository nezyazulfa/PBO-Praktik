import java.util.HashSet;
import java.util.Set;

public class DaftarNegara {
    public static void main(String[] args) {
        Set<String> negara = new HashSet<>();
        negara.add("Indonesia");
        negara.add("Jepang");
        negara.add("Prancis");
        negara.add("Kanada");
        negara.add("Brazil");
        negara.add("Indonesia"); // duplikat

        System.out.println("Daftar Negara: " + negara);
    }
}
