package laboratory4.Task1;


public class Main {
    public static void main(String[] args) {

        Wymierne a = new Wymierne(1, 2);
        Wymierne b = new Wymierne(-2, 4);
        Wymierne c = new Wymierne(3, 4);
        Wymierne d = new Wymierne(5, 6);

        System.out.println("Dodawanie: " + a + " + " + b + " = " + a.dodaj(b));
        System.out.println("Odejmowanie: " + a + " - " + b + " = " + a.odejmij(b));
        System.out.println("Mnożenie: " + a + " * " + b + " = " + a.pomnoz(b));
        System.out.println("Dzielenie: " + a + " / " + b + " = " + a.podziel(b));
        System.out.println("Odwrotność " + a + " = " + a.odwrotnosc());

        Wymierne licznik = a.dodaj(b);
        Wymierne mianownik = c.odejmij(d);
        Wymierne wynik = licznik.podziel(mianownik);

        System.out.println("\nWynik wyrażenia (1/2 + (-2)/4) / (3/4 - 5/6): " + wynik);

        Wymierne e = new Wymierne(0, 4);
        System.out.println(e.odwrotnosc());
    }
}

