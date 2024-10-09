package laboratory1.Task3;

import java.util.Scanner;

//3. W klasie MinMax3 rozwiazac podany problem:

//Uzytkownik podaje liczbe trzycyfrowa (czyli pomiedzy 111 a 999).
//Program znajduje odpowiednio najmniejsza i najwieksza liczbe o cyfrach
//z zadanej liczby, a nastepnie liczy roznice najwiekszej i najmniejszej,
//wypisuje ja na ekran i pretwarza analogicznie dalej.
// Program powinien sie zatrzymac, gdy liczby staja sie takie same.
public class MinMax3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter 3 digit value:");

        int value = scanner.nextInt();

        while (value > 999 || value < 111) {
            System.out.println("Error");
            value = scanner.nextInt();
        }
//            System.out.println(minimum);
//            System.out.println(medium);
//            System.out.println(maximum);

        int minimum = min(value);
        int maximum = max(value);
        int medium = med(minimum, maximum, value);

        if(isZero(value))
        {
            System.out.println("0");
        }
        else{
            int result = maxValue(maximum, medium, minimum) - minValue(maximum, medium, minimum);

            do{
                maximum = max(result);
                minimum = min(result);
                medium = med(minimum, maximum, result);
                result = maxValue(maximum, medium, minimum) - minValue(maximum, medium, minimum);

                System.out.println(result);
            }
            while(result != 495);
        }
    }

    public static int min(int value) {
        int min = 9;
        for (int i = 3; i > 0; i--) {
            if (value % 10 < min) {
                min = value % 10;
            }
            value /= 10;
        }
        return min;
    }

    public static int max(int value) {
        int max = 0;
        for (int i = 3; i > 0; i--) {
            if (value % 10 > max) {
                max = value % 10;
            }
            value /= 10;
        }
        return max;
    }

    public static int med(int min, int max, int value) {
        int med = min;

        for (int i = 3; i > 0; i--) {
            if (value % 10 != min && value % 10 != max) {
                med = value % 10;
            }
            value /= 10;
        }
        return med;
    }

    public static int minValue(int max, int med, int min) {
        return max + med*10 + min*100;
    }

    static int maxValue(int max, int med, int min) {
        return max*100 + med*10 + min;
    }

    static boolean isZero(int n){
        String toString = Integer.toString(n);
        char[] chars = toString.toCharArray();
        return chars[0] == chars[1] && chars[1] == chars[2];
    }
}
