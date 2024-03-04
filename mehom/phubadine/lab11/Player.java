package mehom.phubadine.lab11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Player implements Serializable {
    String name, nationality, dob, playerType, genderResult;
    String hobbies;
    List sports;
    private int year;

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGenderResult(String genderResult) {
        this.genderResult = genderResult;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setSports(List sports) {
        this.sports = sports;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
	public String toString() {
        return name +" has nationality as " + nationality + " and was born on " + dob + ", has gender as " + 
        genderResult + ", is a " + playerType + " player, has hobbies as " + hobbies + " and plays " + sports;
    }

}