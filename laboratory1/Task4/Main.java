package laboratory1.Task4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 4-digit value: ");
        int value = scanner.nextInt();
        int result = 1;

        do{
            result = MaxNum(value) - MinNum(value);
            System.out.println(result);
        }
        while(result >0);
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
}

