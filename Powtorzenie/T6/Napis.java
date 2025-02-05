package Powtorzenie.T6;

public class Napis implements Comparable<Napis> {
    int napis;

    public Napis(int napis) {
        this.napis = napis;
    }

    @Override
    public int compareTo(Napis o) {
        return (this.napis - o.napis)*-1;
    }

    @Override
    public String toString() {
        return this.napis + "";
    }
}
