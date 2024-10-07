package laboratory1.Task2;
import java.util.Scanner;

//2. Sprawdz, czy liczba podana z klawiatury jest liczba palindromiczna
// (lustrzane odbicie, czytana od konca i poczatku jest taka sama).
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (palindrom(scanner.nextLine())) {
            System.out.println("This value is palindrom");
        } else {
            System.out.println("This value is not palindrom");
        }
    }

    public static boolean palindrom(String str) {

        String imieWspak = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            imieWspak += str.charAt(i);
        }
        return imieWspak.equals(str);
    }
}
