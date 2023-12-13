package mehom.phubadine.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {
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
        runOperation(row_list);

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
        System.out.println("\nSelect matrix initialization method:");
        System.out.println("1. User Input");
        System.out.println("2. Random Numbers");
        System.out.println("3. All Zeros");
        System.out.println("4. All Ones");
        System.out.println("5. Diagonal Matix");

        System.out.print("Enter choice (1-5): ");
        int option = input.nextInt();

        return option;
    }

    static int displayOperation() {
        System.out.println("Choose an operation:");
        System.out.println("1. Transpose Matrix");
        System.out.println("2. Row and Column Sum");
        System.out.println("3. Find Max/Min Value");
        System.out.println("4. Diagonal Display");
        System.out.println("5. Exit");

        System.out.print("Enter choice: ");
        int options = input.nextInt();

        return options;
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

    static void runOperation(List<List<Integer>> matrix) {

        int option = displayOperation();
        while (option != 5) {
            if (option == 1) {
                displayMatrix(transposeMatrix(matrix));

            } else if (option == 2) {
                sumRowColumn(matrix);
            } else if (option == 3) {
                maxminVal(matrix);
            } else if (option == 4) {
                diagonalDisplay(matrix);
            } else if (option == 5) {
                break;
            }

            option = displayOperation();
        }

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
        runOperation(row_list);
    }

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

    static void sumRowColumn(List<List<Integer>> matrix) {
        int i_row = 0;
        System.out.println("Row Sums:");
        for (List<Integer> row : matrix) {
            int sum = 0;
            for (int column : row) {
                sum += column;
            }
            i_row += 1;
            System.out.println("Row " + i_row + ": " + sum);
        }
        List<List<Integer>> trans_sum = transposeMatrix(matrix);
        int i_column = 0;
        for (List<Integer> row : trans_sum) {
            int sum = 0;
            for (int column : row) {
                sum += column;
            }
            i_column += 1;
            System.out.println("column " + i_column + ": " + sum);
        }

    }

    static void maxminVal(List<List<Integer>> matrix) {
        int minVal = 1_000_000_000;
        int maxVal = 0;
        for (int row = 0; row < matrix.size(); row++) {
            for (int column = 0; column < matrix.get(0).size(); column++) {
                int val = matrix.get(row).get(column);
                if (val < minVal) {
                    minVal = val;
                } else if (val > maxVal) {
                    maxVal = val;
                }
            }
        }
        System.out.println("Maximum Value: " + maxVal);
        System.out.println("Minimum Value: " + minVal);
    }

    static void diagonalDisplay(List<List<Integer>> matrix) {
        System.out.println("Main Diagonal:");
        for (int row = 0; row < matrix.size(); row++) {
            for (int column = 0; column < matrix.get(0).size(); column++) {
                if (row == column) {
                    int val = matrix.get(row).get(column);
                    System.out.print(val + " ");
                }
            }
        }
        System.out.println();
    }
}
