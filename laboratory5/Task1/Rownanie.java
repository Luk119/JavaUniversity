package laboratory5.Task1;

abstract class Rownanie
{
    protected double[] dane;
    protected double[] rozwiazania;
    protected int liczbaRozwiazan; // 0, 1, nieskonczenie wiele
    Rownanie(int ilosc_wej,int ilosc_wyj) {
        dane = new double[ilosc_wej];
        rozwiazania = new double[ilosc_wyj];
    }
    private void wprowadzDane() { } // uzupelnic kodem wczytywania wspolczynnikow
    private void wypiszWynik() { } // uzupelnic w zaleznosci od liczby rozwiazan
    abstract protected int rozwiazanie(); // oczywiscie trzeba bedzie zaimplementowac konkretnie
    final void rozwiaz()
    {
        wprowadzDane();
        liczbaRozwiazan = rozwiazanie();
        wypiszWynik();
    }
}