package laboratory5.Task3;
//Łukasz Kundzicz
public class Prostopadloscian implements Figura3D{

    private double a;
    private double b;
    private double c;

    public Prostopadloscian(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double objetosc() {
        return a * b * c;
    }

    @Override
    public double pole() {
        return 2 * a*b + 2 * a*c + 2*b*c;
    }

    @Override
    public double obwod() {
        return 4*a + 4*b + 4*c;
    }

    @Override
    public String toString() {
        return "prostopadloscian: {" + a + ", " + b + ", "+  c + "}\npole: " + pole() + "\nobwod: "
                + obwod() + "\nobjetosc: " + objetosc() + "\n";
    }
}
