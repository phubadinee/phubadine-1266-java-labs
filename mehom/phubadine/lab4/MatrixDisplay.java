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
    static int n_row, n_column;
    static Scanner input = new Scanner(System.in);
      
    public static void main(String[] args) {
        inputMatrix();
    }

    static void inputMatrix() {
        // Input rows
        System.out.print("Enter the number of rows: ");
        n_row = input.nextInt();
        while (n_row <= 0) { // rows only > 0
            // Input new rows
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of rows: ");
            n_row = input.nextInt();
        }
        // Input columns
        System.out.print("Enter the number of column: ");
        n_column = input.nextInt();
        while (n_column <= 0) { // columns only > 0
            // Input new columns
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of rows: ");
            n_column = input.nextInt();
        }

        // Build List for input matrix (collect row (list))
        List<List<Integer>> row_list = new ArrayList<>();

        // Access to list
        for (int row = 0; row < n_row; row++ ) {
            // Build List for input matrix (collect column (int))
            List<Integer> column_list = new ArrayList<>();
            
            for (int column = 0; column < n_column; column++) {
                System.out.print("Enter element [" + row + "][" + column + "]: ");
                // Input num 
                int res = input.nextInt();
                // add num to column list
                column_list.add(res);
            }
            // add column to row list
            row_list.add(column_list);
        }  
        displayMatrix(row_list);
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
