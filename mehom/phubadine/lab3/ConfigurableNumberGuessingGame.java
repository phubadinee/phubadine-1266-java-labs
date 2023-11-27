package mehom.phubadine.lab3;

import java.util.Scanner;

public class ConfigurableNumberGuessingGame {    
    static int secret, min, max, numTries, maxTries;
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        configure();
        genAnswer();
        playGame();
    }
        
    static void configure(){
        System.out.print("Enter the min value:");
        min = input.nextInt();
        System.out.print("Enter the max value:");
        max = input.nextInt();
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
    }   
    static void genAnswer() {
        secret = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGame(){
        System.out.println("Welcome to a number guessing game!");
        while (true) {

            // Check tried 
            if (numTries != maxTries) {
                // input stage
                System.out.print("Enter an integer between " + min + " and " + max + ":");
                int guessing = input.nextInt();
                numTries += 1;
                // Guess condition stage
                if (guessing == secret) {
                    System.out.println("Congratulations!");
                    if (numTries == 1){
                        System.out.println("You have tried " + numTries + " time.");
                    }else{
                        System.out.println("You have tried " + numTries + " times.");
                    }
                    break;
                } else if (guessing > secret) {
                        System.out.println("Try a lower number!");
                } else {
                    System.out.println("Try a higher number!");     
                }
            
            } else {
                System.out.println("You have tried 5 times. You ran out of guesses.");
                System.out.println("The answer is " + secret + ".");
                break;
            }
        }
        
    }


}
