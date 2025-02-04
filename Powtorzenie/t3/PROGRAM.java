package Powtorzenie.t3;

public class PROGRAM {
    public static void main(String[] args) {
        Budynek b = new Budynek() {
            @Override
            public String material() {
                return "Cegla";
            }
        };
        System.out.println(b.material());
    }
}
