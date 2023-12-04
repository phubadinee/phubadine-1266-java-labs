package mehom.phubadine.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixDisplay {
    static int n_row, n_column;
    static Scanner input = new Scanner(System.in);
      
    public static void main(String[] args) {
        inputMatrix();
    }

    static void inputMatrix() {
        
        System.out.print("Enter the number of rows: ");
        n_row = input.nextInt();
        while (n_row <= 0) {
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of rows: ");
            n_row = input.nextInt();
        }
        System.out.print("Enter the number of column: ");
        n_column = input.nextInt();
        while (n_column <= 0) {
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of rows: ");
            n_column = input.nextInt();
        }

        List<List<Integer>> row_list = new ArrayList<>();
        for (int row = 0; row < n_row; row++ ) {
            List<Integer> column_list = new ArrayList<>();
            
            for (int column = 0; column < n_column; column++) {
                System.out.print("Enter element [" + row + "][" + column + "]: ");
                int res = input.nextInt();
                column_list.add(res);
            }
            row_list.add(column_list);
        }  
        displayMatrix(row_list);
    }

    static void displayMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row: matrix) {
            for (int column: row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}
