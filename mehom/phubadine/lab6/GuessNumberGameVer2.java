package mehom.phubadine.lab6;

public class GuessNumberGameVer2 extends GuessNumberGameVer1 implements HasRule{
    public GuessNumberGameVer2() {
        super();
    }

    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public void playGame() {
        System.out.println("Playing Guess Number Game Version 2");
    }

    @Override 
    public String toString() {
        return "Gueses Number Game Version 2 : " + 
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
        System.out.println("Guess Number Game Rules: ...");
    }



}
