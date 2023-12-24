package mehom.phubadine.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/*
 * MatrixDisplayOptions Program
 * Select Mode for Matrix:
    * 1. User Input (enter row and column -> enter num index)
    * 2. Random Numbers (enter row and column -> return Random number in Matrix)
    * 3. All Zeros (enter row and column -> return all zeros matrix)
    * 4. All Ones ( enter row and column -> return all ones matrix)
    * 5. Diagonal Matix (enter num for row == column (diagonal matrix) -> return Diagonal Matrix)
 * Output : matrix
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class MatrixDisplayOptions {

    // Variable value for input row, column
    static int nRow, nColumn;
    static int res, diagonalShape;
    
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        // called method for playing
        int menu = displayOption();
        runOption(menu);
        
    }

    static void menu(int mode) {

        // Enter row
        System.out.print("Enter the number of rows: ");
        nRow = input.nextInt();
        while (nRow <= 0) { // row only > 0
            // Enter new rows
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of rows: ");
            nRow = input.nextInt();
        }
        // Enter row
        System.out.print("Enter the number of columns: ");
        nColumn = input.nextInt();
        while (nColumn <= 0) { // column only > 0 
            // Enter new column
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of columns: ");
            nColumn = input.nextInt();
        }

        // Build List for input matrix (collect row (list))
        List<List<Integer>> rowList = new ArrayList<>();
        
        // Access to list
        for (int row = 0; row < nRow; row++) {
            // Build List for input matrix (collect column (int))
            List<Integer> columnList = new ArrayList<>();

            // Access to inner matrix
            for (int column = 0; column < nColumn; column++) {
                if (mode == 1) {    // Normal input
                    System.out.print("Enter element [" + row + "][" + column + "]: ");
                    res = input.nextInt();
                } else if (mode == 2) { // Random input
                    res = rand.nextInt(9);
                } else if (mode == 3) { // All zeros
                    res = 0;
                } else if (mode == 4) { // All Ones
                    res = 1;
                }
                // add num to column list
                columnList.add(res);
            }
            // add column to row list
            rowList.add(columnList);
        }
        displayMatrix(rowList);
    }

    static void displayMatrix(List<List<Integer>> matrix) {
        // Access to list in list
        for (List<Integer> row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    // Get input option
    static int displayOption() {
        System.out.println("Select matrix initialization method:");
        System.out.println("1. User Input");
        System.out.println("2. Random Numbers");
        System.out.println("3. All Zeros");
        System.out.println("4. All Ones");
        System.out.println("5. Diagonal Matrix");

        System.out.print("Enter choice (1-5): ");
        int option = input.nextInt(); // Get option

        return option;
    }

    // Run from choose option
    static void runOption(int option) {
        if (option == 1) {
            menu(1); // User Input
        } else if (option == 2) {
            menu(2); // Random Numbers
        } else if (option == 3) {
            menu(3); // All Zeros
        } else if (option == 4) {
            menu(4); // All Ones
        } else if (option == 5) {
            diagonalMatrix(); // Diagonal
        }

        int menu = displayOption();
        runOption(menu);    // Recursion
    }

    // Build Diagonal Matrix
    static void diagonalMatrix() {
        System.out.print("Enter the number of rows and column for diagonal matrix: ");
        diagonalShape = input.nextInt(); // Get shape

        List<List<Integer>> rowList = new ArrayList<>();
        for (int row = 0; row < diagonalShape; row++) {
            List<Integer> columnList = new ArrayList<>();

            for (int column = 0; column < diagonalShape; column++) {
                if (row == column) {
                    res = 1; // Diagonal
                } else {
                    res = 0; // Not Diagonal
                }
                columnList.add(res);
            }
            rowList.add(columnList);
        }
        displayMatrix(rowList);
    }
}   