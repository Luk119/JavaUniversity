package laboratory9.Task1;

import java.util.Arrays;

// Łukasz Kundzicz
public class Main {
    public static void main(String[] args) {
        Przedzial p1 = new Przedzial(1.0, true, 2.0, false);
        Przedzial p2 = new Przedzial(5.0, true, 7.0, true);
        Przedzial p3 = new Przedzial(Double.NEGATIVE_INFINITY, false, 2.0, false);
        Przedzial p4 = new Przedzial(Double.NEGATIVE_INFINITY, false, Double.POSITIVE_INFINITY, false);
        Przedzial pusty = Przedzial.pusty();

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        System.out.println("p4: " + p4);
        System.out.println("Pusty: " + pusty);

        System.out.println("\np1 \\/ p3: " + p1.suma(p3));
        System.out.println("p1 \\/ p2: " + p1.sumaRozlaczna(p2)[0] + " \\/ " + p1.sumaRozlaczna(p2)[1]);
        System.out.println("p1 /\\ p2: " + p1.iloczyn(p2));
        System.out.println("p1 /\\ p3: " + p1.iloczyn(p3));
        System.out.println("p1 / p2: " + p1.roznica(p2));
        System.out.println("p1 / p4: " + p1.roznica(p4));
        System.out.println("Dopełnienie p3: " + p3.dopelnienie());
    }
}
