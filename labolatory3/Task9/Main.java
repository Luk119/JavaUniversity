package labolatory3.Task9;

public class Main extends Square {
    public static void main(String[] args){

        Square s1 = new Square();
        s1.setA(3.3);
        System.out.println(s1.getA());


        System.out.println(s1);

        Square[] arrayOfSquares = new Square[5];

        for(int i=0; i < 5; i++){
            arrayOfSquares[i] = new Square(i);
        }

        for(Square square: arrayOfSquares){
            System.out.println(square);
        }

    }
}
