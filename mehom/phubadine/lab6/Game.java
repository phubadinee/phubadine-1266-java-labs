package mehom.phubadine.lab6;

public abstract class Game {
    protected String gameName;
    protected int numOfPlayers;

    public Game() {
        this.gameName = "unknown game";
        this.numOfPlayers = 0;
    }

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
        return " ";
    }

    public abstract void playGame();

}
