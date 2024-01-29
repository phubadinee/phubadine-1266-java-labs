package mehom.phubadine.lab7;

import mehom.phubadine.lab5.GuessNumberGameVer3;

/* 
 * The Java class GuessNumberGameVer4 extends GuessNumberGameVer3 and represents a number-guessing game. 
 * It includes constructors for setting the minimum and maximum numbers, as well as the maximum allowed 
 * tries. The overridden toString() method generates a formatted string displaying the game's version, along with 
 * the specified minimum and maximum numbers, and the maximum tries.
 * GuessNumberGameVer1
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class GuessNumberGameVer4 extends GuessNumberGameVer3 {
    
    // Default constructor
    public GuessNumberGameVer4() {
        super();
    }

    // Constructor with specified minNum and maxNum
    public GuessNumberGameVer4(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    // Constructor with specified minNum, maxNum, and maxTries
    public GuessNumberGameVer4(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    // Overridden toString() method to provide a formatted string representation
    @Override
    public String toString() {
        return "GuessNumberGameVer4" +
                " (min: " + this.minNum + 
                ", max:" + this.maxNum +
                ", max tries:" + this.maxTries +
                ")";
    }
}
