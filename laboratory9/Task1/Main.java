package laboratory9.Task1;

public class Main {
    public static void main(String[] args) {
        Przedzial p1 = new Przedzial(1.0, true, 5.0, false);
        Przedzial p2 = new Przedzial(3.0, true, 10.0, true);
        Przedzial p3 = new Przedzial(-Double.POSITIVE_INFINITY, false, 2.0, false);

        System.out.println("P1: " + p1);
        System.out.println("P2: " + p2);
        System.out.println("P3: " + p3);

        System.out.println("Suma P1 i P2: " + p1.suma(p2));
        System.out.println("Iloczyn P1 i P2: " + p1.iloczyn(p2));
        System.out.println("Różnica P1 i P2: " + p1.roznica(p2));
        System.out.println("Dopełnienie P3: " + p3.dopelnienie());
    }
}
