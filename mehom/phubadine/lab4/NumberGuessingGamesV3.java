package mehom.phubadine.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * NumberGuessingGames
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class NumberGuessingGamesV3 {
    static int secret, min, max, numTries, maxTries;
    static int state = 1;
    static Scanner input = new Scanner(System.in);
    static Scanner input_state = new Scanner(System.in);
    static String select;
    static int index;
    static boolean status, option;
    static int totalGame, totalWins, totalNumTries, highScore;
    static double winRatio, avgPerGame;

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
        while (max < min) {
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }

        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
        while (maxTries <= 0) {
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
        }
    }

    static void genAnswer() {
        secret = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGame() {
        totalWins = 0;
        highScore = maxTries;
        String flag = "y";

        while (flag.equals("y") || flag.equals("Y")) {
            genAnswer();

            numTries = 0;
            totalGame += 1;
            state = 1;

            List<Integer> answer = new ArrayList<Integer>();

            // Start Game!
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
                    totalNumTries += 1;
                    numTries += 1;

                    // Guess condition stage
                    if (guessing == secret) {
                        System.out.println("Congratulations!");
                        totalWins += 1;
                        if (numTries == 1) {
                            System.out.println("You have tried " + numTries + " time.");
                        } else {
                            System.out.println("You have tried " + numTries + " times.");
                        }
                        if (numTries < highScore) {
                            highScore = numTries;
                            option = true;
                        } else if (highScore == maxTries) {
                            option = false;
                        }
                        status = true;
                        state = 0;
                    } else if (guessing > secret) {
                        System.out.println("Try a lower number!");
                    } else {
                        System.out.println("Try a higher number!");
                    }

                } else {
                    System.out.print("You ran out of guesses.");
                    System.out.println("The answer was " + secret + ".");
                    status = false;
                    state = 0;
                }
            }

            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit:");
            select = input_state.nextLine();
            while (select.equals("a") || select.equals("g")) {
                if (select.equals("a")) {
                    System.out.println("All guesses:");
                    for (int i : answer) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                } else if (select.equals("g")) {
                    System.out.println("Enter the number of the guess you want to see (1-" + answer.size() + "):");
                    index = input.nextInt();
                    System.out.println("Guess " + index + ": " + answer.get(index - 1));
                }
                System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit:");
                select = input_state.nextLine();
            }

            Gamelog();
            System.out.print("Want yo play again (Y or y):");
            flag = input_state.nextLine();
        }
        GameStatistics(option);
        // System.out.println("Thank you for playing our games. Bye!");
    }

    static void Gamelog() {
        System.out.print("Game Log: ");
        System.out.print("Answer: " + secret);
        System.out.print(", Guesses: " + numTries);
        System.out.println(", Win: " + status);
    }

    static void GameStatistics(boolean option) {

        winRatio = (double) totalWins / (double) totalGame;
        avgPerGame = (double) totalNumTries / (double) totalGame;
        System.out.println("----- Game Statistics -----");
        System.out.println("Total games played: " + totalGame);
        System.out.println("Total wins: " + totalWins);
        System.out.println("Win Ratio: " + winRatio + "%");
        System.out.println("Average guess per game:" + avgPerGame);
        if (option == true) {
            System.out.println("High Score (Least Gusses): " + highScore);
        }else{
            System.out.println("High Score (Least Gusses): N/A");
        }
        
    }
}
