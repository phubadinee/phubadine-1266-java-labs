package mehom.phubadine.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class MatrixDisplayOptions {
    static int n_row, n_column;
    static int res, diagonal_shape;
    
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        
        int menu = displayOption();
        runOption(menu);
        
    }

    static void menu(int mode) {

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
        for (int row = 0; row < n_row; row++) {
            List<Integer> column_list = new ArrayList<>();

            for (int column = 0; column < n_column; column++) {
                if (mode == 1) {
                    System.out.print("Enter element [" + row + "][" + column + "]: ");
                    res = input.nextInt();
                } else if (mode == 2) {
                    res = rand.nextInt(9);
                } else if (mode == 3) {
                    res = 0;
                } else if (mode == 4) {
                    res = 1;
                }

                column_list.add(res);
            }
            row_list.add(column_list);
        }
        displayMatrix(row_list);
    }

    static void displayMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    static int displayOption() {
        System.out.println("Select matrix initialization method:");
        System.out.println("1. User Input");
        System.out.println("2. Random Numbers");
        System.out.println("3. All Zeros");
        System.out.println("4. All Ones");
        System.out.println("5. Diagonal Matix");

        System.out.print("Enter choice (1-5): ");
        int option = input.nextInt();

        return option;
    }

    static void runOption(int option) {
        if (option == 1) {
            menu(1);
        } else if (option == 2) {
            menu(2);
        } else if (option == 3) {
            menu(3);
        } else if (option == 4) {
            menu(4);
        } else if (option == 5) {
            diagonalMatrix();
        }

        int menu = displayOption();
        runOption(menu);
    }

    static void diagonalMatrix() {
        System.out.print("Enter the number of rows and column for diagonal matrix: ");
        diagonal_shape = input.nextInt();

        List<List<Integer>> row_list = new ArrayList<>();
        for (int row = 0; row < diagonal_shape; row++) {
            List<Integer> column_list = new ArrayList<>();

            for (int column = 0; column < diagonal_shape; column++) {
                if (row == column) {
                    res = 1;
                } else {
                    res = 0;
                }
                column_list.add(res);
            }
            row_list.add(column_list);
        }
        displayMatrix(row_list);
    }   
}
