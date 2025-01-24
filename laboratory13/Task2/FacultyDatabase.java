package laboratory13.Task2;

import java.io.*;
import java.util.*;
//Łukasz Kundzicz
//Klasa Employee (Pracownik) reprezentująca pracownika Wydziału Informatyki
class Employee {
    private String unit; //jednostka
    private String firstName; //imię
    private String lastName; //nazwisko
    private String degree; //stopień
    private String role; //funkcja
    private boolean gender; //true - kobieta, false - mężczyzna

    public Employee(String unit, String firstName, String lastName, String degree, String role) {
        this.unit = unit;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.role = role;
        this.gender = determineGender(firstName);
    }

    //imiona kończące się na 'a' to kobiety
    private boolean determineGender(String firstName) {
        return firstName.toLowerCase().endsWith("a");
    }

    public String getUnit() {
        return unit;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDegree() {
        return degree;
    }

    public String getRole() {
        return role;
    }

    public boolean isGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, %s, %s, %s",
                unit, firstName, lastName, degree, role, gender ? "female" : "male");
    }
}

//Klasa Database przechowująca listę pracowników
public class FacultyDatabase {

    private List<Employee> employees;

    public FacultyDatabase() {
        employees = new ArrayList<>();
    }

    //Wczytywanie pracowników z pliku
    public void loadFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t"); //Kolumny oddzielone tabem
                if (data.length >= 5) {
                    Employee employee = new Employee(data[0], data[1], data[2], data[3], data[4]);
                    employees.add(employee);
                }
            }
        }
    }

    // Sortowanie pracowników
    public void sortEmployees(boolean sortByGender) {
        Comparator<Employee> comparator = Comparator
                .comparing(Employee::isGender).reversed() //Panie na początek (jeśli włączone)
                .thenComparing(e -> degreeHierarchy(e.getDegree())) //Sortowanie wg stopnia
                .thenComparing(Employee::getRole, Comparator.nullsLast(Comparator.naturalOrder())) //Funkcja
                .thenComparing(Employee::getLastName) //Nazwisko
                .thenComparing(Employee::getFirstName); //Imię

        if (!sortByGender) {
            comparator = comparator.reversed(); //Ignoruj płeć, sortuj tylko wg stopnia
        }

        employees.sort(comparator);
    }

    //Hierarchia stopni
    private int degreeHierarchy(String degree) {
        switch (degree.toLowerCase()) {
            case "prof":
                return 1;
            case "dr hab":
                return 2;
            case "dr":
                return 3;
            case "mgr":
                return 4;
            default:
                return 5; //W przypadku innych wartości
        }
    }

    //Wyświetlanie listy pracowników
    public void displayEmployees() {
        employees.forEach(System.out::println);
    }
}

