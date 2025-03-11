package laboratory7.Task1;
//Łukasz Kundzicz
class Spojnik {

    String symbol;
    int sila;

    public Spojnik(String symbol, int sila) {
        this.symbol = symbol;
        this.sila = sila;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

interface Spojniki {
    Spojnik ZMIENNA = new Spojnik("", 110);
    Spojnik NEGACJA = new Spojnik("~", 100);
    Spojnik KONIUNKCJA = new Spojnik("&", 90);
    Spojnik ALTERNATYWA = new Spojnik("|", 80);
    Spojnik IMPLIKACJA = new Spojnik("->", 70);
    Spojnik ROWNOWAZNOSC = new Spojnik("<=>", 60);
}
