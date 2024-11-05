package laboratory5.Task3;
//Łukasz Kundzicz
public class Kula implements Figura3D {

    private double r;

    public Kula(double r) {
        this.r = r;
    }
    @Override
    public double objetosc() {
        return 4.0/3.0 * Math.PI * r * r * r;
    }

    @Override
    public double pole() {
        return 4 * Math.PI * r * r;
    }

    @Override
    public double obwod() {
        return 2 * Math.PI * r;
    }

    @Override
    public String toString() {
        return "kula: {" + r + "}\npole: " + pole() + "\nobwod: "
                + obwod() + "\nobjetosc: " + objetosc() + "\n";
    }
}
