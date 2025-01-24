package laboratory13.Task2;

import java.io.IOException;
//Łukasz Kundzicz
public class Main {
    public static void main(String[] args) {
        FacultyDatabase database = new FacultyDatabase();

        try {
            //Wczytaj dane z pliku
            database.loadFromFile("laboratory13/Task2/wi_uwb.txt");

            //Sortowanie z uwzględnieniem płci
            System.out.println("Employees (with gender consideration):");
            database.sortEmployees(true);
            database.displayEmployees();

            //Sortowanie bez uwzględnienia płci
            System.out.println("\nEmployees (without gender consideration):");
            database.sortEmployees(false);
            database.displayEmployees();

        } catch (IOException e) {
            System.err.println("Error while loading the file: " + e.getMessage());
        }
    }
}
