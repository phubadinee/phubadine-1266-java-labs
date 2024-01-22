package mehom.phubadine.lab6;

/*
 * RockPaperScissorGame is a subclass of Game representing a two-player rock-paper-scissors game. 
 * It initializes player choices, sets game details using the superclass constructor, and provides 
 * specific implementations for playing the game and displaying information.
 * 
 * Rock Paper Scissor Game 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class RockPaperScissorGame extends Game{
    // Build Variable
    protected String player1Choice;
    protected String player2Choice;

    // Default constructor
    public RockPaperScissorGame() {
        super.setGameName("Rock Paper Scissor Game");
        super.setNumOfPlayers(2);
        this.player1Choice = this.player2Choice = "rock";
    }


    // Parameter Constructor  Initialize player1Choice and player2Choice
    public RockPaperScissorGame(String player1Choice, String player2Choice) {
        super.setGameName("Rock Paper Scissor Game");
        super.setNumOfPlayers(2);
        this.player1Choice = player1Choice;
        this.player2Choice = player2Choice;
    }
    
    // Setter and Getter Method
    public String getPlayer1Choice() {
        return this.player1Choice;
    }

    public void setPlayer1Choice(String player1Choice) {
        this.player1Choice = player1Choice;
    }

    public String getPlayer2Choice() {
        return this.player2Choice;
    }

    public void setPlayer2Choice(String player2Choice) {
        this.player2Choice = player2Choice;
    }

    @Override
    public void playGame() {
        System.out.println("Playing Rock Paper Scissor Game");
    }

    @Override
    public String toString() {
        return "{ gameName='" + this.getGameName() + 
        "', numOfPlayers='" + this.getNumOfPlayers() +
        "'}{ player1Choice='" + this.getPlayer1Choice() +
        "', player2Choice='" + this.getPlayer2Choice() + 
        "'}";
    }


}
