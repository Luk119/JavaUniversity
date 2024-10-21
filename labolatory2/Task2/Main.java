package labolatory2.Task2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Zapoznac sie z  Java Oracle Math
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter number of players: ");
        int playersNum = scanner.nextInt();


        List<String> arr = new ArrayList<>();

        for (int i = 1; i <= playersNum / 2  ; i++) {
            int opponent = playersNum - i + 1;
            arr.add(i + " - " + opponent);
        }

        if (playersNum % 2 != 0) {
            arr.add("DYE " + (playersNum/2 + 1));
        }

        System.out.println("Round 1:");
        for (String v : arr) {
            System.out.println(v);
        }
    }
}
