package laboratory5.Task2;

public class Main {
    public static void main(String[] args) {
        Figura prostokat = new Prostokat(5, 3);
        Figura kolo = new Kolo(4);
        Figura trojkat = new Trojkat(3, 3, 4, 5);

        prostokat.wypisz();
        System.out.println();

        kolo.wypisz();
        System.out.println();

        trojkat.wypisz();
    }
}