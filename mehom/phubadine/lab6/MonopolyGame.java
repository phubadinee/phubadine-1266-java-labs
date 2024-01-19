package mehom.phubadine.lab6;

public class MonopolyGame extends Game{
    protected String[] gamePieces;
    String res = "";
    
    public MonopolyGame() {
        super.setGameName("Monopoly Game");
        super.setNumOfPlayers(4);
        this.gamePieces = new String[] {"car", "top hat", "thimble", "boot"};
    }

    public MonopolyGame(String[] gamePieces) {
        super.setGameName("Monopoly Game");
        super.setNumOfPlayers(4);
        this.gamePieces = gamePieces;
    }

    // Setter and Getter Method
    public String getGamePieces() {
        for (String game : this.gamePieces) {
            res += game + " ";
        }
        return res;
    }

    public void setGamePieces(String[] gamePieces) {
        this.gamePieces = gamePieces;
    }

    @Override
    public void playGame() {
        System.out.println("Playing Monopoly Game");
    }

    @Override
    public String toString() {
        return "{ gameName='" + this.getGameName() + 
        "', numOfPlayers='" + this.getNumOfPlayers() +
        "'}{ game pieces='" + this.getGamePieces() +
        "'}";
    } 

}
