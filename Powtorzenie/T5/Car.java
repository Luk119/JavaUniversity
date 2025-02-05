package Powtorzenie.T5;

public class Car extends Vehicle {
    public static int dlaWszystkich=20;
    public Car(int wheels, String name, int speed){
        super(wheels, name, speed);
    }
    @Override
    public void sound(){
        System.out.println("Car sound");
    }

    public void setDlaWszystkich(int dlaWszystkich){
        this.dlaWszystkich = dlaWszystkich;
    }

    public int getDlaWszystkich(){
        return dlaWszystkich;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
