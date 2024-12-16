package laboratory11.Task1;

// Łukasz Kundzicz
public class Pixel {

    private int x;
    private int y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Pixel pixel = (Pixel) obj;
        return x == pixel.x && y == pixel.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
