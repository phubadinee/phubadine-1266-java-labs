package mehom.phubadine.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * MatrixDisplay Program
 * Input : row and column (int) 
 *         and type number in matrix [0][0] -> [row][column] 
 * Output : matrix
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class MatrixDisplay {
    static int nRow, nColumn;
    static Scanner input = new Scanner(System.in);
      
    public static void main(String[] args) {
        inputMatrix();
    }

    static void inputMatrix() {
        // Input rows
        System.out.print("Enter the number of rows: ");
        nRow = input.nextInt();
        while (nRow <= 0) { // rows only > 0
            // Input new rows
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of rows: ");
            nRow = input.nextInt();
        }
        // Input columns
        System.out.print("Enter the number of column: ");
        nColumn = input.nextInt();
        while (nColumn <= 0) { // columns only > 0
            // Input new columns
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of rows: ");
            nColumn = input.nextInt();
        }

        // Build List for input matrix (collect row (list))
        List<List<Integer>> rowList = new ArrayList<>();

        // Access to list
        for (int row = 0; row < nRow; row++ ) {
            // Build List for input matrix (collect column (int))
            List<Integer> columnList = new ArrayList<>();
            
            for (int column = 0; column < nColumn; column++) {
                System.out.print("Enter element [" + row + "][" + column + "]: ");
                // Input num 
                int res = input.nextInt();
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
        for (List<Integer> row: matrix) {
            for (int column: row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}
