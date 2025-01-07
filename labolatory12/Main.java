package labolatory12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
public class Main {
    public static void main(String[] args) {
        BitmapImage image = new BitmapImage(600, 800);

        // Background
        image.fillRectangle(0, 0, 600, 800, 15, 40, 70); // Dark blue background

        // Snow at the bottom
        image.fillRectangle(0, 750, 600, 50, 255, 255, 255); // White snow

        // Tree base (trunk)
        image.fillRectangle(280, 600, 40, 150, 101, 67, 33); // Brown trunk

        // Tree layers (narrower at the top, wider at the bottom)
        image.fillTriangle(300, 150, 250, 300, 350, 300, 0, 100, 0); // Top layer
        image.fillTriangle(300, 250, 200, 450, 400, 450, 0, 120, 0); // Middle layer
        image.fillTriangle(300, 400, 150, 650, 450, 650, 0, 140, 0); // Bottom layer

        // Ornaments (colorful balls)
        image.fillCircle(275, 200, 10, 255, 0, 0);   // Red ornament
        image.fillCircle(325, 350, 10, 0, 0, 255);   // Blue ornament
        image.fillCircle(250, 500, 10, 255, 255, 0); // Yellow ornament
        image.fillCircle(350, 550, 10, 255, 165, 0); // Orange ornament
        image.fillCircle(300, 600, 10, 75, 0, 130);  // Purple ornament

        // Star on top of the tree
        image.fillStar(300, 100, 50, 255, 215, 0); // Golden star

        try {
            image.saveToFile("labolatory12/choinka.ppm");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
