package mehom.phubadine.lab6;

public abstract class CardGame extends Game {
    protected int numOfCardsPerPlayer;

    public CardGame() {
        super();
        this.numOfCardsPerPlayer = 0;
    }

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