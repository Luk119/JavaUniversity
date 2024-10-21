package labolatory3.Tasks123456_8;

//Łukasz Kundzicz
public class Main extends Rectangle {
    public static void main(String[] args){

        Rectangle rectangle1 = new Rectangle(3);
        Rectangle rectangle2 = new Rectangle(1, 3);
        Rectangle rectangle3 = new Rectangle(9, 7);

        rectangle1.setLength(1);
        rectangle2.setLength(3);
        rectangle3.setLength(1);

        rectangle1.setWidth(1);
        rectangle2.setWidth(3);
        rectangle3.setWidth(5);

        System.out.println("rectangle1:" + rectangle1.getLength());
        System.out.println("rectangle2:" + rectangle2.getLength());
        System.out.println("rectangle3:" + rectangle3.getLength());

        System.out.println("rectangle1:" + rectangle1.getWidth());
        System.out.println("rectangle2:" + rectangle2.getWidth());
        System.out.println("rectangle3:" + rectangle3.getWidth());

        rectangle1.print();
        rectangle2.print();
        rectangle3.print();

        System.out.println(rectangle1.getArea());
        System.out.println(rectangle2.getArea());
        System.out.println(rectangle3.getArea());

        System.out.println(rectangle1.getCircuit());
        System.out.println(rectangle2.getCircuit());
        System.out.println(rectangle3.getCircuit());

        rectangle1.print();
        Rectangle[] array = {rectangle1, rectangle2, rectangle3};

        for(Rectangle p : array){
            p.print();
        }


        System.out.println("\n\n");
        Rectangle r1 = new Rectangle(1,-2, 3,-3);
        System.out.println(r1.getArea());
    }
}
