package mehom.phubadine.lab6;

public abstract class Game {

    // Build Variable
    protected String gameName;
    protected int numOfPlayers;

    // Defualt Constructor
    public Game() {
        this.gameName = "unknown game";
        this.numOfPlayers = 0;
    }

    // Parameter Constructor  Initialize numOfGames
    public Game(String gameName, int numOfGames) {
        this.gameName = gameName;
        this.numOfPlayers = numOfGames;
    }

    // Setter and Getter Method
    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getNumOfPlayers() {
        return this.numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    @Override
    public String toString() {
        return this.getGameName() + " numOfPlayers : " + this.getNumOfPlayers();
    }

    // Abstract for inherited
    public abstract void playGame();

}
