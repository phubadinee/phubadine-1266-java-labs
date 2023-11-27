package mehom.phubadine.lab3;

import java.util.Scanner;

/*
 * NumberGuessingGame
 * input : Guess Number (int)
 * output : if input == guess show "Congratulations"
 *          if input > guess show "Try a lower number!"
 *          if input < guess show "Try a higher number!"
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class NumberGuessingGame {

    public static void main(String[] args) {
        int min = 1, max = 20, guessing, tried = 0;
        int secret = min + (int) (Math.random() * ((max - min) + 1));

        System.out.println("Secret: " + secret);

        System.out.println("Welcome to a number guessing game!");

        while (true) {

            // Check tried 
            if (tried != 5) {
                // input stage
                Scanner guess = new Scanner(System.in);
                System.out.print("Enter an integer between " + min + " and " + max + ":");
                guessing = guess.nextInt();
                tried += 1;
                
                // Guess condition stage
                if (guessing == secret) {
                    System.out.println("Congratulations!");
                    if (tried == 1){
                        System.out.println("You have tried " + tried + " time.");
                    }else{
                        System.out.println("You have tried " + tried + " times.");
                    }
                    break;
                } else if (guessing > secret) {
                        System.out.println("Try a lower number!");
                } else {
                    System.out.println("Try a higher number!");     
                }
            
            } else {
                System.out.println("You have tried 5 times. You ran out of guesses.");
                System.out.println("The answer is " + secret);
                break;
            }
        }
    }
}