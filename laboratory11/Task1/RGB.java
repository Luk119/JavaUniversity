package laboratory11.Task1;

// Łukasz Kundzicz
public class RGB {

    public int red, green, blue;

    public RGB(int red, int green, int blue) {
        if(red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
            throw new IllegalArgumentException("RGB values should be between 0 and 255.");
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed(){
        return red;
    }

    public int getGreen(){
        return green;
    }

    public int getBlue(){
        return blue;
    }

    @Override
    public String toString() {
        return "red: " + red + "\ngreen: " + green + "\nblue: " + blue;
    }
}
