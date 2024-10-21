package labolatory3.Task9;

public class Square {

    private double a;

    public Square(){

    }

    public Square(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double area(){
        return a*a;
    }

    public double circuit(){
        return 4*a;
    }

    @Override
    public String toString() {
        return "Square\n" +
                "a = " + a +
                "\narea = " + area() +
                "\ncircuit = " + circuit() + "\n";
    }
}
