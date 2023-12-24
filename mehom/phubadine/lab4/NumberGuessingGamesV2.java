package mehom.phubadine.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * NumberGuessingGamesV2
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
 * Post-Game Guess Review: Upon the game's conclusion (regardless of whether the player guesses correctly or depletes all attempts), the player is provided with various options to review their guesses.
    'a' Option: Selecting this option displays a comprehensive list of all guesses made by the player throughout the game.
    'g' Option: This option allows the player to choose and view a specific guess.
    Exit Feature: Any other keypress will exit the program.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class NumberGuessingGamesV2 {
    // Variable type of value
    static int secret, min, max, numTries, maxTries;
    static int state = 1;
    static Scanner input = new Scanner(System.in);
    static Scanner inputState = new Scanner(System.in);
    static String select;
    static int index;

    public static void main(String[] args) {
        // Calling method
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
            // collect answer from user input 
            List<Integer> answer = new ArrayList<Integer>();

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
                        System.out.print("Your guess should be in [" + min + "," + max + "]:");
                        guessing = input.nextInt();
                    }
                    answer.add(guessing);
                    numTries += 1;

                    // Guess condition stage
                    if (guessing == secret) {
                        System.out.println("Congratulations!");
                        // if (numTries == 1) {
                        //     System.out.println("You have tried " + numTries + " time.");
                        // } else {
                        //     System.out.println("You have tried " + numTries + " times.");
                        // }
                        state = 0;
                    } else if (guessing > secret) {
                        System.out.println("Try a lower number!");
                    } else {
                        System.out.println("Try a higher number!");
                    }

                } else {
                    System.out.print("You ran out of guesses.");
                    System.out.println("The answer was " + secret + ".");
                    state = 0;
                }
            }

            // Select mode for display [a : list all] and [g : specific guess]
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
            select = inputState.nextLine();    // input mode
            // Mode zone
            while (select.equals("a") || select.equals("g")) {
                if (select.equals("a")) {   // display all guesses
                    System.out.println("All guesses:");
                    for (int i : answer) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                } else if (select.equals("g")) {    // display specific guesses
                    System.out.print("Enter the number of the guess you want to see (1-" + answer.size() + "): ");
                    index = input.nextInt();    // see index guesses
                    System.out.println("Guess " + index + ": " + answer.get(index - 1));
                }
                // new input for mode and enter any key to exit
                System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
                select = inputState.nextLine();
            }
            // enter flag to play again or exit
            System.out.print("Want yo play again (Y or y):");
            flag = inputState.nextLine();
        }
        System.out.println("Thank you for playing our games. Bye!");
    }
}
