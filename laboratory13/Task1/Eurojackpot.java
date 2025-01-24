package laboratory13.Task1;

import java.util.*;
//Łukasz Kundzicz
public class Eurojackpot {

    private Set<Integer> drawnMainNumbers;
    private Set<Integer> drawnEuroNumbers;
    private Set<Integer> playerMainNumbers;
    private Set<Integer> playerEuroNumbers;

    public Eurojackpot() {
        drawnMainNumbers = new HashSet<>();
        drawnEuroNumbers = new HashSet<>();
        playerMainNumbers = new HashSet<>();
        playerEuroNumbers = new HashSet<>();
    }

    //Losowanie liczb z danego zakresu
    private Set<Integer> drawNumbers(int range, int count) {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        while (numbers.size() < count) {
            numbers.add(random.nextInt(range) + 1);
        }
        return numbers;
    }

    //Losowanie liczb dla Eurojackpot
    public void drawLottery() {
        drawnMainNumbers = drawNumbers(50, 5);
        drawnEuroNumbers = drawNumbers(12, 2);
    }

    //Wprowadzanie liczb przez gracza
    public void enterPlayerNumbers(Set<Integer> mainNumbers, Set<Integer> euroNumbers) {
        if (mainNumbers.size() == 5 && euroNumbers.size() == 2) {
            playerMainNumbers = mainNumbers;
            playerEuroNumbers = euroNumbers;
        } else {
            throw new IllegalArgumentException("Invalid number of main or euro numbers.");
        }
    }

    //Wyświetlanie wyników
    public void displayResults() {
        System.out.println("Drawn main numbers: " + drawnMainNumbers);
        System.out.println("Drawn euro numbers: " + drawnEuroNumbers);
        System.out.println("Player main numbers: " + playerMainNumbers);
        System.out.println("Player euro numbers: " + playerEuroNumbers);
    }

    //Liczenie trafień
    public void checkResults() {
        int mainMatches = countMatches(drawnMainNumbers, playerMainNumbers);
        int euroMatches = countMatches(drawnEuroNumbers, playerEuroNumbers);

        System.out.println("Main matches: " + mainMatches);
        System.out.println("Euro matches: " + euroMatches);

        String prize = determinePrize(mainMatches, euroMatches);
        System.out.println("You won: " + prize);
    }

    private int countMatches(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection.size();
    }

    private String determinePrize(int mainMatches, int euroMatches) {
        if (mainMatches == 5 && euroMatches == 2) return "I (5+2)";
        if (mainMatches == 5 && euroMatches == 1) return "II (5+1)";
        if (mainMatches == 5 && euroMatches == 0) return "III (5+0)";
        if (mainMatches == 4 && euroMatches == 2) return "IV (4+2)";
        if (mainMatches == 4 && euroMatches == 1) return "V (4+1)";
        if (mainMatches == 3 && euroMatches == 2) return "VI (3+2)";
        if (mainMatches == 4 && euroMatches == 0) return "VII (4+0)";
        if (mainMatches == 2 && euroMatches == 2) return "VIII (2+2)";
        if (mainMatches == 3 && euroMatches == 1) return "IX (3+1)";
        if (mainMatches == 3 && euroMatches == 0) return "X (3+0)";
        if (mainMatches == 1 && euroMatches == 2) return "XI (1+2)";
        if (mainMatches == 2 && euroMatches == 1) return "XII (2+1)";
        return "No prize";
    }


}