package laboratory9.Task1;

public class Interval<Key extends Comparable<Key>> {
    private final Key min;    // min endpoint
    private final Key max;    // max endpoint

    public Interval(Key min, Key max) {
        if (less(max, min)) throw new RuntimeException("Illegal argument");
        this.min = min;
        this.max = max;
    }

    public Key min() {
        return min;
    }

    public Key max() {
        return max;
    }

    public boolean contains(Key x) {
        return !less(x, min) && !less(max, x);
    }

    public boolean intersects(Interval<Key> b) {
        Interval<Key> a  = this;
        if (less(a.max, b.min)) return false;
        if (less(b.max, a.min)) return false;
        return true;
    }

    public boolean equals(Interval<Key> b) {
        Interval<Key> a  = this;
        return a.min.equals(b.min) && a.max.equals(b.max);
    }

    private boolean less(Key x, Key y) {
        return x.compareTo(y) < 0;
    }

    public String toString() {
        return "[" + min + ", " + max + "]";
    }
}
