package laboratory1.Test;

import java.util.Scanner;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter 4-digit number:");

        int number = sc.nextInt();
        int[] sorted = licz(number);
        int roznica=0;
//        System.out.println(Arrays.toString(licz(number)));
//        while(maxV(sorted) - minV(sorted)){
//
//        }
        while(roznica != 6174 && roznica != 0) {

            System.out.println(maxV(sorted) - minV(sorted));
            roznica = maxV(sorted) - minV(sorted);
            sorted = licz(roznica);
        }
    }


    static int[] licz(int number) {

//        int[] tab = new int[10];
        int[] tab = new int[4];
        for(int i = 0; i < 4; i++){
            tab[i] = number % 10;
            number /= 10;
        }
        Arrays.sort(tab);

        return tab;
    }
    static int maxV(int[] tab){
        return tab[3]*1000 + tab[2]* 100 + tab[1]* 10 + tab[0];
    }
    static int minV(int[] tab){
        return tab[0]*1000 + tab[1]* 100 + tab[2]* 10 + tab[3];
    }
}
