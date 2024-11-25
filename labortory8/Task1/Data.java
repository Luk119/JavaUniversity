package labortory8.Task1;
//Łukasz Kundzicz
// 3. Data
public class Data {
    private int dzien;
    private int miesiac;
    private int rok;

    public Data(int dzien, int miesiac, int rok) {
        this.dzien = dzien;
        this.miesiac = miesiac;
        this.rok = rok;
    }

    @Override
    public String toString() {
        return dzien + "/" + miesiac + "/" + rok;
    }
}

