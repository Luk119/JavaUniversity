package laboratory13.Task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//Łukasz Kundzocz
public class Main {
    public static void main(String[] args) {
        Eurojackpot game = new Eurojackpot();
        game.drawLottery();

        //Symulacja
        Set<Integer> mainNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> euroNumbers = new HashSet<>(Arrays.asList(1, 2));

        game.enterPlayerNumbers(mainNumbers, euroNumbers);
        game.displayResults();
        game.checkResults();
    }

}
