package Powtorzenie.T1;

public class Main {
    public static void main(String[] args) {

        try{
            if(args.length != 2){
                throw new IllegalArgumentException("Wrong number of arguments");
            }

            System.out.println(Double.parseDouble(args[0]) + Double.parseDouble(args[1]));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
