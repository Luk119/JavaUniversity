package laboratory5.Task0;
import java.util.Arrays;

//Łukasz Kundzicz
public class Student extends Czlowiek{

    int[] oceny;

    public Student(String imie, String nazwisko, int rok_urodzenia, int[] oceny) {
        super(imie, nazwisko, rok_urodzenia);
        this.oceny = oceny;
    }

    @Override
    public String toString() {
        return Arrays.toString(oceny);
    }
}
