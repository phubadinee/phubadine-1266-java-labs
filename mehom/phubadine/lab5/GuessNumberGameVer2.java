package mehom.phubadine.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessNumberGameVer2 extends GuessNumberGameVer1 {
    final int MAX_GUESSES = 20;
    protected int[] guesses;
    protected int numGuesses = 0;
    protected int state;
    static Scanner inputState = new Scanner(System.in);
    protected String mode;

    public GuessNumberGameVer2() {
        super();
        guesses = new int[MAX_GUESSES];
    }
    public GuessNumberGameVer2(int minNum, int maxNum) {
        super(minNum, maxNum);
        guesses = new int[MAX_GUESSES];
    }
    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
    }

    @Override
    public void playGame() {
        this.correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));
        // Set tried and State=1 (before playing game)
        tried = 0;
        state = 1;
        System.out.println("Welcome to a number guessing game!");

        while (state == 1) {
            // Check tried
            if (tried != maxTries) {
                // input stage
                System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
                int guessing = input.nextInt();
                while (guessing < minNum || guessing > maxNum) {
                    System.out.print("Your guess should be in [" + minNum + "," + maxNum + "]:");
                    guessing = input.nextInt();
                }
                guesses[tried] = guessing;
                tried += 1;

                // Guess condition stage
                if (guessing == correctNum) {
                    System.out.println("Congratulations!");
                    if (tried == 1) {
                        System.out.println("You have tried " + tried + " time.");
                    } else {
                        System.out.println("You have tried " + tried + " times.");
                    }
                    state = 0;
                } else if (guessing > correctNum) {
                    System.out.println("Try a lower number!");
                } else {
                    System.out.println("Try a higher number!");
                }

            } else {
                System.out.println("You have tried " + tried + " times. You ran out of guesses.");
                System.out.println("The answer is " + correctNum + ".");
                state = 0;
            }
        }
    }

    public void showSpecific() {
        System.out.println("Enter which guess in the range (1-" + tried + ")");
        int index = input.nextInt();    // see index guesses
        System.out.println("Guess number " + index + " is " + guesses[index-1]);
    }

    public void showGuesses() {
        for (int i = 0; i < tried; i++) {
            System.out.print(guesses[i] + " ");
        }
        System.out.println();
    }

    public void playGames() {
        
        mode = "y";
        while (mode.equals("y") || mode.equals("Y")) {

            playGame();

            // Select mode for display [a : list all] and [g : specific guess]
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all guesses or 'g' to see a guess on a specific play.");
            
            mode = inputState.nextLine();    // input mode

            while (!mode.equals("q") && !mode.equals("Y") && !mode.equals("y")) {
                // Mode zone
                if (mode.equals("g") || mode.equals("G")) {
                    showSpecific();
                } else if (mode.equals("a") || mode.equals("A")) {
                    showGuesses();
                } else if (mode.equals("q")) {
                    break;
                }

                System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
                System.out.println("Type 'a' to see all guesses or 'g' to see a guess on a specific play.");
                
                mode = inputState.nextLine();
            }
        }
    }
}
