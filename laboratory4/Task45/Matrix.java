package laboratory4.Task45;

import java.util.Random;

public class Matrix {

    int [][] arr;

    Matrix(int w, int k) {
        arr = new int [w][k];
    }

    Matrix(int w) {
        this(w,w);
    }

    void generuj() {
        Random r = new Random();
        for (int w = 0; w < arr.length; w++) {
            for (int k = 0; k < arr[w].length; k++) {
                arr[w][k] = r.nextInt(10);
            }
        }
    }

    Matrix wytnijWiersz(int nr) {
        Matrix wynik = new Matrix(arr.length-1,arr[0].length);

        for (int w = 0; w < nr; w++) {
            for (int k = 0; k < arr[w].length; k++) {
                wynik.arr[w][k] = this.arr[w][k];
            }
        }

        for (int w = nr+1; w < arr.length; w++) {
            for (int k = 0; k < arr[w].length; k++) {
                wynik.arr[w-1][k] = this.arr[w][k];
            }
        }

        return wynik;
    }

    Matrix wytnijKolumne(int nr) {
        Matrix wynik = new Matrix(arr.length, arr[0].length-1);

        for (int w = 0; w < arr.length; w++) {
            for (int k = 0; k < arr[w].length; k++) {
                if(k == nr){
                    continue;
                }
                else if(k < nr){
                    wynik.arr[w][k] = this.arr[w][k];
                }
                else{
                    wynik.arr[w][k-1] = this.arr[w][k];
                }

            }
        }
        return wynik;
    }

    Matrix wytnijWierszKolumne(int w, int k) {
        return this.wytnijWiersz(w).wytnijKolumne(k);
    }

    @Override
    public String toString() {
        StringBuilder macierz = new StringBuilder();
        for (int w = 0; w < arr.length; w++) {
            for (int k = 0; k < arr[w].length; k++) {
                macierz.append(arr[w][k]).append(" ");
            }
            macierz.append("\n");
        }
        return macierz.toString();
    }

    int det() {
        if (arr.length != arr[0].length) {
            throw new IllegalArgumentException("Macierz musi być kwadratowa, aby obliczyć wyznacznik.");
        }
        if (arr.length == 1) {
            return arr[0][0];
        }
        if (arr.length == 2) {
            return arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
        }

        int suma = 0;

        for (int k = 0; k < arr.length; k++) {
            Matrix minor = wytnijWierszKolumne(0, k);

           int sign;
            if (k % 2 == 0) {
                sign = 1;
            } else {
                sign = -1;
            }

            int element = arr[0][k];
            int minorDeterminant = minor.det();
            suma += sign * element * minorDeterminant;
        }

        return suma;
    }

    boolean odwracalna() {
        if (arr.length != arr[0].length) {
            return false;
        }
        return det() != 0;
    }


}