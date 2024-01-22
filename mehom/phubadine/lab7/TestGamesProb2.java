package mehom.phubadine.lab7;

import java.util.ArrayList;
import java.util.Collections;

public class TestGamesProb2 {
    static ArrayList<GuessNumberGameVer4> games = new ArrayList<GuessNumberGameVer4>();

    public static void printGamesList(String msg) {
        System.out.println(msg);
        for (GuessNumberGameVer4 game : games) {
            System.out.println(game);
        }
    }

    public static void initGamesList() {
        games.add(new GuessNumberGameVer4(1, 10, 7));
        games.add(new GuessNumberGameVer4(1, 10, 5));
        games.add(new GuessNumberGameVer4(1, 5, 5));

        printGamesList("===== Unsorted games list: =====");
    }

    public static void sortGamesList() {
        Collections.sort(games, new SortByMaxTriesGuessRange());
        printGamesList("===== Sorted games list: =====");
    }

    public static void main(String[] args) {
        initGamesList();
        sortGamesList();
    }
}

