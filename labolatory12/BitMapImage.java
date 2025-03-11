package labolatory12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
//Łukasz Kundzicz
class BitMapImage {
    private int width, height; // Szerokość i wysokość zdjęcia
    private int[][][] pixels; // Tablica pikseli (RGB)

    public BitMapImage(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[height][width][3]; // Inicjalizuj piksel
    }

    public void setPixel(int x, int y, int r, int g, int b) {
        // Ustaw kolor piksela
        if (x >= 0 && x < width && y >= 0 && y < height) {
            pixels[y][x][0] = r; // Czerwony
            pixels[y][x][1] = g; // Zielony
            pixels[y][x][2] = b; // Niebieski
        }
    }

    public void fillRectangle(int x, int y, int rectWidth, int rectHeight, int r, int g, int b) {
        // Wypełnia prostokąt kolorem
        for (int i = y; i < y + rectHeight; i++) {
            for (int j = x; j < x + rectWidth; j++) {
                setPixel(j, i, r, g, b);
            }
        }
    }

    public void fillCircle(int centerX, int centerY, int radius, int r, int g, int b) {
        // Wypełnia okrąg kolorem
        for (int y = -radius; y <= radius; y++) {
            for (int x = -radius; x <= radius; x++) {
                if (x * x + y * y <= radius * radius) {
                    setPixel(centerX + x, centerY + y, r, g, b);
                }
            }
        }
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int r, int g, int b) {
        // Wypełnia trójkąt kolorem
        int minX = Math.min(x1, Math.min(x2, x3));
        int maxX = Math.max(x1, Math.max(x2, x3));
        int minY = Math.min(y1, Math.min(y2, y3));
        int maxY = Math.max(y1, Math.max(y2, y3));

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                if (isInsideTriangle(x, y, x1, y1, x2, y2, x3, y3)) {
                    setPixel(x, y, r, g, b);
                }
            }
        }
    }

    private boolean isInsideTriangle(int px, int py, int x1, int y1, int x2, int y2, int x3, int y3) {
        // Sprawdza, czy punkt jest w trójkącie
        double areaOrig = triangleArea(x1, y1, x2, y2, x3, y3);
        double area1 = triangleArea(px, py, x2, y2, x3, y3);
        double area2 = triangleArea(x1, y1, px, py, x3, y3);
        double area3 = triangleArea(x1, y1, x2, y2, px, py);
        return Math.abs(areaOrig - (area1 + area2 + area3)) < 0.01;
    }

    private double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Oblicza pole trójkąta
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    public void fillStar(int centerX, int centerY, int size, int r, int g, int b) {
        // Rysuje gwiazdę
        int halfSize = size / 2;
        fillTriangle(centerX - halfSize, centerY, centerX + halfSize, centerY, centerX, centerY - size, r, g, b);
        fillTriangle(centerX - halfSize, centerY, centerX + halfSize, centerY, centerX, centerY + size, r, g, b);
    }

    public void saveToFile(String filename) throws IOException {
        // Zapisuje obraz do pliku
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))) {
            writer.println("P3"); // Nagłówek PPM
            writer.println(width + " " + height); // Rozmiar obrazu
            writer.println("255"); // Maksymalna wartość koloru
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    writer.print(pixels[y][x][0] + " " + pixels[y][x][1] + " " + pixels[y][x][2] + " ");
                }
                writer.println();
            }
        }
    }
}
