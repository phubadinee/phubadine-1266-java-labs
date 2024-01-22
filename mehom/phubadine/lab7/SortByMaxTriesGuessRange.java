package mehom.phubadine.lab7;

import java.util.Comparator;

public class SortByMaxTriesGuessRange implements Comparator<GuessNumberGameVer4>{
    public int compare(GuessNumberGameVer4 a, GuessNumberGameVer4 b) {
        if (a.getMaxTries() == b.getMaxTries()) {
            // return Integer.compare(b.getMaxNum(), a.getMaxNum());
            int value_a = a.getMaxNum() - a.getMinNum();
            int value_b = b.getMaxNum() - b.getMinNum();
            
            return Integer.compare(value_b, value_a);
        } else {
            return Integer.compare(a.getMaxTries(), b.getMaxTries());
        }
    }
}
