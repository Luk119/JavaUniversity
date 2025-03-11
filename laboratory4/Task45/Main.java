package laboratory4.Task45;

//ŁukaszKundzicz
public class Main {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(9);
        Matrix matrix2 = new Matrix(4);
        matrix.generuj();
        matrix2.generuj();

        System.out.println(matrix);
        System.out.println(matrix.det());
        System.out.println("\n\n");
        System.out.println(matrix.wytnijWierszKolumne(1, 1));

        System.out.println(matrix2.odwracalna());

    }
}
