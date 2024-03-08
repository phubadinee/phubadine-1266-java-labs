package mehom.phubadine.lab11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JCheckBox;


public class Player implements Serializable {
    String name, nationality, dob, playerType, genderResult, hobbies;
    int playerIndex;
    ArrayList<JCheckBox> hobbiesList;
    List<String> sports;
    int[] sportIndex;
    int year;

    public Player() {

    }

    public Player(String name, String nationality, String dob, int playerIndex, String genderResult, String hobbies, int[] sportsIndex, int year) {
        this.name = name;
        this.nationality = nationality;
        this.dob = dob;
        this.playerType = playerType;
        this.playerIndex = playerIndex;
        this.genderResult = genderResult;
        this.hobbies = hobbies;
        this.sportIndex = sportsIndex;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getDob() {
        return this.dob;
    }

    public String getGenderResult() {
        return this.genderResult;
    }

    public String getPlayerType() {
        return this.playerType;
    }

    public int getPlayerIndex() {
        return this.playerIndex;
    }

    public String getHobbies() {
        return this.hobbies;
    }

    public int[] getSportIndex() {
        return this.sportIndex;
    }

    public int getYear() {
        return this.year;
    }
    
    // public void setName(String name) {
    //     this.name = name;
    // }

    // public void setNationality(String nationality) {
    //     this.nationality = nationality;
    // }

    // public void setDob(String dob) {
    //     this.dob = dob;
    // }

    // public void setGenderResult(String genderResult) {
    //     this.genderResult = genderResult;
    // }

    // public void setPlayerType(String playerType) {
    //     this.playerType = playerType;
    // }

    // public void setHobbies(ArrayList<JCheckBox> hobbies) {
    //     this.hobbies = hobbies;
    // }

    // public void setSports(List sports) {
    //     this.sports = sports;
    // }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
	public String toString() {
        // return name +" has nationality as " + nationality + " and was born on " + dob + ", has gender as " + 
        // genderResult + ", is a " + playerType + " player, has hobbies as " + hobbies + " and plays " + sports;

        return this.getName() +" has nationality as " + this.getNationality() + " and was born on " + this.getDob() + ", has gender as " + 
        this.getGenderResult() + ", is a " + this.getPlayerType();
    }

}