//1. Cztery kwadraty.
//Twierdzenie Lagrange'a (tzw. twierdzenie o sumie czterech kwadratow)
//mowi, ze kazda liczba naturalna da sie zapisac jako suma czterech
//kwadratow pewnych liczb naturalnych (niektore z nich moga byc zerami).
//Napisz program (CzteryKwadraty), ktory uzywajac tablic jako pomocniczego
//kontenera wylicza i wypisuje na ekran rozklad na cztery kwadraty
//        (wystarczy jeden dla liczby) kazdej liczby z ustalonego przedzialu liczb
//naturalnych (a,b) podanego przez uzytkownika (0 <= a <= b <= 1000).
//Program ma tez znalezc te liczby z przedzialu [0;1000], dla ktorych nie
//istnieja rozklady w postaci kwadratow liczb wylacznie roznych od zera.
package labolatory2.Task1;

import java.util.Scanner;
//Łukasz Kundzicz
public class CzteryKwadraty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pobieranie liczby od użytkownika
        System.out.print("Enter a number: ");
        int n;
        do{
            n = scanner.nextInt();
        }while(n < 0 || n > 1000);

        boolean found = false;

        for (int i = 0; i*i <= n; i++) {
            for (int j = 0; j*j <= n - i*i; j++) {
                for (int k = 0; k*k <= n - i*i - j*j; k++) {
                    for (int l = 0; l*l <= n - i*i - j*j - k*k; l++) {
                        if (i*i + j*j + k*k + l*l == n) {
                            System.out.println(n + " = " + l + "² + " + k + "² + " + j + "² + " + i + "²");
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
                if (found) break;
            }
            if (found) break;
        }
    }
}
