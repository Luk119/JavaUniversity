package Powtorzenie.T2;

public class Paliwowe extends Samochod {
    private String typPaliwa;

    Paliwowe(String marka, int rok, String paliwo){
        super(marka, rok);
        this.typPaliwa = paliwo;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + typPaliwa;
    }
}

// final:
// -dla klasy, klasa nie może być dziedziczona
// -dla metoda, nie może zostać nadpisana
// -dla pola, wartość pola nie może być zmieniona