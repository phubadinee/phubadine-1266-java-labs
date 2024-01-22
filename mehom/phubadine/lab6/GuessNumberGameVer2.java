package mehom.phubadine.lab6;

/*
 * GuessNumberGameVer2
 * 
 * Class GuessNumberGameVer2 is inherited from GuessNumberGameVer1. 
 * It overrides the methods toString() and playGame(). It also implements interface HasRule.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class GuessNumberGameVer2 extends GuessNumberGameVer1 implements HasRule{
    
    // Defualt Constructor
    public GuessNumberGameVer2() {
        super();
    }

    // Parameter Constructor  Initialize minNum, maxNum
    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public void playGame() {
        System.out.println("Playing Guess Number Game Version 2");
    }

    @Override 
    public String toString() {
        return this.getGameName() + " Version 2 : " + 
        "{ gameName='" + this.getGameName() + 
        "', numOfPlayers='" + this.getNumOfPlayers() +
        "'}{ minNum='" + this.getMinNum() +
        "', maxNum='" + this.getMaxNum() + 
        "', correctNum='" + this.correctNum +
        "', maxTries='" + this.getMaxTries() +
        "'}";
    }
    
    @Override
    public void gameRule() {
        System.out.println(this.getGameName() + " Rules : ...");
    }
}