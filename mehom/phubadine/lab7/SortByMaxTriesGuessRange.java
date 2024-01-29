package mehom.phubadine.lab7;

import java.util.Comparator;

/* 
 * The Java class SortByMaxTriesGuessRange implements the Comparator interface to 
 * define a custom comparison for sorting GuessNumberGameVer4 objects. It first 
 * compares the maximum allowed tries (maxTries) of two instances. If the max tries 
 * are equal, it then compares the difference between the maximum and minimum numbers 
 * (maxNum - minNum). This class provides a more detailed sorting mechanism by considering both max tries 
 * and the range of possible guesses in each game.
 * 
 * SortBy MaxTries Guess Range
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class SortByMaxTriesGuessRange implements Comparator<GuessNumberGameVer4>{
    public int compare(GuessNumberGameVer4 a, GuessNumberGameVer4 b) {
        // Compare based on max tries
        if (a.getMaxTries() == b.getMaxTries()) {
            // return Integer.compare(b.getMaxNum(), a.getMaxNum());
            int value_a = a.getMaxNum() - a.getMinNum();
            int value_b = b.getMaxNum() - b.getMinNum();
                        
            // Reverse the order if you want to prioritize smaller range in case of a tie
            return Integer.compare(value_b, value_a);
        } else {
            // If max tries are different, prioritize the one with fewer max tries
            return Integer.compare(a.getMaxTries(), b.getMaxTries());
        }
    }
}
