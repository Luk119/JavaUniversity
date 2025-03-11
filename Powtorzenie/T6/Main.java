package Powtorzenie.T6;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Napis napis = new Napis(1);
        Napis napis2 = new Napis(2);
        Napis napis3 = new Napis(-1);

        ArrayList<Napis> napisy = new ArrayList<>();

        napisy.add(napis);
        napisy.add(napis2);
        napisy.add(napis3);
        Collections.sort(napisy);
        System.out.println(napisy);

    }
}
