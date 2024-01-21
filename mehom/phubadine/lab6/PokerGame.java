package mehom.phubadine.lab6;

/*
 * Poker Game
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PokerGame extends CardGame implements HasRule {
    
    // Default constructor
    public PokerGame() {
        super.setGameName("Poker Game");
        super.setNumOfPlayers(4);
        super.setNumOfCardsPerPlayer(5);
    }

    // Parameter Constructor  Initialize numOfCardsPlayer
    public PokerGame(int numOfCardsPerPlayer) {
        super.setGameName("Poker Game");
        super.setNumOfPlayers(4);
        super.setNumOfCardsPerPlayer(numOfCardsPerPlayer);
    }

    @Override 
    public String toString() {
        return  "{ gameName='" + this.getGameName() +
        "', numOfPlayers='" + this.getNumOfPlayers() + 
        "'} { numOfCardsPerPlayer='" + this.getNumOfCardsPerPlayer() +
        "'}";
    }

    // method to specify how the game is played
    @Override
    public void playGame() {
        System.out.println("Playing Poker Game.");
    }

    // method to specify the rules of the game
    @Override
    public void gameRule() {
        System.out.println("Poker Game Rules : ...");
    }
}
