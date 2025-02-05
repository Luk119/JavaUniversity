package Powtorzenie.T5;

public class Vehicle {
    private int wheels;
    private String name;
    private int speed;

    public Vehicle(int wheels, String name, int speed) {
        this.wheels = wheels;
        this.name = name;
        this.speed = speed;
    }

    public void sound(){
        System.out.println("Vehicle makes brr");
    }

    @Override
    public String toString() {
        return wheels + " wheels " + name + " " + speed;
    }
}
