package laboratory11.Task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Łukasz Kundzicz
public class BitmapImage {

    private int width;
    private int height;
    private Map<Pixel, RGB> pixels;

    public BitmapImage(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new HashMap<>();
    }

    public void setPixelColor(Pixel p, RGB rgb) {
        if (p.getX() < 0 || p.getX() >= width || p.getY() < 0 || p.getY() >= height) {
            throw new IllegalArgumentException("Pixel coordinates are out of bounds.");
        }
        pixels.put(p, rgb);
    }

    public void saveToFile(String fname) {
        try (FileWriter writer = new FileWriter(fname)) {
            // Nagłówek pliku PPM
            writer.write("P3\n");
            writer.write(width + " " + height + "\n");
            writer.write("255\n");

            // Dane pikseli
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Pixel p = new Pixel(x, y);
                    RGB color = pixels.getOrDefault(p, new RGB(255, 255, 255)); // Domyślny kolor: biały
                    writer.write(color.toString() + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
}
