package mehom.phubadine.lab6;

/*
 * CardGame is an abstract class inheriting from Game. 
 * It introduces numOfCardsPerPlayer to manage the number of cards each player gets. 
 * The class provides constructors for initialization, overriding toString() to display card-related 
 * information along with the superclass details. It declares an abstract playGame() method, allowing 
 * subclasses to implement specific card games within the general framework of the abstract Game class.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */
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