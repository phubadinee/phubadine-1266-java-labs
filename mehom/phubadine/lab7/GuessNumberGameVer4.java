package mehom.phubadine.lab7;

import mehom.phubadine.lab5.GuessNumberGameVer3;

public class GuessNumberGameVer4 extends GuessNumberGameVer3 {
    
    public GuessNumberGameVer4() {
        super();
    }
    public GuessNumberGameVer4(int minNum, int maxNum) {
        super(minNum, maxNum);
    }
    public GuessNumberGameVer4(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public String toString() {
        return "GuessNumberGameVer4" +
                " (min: " + this.minNum + 
                ", max:" + this.maxNum +
                ", max tries:" + this.maxTries +
                ")";
    }
}
