package laboratory6.Task2;
import java.io.Serializable;

//Łukasz Kundzicz
public class Wymierne implements Serializable {
    private static final long serialVersionUID = 1L;
    private int licznik;
    private int mianownik;

    public Wymierne(int licznik, int mianownik) {
        if(mianownik == 0){
            throw new IllegalArgumentException("Nie wolno dzielic przez zero");

        }
        this.licznik = licznik;
        this.mianownik = mianownik;
        skroc();
    }


    public Wymierne suma(Wymierne ulamek){
        int nowy_licznik;
        int nowy_mianownik;
        if(this.mianownik == ulamek.mianownik){
            nowy_mianownik = this.mianownik;
            nowy_licznik = this.licznik + ulamek.licznik;
        }
        else{
            nowy_mianownik = this.mianownik * ulamek.mianownik;
            nowy_licznik = this.licznik * ulamek.mianownik + ulamek.licznik * this.mianownik;
        }
        return new Wymierne(nowy_licznik,nowy_mianownik);
    }

    public Wymierne iloczyn(Wymierne ulamek) {
        int nowyLicznik = this.licznik * ulamek.licznik;
        int nowyMianownik = this.mianownik * ulamek.mianownik;
        return new Wymierne(nowyLicznik, nowyMianownik);
    }

    private void skroc() {
        int nwd = nwd(Math.abs(licznik), Math.abs(mianownik));
        licznik /= nwd;
        mianownik /= nwd;
    }

    private int nwd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return nwd(b, a % b);
    }

    @Override
    public String toString() {
        skroc();
        if (licznik == 0) {
            return "0";
        } else if (Math.abs(licznik) < Math.abs(mianownik)) {
            return licznik + "/" + mianownik;
        } else if (licznik % mianownik == 0) {
            return String.valueOf(licznik / mianownik);  // Liczba całkowita
        } else {
            // część całkowitą + ułamek
            int calosc = licznik / mianownik;
            int nowyLicznik = Math.abs(licznik % mianownik);
            return calosc + " " + nowyLicznik + "/" + Math.abs(mianownik);
        }
    }
}