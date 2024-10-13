package laboratory1.Task2;
import java.util.Scanner;

//2. Sprawdz, czy liczba podana z klawiatury jest liczba palindromiczna
// (lustrzane odbicie, czytana od konca i poczatku jest taka sama).

// Łukasz Kundzicz

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (palindrom(scanner.nextLine())) {
            System.out.println("This value is palindrom");
        } else {
            System.out.println("This value is not palindrom");
        }
    }

//    Funkcja zwracająca string wspak
    public static boolean palindrom(String str) {

        String Wspak = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            Wspak += str.charAt(i);
        }
        return Wspak.equals(str);
    }
}
