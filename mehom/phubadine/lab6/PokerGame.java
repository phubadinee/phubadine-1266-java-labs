package mehom.phubadine.lab6;

public class PokerGame extends CardGame implements HasRule {
    public PokerGame() {
        this.gameName = "Poker Game";
        this.numOfPlayers = 3;
        this.numOfCardsPerPlayer = 5;
    }

    public PokerGame(int numOfCardsPerPlayer) {
        this.gameName = "Poker Game";
        this.numOfPlayers = 3;
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    @Override 
    public String toString() {
        return  "{ gameName='" + this.getGameName() +
        "', numOfPlayers='" + this.getNumOfPlayers() + 
        "'} { numOfCardsPerPlayer='" + this.getNumOfCardsPerPlayer() +
        "'}";
    }

    @Override
    public void playGame() {
        System.out.println("Playing Poker Game.");
    }

    @Override
    public void gameRule() {
        System.out.println("Poker Game Rules : ...");
    }




}
