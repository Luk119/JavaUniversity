package laboratory5.Task0;
//Łukasz Kundzicz
public class Main {
    public static void main(String[] args) {

        int[] oceny = {1, 2, 3, 4};
        Czlowiek czlowiek = new Czlowiek("Łukasz", "Kundzicz", 2003);
        Pracownik pracownik = new Pracownik("Kuba", "Kowalski", 2002, 4500);
        Student student = new Student("Karol", "Mickiewicz", 2001, oceny);
        Object ososba = new Student("Mikołaj", "Kopernik", 203, oceny);

        System.out.println(student);
        System.out.println(pracownik);
    }
}
