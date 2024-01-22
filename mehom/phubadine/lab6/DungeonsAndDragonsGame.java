package mehom.phubadine.lab6;

/*
 * Dungeons And Dragons Game
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class DungeonsAndDragonsGame extends CardGame implements HasRule, UseBoard, UseDice{
    
    // Default constructor
    public DungeonsAndDragonsGame() {
        super.setNumOfCardsPerPlayer(6);
        super.setGameName("Dungeons And Dragons Game");
        super.setNumOfPlayers(3);
    }  

    // Parameter Constructor  Initialize numOfCardsPerPlayer
    public DungeonsAndDragonsGame(int numOfCardsPerPlayer) {
        super.setNumOfCardsPerPlayer(numOfCardsPerPlayer);
        super.setGameName("Dungeons And Dragons Game");
        super.setNumOfPlayers(3);
    }

    // Display gameName, numOfPlayers and numOfCardsPerPlayer
    @Override
    public String toString() {
        return this.getGameName() + " : " + 
                "{ gameName='" + this.getGameName() +
                "', numOfPlayers='" + this.getNumOfPlayers() + 
                "'} { numOfCardsPerPlayer='" + this.getNumOfCardsPerPlayer() +
                "'}";
    }

    // method to specify how the game is played
    @Override
    public void playGame() {
        System.out.println("Playing " + this.getGameName());
    }

    // method to specify the rules of the game
    @Override
    public void gameRule() {
        System.out.println(this.getGameName() + " Rules : ...");
    }

    // method to specify how the game board is set up
    @Override 
    public void setUpBoard() {
        System.out.println("Setting up board for " + this.getGameName());
    }

    // method to specify how dice are rolled in the game
    @Override
    public void rollDice() {
        System.out.println("Rolling 2 dices for " + this.getGameName());
    }
        
}

