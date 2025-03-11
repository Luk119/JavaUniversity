package Powtorzenie.T2;

public class Samochod {
    private String marka;
    private int rok;

    Samochod(String marka, int rok) {
        this.marka = marka;
        this.rok = rok;
    }

    @Override
    public String toString() {
        return marka + " " + rok;
    }
}
