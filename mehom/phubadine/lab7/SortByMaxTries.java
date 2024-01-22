package mehom.phubadine.lab7;

import java.util.Comparator;

public class SortByMaxTries implements Comparator<GuessNumberGameVer4>{
    public int compare(GuessNumberGameVer4 a, GuessNumberGameVer4 b) {
        return Integer.compare(a.getMaxTries(), b.getMaxTries());

    }
}
