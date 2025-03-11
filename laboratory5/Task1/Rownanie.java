package laboratory5.Task1;

import java.util.Scanner;
//Łukasz Kundzicz
abstract class Rownanie
{
    protected double[] dane;
    protected double[] rozwiazania;
    protected int liczbaRozwiazan; // 0, 1, nieskonczenie wiele
    Rownanie(int ilosc_wej,int ilosc_wyj) {
        dane = new double[ilosc_wej];
        rozwiazania = new double[ilosc_wyj];
    }
    private void wprowadzDane() {
        Scanner sc = new Scanner(System.in);

        System.out.println("liniowe z jedną niewiadomą: ax + b = 0");
        System.out.println("liniowe z dwoma niewiadomymi: ax + by = c");

        for (int i = dane.length-1; i >= 0; i--) {
            System.out.println("Podaj a" + i + ": ");
            dane[i] = sc.nextDouble();
        }
    } // uzupelnic kodem wczytywania wspolczynnikow
    private void wypiszWynik() {
        if (liczbaRozwiazan == 0) {
            System.out.println("Brak rozwiązań");
        }
        else if (liczbaRozwiazan == 1) {
            System.out.println("x = " + rozwiazania[0]);
        }
        else if (liczbaRozwiazan == 2) {
            System.out.println("x = " + rozwiazania[0]);
            System.out.println("y = " + rozwiazania[1]);
        }
        else {
            System.out.println("Nieskończenie wiele rozw.");
        }
    } // uzupelnic w zaleznosci od liczby rozwiazan
    abstract protected int rozwiazanie(); // oczywiscie trzeba bedzie zaimplementowac konkretnie
    final void rozwiaz()
    {
        wprowadzDane();
        liczbaRozwiazan = rozwiazanie();
        wypiszWynik();
    }
}