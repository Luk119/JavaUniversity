package labolatory3.Task7;

class Person {

    private static int numberOfPeople = 0;
    private String name;
    private int age;

//    static{
//        System.out.println("Static block has been executed.");
//        numberOfPeople = 0;
//    }
    Person(){

    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
        numberOfPeople++;
    }

    void printNumberOfPeople(){
        System.out.println(numberOfPeople);
    }
}
