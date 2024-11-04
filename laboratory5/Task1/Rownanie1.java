package laboratory5.Task1;

public class Rownanie1 extends Rownanie{

    Rownanie1() {
        super(2, 1);
    }

    @Override
    protected int rozwiazanie() {
        double a = dane[1];
        double b = dane[0];
        if (a == 0 && b == 0) {
            return 666;
        }else if (a == 0) {
            return 0;
        }
        rozwiazania[0] = -b/a;
        return 1;
    }



}
