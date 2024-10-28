package laboratory4.Task2;

//Łukasz Kundzicz
public class Main {
    public static void main(String[] args) {
        Zespolone z1 = new Zespolone(3, 4);
        Zespolone z2 = new Zespolone(1, -2);

        System.out.println("Liczba zespolona z1: " + z1);
        System.out.println("Liczba zespolona z2: " + z2);

        System.out.println("\nDodawanie: " + z1 + " + " + z2 + " = " + z1.dodaj(z2));
        System.out.println("Odejmowanie: " + z1 + " - " + z2 + " = " + z1.odejmij(z2));
        System.out.println("Mnożenie: " + z1 + " * " + z2 + " = " + z1.pomnoz(z2));
        System.out.println("Dzielenie: " + z1 + " / " + z2 + " = " + z1.podziel(z2));
        System.out.println("Moduł z1: |" + z1 + "| = " + z1.modul());
        System.out.println("Sprzężenie z1: " + z1 + " = " + z1.sprzezenie());
        System.out.println("Moduł z2: |" + z2 + "| = " + z2.modul());
        System.out.println("Sprzężenie z2: " + z2 + " = " + z2.sprzezenie());
    }
}
