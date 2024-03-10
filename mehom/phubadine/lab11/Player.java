package mehom.phubadine.lab11;

import java.io.Serializable;
import java.util.*;
import javax.swing.*;


/* 
 * The Java code defines a serializable Player class with attributes like name, nationality, and sports information. 
 * It includes constructors, getter methods, and a overridden toString method for meaningful representation.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */


// Player class implementing Serializable for object serialization
public class Player implements Serializable {
    // Instance variables to store player information=
    String name, nationality, dob, playerType, genderResult, hobbies;
    int playerIndex;
    ArrayList<JCheckBox> hobbiesList;
    List<String> sports;
    List sporList;
    int[] sportIndex;
    int year;

    // Default constructor
    public Player() {

    }

    // Parameterized constructor to initialize player information
    public Player(String name, String nationality, String dob, String playerType, int playerIndex, String genderResult, String hobbies, int[] sportsIndex, int year, List sportList) {
        this.name = name;
        this.nationality = nationality;
        this.dob = dob;
        this.playerType = playerType;
        this.playerIndex = playerIndex;
        this.genderResult = genderResult;
        this.hobbies = hobbies;
        this.sportIndex = sportsIndex;
        this.year = year;
        this.sporList = sportList;
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

    public List getSportList() {
        return this.sporList;
    }
    
    public void setYear(int year) {
        this.year = year;
    }

    // Override toString method for meaningful representation of the object
    @Override
	public String toString() {
        return this.getName() + 
        " has nationality as " + this.getNationality() + 
        " and was born on " + this.getDob() + 
        ", has gender as " + this.getGenderResult() + 
        ", is a " + this.getPlayerType() + 
        " player, has hobbies as " + this.getHobbies() + 
        " and plays " + this.getSportList() + 
        " and has experience years as " + this.getYear();
    }
}