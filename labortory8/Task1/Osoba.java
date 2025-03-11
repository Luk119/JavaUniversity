package labortory8.Task1;
//Łukasz Kundzicz
// 3. Osoba
public class Osoba {
    private String nazwisko;
    private String pesel;

    public Osoba(String nazwisko, String pesel) {
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public Data pesel2data() {
        int rok = Integer.parseInt(pesel.substring(0, 2));
        int miesiac = Integer.parseInt(pesel.substring(2, 4));
        int dzien = Integer.parseInt(pesel.substring(4, 6));
        if (miesiac > 20) {
            rok += 2000;
            miesiac -= 20;
        } else {
            rok += 1900;
        }
        return new Data(dzien, miesiac, rok);
    }

    public char plec() {
        return (pesel.charAt(9) % 2 == 0) ? 'K' : 'M';
    }
}

