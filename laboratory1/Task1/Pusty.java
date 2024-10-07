package laboratory1.Task1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Pusty {
    public static void main(String[] args) {

        List<String> surnames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter surnames:");
        while(true) {
            String surname = scanner.nextLine();
            if (surname.equals("Pusty")) {break;}
            surnames.add(surname);
        }

//        for(String surname : surnames){
//            System.out.println(surname);
//        }

        for(int i=surnames.size()-1; i>=0; i--) {
            System.out.println(surnames.get(i));
        }

    }
}
