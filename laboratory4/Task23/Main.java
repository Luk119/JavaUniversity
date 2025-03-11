package laboratory4.Task23;
import java.util.Random;

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


        Zespolone[] arr = new Zespolone[5];

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            arr[i] = new Zespolone(random.nextInt(10) + 1, random.nextInt(10) + 1);
            System.out.println(arr[i]);
        }

        System.out.println(Najwiekszy(arr));

    }

    public static Zespolone Najwiekszy(Zespolone[] arr) {
        double max=arr[0].modul();
        int maxIndex=0;
        for(int i=1; i<arr.length; i++) {
            if(arr[i].modul() > max){
                max = arr[i].modul();
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
}
