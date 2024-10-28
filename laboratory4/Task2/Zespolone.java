package laboratory4.Task2;

//Łukasz Kundzicz
public class Zespolone {
    private double r;
    private double u;

    public Zespolone(double r, double u) {
        this.r = r;
        this.u = u;
    }

    public Zespolone dodaj(Zespolone other) {
        return new Zespolone(this.r + other.r, this.u + other.u);
    }

    public Zespolone odejmij(Zespolone other) {
        return new Zespolone(this.r - other.r, this.u - other.u);
    }

    public Zespolone pomnoz(Zespolone other) {
        double R = this.r * other.r - this.u * other.u;
        double U = this.r * other.u + this.u * other.r;
        return new Zespolone(R, U);
    }

    public Zespolone podziel(Zespolone other) {
        double m = other.r * other.r + other.u * other.u;
        if (m == 0) {
            throw new ArithmeticException("Nie można dzielić przez zero.");
        }
        double R = (this.r * other.r + this.u * other.u) / m;
        double U = (this.u * other.r - this.r * other.u) / m;
        return new Zespolone(R, U);
    }

    public double modul() {
        return Math.sqrt(r * r + u * u);
    }

    public Zespolone sprzezenie() {
        return new Zespolone(r, -u);
    }

    @Override
    public String toString() {
        if (u == 0) return r + "";
        if (r == 0) return u + "i";
        return r + (u > 0 ? " + " : " - ") + Math.abs(u) + "i";
    }
}
