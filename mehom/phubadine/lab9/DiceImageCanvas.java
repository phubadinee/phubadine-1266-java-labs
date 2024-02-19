package mehom.phubadine.lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/* 
 * The DiceImageCanvas class in Java defines a custom JPanel for displaying a dice 
 * with a specified number of dots. It calculates and positions ellipses to represent 
 * dots based on the dice number and overrides the paintComponent method to draw 
 * the dots on a white square background.
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class DiceImageCanvas extends JPanel {

    // Variables to store information about the dice and graphical elements
    protected int diceNumber;
    protected Graphics2D dice;
    protected Ellipse2D.Double circleCenter, circleTopRight, circleBottomLeft,
            circleTopLeft, circleBottomRight, circleTopCenter, circleBottomCenter;
    protected Rectangle2D.Double square;
    protected int squareWidth = 150, squareHeight = 150;
    protected int canvasWidth = 400, canvasHeight = 400;
    protected int circleWidth = 30, circleHeight = 30;
    protected int circleRadius = circleWidth / 2;
    protected int startSquareX = 125;
    protected int startSquareY = 40;
    protected int margin = 10;

    // Constructor to initialize the DiceImageCanvas with a specified dice number
    public DiceImageCanvas(int diceNumber) {
        this.diceNumber = diceNumber;
        createCircles();
    }

    // Method to create and position circles based on dice layout
    protected void createCircles() {
        // initialize different types of circles (circleCenter, circleTopRight, ...)
        int posTopRow = (squareHeight / 6) * 1 - (circleHeight / 2) + startSquareX;
        int posCenterRow = (squareHeight / 6) * 3 - (circleHeight / 2) + startSquareX;
        int posBottomRow = (squareHeight / 6) * 5 - (circleHeight / 2) + startSquareX;

        int posLeftColumn = (squareWidth / 6) * 1 - (circleWidth / 2)+ startSquareY;
        int posCenterColumn = (squareWidth / 6) * 3 - (circleWidth / 2) +startSquareY;
        int posRightColumn = (squareWidth / 6) * 5 - (circleWidth / 2) + startSquareY;

        circleTopLeft = new Ellipse2D.Double(posTopRow, posLeftColumn, circleWidth, circleHeight);
        circleTopCenter =  new Ellipse2D.Double(posCenterRow, posLeftColumn, circleWidth, circleHeight);
        circleTopRight = new Ellipse2D.Double(posBottomRow, posLeftColumn, circleWidth, circleHeight);
        circleCenter =  new Ellipse2D.Double(posCenterRow, posCenterColumn, circleWidth, circleHeight);
        circleBottomLeft = new Ellipse2D.Double(posTopRow, posRightColumn, circleWidth, circleHeight);
        circleBottomCenter =  new Ellipse2D.Double(posCenterRow, posRightColumn, circleWidth, circleHeight);
        circleBottomRight = new Ellipse2D.Double(posBottomRow, posRightColumn, circleWidth, circleHeight);
    }

    protected void drawDiceNumber() {
        // depending on a dice number, place red dots properly on a rectangle
        System.out.println(diceNumber);
        if (diceNumber == 1) {
            dice.fill(circleCenter);
        } else if (diceNumber == 2){
            dice.fill(circleTopRight);
            dice.fill(circleBottomLeft);
        } else if (diceNumber == 3){
            dice.fill(circleTopRight);
            dice.fill(circleCenter);
            dice.fill(circleBottomLeft);
        } else if (diceNumber == 4){
            dice.fill(circleTopRight);
            dice.fill(circleTopLeft);
            dice.fill(circleBottomLeft);
            dice.fill(circleBottomRight);
        } else if (diceNumber == 5){
            dice.fill(circleTopRight);
            dice.fill(circleTopLeft);
            dice.fill(circleCenter);
            dice.fill(circleBottomLeft);
            dice.fill(circleBottomRight);
        } else if (diceNumber == 6){
            dice.fill(circleTopRight);
            dice.fill(circleTopLeft);
            dice.fill(circleTopCenter);
            dice.fill(circleBottomCenter);
            dice.fill(circleBottomLeft);
            dice.fill(circleBottomRight);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        // call paintComponent of super class
        super.paintComponent(g);
        dice = (Graphics2D)g;
        // cast graphics object to graphics2D object
        square = new Rectangle2D.Double(startSquareX, startSquareY, squareWidth, squareHeight);
        // set paint to white and fill the quare
        dice.setColor(Color.WHITE);
        // dice.draw(circleTopCenter);
        dice.fill(square);
        // call code to draw dice number
        dice.setColor(Color.RED);
        drawDiceNumber();
    }
}