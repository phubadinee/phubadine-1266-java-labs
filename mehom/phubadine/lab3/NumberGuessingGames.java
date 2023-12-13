package mehom.phubadine.lab3;

import java.util.Scanner;

/*
 * NumberGuessingGame
 * input : Guess Number (int)
 * output : if input == guess show "Congratulations"
 *          if input > guess show "Try a lower number!"
 *          if input < guess show "Try a higher number!"
 * 
 * This program to check guessing and only guess between min max
 * can't input max < min , and maxtries = 0 and < 0
 * 
 * Configure : min, max, maxTries
 * Gen Answer : type(int) between min max
 * Play Game : enter your guessing to the game
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class NumberGuessingGames {
    static int secret, min, max, numTries, maxTries;
    static int state = 1;
    static Scanner input = new Scanner(System.in);
    static Scanner input_state = new Scanner(System.in);
    public static void main(String[] args) {
        configure();
        genAnswer();
        playGame();
    }

    static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();

        System.out.print("Enter the max value:");
        max = input.nextInt();
        while (max < min) { // Run when max < min
            // Enter new max
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }

        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
        while (maxTries <= 0) { // Run when maxTries < 0 
            // Enter new maxTries
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
        }
    }

    static void genAnswer() {
        // Random answer between min -> max
        secret = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGame() {
        // Set flag for running in while loop
        String flag = "y";

        while (flag.equals("y") || flag.equals("Y")) {
            // Random answer
            genAnswer();

            // Set numTries and State=1 (before playing game)
            numTries = 0;
            state = 1;
            System.out.println("Welcome to a number guessing game!");

            while (state == 1) {

                // Check tried
                if (numTries != maxTries) {
                    // input stage
                    System.out.print("Enter an integer between " + min + " and " + max + ":");
                    int guessing = input.nextInt();

                    while (guessing < min || guessing > max) {
                        System.out.println("The number must be between " + min + " and " + max);
                        System.out.print("Enter an integer between " + min + " and " + max + ":");
                        guessing = input.nextInt();
                    }
                    numTries += 1;

                    // Guess condition stage
                    if (guessing == secret) {
                        System.out.println("Congratulations!");
                        if (numTries == 1) {
                            System.out.println("You have tried " + numTries + " time.");
                        } else {
                            System.out.println("You have tried " + numTries + " times.");
                        }
                        state = 0;      // Set state for exit
                    } else if (guessing > secret) {
                        System.out.println("Try a lower number!");
                    } else {
                        System.out.println("Try a higher number!");
                    }

                } else {
                    // Display after final game
                    if (maxTries == 1){
                        System.out.println("You have tried " + maxTries + " time. You ran out of guesses.");
                    }else{
                        System.out.println("You have tried " + maxTries +" times. You ran out of guesses.");
                    }
                    System.out.println("The answer is " + secret + ".");

                    state = 0;      // Set state for exit
                }
            }
            System.out.print("Want to play again (Y or y):");
            flag = input_state.nextLine();
        }
        System.out.println("Thank you for playing our games. Bye!");
    }
}
