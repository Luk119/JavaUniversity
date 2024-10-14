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

import java.util.Arrays;
import java.util.Scanner;

//Łukasz Kundzicz
public class CzteryKwadraty {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter value: ");

        int value = -1;
        do {
            value = scan.nextInt();
        } while (value < 0 || value > 1000);

        int[] tab = new int[4];

        for (int i = 0; i < 4; i++) {
            tab[i] = (int) Math.sqrt(value);
            value = value - (int) Math.pow(tab[i], 2);

        }
        System.out.println(Arrays.toString(tab));


    }
}
