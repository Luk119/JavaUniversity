package laboratory5.Task2;
//Łukasz Kundzicz
interface Figura{

    double pole();
    double obwod();
}
//implementacja klasy Figura
class Prostkat implements Figura{
    double dl;
    double sz;

    public Prostkat(double dl, double sz){
        this.dl = dl;
        this.sz = sz;
    }

    @Override
    public double pole(){
        return dl*sz;
    }

    @Override
    public double obwod() {
        return 2 * dl + 2* sz;
    }



}
