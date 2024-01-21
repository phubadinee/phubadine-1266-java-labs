package mehom.phubadine.lab6;

/*
 * Monopoly Game Ver 2
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class MonopolyGameVer2 extends MonopolyGame implements HasRule, UseBoard, UseDice{

    // Defualt Constructor
    public MonopolyGameVer2() {
        super();
    }

    // Parameter Constructor  Initialize gamePices
    public MonopolyGameVer2(String[] gamePieces) {
        super(gamePieces);
    }

    @Override
    public void playGame() {
        System.out.println("Play Monopoly Game Version 2");
    }

    @Override
    public String toString() {
        return "Monopoly Game Version 2 : " + "{ gameName='" + this.getGameName() + 
        "', numOfPlayers='" + this.getNumOfPlayers() +
        "'}{ game pieces='" + this.getGamePieces() +
        "'}";
    } 

    // method to specify the rules of the game
    @Override
    public void gameRule() {
        System.out.println("Monopoly Rules: ...");
    }

    // method to specify how the game board is set up
    @Override
    public void setUpBoard() {
        System.out.println("Set up monopoly board");
    }

    // method to specify how dice are rolled in the game
    @Override
    public void rollDice() {
        System.out.println("Roll 2 dice for monopoly game");
    }
}
