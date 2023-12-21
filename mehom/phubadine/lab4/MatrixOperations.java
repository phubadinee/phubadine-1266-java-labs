package mehom.phubadine.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


/*
 * MatrixOperations Program
 * Select Mode for Matrix:
    * 1. User Input (enter row and column -> enter num index)
    * 2. Random Numbers (enter row and column -> return Random number in Matrix)
    * 3. All Zeros (enter row and column -> return all zeros matrix)
    * 4. All Ones ( enter row and column -> return all ones matrix)
    * 5. Diagonal Matix (enter num for row == column (diagonal matrix) -> return Diagonal Matrix)

    Operations:
    * Transpose Matrix
    * Sum Row and Column
    * Find Max/Min
    * Diagonal Display
    * Exit

 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class MatrixOperations {

    // Variable 
    static int n_row, n_column;
    static int res, diagonal_shape;
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        // Main Program
        int menu = displayOption();
        runOption(menu);

    }

    // Function Menu for  get input rows and column
    static void menu(int mode) {
        System.out.print("Enter the number of rows: ");
        n_row = input.nextInt();
        while (n_row <= 0) { // row only > 0
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of rows: ");
            n_row = input.nextInt();

        }
        System.out.print("Enter the number of columns: ");
        n_column = input.nextInt();
        while (n_column <= 0) { // column only > 0 
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of columns: ");
            n_column = input.nextInt();
        }

        // Build List for input matrix (collect row (list))
        List<List<Integer>> row_list = new ArrayList<>();

        // Access to list
        for (int row = 0; row < n_row; row++) {
            // Build List for input matrix (collect column (int))
            List<Integer> column_list = new ArrayList<>();

            // Access to inner matrix
            for (int column = 0; column < n_column; column++) {
                if (mode == 1) { // Normal input
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
                column_list.add(res);
            }
            // add column to row list
            row_list.add(column_list);
        }
        displayMatrix(row_list);
        runOperation(row_list);

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
        System.out.println("\nSelect matrix initialization method:");
        System.out.println("1. User Input");
        System.out.println("2. Random Numbers");
        System.out.println("3. All Zeros");
        System.out.println("4. All Ones");
        System.out.println("5. Diagonal Matrix");

        System.out.print("Enter choice (1-5): ");
        int option = input.nextInt(); // Get option

        return option;
    }

    // Choose Operation
    static int displayOperation() {
        System.out.println("Choose an operation:");
        System.out.println("1. Transpose Matrix");
        System.out.println("2. Row and Column Sum");
        System.out.println("3. Find Max/Min Value");
        System.out.println("4. Diagonal Display");
        System.out.println("5. Exit");

        System.out.print("Enter choice: ");
        int options = input.nextInt(); // Get option

        return options;
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

    static void runOperation(List<List<Integer>> matrix) {

        int option = displayOperation(); // Get Option from method
        while (option != 5) {
            if (option == 1) {
                displayMatrix(transposeMatrix(matrix)); // Transpose and display
            } else if (option == 2) {
                sumRowColumn(matrix);
            } else if (option == 3) {
                maxminVal(matrix);
            } else if (option == 4) {
                diagonalDisplay(matrix);
            } else if (option == 5) {
                break; // Exit from Operation
            }

            option = displayOperation();
        }

    }

    // Build Diagonal Matrix
    static void diagonalMatrix() {
        System.out.print("Enter the number of rows and column for diagonal matrix: ");
        diagonal_shape = input.nextInt(); // Get shape

        // Access to list in list
        List<List<Integer>> row_list = new ArrayList<>();
        for (int row = 0; row < diagonal_shape; row++) {
            List<Integer> column_list = new ArrayList<>();

            for (int column = 0; column < diagonal_shape; column++) {
                if (row == column) {
                    res = 1; // Diagonal
                } else {
                    res = 0; // Not Diagonal
                }
                column_list.add(res);
            }
            row_list.add(column_list);
        }
        displayMatrix(row_list);
        runOperation(row_list);
    }

    // Transpose Method
    static List<List<Integer>> transposeMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> trans = new ArrayList<>();
        for (int row = 0; row < n_column; row++) {
            List<Integer> newRow = new ArrayList<>();
            for (int column = 0; column < n_row; column++) {
                newRow.add(matrix.get(column).get(row));
            }
            trans.add(newRow);
        }
        // displayMatrix(trans);
        return trans;
    }

    // Sum Row and Column
    static void sumRowColumn(List<List<Integer>> matrix) {
        // Sum Row
        int i_row = 0;
        System.out.println("Row Sums:");
        for (List<Integer> row : matrix) {
            int sum = 0;
            for (int column : row) {
                sum += column; // Sum in list using for loop
            }
            i_row += 1; // order list next
            System.out.println("Row " + i_row + ": " + sum);
        }
        // Sum Column
        List<List<Integer>> trans_sum = transposeMatrix(matrix);
        int i_column = 0;
        for (List<Integer> row : trans_sum) {
            int sum = 0;
            for (int column : row) {
                sum += column; // Sum in list using for loop
            }
            i_column += 1; // order list next
            System.out.println("column " + i_column + ": " + sum);
        }

    }

    // Max Min Value in Matrix
    static void maxminVal(List<List<Integer>> matrix) {
        int minVal = 1_000_000_000; // Set Min
        int maxVal = 0; // Set Max
        for (int row = 0; row < matrix.size(); row++) {
            for (int column = 0; column < matrix.get(0).size(); column++) {
                int val = matrix.get(row).get(column); // Get Value in Matrix
                if (val < minVal) {
                    minVal = val; // Set new Min
                } else if (val > maxVal) {
                    maxVal = val; // Set new Max
                }
            }
        }
        System.out.println("Maximum Value: " + maxVal);
        System.out.println("Minimum Value: " + minVal);
    }


    static void diagonalDisplay(List<List<Integer>> matrix) {
        System.out.println("Main Diagonal:");
        // Access list in list
        for (int row = 0; row < matrix.size(); row++) {
            for (int column = 0; column < matrix.get(0).size(); column++) {
                if (row == column) {
                    int val = matrix.get(row).get(column); // Get Value in Matrix
                    System.out.print(val + " ");
                }
            }
        }
        System.out.println();
    }
}
