package laboratory7.Task1;
//Łukasz Kundzicz
abstract class Formula {

    Spojnik spojnik;

    public Formula(Spojnik spojnik) {
        this.spojnik = spojnik;
    }

    abstract public boolean oblicz();

    @Override
    public abstract String toString();
}
// Klasa do wyrażeń z jednym argumentem - negacja
abstract class Formula1 extends Formula {

    Formula arg;

    public Formula1(Spojnik spojnik, Formula arg) {
        super(spojnik);
        this.arg = arg;
    }

    @Override
    public String toString() {
        return spojnik.symbol + arg.toString();
    }
}
// Klasa do wyrażeń z dwoma argumentami - AND, OR...
abstract class Formula2 extends Formula {

    Formula arg1, arg2;

    public Formula2(Spojnik spojnik, Formula arg1, Formula arg2) {
        super(spojnik);
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public String toString() {
        return "(" + arg1.toString() + " " + spojnik.symbol + " " + arg2.toString() + ")";
    }
}

// klasa tworząca dowolne zmienne logiczne - (A - true, B- false...)
class Zmienna extends Formula {

    String nazwa;
    boolean wartosc;

    public Zmienna(String nazwa, boolean wartosc) {
        super(Spojniki.ZMIENNA);
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    @Override
    public boolean oblicz() {
        return wartosc;
    }
}

// Operatory logiczne
class Negacja extends Formula1 {
    public Negacja(Formula arg) {
        super(Spojniki.NEGACJA, arg);
    }

    @Override
    public boolean oblicz() {
        return !arg.oblicz();
    }
}

class Alternatywa extends Formula2 {
    public Alternatywa(Formula arg1, Formula arg2) {
        super(Spojniki.ALTERNATYWA, arg1, arg2);
    }

    @Override
    public boolean oblicz() {
        return arg1.oblicz() || arg2.oblicz();
    }
}

class Koniunkcja extends Formula2 {
    public Koniunkcja(Formula arg1, Formula arg2) {
        super(Spojniki.KONIUNKCJA, arg1, arg2);
    }

    @Override
    public boolean oblicz() {
        return arg1.oblicz() && arg2.oblicz();
    }
}

class Implikacja extends Formula2 {
    public Implikacja(Formula arg1, Formula arg2) {
        super(Spojniki.IMPLIKACJA, arg1, arg2);
    }

    @Override
    public boolean oblicz() {
        return !arg1.oblicz() || arg2.oblicz();
    }
}

class Rownowaznosc extends Formula2 {
    public Rownowaznosc(Formula arg1, Formula arg2) {
        super(Spojniki.ROWNOWAZNOSC, arg1, arg2);
    }

    @Override
    public boolean oblicz() {
        return arg1.oblicz() == arg2.oblicz();
    }
}

