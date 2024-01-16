package mehom.phubadine.lab6;

public class MonopolyGameVer2 extends MonopolyGame implements HasRule, UseBoard, UseDice{

    public MonopolyGameVer2() {
        super();
    }
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

    public void gameRule() {
        System.out.println("Monopoly Rules: ...");
    }

    public void setUpBoard() {
        System.out.println("Set up monopoly board");
    }

    public void rollDice() {
        System.out.println("Roll 2 dice for monopoly game");
    }
}
