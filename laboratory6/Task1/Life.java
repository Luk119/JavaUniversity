package laboratory6.Task1;

import java.nio.file.*;
import java.io.*;
import java.util.*;
//Łukasz Kundzicz
public class Life {
    private final int k;
    private final int r;
    private boolean[][] board;
    private boolean[][] prevBoard;
    private final Random random = new Random();
    private final Set<String> previousStates = new HashSet<>(); // Do wykrywania cykli

    public Life(int r, int k) {
        this.k = k;
        this.r = r;
        this.board = new boolean[r][k];
    }

    // Inicjalizacja losowa
    public void initializeRandom(int aliveCells) {
        for (int i = 0; i < aliveCells; i++) {
            int x,y;
            do {
                x = random.nextInt(r);
                y = random.nextInt(k);
            } while (board[x][y]);
            board[x][y] = true;
        }
    }

    // Inicjalizacja z pliku
    // Inicjalizacja z pliku
    public void initializeFromFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));

        // Sprawdzenie, czy plik jest pusty
        if (lines.isEmpty()) {
            System.out.println("Plik jest pusty!");
            return;
        }

        // Iteracja po liniach pliku
        for (int i = 0; i < Math.min(r, lines.size()); i++) {
            String line = lines.get(i).trim(); // Usuwanie białych znaków z linii
            for (int j = 0; j < Math.min(k, line.length()); j++) {
                char cell = line.charAt(j);
                // Sprawdzenie, czy znak to '1' lub '0'
                if (cell == '1') {
                    board[i][j] = true;
                } else if (cell == '0') {
                    board[i][j] = false;
                } else {
                    System.out.println("Nieprawidłowy znak w pliku: " + cell);
                    return;
                }
            }
        }
    }


    // Wypisywanie planszy
    public void printBoard() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < k; j++) {
                if (board[i][j]) {
                    System.out.print('1');
                } else {
                    System.out.print('0');
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Liczenie żywych sąsiadów
    private int countAliveNeighbors(int x, int y) {
        int aliveNeighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < r && newY >= 0 && newY < k && board[newX][newY]) {
                    aliveNeighbors++;
                }
            }
        }
        return aliveNeighbors;
    }

    // Generacja następnego stanu
    public void nextGeneration() {
        boolean[][] newBoard = new boolean[r][k];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < k; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);
                if (board[i][j]) {
                    newBoard[i][j] = aliveNeighbors == 2 || aliveNeighbors == 3;
                } else {
                    newBoard[i][j] = aliveNeighbors == 3;
                }
            }
        }
        prevBoard = board;
        board = newBoard;
    }

    // Sprawdzenie stabilności układu
    public boolean isStable() {
        if (prevBoard == null)
        {
            return false;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < k; j++) {
                if (board[i][j] != prevBoard[i][j]) return false;
            }
        }
        return true;
    }

    // Sprawdzenie, czy układ się powtarza
    private boolean isCycle() {
        String currentState = Arrays.deepToString(board);
        if (previousStates.contains(currentState)) return true;
        previousStates.add(currentState);
        return false;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz opcję:");
        System.out.println("Rozpocznij nową grę(1)");
        System.out.println("Wczytaj z pliku(2)");
        System.out.print("Twój wybór: ");
        int choice = scanner.nextInt();

        int r, k;
        System.out.print("Podaj liczbę wierszy: ");
        r = scanner.nextInt();
        System.out.print("Podaj liczbę kolumn: ");
        k = scanner.nextInt();

        Life game = new Life(r, k);

        switch (choice) {
            case 1:
                System.out.print("Podaj ilość żywych komórek: ");
                int aliveCells = scanner.nextInt();
                game.initializeRandom(aliveCells);
                break;

            case 2:
                System.out.print("Podaj nazwę pliku: ");
                String filename = scanner.next();
                game.initializeFromFile(filename);
                break;

            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

        System.out.print("Podaj prędkość (ms): ");
        int speed = scanner.nextInt();

        while (true) {
            game.printBoard();
            if (game.isStable()) {
                System.out.println("Układ jeest stabilny");
                break;
            }
            if (game.isCycle()) {
                System.out.println("Układ sie powtarza");
                break;
            }
            game.nextGeneration();
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
