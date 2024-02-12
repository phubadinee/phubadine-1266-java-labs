package mehom.phubadine.lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DiceImageCanvas extends JPanel {
    protected int diceNumber;
    protected Graphics2D g2d;
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

    public DiceImageCanvas(int diceNumber) {
        // initialize dice number
        this.diceNumber = diceNumber;
        // set size with width canvasWidth and height canvasHeight

        // initialize a square which is a background

        // call method createCircles to place dots on a rectangle
        createCircles();
    }

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
        if (diceNumber == 1) {
            g2d.fill(circleTopCenter);
        } else if (diceNumber == 2){
            g2d.fill(circleTopRight);
            g2d.fill(circleBottomLeft);
        } else if (diceNumber == 3){
            g2d.fill(circleTopRight);
            g2d.fill(circleCenter);
            g2d.fill(circleBottomLeft);
        } else if (diceNumber == 4){
            g2d.fill(circleTopRight);
            g2d.fill(circleTopLeft);
            g2d.fill(circleBottomLeft);
            g2d.fill(circleBottomRight);
        } else if (diceNumber == 5){
            g2d.fill(circleTopRight);
            g2d.fill(circleTopLeft);
            g2d.fill(circleCenter);
            g2d.fill(circleBottomLeft);
            g2d.fill(circleBottomRight);
        } else if (diceNumber == 6){
            g2d.fill(circleTopRight);
            g2d.fill(circleTopLeft);
            g2d.fill(circleTopCenter);
            g2d.fill(circleBottomCenter);
            g2d.fill(circleBottomLeft);
            g2d.fill(circleBottomRight);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        // call paintComponent of super class
        super.paintComponent(g);
        g2d = (Graphics2D)g;
        // cast graphics object to graphics2D object
        square = new Rectangle2D.Double(startSquareX, startSquareY, squareWidth, squareHeight);

        // set paint to white and fill the quare
        g2d.setColor(Color.WHITE);
        // g2d.draw(circleTopCenter);
        g2d.fill(square);
        // call code to draw dice number
        g2d.setColor(Color.RED);
        drawDiceNumber();
    }
}