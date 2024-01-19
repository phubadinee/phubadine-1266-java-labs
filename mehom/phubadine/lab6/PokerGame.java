package mehom.phubadine.lab6;

public class PokerGame extends CardGame implements HasRule {
    public PokerGame() {
        super.setGameName("Poker Game");
        super.setNumOfPlayers(3);
        super.setNumOfCardsPerPlayer(5);
    }

    public PokerGame(int numOfCardsPerPlayer) {
        super.setGameName("Poker Game");
        super.setNumOfPlayers(3);
        super.setNumOfCardsPerPlayer(numOfCardsPerPlayer);
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
