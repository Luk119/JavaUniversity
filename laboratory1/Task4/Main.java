package laboratory1.Task4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 4-digit value: ");
        int value = scanner.nextInt();

        if(isZero(value)){
            System.out.println("0");
        }
        else {
            int result = value;

            do {
                result = MaxNum(result) - MinNum(result);
                System.out.println(result);
            }
            while (result != 6174);
        }


//        System.out.println(MaxNum(1234));
//        System.out.println(MinNum(1234));
//        result = MaxNum(value) - MinNum(value);
//        System.out.println(result);

    }


    static int MinNum(int n) {
        String toString = Integer.toString(n);
        char[] chars = toString.toCharArray();
        Arrays.sort(chars);
        toString = new String(chars);
        return Integer.parseInt(toString);
    }

    static int MaxNum(int n) {
        String toString = Integer.toString(n);
        char[] chars = toString.toCharArray();
        Arrays.sort(chars);
        StringBuilder reverse = new StringBuilder(new String(chars));
        reverse.reverse();
        return Integer.parseInt(reverse.toString());
    }

    static boolean isZero(int n){
        String toString = Integer.toString(n);
        char[] chars = toString.toCharArray();
        return chars[0] == chars[1] && chars[1] == chars[2] && chars[1] == chars[3];
    }
}

