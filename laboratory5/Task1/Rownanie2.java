package laboratory5.Task1;

public class Rownanie2 extends Rownanie {

    Rownanie2() {
        super(6, 2);
    }

    @Override
    protected int rozwiazanie() {

        double a = dane[5];
        double b = dane[4];
        double c = dane[3];
        double d = dane[2];
        double e = dane[1];
        double f = dane[0];

        // ax + by = c
        // dx + ey = f
        double wyznacznik1 = a*e - b*d;
        System.out.println(wyznacznik1);
        double wyznacznik2 = c*e - b*f;
        double wyznacznik3 = a*f - c*d;
        System.out.println(wyznacznik3);

        rozwiazania[0] = wyznacznik2/wyznacznik1;
        rozwiazania[1] = wyznacznik3/wyznacznik1;
        return 2;
    }
}
