package mehom.phubadine.lab11;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    String name, nationality, dob, playerType;
    ArrayList<String> hobbies = new ArrayList<String>();
    ArrayList<String> sports = new ArrayList<String>();
    private int year;
}
