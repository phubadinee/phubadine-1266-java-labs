package mehom.phubadine.lab5;

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {

    protected double avgGuesses;
    protected int sumGuesses, minGuesses, maxGuesses;

    public GuessNumberGameVer3() {
        super();
    }
    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
    }
    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public void playGames() {
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
                    showSpecific();
                } else if (mode.equals("a") || mode.equals("A")) {
                    showGuesses();
                } else if (mode.equals("v") || mode.equals("V")) {
                    System.out.println("Average = " + guessAverage());
                } else if (mode.equals("m") || mode.equals("M")) {
                    System.out.println("Min = " + guessMin());
                } else if (mode.equals("x") || mode.equals("X")) {
                    System.out.println("Max = " + guessMax());
                } else if (mode.equals("q")) {
                    break;
                } else {
                    System.out.println("Invalid command");
                }

                System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
                System.out.println("Type 'a' to see all guesses or 'g' to see a guess on a specific play.");
                System.out.println("Type 'v' to display of all the guesses, 'm' to show the minimun of the guesses, or 'x' show the maximum of the guesses");
                
                mode = inputState.nextLine();
            }
        }
    }
    public double guessAverage() {
        sumGuesses = 0;
        for (int i = 0; i < tried; i++) {
            sumGuesses += guesses[i];
        }
        avgGuesses = (double) sumGuesses / (double) tried;
        return avgGuesses;
    }

    public int guessMin() {
        minGuesses = maxNum;
        for (int i = 0; i < tried; i++) {
            if (guesses[i] < minGuesses) {
                minGuesses = guesses[i];
            }
        }
        return minGuesses;
    }
    
    public int guessMax() {
        maxGuesses = minNum;
        for (int i = 0; i < tried; i++) {
            if (guesses[i] > maxGuesses) {
                maxGuesses = guesses[i];
            }
        }
        return maxGuesses;
    }
}
