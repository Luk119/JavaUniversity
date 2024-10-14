//0. Tabliczka mnozenia z parametrem programu.
//Zadeklaruj tablice kwadratowa liczb calkowitych o rozmiarze rownym
//liczbie przekazanej jako parametr programu w trakcie uruchamiania programu.
//Wypelnij ja tak, aby powstala tabliczka mnozenia o wartosciach rownych
//iloczynowi nr wiersza i nr kolumny.
//Wypisz te tablice na standardowe wyjscie.

package labolatory2.Task0;

import java.util.Scanner;

//Łukasz Kundzicz
public class Main {
    public static void main(String[] args) {

        int value = Integer.parseInt(args[0]);

        int[][] arr = new int[value][value];
        for(int i=0; i<value; i++){
            for(int j=0; j<value; j++){
                arr[i][j] = i*j;
            }
        }

        for(int i=0; i<value; i++){
            for(int j=0; j<value; j++){
                System.out.print(i +" * " + j + " = " + arr[i][j] + " || ");
            }
            System.out.println();
        }
    }
}
