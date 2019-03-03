package VideoCodeAlong;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);


        long num = 0;
        do {
            System.out.print(" Please give the desired factorial :");
            try {
                num = Long.parseLong(userInput.nextLine());
                if (num > 0) System.out.println(num +"! = " + factorial(num));
            } catch (NumberFormatException e){
                System.out.println("That was not a valid input, valid in put would be any non-zero positive integer");
                num = 0;
            }


        } while (num == 0);

    }//main

    public static long factorial(long num){
        if(num!=1){
        return num * factorial(num-1);
        } else return 1;
    }

}//Factorial
