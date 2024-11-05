package laboratory5.Task0;
//Łukasz Kundzicz
public class Pracownik extends Czlowiek{

    protected float wyplata;

    public Pracownik(String imie, String nazwisko, int rok_urodzenia, float wyplata) {
        super(imie, nazwisko, rok_urodzenia);
        this.wyplata = wyplata;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imię='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", rok urodzenia=" + rok_urodzenia +
                ", wypłata=" + wyplata +
                '}';
    }


}
