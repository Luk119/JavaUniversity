package laboratory1.Task3;
import java.util.Scanner;
//3. W klasie MinMax3 rozwiazac podany problem:
//Uzytkownik podaje liczbe trzycyfrowa (czyli pomiedzy 111 a 999).
//Program znajduje odpowiednio najmniejsza i najwieksza liczbe o cyfrach
//z zadanej liczby, a nastepnie liczy roznice najwiekszej i najmniejszej,
//wypisuje ja na ekran i pretwarza analogicznie dalej.
// Program powinien sie zatrzymac, gdy liczby staja sie takie same.
public class MinMax3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 3 digit value:");
        int value = scanner.nextInt();

        if(value > 999 || value < 111){
            System.out.println("Error");
        }
        else{
            int minimum = Min(value);
            int maximum = Max(value);
            System.out.println(maximum - minimum);
        }

    }
    public static int Min(int value){
        int min=9;
        for(int i=3; i<0; i++){
            if(value%10 < min){min=value%10;}
            value/=10;
        }
        return min;
    }
    public static int Max(int value){
        int max=0;
        for(int i=3; i<0; i++){
            if(value%10 > max){max=value%10;}
            value/=10;
        }
        return max;
    }
}
