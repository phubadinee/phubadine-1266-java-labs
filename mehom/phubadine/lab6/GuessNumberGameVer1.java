package mehom.phubadine.lab6;

public class GuessNumberGameVer1 extends Game {
    protected int minNum, maxNum, maxTries;
    protected int correctNum;

    public GuessNumberGameVer1() {
        this.gameName = "Guess Number Game";
        this.numOfPlayers = 1;
        this.minNum = 1;
        this.maxNum = 10;
        this.maxTries = 3;
        this.correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));

    }
    public GuessNumberGameVer1(int minNum, int maxNum) {
        this.gameName = "Guess Number Game";
        this.numOfPlayers = 1;
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = 3;
        this.correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));
    }
    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        this.gameName = "Guess Number Game";
        this.numOfPlayers = 1;
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
