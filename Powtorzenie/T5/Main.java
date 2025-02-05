package Powtorzenie.T5;

public class Main {
    public static void main(String[] args) {

        Car car = new Car(4, "audi", 200);
        Car car2 = new Car(4, "audi", 200);
        System.out.println(car);
        car.sound();

        System.out.println(car instanceof Car);

        car.setDlaWszystkich(12);

        System.out.println(car.getDlaWszystkich());
        System.out.println(car2.getDlaWszystkich());


    }
}
