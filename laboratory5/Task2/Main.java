package laboratory5.Task2;

import laboratory5.Task3.Figura3D;
import laboratory5.Task3.Kula;
import laboratory5.Task3.Prostopadloscian;

public class Main {
    public static void main(String[] args) {
        Figura prostokat = new Prostokat(5, 3);
        Figura kolo = new Kolo(4);
        Figura trojkat = new Trojkat(3, 3, 4, 5);

        Figura3D kula = new Kula(2);
        Figura3D prostopadloscian = new Prostopadloscian(3, 2, 3);

        System.out.println(prostokat);
        System.out.println(kolo);
        System.out.println(trojkat);
        System.out.println(kula);
        System.out.println(prostopadloscian);

    }
}