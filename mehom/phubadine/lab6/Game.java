package mehom.phubadine.lab6;

/*
 * The Game class is an abstract class with properties gameName (String) 
 * and numOfPlayers (int). It has constructors for initializing these properties, 
 * getter and setter methods, and a toString() method that outputs the game name and number of players. 
 * Additionally, it declares an abstract method playGame(), which must be implemented by its subclasses. 
 * This design allows for the creation of specific game types by extending the abstract Game class.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

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
