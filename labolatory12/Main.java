package labolatory12;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        BitMapImage image = new BitMapImage(600, 800);

        // Tło
        image.fillRectangle(0, 0, 600, 800, 15, 40, 140);

        // Śnieg na dole
        image.fillRectangle(0, 750, 600, 50, 255, 255, 255);

        // Pień
        image.fillRectangle(280, 600, 40, 150, 101, 67, 33);

        // Warstwy choinki
        image.fillTriangle(300, 150, 250, 300, 350, 300, 0, 100, 0); // Górna warstwa
        image.fillTriangle(300, 250, 200, 450, 400, 450, 0, 120, 0); // Środkowa warstwa
        image.fillTriangle(300, 400, 150, 650, 450, 650, 0, 140, 0); // Dolna warstwa

        // Bombki na choince
        image.fillCircle(275, 200, 10, 255, 0, 0);   // Czerwona bombka
        image.fillCircle(360, 450, 10, 255, 0, 0);   // Czerwona bombka 2
        image.fillCircle(325, 350, 10, 0, 0, 255);   // Niebieska bombka
        image.fillCircle(250, 500, 10, 255, 255, 0); // Żółta bombka
        image.fillCircle(320, 230, 10, 255, 255, 0); // Żółta bombka 2
        image.fillCircle(350, 550, 10, 255, 165, 0); // Pomarańczowa bombka
        image.fillCircle(300, 600, 10, 75, 0, 130);  // Fioletowa bombka
        image.fillCircle(290, 400, 10, 75, 0, 130);  // Fioletowa bombka 2

        // Gwiazda na szczycie
        image.fillStar(300, 100, 50, 255, 215, 0);

        // Zapis do pliku w PPM
        try {
            image.saveToFile("labolatory12/choinka.ppm");
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania pliku: " + e.getMessage());
        }
    }
}
