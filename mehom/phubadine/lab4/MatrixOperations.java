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
    static int nRow, nColumn;
    static int res, diagonalShape;
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static int stat;
    public static void main(String[] args) {
        // Main Program
        stat = 0;
        int menu = displayOption();
        runOption(menu);

    }

    // Function Menu for  get input rows and column
    static void menu(int mode) {
        
        System.out.print("Enter the number of rows: ");
        nRow = input.nextInt();
        while (nRow <= 0) { // row only > 0
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of rows: ");
            nRow = input.nextInt();

        }
        System.out.print("Enter the number of columns: ");
        nColumn = input.nextInt();
        while (nColumn <= 0) { // column only > 0 
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
                columnList.add(res);
            }
            // add column to row list
            rowList.add(columnList);
        }
            
        if (stat != 5) {
            displayMatrix(rowList);
            stat = displayOperation();
            runOperation(rowList, stat);
        }
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
        int options = input.nextInt(); // Get option
        stat = 0;
        return options;
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
    static void runOption(int optionMenu) {
        if (optionMenu == 1) {
            menu(1); // User Input
        } else if (optionMenu == 2) {
            menu(2); // Random Numbers
        } else if (optionMenu == 3) {
            menu(3); // All Zeros
        } else if (optionMenu == 4) {
            menu(4); // All Ones
        } else if (optionMenu == 5) {
            diagonalMatrix(); // Diagonal
        }

        int menu = displayOption();
        runOption(menu);    // Recursion
    }

    static void runOperation(List<List<Integer>> matrix, int option) {
        if (option !=5) {
            while (option != 5) {
                if (option == 1) {
                    matrix = transposeMatrix(matrix);
                    displayMatrix(matrix); // Transpose and display
                } else if (option == 2) {
                    sumRowColumn(matrix);  
                } else if (option == 3) {
                    maxMinVal(matrix);    
                } else if (option == 4) {
                    diagonalDisplay(matrix);;       
                } else if (option == 5) {
                    break; // Exit from Operation
                }
                option = displayOperation();
            
             }
            runOperation(matrix, option);
        }
        
                
    }

    // Build Diagonal Matrix
    static void diagonalMatrix() {
        System.out.print("Enter the number of rows and column for diagonal matrix: ");
        diagonalShape = input.nextInt(); // Get shape

        // Access to list in list
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
        int option = displayOperation();
        runOperation(rowList, option);
    }

    // Transpose Method
    // static List<List<Integer>> transposeMatrix(List<List<Integer>> matrix) {
    //     List<List<Integer>> trans = new ArrayList<>();
    //     for (int row = 0; row < nColumn; row++) {
    //         List<Integer> newRow = new ArrayList<>();
    //         for (int column = 0; column < nRow; column++) {
    //             newRow.add(matrix.get(column).get(row));
    //         }
    //         trans.add(newRow);
    //     }
    //     // displayMatrix(trans);
    //     return trans;
    // }

    static List<List<Integer>> transposeMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> trans = new ArrayList<>();
        for (int row = 0; row < matrix.get(0).size(); row++) {
            List<Integer> newRow = new ArrayList<>();
            for (int column = 0; column < matrix.size(); column++) {
                newRow.add(matrix.get(column).get(row));
            }
            trans.add(newRow);
        }
        
        return trans;
    }

    // Sum Row and Column
    static void sumRowColumn(List<List<Integer>> matrix) {
        // Sum Row
        int iRow = 0;
        System.out.println("Row Sums:");
        for (List<Integer> row : matrix) {
            int sum = 0;
            for (int column : row) {
                sum += column; // Sum in list using for loop
            }
            iRow += 1; // order list next
            System.out.println("Row " + iRow + ": " + sum);
        }
        // Sum Column
        List<List<Integer>> trans_sum = transposeMatrix(matrix);
        int iColumn = 0;
        for (List<Integer> row : trans_sum) {
            int sum = 0;
            for (int column : row) {
                sum += column; // Sum in list using for loop
            }
            iColumn += 1; // order list next
            System.out.println("column " + iColumn + ": " + sum);
        }

    }

    // Max Min Value in Matrix
    static void maxMinVal(List<List<Integer>> matrix) {
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
