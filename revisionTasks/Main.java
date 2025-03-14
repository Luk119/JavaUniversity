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

//        System.out.println("enter text: ");
//        String input = scanner.nextLine();
//
//        String modify = input.toUpperCase() + "!";
//
//        System.out.println(modify);

    // Task 6

//        System.out.println("Enter first text: ");
//        String firstInput = scanner.nextLine();
//
//        System.out.println("Enter first text: ");
//        String secondInput = scanner.nextLine();
//
//        boolean isEqual = false;
//
//        if(firstInput.equalsIgnoreCase(secondInput)){
//            isEqual = true;
//        }
//
//        System.out.println("isEqual: " + isEqual);

    // Task 7

//        System.out.println("enter a text: ");
//        String input = scanner.nextLine();
//
//        System.out.println("enter a digit: ");
//        int index = scanner.nextInt() - 1;
//
//        System.out.println(digitOrLetter(input, index));

    // Task 8

//        System.out.println("enter a text: ");
//        String text = scanner.nextLine();
//
//        char[] textCharArray = text.toCharArray();
//
//        String reversed = "";
//        for(int i=textCharArray.length-1; i>=0; i--){
//            reversed += textCharArray[i];
//        }
//
//        System.out.println(reversed);

    // Task 9


//        System.out.println("enter a word: ");
//        String text = scanner.nextLine();
//
//        System.out.println("enter a character to insert: ");
//        char character = scanner.nextLine().charAt(0);
//
//        System.out.println("enter an index: ");
//        int index = scanner.nextInt();
//
//        if(index < 0 || index > text.length()){
//            System.out.println("wrong index");
//        }
//
//        StringBuilder sb = new StringBuilder(text);
//        sb.insert(index, character);
//
//        System.out.println(sb);

    // Task 10

        System.out.println("enter a word with different letter sizes: ");
        String word = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for(char w : word.toCharArray()){

            if(Character.isUpperCase(w)){
                sb.append(Character.toLowerCase(w));
            }
            else if(Character.isLowerCase(w)){
                sb.append(Character.toUpperCase(w));
            }
            else{
                sb.append(w);
            }
        }

        System.out.println(sb);

    }

    public static String digitOrLetter(String text, int index){

        if (index > text.length() || index < 0) {
            return "wrong index";
        }

        char myChar = text.charAt(index);

        if(Character.isDigit(myChar)){
            return "it's digit";
        }
        else if(Character.isLetter(myChar)){
            return "i'ts letter";
        }
        else{
            return "it's other symbol";
        }
    }
}