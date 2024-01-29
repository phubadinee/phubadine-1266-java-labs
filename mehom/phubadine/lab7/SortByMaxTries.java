package mehom.phubadine.lab7;

import java.util.Comparator;

/* 
 * The Java class SortByMaxTries implements the Comparator interface to define a custom 
 * comparison for sorting GuessNumberGameVer4 objects based on their maximum allowed 
 * tries (maxTries). The compare method compares two instances of GuessNumberGameVer4 and 
 * returns the result of the comparison using the Integer.compare method on their 
 * maximum tries.
 * 
 * Sort By Max Tries
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class SortByMaxTries implements Comparator<GuessNumberGameVer4>{
    public int compare(GuessNumberGameVer4 a, GuessNumberGameVer4 b) {
        return Integer.compare(a.getMaxTries(), b.getMaxTries());
    }
}
