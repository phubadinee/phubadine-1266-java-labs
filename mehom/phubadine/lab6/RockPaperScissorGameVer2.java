package mehom.phubadine.lab6;

/*
 * Rock Paper Scissor Game Ver 2
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class RockPaperScissorGameVer2 extends RockPaperScissorGame implements HasRule{
    
    // Defualt Constructor
    public RockPaperScissorGameVer2() {
        super();
    }   

    // Parameter Constructor  Initialize player1Choice and player2Choice
    public RockPaperScissorGameVer2(String player1Choice, String player2Choice) {
        super(player1Choice, player2Choice);
    }   

    // method to specify how the game is played
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

    // method to specify the rules of the game
    @Override
    public void gameRule() {
        System.out.println("Rock Paper Scissor Rule: ...");
    }
}
