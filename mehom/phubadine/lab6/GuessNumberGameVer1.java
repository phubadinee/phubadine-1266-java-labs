package mehom.phubadine.lab6;

/*
 * The GuessNumberGameVer1 class is a subclass of the abstract Game class. 
 * It introduces properties such as minNum, maxNum, maxTries, and correctNum. 
 * It has constructors to initialize these properties, utilizing the superclass's constructor to set gameName 
 * to "Guess Number Game" and numOfPlayers to 1. The class overrides the toString() method, leveraging the 
 * superclass's toString() to display game information. Additionally, it overrides the playGame() method, 
 * providing a specific implementation for playing the guess number game.
 * 
 * GuessNumberGameVer1
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class GuessNumberGameVer1 extends Game {

    // Build Variable
    protected int minNum, maxNum, maxTries;
    protected int correctNum;

    // Defualt Constructor
    public GuessNumberGameVer1() {
        super.setGameName("Guess Number Game");
        super.setNumOfPlayers(1);
        this.minNum = 1;
        this.maxNum = 10;
        this.maxTries = 3;
        this.correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));
    }

    // Parameter Constructor  Initialize minNum, maxNum
    public GuessNumberGameVer1(int minNum, int maxNum) {
        super.setGameName("Guess Number Game");
        super.setNumOfPlayers(1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = 3;
        this.correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));
    }
       
    // Parameter Constructor  Initialize minNum, maxNum, maxTries
    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        super.setGameName("Guess Number Game");
        super.setNumOfPlayers(1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        this.correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));

    }

    // Setter and Getter Method
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
    public void playGame() {
        System.out.println("Playing Guess Number Game");
    }

    @Override
    public String toString() {
        return "{ gameName='" + this.getGameName() + 
        "', numOfPlayers='" + this.getNumOfPlayers() +
        "'}{ minNum='" + this.getMinNum() +
        "', maxNum='" + this.getMaxNum() + 
        "', correctNum='" + this.correctNum +
        "', maxTries='" + this.getMaxTries() +
        "'}";
    }
}
