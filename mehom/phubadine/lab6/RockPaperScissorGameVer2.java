package mehom.phubadine.lab6;

public class RockPaperScissorGameVer2 extends RockPaperScissorGame implements HasRule{
    public RockPaperScissorGameVer2() {
        super();
    }   

    public RockPaperScissorGameVer2(String player1Choice, String player2Choice) {
        super(player1Choice, player2Choice);
    }   

    @Override
    public void playGame() {
        System.out.println("Playing Rock Paper Scissor Version 2");
    }

    @Override
    public String toString() {
        return "Rock Paper Scissor Game Version 2 : " + "{ gameName='" + this.getGameName() + 
        "', numOfPlayers='" + this.getNumOfPlayers() +
        "'}{ player1Choice='" + this.getPlayer1Choice() +
        "', player2Choice='" + this.getPlayer2Choice() + 
        "'}";
    }

    @Override
    public void gameRule() {
        System.out.println("Rock Paper Scissor Rule: ...");
    }
}
