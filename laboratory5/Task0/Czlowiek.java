package laboratory5.Task0;
//Łukasz Kundzicz
public class Czlowiek {
    public Czlowiek(String imie, String nazwisko, int rok_urodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rok_urodzenia = rok_urodzenia;
    }

    protected String imie;
    protected String nazwisko;
    protected int rok_urodzenia;


    private int licz_wiek(int rok_urodzenia){
        return 2024 - rok_urodzenia;
    }
}
