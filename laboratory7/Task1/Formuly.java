package laboratory7.Task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Łukasz Kundzicz
public class Formuly {

    public static void main(String[] args) {
        Zmienna p = new Zmienna("p", true);
        Zmienna q = new Zmienna("q", false);

        // Tautologie
        Formula tautologia1 = new Implikacja(p, new Alternatywa(p, q));
        Formula tautologia2 = new Rownowaznosc(new Koniunkcja(p, p), p);

        // Kontrtautologie
        Formula kontrtautologia1 = new Koniunkcja(p, new Negacja(p));
        Formula kontrtautologia2 = new Koniunkcja(new Negacja(p), new Alternatywa(p, q));

        // Ani tautologie, ani kontrtautologie
        Formula form1 = new Koniunkcja(p, q);
        Formula form2 = new Rownowaznosc(p, q);

        // Plik do zapisania wyników
        String fileName = "laboratory7/Task1/wyniki.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Wypisanie w standardowej notacji i zapisanie do pliku
            writer.write("Standardowa notacja:\n");
            writer.write("Tautologia 1: " + tautologia1 + " = " + tautologia1.oblicz() + "\n");
            writer.write("Tautologia 2: " + tautologia2 + " = " + tautologia2.oblicz() + "\n");
            writer.write("Kontrtautologia 1: " + kontrtautologia1 + " = " + kontrtautologia1.oblicz() + "\n");
            writer.write("Kontrtautologia 2: " + kontrtautologia2 + " = " + kontrtautologia2.oblicz() + "\n");
            writer.write("Formuła 1: " + form1 + " = " + form1.oblicz() + "\n");
            writer.write("Formuła 2: " + form2 + " = " + form2.oblicz() + "\n");

            // Sprawdzanie tautologii dla wszystkich wartości zmiennych
            sprawdzCzyTautologia(tautologia1, writer);
            sprawdzCzyTautologia(tautologia2, writer);
            sprawdzCzyTautologia(kontrtautologia1, writer);
            sprawdzCzyTautologia(kontrtautologia2, writer);
            sprawdzCzyTautologia(form1, writer);
            sprawdzCzyTautologia(form2, writer);

            System.out.println("Wyniki zostały zapisane do pliku: " + fileName);

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania do pliku: " + e.getMessage());
        }
    }

    public static void sprawdzCzyTautologia(Formula formula, BufferedWriter writer) {
        // Pobierz listę wszystkich zmiennych logicznych
        List<Zmienna> zmienne = collectVariables(formula);
        int liczbaKombinacji = (int) Math.pow(2, zmienne.size());
        boolean jestTautologia = true; // Zakładamy, że formuła jest tautologią aż nie napotkamy fałszu

        try {
            // Iterujemy przez wszystkie kombinacje
            for (int kombinacja = 0; kombinacja < liczbaKombinacji; kombinacja++) {
                // Ustawiamy wartości zmiennych na podstawie bitów liczby 'kombinacja'
                for (int i = 0; i < zmienne.size(); i++) {
                    zmienne.get(i).wartosc = (kombinacja & (1 << i)) != 0; // Jeśli bit i-tej pozycji to 1, ustaw true
                }

                // Obliczamy wynik formuły wartości zmiennych
                boolean wynik = formula.oblicz();
                writer.write("Wartościowanie: " + zmienne + " -> " + wynik + "\n");

                // Jeśli znajdziemy fałsz w wyrażeniu zwracamy false
                if (!wynik) {
                    jestTautologia = false;
                }
            }

            // Wyświetlamy końcowy wynik do pliku
            if (jestTautologia) {
                writer.write(formula + " jest tautologią.\n");
            } else {
                writer.write(formula + " NIE jest tautologią.\n");
            }

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania do pliku: " + e.getMessage());
        }
    }

    public static List<Zmienna> collectVariables(Formula formula) {
        Set<Zmienna> zmienne = new HashSet<>();
        collectVariablesRec(formula, zmienne);
        return new ArrayList<>(zmienne);
    }

    private static void collectVariablesRec(Formula formula, Set<Zmienna> zmienne) {
        if (formula instanceof Zmienna) {
            zmienne.add((Zmienna) formula);
        } else if (formula instanceof Formula1) {
            collectVariablesRec(((Formula1) formula).arg, zmienne);
        } else if (formula instanceof Formula2) {
            collectVariablesRec(((Formula2) formula).arg1, zmienne);
            collectVariablesRec(((Formula2) formula).arg2, zmienne);
        }
    }
}
