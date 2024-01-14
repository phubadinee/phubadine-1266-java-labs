package mehom.phubadine.lab5;

/*
 * GuessNumberGameVer3
 * Program for Guessing Number
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {

    // Variable type of value
    protected double avgGuesses;
    protected int sumGuesses, minGuesses, maxGuesses;

    // Constructor
    public GuessNumberGameVer3() {
        super();
    }
    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
    }
    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    // Start Game Method
    @Override
    public void playGames() {

        // set mode for start while loop
        mode = "y";
        while (mode.equals("y") || mode.equals("Y")) {

            playGame();

            // Select mode for display [a : list all] and [g : specific guess]
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all guesses or 'g' to see a guess on a specific play.");
            System.out.println("Type 'v' to display of all the guesses, 'm' to show the minimun of the guesses, or 'x' show the maximum of the guesses");

            mode = inputState.nextLine();    // input mode

            while (!mode.equals("q") && !mode.equals("Y") && !mode.equals("y")) {
                // Mode zone
                if (mode.equals("g") || mode.equals("G")) {
                    showSpecific(); // get guess from index
                } else if (mode.equals("a") || mode.equals("A")) {
                    showGuesses(); // show all guess
                } else if (mode.equals("v") || mode.equals("V")) {
                    System.out.println("Average = " + guessAverage());  // show avg guess
                } else if (mode.equals("m") || mode.equals("M")) {
                    System.out.println("Min = " + guessMin());  // show min guess
                } else if (mode.equals("x") || mode.equals("X")) {
                    System.out.println("Max = " + guessMax());  // show max guess
                } else if (mode.equals("q")) {
                    break;  // exit
                } else {
                    System.out.println("Invalid command");
                }

                System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
                System.out.println("Type 'a' to see all guesses or 'g' to see a guess on a specific play.");
                System.out.println("Type 'v' to display of all the guesses, 'm' to show the minimun of the guesses, or 'x' show the maximum of the guesses");
               
                // get state
                mode = inputState.nextLine();
            }
        }
    }

    // Calculate Guess Average
    public double guessAverage() {
        // Base sum
        sumGuesses = 0;
        for (int i = 0; i < tried; i++) {
            sumGuesses += guesses[i];
        }
        avgGuesses = (double) sumGuesses / (double) tried;  // cal avg
        return avgGuesses;
    }

    // Find Guess Min
    public int guessMin() {
        minGuesses = maxNum;
        for (int i = 0; i < tried; i++) {
            if (guesses[i] < minGuesses) {
                minGuesses = guesses[i];    // Set new min
            }
        }
        return minGuesses;
    }
    
    // Find Guess Max
    public int guessMax() {
        maxGuesses = minNum;    // set start max = min
        for (int i = 0; i < tried; i++) {
            if (guesses[i] > maxGuesses) {
                maxGuesses = guesses[i];    // Set new max
            }
        }
        return maxGuesses;
    }
}
