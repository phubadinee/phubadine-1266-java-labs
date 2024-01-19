package mehom.phubadine.lab6;

public class DungeonsAndDragonsGame extends CardGame implements HasRule, UseBoard, UseDice{
    public DungeonsAndDragonsGame() {
        super.setNumOfCardsPerPlayer(6);
        super.setGameName("Dungeons And Dragons Game");
        super.setNumOfPlayers(3);
    }  
    public DungeonsAndDragonsGame(int numOfCardsPerPlayer) {
        super.setNumOfCardsPerPlayer(numOfCardsPerPlayer);
        super.setGameName("Dungeons And Dragons Game");
        super.setNumOfPlayers(3);
    }

    @Override
    public String toString() {
        return "Dungeons And Dragons Game : " + 
                "{ gameName='" + this.getGameName() +
                "', numOfPlayers='" + this.getNumOfPlayers() + 
                "'} { numOfCardsPerPlayer='" + this.getNumOfCardsPerPlayer() +
                "'}";
    }

    @Override
    public void playGame() {
        System.out.println("Playing Dungeons And Dragons Game");
    }

    @Override
    public void gameRule() {
        System.out.println("Doungeons And Dragons Game Rules : ...");
    }

    @Override 
    public void setUpBoard() {
        System.out.println("Setting up board for Doungeons And Dragons Game");
    }

    @Override
    public void rollDice() {
        System.out.println("Rolling 2 dices for Dungeons And Dragons Game");
    }
        
}

