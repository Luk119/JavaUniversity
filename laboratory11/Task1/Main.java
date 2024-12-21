package laboratory11.Task1;

//Łukasz Kundzicz
public class Main {
    public static void main(String[] args) {
        generatePolishFlag();
        generateJapaneseFlag();
        generateCzechFlag();
        generateUkrainianFlag();
        generateGermanFlag();
    }

    private static void generatePolishFlag() {
        BitmapImage image = new BitmapImage(800, 500);
        RGB white = new RGB(255, 255, 255);
        RGB red = new RGB(187, 10, 48);
//        RGB red = new RGB(255, 0, 0);

        for (int y = 0; y < 250; y++) {
            for (int x = 0; x < 800; x++) {
                image.setPixelColor(new Pixel(x, y), white);
            }
        }
        for (int y = 250; y < 500; y++) {
            for (int x = 0; x < 800; x++) {
                image.setPixelColor(new Pixel(x, y), red);
            }
        }
        image.saveToFile("laboratory11/Task1/Flags/polska.ppm");
    }

    private static void generateJapaneseFlag() {
        BitmapImage image = new BitmapImage(300, 200);
        RGB white = new RGB(255, 255, 255);
        RGB red = new RGB(188, 0, 45);

        // white background
        for (int y = 0; y < 200; y++) {
            for (int x = 0; x < 300; x++) {
                image.setPixelColor(new Pixel(x, y), white);
            }
        }

        // red circle
        int centerX = 150;
        int centerY = 100;
        int radius = 50;

        for (int y = 0; y < 200; y++) {
            for (int x = 0; x < 300; x++) {
                int dx = x - centerX;
                int dy = y - centerY;
                if (dx * dx + dy * dy <= radius * radius) {
                    image.setPixelColor(new Pixel(x, y), red);
                }
            }
        }
        image.saveToFile("laboratory11/Task1/Flags/japonia.ppm");
    }

    private static void generateCzechFlag() {
        int w = 300;
        int h = 200;

        BitmapImage image = new BitmapImage(w, h);
        RGB white = new RGB(255, 255, 255);
        RGB blue = new RGB(17, 69, 126);
        RGB red = new RGB(215, 20, 26);

        //white and red background
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (y < h/2) {
                    image.setPixelColor(new Pixel(x, y), white);
                } else {
                    image.setPixelColor(new Pixel(x, y), red);
                }
            }
        }

//         upper blue triangle
        for (int y = 0; y < h/2; y++) {
            for (int x = 0; x <= y * 3/2 ; x++) {
                image.setPixelColor(new Pixel(x, y), blue);
            }
        }
//          lower blue triangle
        for (int y = h / 2; y < h; y++) {
            for (int x = 0; x < (h - y) * 3/2; x++) {
                image.setPixelColor(new Pixel(x, y), blue);
            }
        }

        image.saveToFile("laboratory11/Task1/Flags/czechy.ppm");
    }

    private static void generateUkrainianFlag() {
        BitmapImage image = new BitmapImage(300, 200);
        RGB blue = new RGB(0, 87, 183);
        RGB yellow = new RGB(255, 215, 0);

        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 300; x++) {
                image.setPixelColor(new Pixel(x, y), blue);
            }
        }
        for (int y = 100; y < 200; y++) {
            for (int x = 0; x < 300; x++) {
                image.setPixelColor(new Pixel(x, y), yellow);
            }
        }
        image.saveToFile("laboratory11/Task1/Flags/ukraina.ppm");
    }

    private static void generateGermanFlag() {
         BitmapImage image = new BitmapImage(500, 300);
         RGB black = new RGB(0, 0, 0);
         RGB red = new RGB(255, 0, 0);
         RGB yellow = new RGB(255, 202, 0);

         for (int y = 0; y < 100; y++) {
             for (int x = 0; x < 500; x++) {
                 image.setPixelColor(new Pixel(x, y), black);
             }
         }

         for (int y = 100; y < 200; y++) {
             for (int x = 0; x < 500; x++) {
                 image.setPixelColor(new Pixel(x, y), red);
             }
         }

         for (int y = 200; y < 300; y++) {
             for (int x = 0; x < 500; x++) {
                 image.setPixelColor(new Pixel(x, y), yellow);
             }
         }

         image.saveToFile("laboratory11/Task1/Flags/niemcy.ppm");
    }


}
