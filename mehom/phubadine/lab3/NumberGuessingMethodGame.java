package mehom.phubadine.lab3;

import java.util.Scanner;

public class NumberGuessingMethodGame {
    static int secret, tried;

    final static int MIN = 1;
    final static int MAX = 20;
    
    public static void main(String[] args) {
        genAnswer();
        playGame();
    }
        
    static void genAnswer() {
        secret = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
    }

    static void playGame(){
        System.out.println("Welcome to a number guessing game!");
        while (true) {

            // Check tried 
            if (tried != 5) {
                // input stage
                Scanner guess = new Scanner(System.in);
                System.out.print("Enter an integer between " + MIN + " and " + MAX + ":");
                int guessing = guess.nextInt();
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
                System.out.println("The answer is " + secret + ".");
                break;
            }
        }
        
    }


}
