package mehom.phubadine.lab5;

import java.util.Scanner;

/*
 * GuessNumberGameVer1
 * Program for Guessing Number
 * Class has get and set variable and playGame method
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class GuessNumberGameVer1 {

    // Variable type of value
    protected int minNum, maxNum, maxTries;
    protected int correctNum;
    protected static int numOfGames = 0;
    Scanner input = new Scanner(System.in);
    protected int tried, guessing;

    // Constructor
    public GuessNumberGameVer1() {
        this.minNum = 1;
        this.maxNum = 10;
        this.maxTries = 3;
        this.numOfGames += 1;   // Increment total number of games   
    }
    
    public GuessNumberGameVer1(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = 3;
        this.numOfGames += 1;
    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        this.numOfGames += 1;
    }

    public void playGame() {
        this.correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));
        tried = 0;
        System.out.println("Welcome to a number guessing game!");
        
        // Start Game
        while (true) {
            // Check tried 
            if (tried != maxTries) {
                // input stage
                System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
                guessing = input.nextInt();
                tried += 1;
                
                // Guess condition stage
                if (guessing == correctNum) {
                    System.out.println("Congratulations!");
                    if (tried == 1){
                        System.out.println("You have tried " + tried + " time.");
                    }else{
                        System.out.println("You have tried " + tried + " times.");
                    }
                    break;
                } else if (guessing > correctNum) {
                        System.out.println("Try a lower number!");
                } else {
                    System.out.println("Try a higher number!");     
                }
            
            } else {
                System.out.println("You have tried " + tried + " times. You ran out of guesses.");
                System.out.println("The answer is " + correctNum + ".");
                break;
            }
        }
    }


    // Getters and Setters
    public int getMinNum() {
        return this.minNum; 
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return this.maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return this.maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    
    @Override
    public String toString() {
        return "GuessNumberGame with minNum number as " + minNum + " maxNum number as " + maxNum + " maxNum number of tries as " + maxTries;
    }

    static public int getNumOfGames() {
        return numOfGames;
    }
    
}
