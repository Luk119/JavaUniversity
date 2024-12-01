package revisionTasks;

import java.io.StringBufferInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
// Task 1
//        System.out.println("Podaj wyraz do odwrócenia: ");
//        String input = scanner.nextLine();
//
//        StringBuilder sb = new StringBuilder(input);
//
//        String reversed = sb.reverse().toString();
//
//        System.out.println("reversed input: " + reversed);

//    Task 2

//        System.out.println("enter a sentence: ");
//        String sentence = scanner.nextLine();
//        String[] words = sentence.split(" ");
//        StringBuilder sb = new StringBuilder();
//
//        for(String word : words){
//            if(!word.isEmpty()){
//                sb.append(word.toUpperCase().charAt(0));
//            }
//        }
//
//            System.out.println(sb);


//    Task 3

//        System.out.println("enter a word: ");
//        String input = scanner.nextLine();
//
//
//        boolean allDigits = true;
//        for(char i: input.toCharArray()){
//            if(!Character.isDigit(i)){
//                allDigits = false;
//            }
//        }
//
//        System.out.println("allDigits: " + allDigits);
//
    // Task 4

//        System.out.println("enter a entence: ");
//        String sentence = scanner.nextLine();
//
//        System.out.println("enter a  word from that sentence: ");
//        String word = scanner.nextLine();
//
//        int index = sentence.indexOf(word);
//
//        System.out.println("word '" + word + "' is on index " + index);


    // Task 5

        System.out.println("enter text: ");
        String input = scanner.nextLine();

        String modify = input.toUpperCase() + "!";

        System.out.println(modify);




    }
}