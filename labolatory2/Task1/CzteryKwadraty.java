package labolatory2.Task1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CzteryKwadraty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();

        // Read the interval from the user
        System.out.print("Enter value a (0 <= a <= 1000): ");
        int a = scanner.nextInt();
        System.out.print("Enter value b (a <= b <= 1000): ");
        int b = scanner.nextInt();

        if (a <= 0 || b >= 1000 || a >= b) {
            System.out.println("Invalid range.");
            System.exit(1);
        }

        for (int n = a; n <= b; n++) {
            boolean found = false;

            for (int i = 1; Math.pow(i, 2) <= n; i++) {
                for (int j = 1; Math.pow(j, 2) <= n; j++) {
                    for (int k = 1; Math.pow(k, 2) <= n; k++) {
                        for (int l = 1; Math.pow(l, 2) <= n; l++) {
                            if (Math.pow(i, 2) + Math.pow(j, 2) + Math.pow(k, 2) + Math.pow(l, 2) == n) {
                                System.out.println(n + " = " + i + "² + " + j + "² + " + k + "² + " + l + "²");
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

            if (!found) {
                array.add(n);
            }
        }
        System.out.println("Numbers that cannot be expressed without 0²: " + array);
    }
}
