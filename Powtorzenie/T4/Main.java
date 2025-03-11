package Powtorzenie.T4;

public class Main {
    public static void main(String[] args) {

        Box<Integer> box = new Box<>(5);
        Box<String> box2 = new Box<>("Sebka");
        System.out.println(box);
        System.out.println(box2);

        box.setElement(12);
        System.out.println(box);
    }
}
