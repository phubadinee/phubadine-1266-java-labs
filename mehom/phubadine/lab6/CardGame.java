package mehom.phubadine.lab6;

public abstract class CardGame extends Game {

    // Build Variable
    protected int numOfCardsPerPlayer;

    // Defualt Constructor
    public CardGame() {
        super();
        this.numOfCardsPerPlayer = 0;
    }

    // Parameter Constructor  Initialize numOfCardsPerPlayer
    public CardGame(int numOfCardsPerPlayer) {
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    // Setter and Getter Method
    public int getNumOfCardsPerPlayer() {
        return this.numOfCardsPerPlayer;
    }

    public void setNumOfCardsPerPlayer(int numOfCardsPerPlayer) {
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    @Override
    public String toString() {
        return "numOfCardsPerPlayer" + getNumOfCardsPerPlayer();
    }

    // Abstract for inherited
    public abstract void playGame();

}