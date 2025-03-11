package laboratory4.Task1;

//Łukasz Kundzicz
public class Wymierne {
    private int l;
    private int m;

    public Wymierne(int l, int m) {
        if (m == 0) {
            throw new ArithmeticException("Mianownik nie może być zerem.");
        }
        this.l = l;
        this.m = m;
        skroc();
    }

    private void skroc() {
        int gcd = nwd(Math.abs(l), Math.abs(m));
        l /= gcd;
        m /= gcd;
        if (m < 0) {
            l = -l;
            m = -m;
        }
    }

    private int nwd(int a, int b) {
        return b == 0 ? a : nwd(b, a % b);
    }

    public Wymierne dodaj(Wymierne other) {
        int nowyL = l * other.m + other.l * m;
        int nowyM = m * other.m;
        return new Wymierne(nowyL, nowyM);
    }

    public Wymierne odejmij(Wymierne other) {
        int nowyL = l * other.m - other.l * m;
        int nowyM = m * other.m;
        return new Wymierne(nowyL, nowyM);
    }

    public Wymierne pomnoz(Wymierne other) {
        int nowyL = l * other.l;
        int nowyM = m * other.m;
        return new Wymierne(nowyL, nowyM);
    }

    public Wymierne podziel(Wymierne other) {
        if (other.l == 0) {
            throw new ArithmeticException("Nie można dzielić przez zero.");
        }
        int nowyL = l * other.m;
        int nowyM = m * other.l;
        return new Wymierne(nowyL, nowyM);
    }

    public Wymierne odwrotnosc() {
        if (l == 0) {
            throw new ArithmeticException("Liczba 0 nie ma odwrotności.");
        }
        return new Wymierne(m, l);
    }

    @Override
    public String toString() {
        if (m == 1) {
            return Integer.toString(l);
        } else if (Math.abs(l) < m) {
            return l + "/" + m;
        } else {
            int calosci = l / m;
            int nowyL = Math.abs(l % m);
            if (nowyL == 0) {
                return Integer.toString(calosci);
            }
            return calosci + " " + nowyL + "/" + m;
        }
    }
}
