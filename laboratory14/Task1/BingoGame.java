package laboratory14.Task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

//Łukasz Kundzicz
public class BingoGame extends JFrame {
    private static final int GRID_SIZE = 5;
    private static final int MAX_NUMBER = 75;
    private JButton[][] buttons = new JButton[GRID_SIZE][GRID_SIZE];
    private boolean[][] marked = new boolean[GRID_SIZE][GRID_SIZE];
    private Set<Integer> drawnNumbers = new HashSet<>();

    public BingoGame() {
        setTitle("Bingo Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        initializeBoard(boardPanel);

        JButton drawButton = new JButton("Draw Number");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawNumber();
            }
        });

        add(boardPanel, BorderLayout.CENTER);
        add(drawButton, BorderLayout.SOUTH);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeBoard(JPanel boardPanel) {
        List<List<Integer>> columns = generateBingoNumbers();

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                int number = (i == 2 && j == 2) ? 0 : columns.get(j).get(i); // Joker in the center
                JButton button = new JButton(i == 2 && j == 2 ? "Joker" : String.valueOf(number));
                button.setBackground(i == 2 && j == 2 ? Color.ORANGE : Color.WHITE);
                button.addActionListener(new ButtonClickListener(i, j));
                buttons[i][j] = button;
                marked[i][j] = (i == 2 && j == 2); // Joker is pre-marked
                boardPanel.add(button);
            }
        }
    }

    private List<List<Integer>> generateBingoNumbers() {
        List<List<Integer>> columns = new ArrayList<>();

        for (int i = 0; i < GRID_SIZE; i++) {
            List<Integer> column = new ArrayList<>();
            int start = i * 15 + 1;
            int end = start + 15;
            for (int j = start; j < end; j++) {
                column.add(j);
            }
            Collections.shuffle(column);
            columns.add(new ArrayList<>(column.subList(0, GRID_SIZE))); //Pick first 5 numbers
            Collections.sort(columns.get(i)); //Sort for better user experience
        }

        return columns;
    }

    private void drawNumber() {
        if (drawnNumbers.size() >= MAX_NUMBER) {
            JOptionPane.showMessageDialog(this, "All numbers have been drawn!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int number;
        do {
            number = (int) (Math.random() * MAX_NUMBER) + 1;
        } while (drawnNumbers.contains(number));

        drawnNumbers.add(number);
        JOptionPane.showMessageDialog(this, "Drawn Number: " + number, "Draw", JOptionPane.INFORMATION_MESSAGE);

        //Highlight matching numbers on the board
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (buttons[i][j].getText().equals(String.valueOf(number))) {
                    //Set background color to green for the drawn number
                    buttons[i][j].setBackground(Color.GREEN);
                    buttons[i][j].setOpaque(true);
                    buttons[i][j].setBorderPainted(false); //Optionally hide button
                    marked[i][j] = true; //Automatically mark the cell if drawn number are same

                    //Refresh the button
                    buttons[i][j].revalidate();
                    buttons[i][j].repaint();
                }
            }
        }

        //Check for Bingo
        if (checkBingo()) {
            JOptionPane.showMessageDialog(this, "Bingo!", "Winner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean checkBingo() {
        //Check rows and columns
        for (int i = 0; i < GRID_SIZE; i++) {
            if (checkRow(i) || checkColumn(i)) {
                showWinDialog();
                return true;
            }
        }
        //Check diagonals
        if (checkMainDiagonal() || checkAntiDiagonal()) {
            showWinDialog();
            return true;
        }
        return false;
    }

    private boolean checkRow(int row) {
        for (int col = 0; col < GRID_SIZE; col++) {
            if (!marked[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (!marked[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkMainDiagonal() {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (!marked[i][i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal() {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (!marked[i][GRID_SIZE - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private void showWinDialog() {
        //Ask if player wants to play again or quit
        int response = JOptionPane.showOptionDialog(
                this,
                "Bingo! Do you want to play again?",
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[] { "New Game", "Exit" },
                "New Game");

        if (response == JOptionPane.YES_OPTION) {
            startNewGame();
        } else {
            System.exit(0); //Exit app
        }
    }

    private void startNewGame() {
        //Reset drawn numbers
        drawnNumbers.clear();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                marked[i][j] = false;
                buttons[i][j].setBackground(Color.WHITE); //Reset background color
                buttons[i][j].setOpaque(false); //Remove background color
                buttons[i][j].setBorderPainted(true); //Restore button
            }
        }
        JOptionPane.showMessageDialog(this, "The game has been reset. Start a new game!", "New Game", JOptionPane.INFORMATION_MESSAGE);
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = buttons[row][col];
            String buttonText = clickedButton.getText();

            //Check if button is not joker and if text is int
            try {
                int number = Integer.parseInt(buttonText);

                //Check if number was drawn
                if (drawnNumbers.contains(number)) {
                    if (!marked[row][col]) {
                        marked[row][col] = true; //Marking num

                        //Green background
                        clickedButton.setBackground(Color.GREEN);
                        clickedButton.setOpaque(true);
                        clickedButton.setBorderPainted(false);

                        //GUI reset
                        clickedButton.revalidate();
                        clickedButton.repaint();

                        //Bingo check
                        if (checkBingo()) {
                            JOptionPane.showMessageDialog(BingoGame.this, "Bingo!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(BingoGame.this, "This field is already marked!", "Info", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(BingoGame.this, "This number hasn't been drawn yet!", "Info", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                //If text is joker
                if ("Joker".equals(buttonText)) {
                    //If joker nothing changes
                    JOptionPane.showMessageDialog(BingoGame.this, "You clicked the Joker!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //We can ignore that(program do not include more options)
                }
            }
        }
    }
}
