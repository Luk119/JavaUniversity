package laboratory5.Task2;

//Łukasz Kundzicz
interface Figura{

    double pole();
    double obwod();

    void wypisz();
}
//implementacja klasy Figura
class  Prostokat implements Figura{
    private double a;
    private double b;
    public Prostokat(double a, double b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double pole(){
        return a*b;
    }

    @Override
    public double obwod() {
        return 2 * a + 2* b;
    }

    public void wypisz(){
        System.out.println("prostkat: ");
        System.out.println("pole: " + pole());
        System.out.println("obwod: " + obwod());
    }
}

//implementacja klasy Kolo

class Kolo implements Figura{
    private double r;
    public Kolo(double r){
        this.r = r;
    }

    @Override
    public double pole() {
        return Math.PI*r*r;
    }

    @Override
    public double obwod(){
        return 2 * Math.PI * r;
    }

    public void wypisz(){
        System.out.println("kolo: ");
        System.out.println("pole: " + pole());
        System.out.println("obwod: " + obwod());
    }
}
//implementacja klasy Trojkat
class Trojkat implements Figura{
    private double h;
    private double a;
    private double b;
    private double c;

    public Trojkat(double h, double a, double b, double c){
        this.h = h;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double pole() {
        return a*h/2;
    }

    @Override
    public double obwod() {
        return a + b + c;
    }

    public void wypisz(){
        System.out.println("trojkat: ");
        System.out.println("pole: " + pole());
        System.out.println("obwod: " + obwod());
    }
}