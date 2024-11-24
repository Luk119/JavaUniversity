package laboratory6.Task2;
import java.io.*;

//Łukasz Kundzicz
public class Main {

    public static void main(String[] args) {
        try (BufferedReader objReader = new BufferedReader(new FileReader("/Users/lukasz/IdeaProjects/JavaUniversity/laboratory6/Task2/ulamki.txt"))) {
            String strLine1 = objReader.readLine(); // Pierwsza linia
            String strLine2 = objReader.readLine(); // Druga linia

            if (strLine1 != null && strLine2 != null) {
                // Podziel linie na elementy ułamków
                String[] ulamki1 = strLine1.trim().split(" ");
                String[] ulamki2 = strLine2.trim().split(" ");
                
                if (ulamki1.length != ulamki2.length) {
                    throw new IllegalArgumentException("Obie linie muszą mieć taką samą liczbę elementów!");
                }

                // Tworzymy tablice obiektów Wymierne dla wektorów
                Wymierne[] linia1 = new Wymierne[ulamki1.length];
                Wymierne[] linia2 = new Wymierne[ulamki2.length];

                // Parsowanie ułamków bezpośrednio w pętli
                for (int i = 0; i < ulamki1.length; i++) {
                    String[] parts1 = ulamki1[i].split("/");
                    linia1[i] = new Wymierne(
                            Integer.parseInt(parts1[0]),
                            Integer.parseInt(parts1[1])
                    );

                    String[] parts2 = ulamki2[i].split("/");
                    linia2[i] = new Wymierne(
                            Integer.parseInt(parts2[0]),
                            Integer.parseInt(parts2[1])
                    );
                }

                // Obliczenie iloczynu skalarnego
                Wymierne iloczynSkalarny = new Wymierne(0, 1); // Zaczynamy od 0
                for (int i = 0; i < linia1.length; i++) {
                    iloczynSkalarny = iloczynSkalarny.suma(linia1[i].iloczyn(linia2[i]));
                }

                System.out.println("Iloczyn skalarny wektorów: " + iloczynSkalarny);

                //Serializacja wyniku do pliku
                try (FileOutputStream fos = new FileOutputStream("wynik.ser");
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(iloczynSkalarny);
                    System.out.println("Wynik zserializowany");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Deserializacja obiektu Wymierne z pliku
                try (FileInputStream fis = new FileInputStream("wynik.ser");
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    Wymierne odczytanyIloczyn = (Wymierne) ois.readObject();
                    System.out.println("Odczytany iloczyn skalarny: " + odczytanyIloczyn);
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Błąd podczas deserializacji: " + e.getMessage());
                }


            }
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu pliku: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Błąd danych wejściowych: " + e.getMessage());
        }
    }
}
